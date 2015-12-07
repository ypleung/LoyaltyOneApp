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
   href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="${bsCyborgCss}" rel="stylesheet" />   
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}
</style>
</head>
<body>

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
               <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
               <li><a data-toggle="tab" href="#about">About</a></li>
               <li><a data-toggle="tab" href="#projects">Projects</a></li>
               <li><a data-toggle="tab" href="#contact">Contact</a></li>
               <li class="hidden"><a data-toggle="tab" href="#main">main</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
               <li><a href="#"><span
                     class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
         </div>
      </div>
   </nav>

   <div class="tab-content">

      <div id="home" class="tab-pane fade in active">

         <div class="container">
            <div class="row">
               <div class="col-sm-8">
                  <div id="myCarousel" class="carousel slide"
                     data-ride="carousel">
                     <!-- Indicators -->
                     <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0"
                           class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                     </ol>

                     <!-- Wrapper for slides -->
                     <div class="carousel-inner" role="listbox">
                        <div class="item active">
                           <img
                              src="http://placehold.it/800x400?text=IMAGE"
                              alt="Image">
                           <div class="carousel-caption">
                              <h3>Sell $</h3>
                              <p>Money Money.</p>
                           </div>
                        </div>

                        <div class="item">
                           <img
                              src="http://placehold.it/800x400?text=Another Image Maybe"
                              alt="Image">
                           <div class="carousel-caption">
                              <h3>More Sell $</h3>
                              <p>Lorem ipsum...</p>
                           </div>
                        </div>
                     </div>

                     <!-- Left and right controls -->
                     <a class="left carousel-control" href="#myCarousel"
                        role="button" data-slide="prev"> <span
                        class="glyphicon glyphicon-chevron-left"
                        aria-hidden="true"></span> <span class="sr-only">Previous</span>
                     </a> <a class="right carousel-control"
                        href="#myCarousel" role="button"
                        data-slide="next"> <span
                        class="glyphicon glyphicon-chevron-right"
                        aria-hidden="true"></span> <span class="sr-only">Next</span>
                     </a>
                  </div>
               </div>
               <div class="col-sm-4">
                  <div class="well">
                     <p>Some text..</p>
                  </div>
                  <div class="well">
                     <p>Upcoming Events..</p>
                  </div>
                  <div class="well">
                     <p>Visit Our Blog</p>
                  </div>
               </div>
            </div>
            <hr>
         </div>

         <div class="container text-center">

            <h3>What We Do</h3>
            <br>
            <div class="row">
               <div class="col-sm-3">
                  <img src="http://placehold.it/150x80?text=IMAGE"
                     class="img-responsive" style="width: 100%"
                     alt="Image">
                  <p>Current Project</p>
               </div>
               <div class="col-sm-3">
                  <img src="http://placehold.it/150x80?text=IMAGE"
                     class="img-responsive" style="width: 100%"
                     alt="Image">
                  <p>Project 2</p>
               </div>
               <div class="col-sm-3">
                  <div class="well">
                     <p>Some text..</p>
                  </div>
                  <div class="well">
                     <p>Some text..</p>
                  </div>
               </div>
               <div class="col-sm-3">
                  <div class="well">
                     <p>Some text..</p>
                  </div>
                  <div class="well">
                     <p>Some text..</p>
                  </div>
               </div>
            </div>
            <hr>
         </div>

      </div>

      <div id="main" class="tab-pane fade"></div>

   </div>
   <div class="container text-center">
      <h3>Our Partners</h3>
      <br>
      <div class="row">
         <div class="col-sm-1">
            <img src="http://placehold.it/150x80?text=IMAGE"
               class="img-responsive" style="width: 100%" alt="Image">
            <p>Partner 1</p>
         </div>
         <div class="col-sm-1">
            <img src="http://placehold.it/150x80?text=IMAGE"
               class="img-responsive" style="width: 100%" alt="Image">
            <p>Partner 2</p>
         </div>
         <div class="col-sm-1">
            <img src="http://placehold.it/150x80?text=IMAGE"
               class="img-responsive" style="width: 100%" alt="Image">
            <p>Partner 3</p>
         </div>
         <div class="col-sm-1">
            <img src="http://placehold.it/150x80?text=IMAGE"
               class="img-responsive" style="width: 100%" alt="Image">
            <p>Partner 4</p>
         </div>
         <div class="col-sm-1">
            <img src="http://placehold.it/150x80?text=IMAGE"
               class="img-responsive" style="width: 100%" alt="Image">
            <p>Partner 5</p>
         </div>
         <div class="col-sm-1">
            <img src="http://placehold.it/150x80?text=IMAGE"
               class="img-responsive" style="width: 100%" alt="Image">
            <p>Partner</p>
         </div>
      </div>
   </div>

   <br>

   <nav class="navbar navbar-inverse">
      <div class="container-fluid">
         <div class="navbar-collapse collapse" id="footer-body">
            <ul class="nav navbar-nav">
               <li><a href="#">Browse Our Library</a></li>
               <li><a href="#">About Us</a></li>
               <li><a href="#">Contact Us</a></li>
               <li><a href="#">Our Partners</a></li>
               <li><a href="#">User Review</a></li>
               <li><a href="#">Terms &amp; Conditions</a></li>
               <li><a href="#">Privacy Policy</a></li>
            </ul>
         </div>
      </div>
   </nav>

   <spring:url value="/resources/js/menu.js" var="menujs" />
   <script>
				var baseurl = "${base}";
			</script>
   <script src="${menujs}"></script>


</body>
</html>

<!-- # Copyright by YP Leung, 2015 Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php -->

