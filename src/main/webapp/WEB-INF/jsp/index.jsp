<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<c:url var="base" value="/" scope="request" />
<spring:url value="/resources/css/bootstrap-cyborg.css"
   var="bsCyborgCss" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="${bsCyborgCss}" rel="stylesheet" />
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>
</head>
<body>
   
   <input type="hidden" id="loadCommentsTab" value="0"></input>

   <nav class="navbar navbar-inverse">
      <div class="container-fluid">
         <div class="navbar-header">
            <button type="button" class="navbar-toggle"
               data-toggle="collapse" data-target="#topNavbar">
               <span class="icon-bar"></span> <span class="icon-bar"></span>
               <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
         </div>
         <div class="collapse navbar-collapse" id="topNavbar">
            <ul class="nav navbar-nav">
               <li class="active"><a data-toggle="tab"
                  href="#comments">Home</a></li>
               <li class="hidden"><a data-toggle="tab" href="#main">main</a></li>

            </ul>
            <div id="userService">
            <ul  class="nav navbar-nav navbar-right">
               <li class="dropdown" id="menuRegister"><a
                  class="dropdown-toggle" href="#register"
                  data-toggle="dropdown" id="navLogin">Register</a>
                  <div class="dropdown-menu" style="padding:17px;">
                     <form class="form" id="formRegister">
                        <div class="form-group">
                           <input name="rusername" id="regUsername" required
                              placeholder="Username" type="text">
                        </div>
                        <div class="form-group">
                           <input type="password" class="form-control"
                              id="regPassword" required 
                              name="rpassword"
                              placeholder="Password">
                        </div>
                        <div class="form-group">
                           <input type="password" class="form-control"
                              id="regPasswordChk" required
                              name="rpasswordchk"
                              placeholder="Verify Password">
                        </div>
                        <br />
                        <button type="submit" id="btnLogin" class="btn">Login</button>
                     </form>
                  </div></li>
               <li class="dropdown" id="menuLogin"><a
                  class="dropdown-toggle" href="#login"
                  data-toggle="dropdown" id="navLogin">Login</a>
                  <div class="dropdown-menu" style="padding:17px;">
                     <form class="form" id="formLogin">
                        <div class="form-group">
                           <input name="username" id="username" required
                              placeholder="Username" type="text">
                        </div>
                        <div class="form-group">
                           <input name="password" id="password" required
                              placeholder="Password" type="password">
                        </div>
                        <br />
                        <button type="submit" id="btnLogin" class="btn">Login</button>
                     </form>
                  </div></li>
            </ul>
            </div>
            <ul class="nav navbar-right">
               <li id="userDisplay"></li>
            </ul>
         </div>
      </div>
   </nav>
   <div id="ErrorDiv"><p class="bg-danger" id="ErrorText"></p></div>
   <div class="tab-content">
      <div id="home" class="tab-pane fade"></div>
      <div id="main" class="tab-pane fade in active"></div>
   </div>
   <br/>
   <div id="location">
<div class="container">
   <div id="commentsTable" class="row">
      <div class="col-sm-9">
      <p><b>CITY: </b><span id="city"></span> <b>LATITUDE: </b><span id="latitude"></span> <b>LONGITUDE: </b><span id="longitude"></span></p>
      </div>
      </div></div>
   </div>

   <br>

   <nav class="navbar navbar-inverse">
      <div class="container-fluid">
         <div class="navbar-collapse collapse" id="footer-body">
            <ul class="nav navbar-nav">
               <li><a href="#">Fun With Java</a></li>
            </ul>
         </div>
      </div>
   </nav>

   <spring:url value="/resources/js/menu.js" var="menujs" />
   <spring:url value="/resources/js/loyalty.js" var="loyaltyjs" />
   <script>
				var baseurl = "${base}";
			</script>
   <script src="${menujs}"></script>
   <script src="${loyaltyjs}"></script>


</body>
</html>

<!-- # Copyright by YP Leung, 2015 Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php -->

