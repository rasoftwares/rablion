<% request.getRequestDispatcher("/gemsApp.html").forward(request, response); %>

<html>
<head>
	<link rel="stylesheet" href="external/bootstrap/css/bootstrap.min.css" />
  	<script src="external/jquery/jquery.js"></script>  
  	<script src="external/bootstrap/js/bootstrap.min.js"></script>
  	<style>
    .ng-enter {
-webkit-transition: all 5s linear;
-moz-transition: all 5s linear;
-ms-transition: all 5s linear;
-o-transition: all 5s linear;
transition: all 5s linear;
opacity: 0;
}
.ng-enter-active {
opacity: 1;
}
    </style>
</head>
<body>

<div class="container">
	<div class="col-md-12 text-center">
		<h2 class="brand"> Apps </h2>
	</div>
	<hr><hr>
	<div align="center" >
		<ul class="nav nav-stacked">
		    <li role="presentation" class="active"> <a href="gemsApp.html" target="_self" class="btn btn-default"> Gems </a></li>
		    <li role="presentation"> <a href="mortgageApp.html" target="_self" class="btn"> Mortgage </a> </li>
		</ul>
	</div>
</div>
</body>
</html>
