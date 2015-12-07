/*!
 * Navigation Javascripts
 */
$('#topNavbar a').click(function () {
    // get the div's id
    var divid = $(this).attr('href').substr(1);
    if (divid != "home") {
      var url = baseurl + divid;
      alert (" url: " + url);
      $.get(url, { section: divid }).success(function(data){
          $("#main").html(data);
      });
      $('#topNavbar a[href="#main"]').tab('show');
    } else {
      $('#topNavbar a[href="#home"]').tab('show');
    }
})

/*! # Copyright by YP Leung, 2015 Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php */
