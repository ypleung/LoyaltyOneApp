/*!
 * Navigation Javascripts
 */

$('#topNavbar a').click(function () {
    // get the div's id
    var divid = $(this).attr('href').substr(1);
    //alert(" what is it: " + divid) ;
    if ((divid != "home") && (divid != "login") && (divid != "register")) {
      var url = baseurl + divid;
      $.get(url, { section: divid }).success(function(data){
          $("#main").html(data);
      });
      $('#topNavbar a[href="#main"]').tab('show');
    } 
})

/*! # Copyright by YP Leung, 2015 Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php */
