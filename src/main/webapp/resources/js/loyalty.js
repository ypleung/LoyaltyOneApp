/*!
 * Action Javascripts
 */

var replyFormParentId;
var replyFormNesting;
var loadComments;

jQuery(document).ready(
      function($) {
         
         runGeoLocation();
         
         // formLogin event
         $(document).on('submit', '#formLogin', function(e) {
            e.preventDefault();
            //alert("form submit!");
            var url = baseurl + "login";
            var input = {};
            input["username"] = $("#username").val();
            input["password"] = $("#password").val();
            ajaxSendUrl(url, input, displayLogin, {});

         });
         
         // formRegister event
         $(document).on('submit', '#formRegister', function(e) {
            e.preventDefault();
            //alert("form submit!");
            
            var user, pass, passChk;
            user = $("#regUsername").val();
            pass = $("#regPassword").val();
            passChk = $("#regPasswordChk").val();
            if (isSafeChar(user) != "1") { alert("Bad username."); return false; } 
            
            var msg = chkPassword(pass, passChk);
            if (msg != "ok") { alert(msg); return false; }
            
            var url = baseurl + "register";
            var input = {};
            input["username"] = $("#regUsername").val();
            input["password"] = $("#regPassword").val();
            ajaxSendUrl(url, input, displayLogin, {});

         });

         //alert(" loading: " + $("#loadCommentsTab").val());
         loadComments = $("#loadCommentsTab").val();
         if ((loadComments == "0") || (!loadComments)) {
            // update comments section
            var commentsurl = baseurl + "comments";
            $.get(commentsurl, {
               section : "comments"
            }).success(function(data) {
               $("#main").html(data);
               $('#main form').submit(function(event) {
                  event.preventDefault();
                  $('#topNavbar a[href="#main"]').tab('show');
               });
            });
         } else {
            $("#loadCommentsTab").val("0");
         }

         // Register dynamic events for comments form
         $('#main').on('submit', '#commentForm', function() {
            var url = baseurl + "addComment";
            var input = {};
            input["comment"] = $("#comment").val();
            ajaxSendUrl(url, input, addCommentDiv, $("#displayComment"));

         });

         $('#main').on('submit','#replyForm', function() {
                  var url = baseurl + "addComment";
                  var obj = convertSerialFormToJson($('#replyForm')
                        .serializeArray());

                  obj["parentId"] = replyFormParentId;
                  obj["nesting"] = ++replyFormNesting;

                  ajaxSendUrl(url, obj, addCommentDiv, $("#" + obj["parentId"]
                        + "ReplyDiv"));
                  $("#replyFormModal").modal('hide');

               });
      });

function addCommentDiv(node, data) {
   var obj = data;
   var commentString;
   var indentNum;

   if (!obj.formData.nesting) {
      obj.formData.nesting = 0;
      indentNum = obj.formData.nesting;
      commentString = "<div class=\"col-sm-9\">" + "<h5>"
            + obj.formData.comment + "</h5>";
   } else {
      indentNum = obj.formData.nesting;
      commentString = "<div class=\"col-sm-" + indentNum + "\"></div>"
            + "<div class=\"col-sm-" + (9 - indentNum) + "\">"
            + "<span align=\"left\"><lead>" + obj.formData.comment
            + "</lead></span> ";
   }

   $(
         "<div class=\"col-sm-9\">"
               + commentString
               + "Posted By: <span align=\"right\"><small>"
               + obj.formData.username
               + "</small></span> <br/> <span>"
               + "<a id=\""
               + obj.formData.commentId
               + "replyButton\" type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#replyFormModal\">Reply</a>"
               + "<script>" + "$('#" + obj.formData.commentId
               + "replyButton').on('click', function(event) {"
               + "event.preventDefault();"
               + " replyCommentModal( { \"parentId\": \""
               + obj.formData.commentId + "\", \"nesting\": \"" + indentNum
               + "\" } ); " + "});" + "</script>" + "</span></div>" + "</div>"
               + "<div id=\"" + obj.formData.commentId
               + "ReplyDiv\"class=\"col-sm-9\"></div>").insertAfter(node);

}

function convertSerialFormToJson(serialForm) {
   var obj = {};
   $.each(serialForm, function() {
      if (obj[this.name] !== undefined) {
         if (!obj[this.name].push) {
            obj[this.name] = [ obj[this.name] ];
         }
         obj[this.name].push(this.value || '');
      } else {
         obj[this.name] = this.value || '';
      }
   });
   return obj;
}

function replyCommentModal(data) {
   var obj = data;
   // set modal form the parentId
   // launch modal window
   replyFormParentId = obj.parentId;
   replyFormNesting = obj.nesting;

}

function ajaxSendUrl(sendUrl, input, callMe, callArg1) {

   //alert(" url: " + JSON.stringify(input));
   $.ajax({
      type : "POST",
      contentType : "application/json",
      url : sendUrl,
      data : JSON.stringify(input),
      dataType : 'json',
      timeout : 10000,
      success : function(data) {
         console.log("SUCCESS: ", data);
         callMe(callArg1, data);
      },
      error : function(e) {
         console.log("ERROR: ", e);
         displayError(e);
      },

   });

}

function displayError(e) {

   var errorMsg = "ERROR: \'" + e + "'";
   //alert("called error! " + errorMsg);
   $("#errorText").html(errorMsg);
}

function displayLogin(arg, data) {
   var obj = data;
   if (obj.code == "200") {
      //alert ("Logged In!");
      $("#userDisplay").html("Welcome " + obj.formData.username);
      $("#userService").hide();
   } else {
      alert (obj.msg);
   }
   $("#loadCommentsTab").val("1");

}

function chkPassword(password, verifyPassword) {

   if (password != verifyPassword) { return "Password and verify password must match.";  }  
   if (password.length < 6) { return "Password length should exceed 6 characters"; }
   if (password.match(/[\s]+/)) { return "Password cannot contain spaces" ; }
   if (!(password.match(/[0-9]+/))) { return "Password should contain a digit." ; }
   
   if (isSafeChar(password) == "1") { return "ok"; }
   return "Password can only contain letters and numbers.";
  
}

function isSafeChar(str) {

   msg = str.match(/^[A-Za-z0-9][A-Za-z0-9]*$/); 
   if (str.match(/^[A-Za-z0-9][A-Za-z0-9]*$/)) { return "1" };
   return "0";
}


window.onunload = function(){
   $("#loadCommentsTab").val("0"); 
}

function runGeoLocation () {

   if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(geoSuccess, geoError);
   } 
}

function geoSuccess (position) {
   var userPos = position;
   //alert (" getting  geo: lat " + userPos.coords.latitude);
   var lat = userPos.coords.latitude;
   var long = userPos.coords.longitude; 
   $('#latitude').html(lat);
   $('#longitude').html(long); 
   
   var city = getCity(lat, long);
   //alert ("geo city: " + city);

}

function geoError() {
   console.log('Error occurred. Error code: ' + error.code);
}

function getCity (lat, long) {
   var url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="
      +lat+","+long+"&sensor=false";
   $.get(url).success(function(data) {
      var loc1 = data.results[0];
      var county, city;
        $.each(loc1, function(k1,v1) {
           if (k1 == "address_components") {
              //alert("length: " + v1.length);
              for (var i = 0; i < v1.length; i++) {
                 for (k2 in v1[i]) {
                    if (k2 == "types") {
                       var types = v1[i][k2];
                       //alert ("types: " + types[0]);
                       if (types[0] =="sublocality_level_1") {
                           county = v1[i].long_name;
                           //alert ("county: " + county);
                       } 
                       if (types[0] =="locality") {
                          city = v1[i].long_name;
                          //alert ("city: " + city);
                      } 
                    }
              
                 }          

              }

           }
            
        });
        $('#city').html(city); 
   }); 

}




/*
 * ! # Copyright by YP Leung, 2015 Licensed under the MIT license:
 * http://www.opensource.org/licenses/mit-license.php
 */
