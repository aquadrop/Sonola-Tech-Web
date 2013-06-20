

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="sonola.appengine.models.User"%>

<!DOCTYPE html>
<html lang="en">
<head>

<script>
	var map;
	function initialize() {
		var mapOptions = {
			zoom : 8,
			center : new google.maps.LatLng(-34.397, 150.644),
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>



<meta charset="utf-8">
<title>Sonola &middot; Contact</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	float: left;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

/* Wrapper for page content to push down footer */
#wrap {
	min-height: 100%;
	height: auto !important;
	height: 100%;
	/* Negative indent footer by it's height */
	margin: 0 auto -60px;
}

/* Set the fixed height of the footer here */
#push,#footer {
	height: 60px;
}

#footer {
	background-color: #f5f5f5;
}

/* Lastly, apply responsive CSS fixes as necessary */
@media ( max-width : 767px) {
	#footer {
		margin-left: -20px;
		margin-right: -20px;
		padding-left: 20px;
		padding-right: 20px;
	}
}

<
style>html,body,#map-canvas {
	margin: 0;
	padding: 0;
	height: 100%;
}
</style>
</style>
<link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="../assets/ico/favicon.png">
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Sonola</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="/">Home</a></li>
						<li><a href="#about">About</a></li>
						<li class="active"><a href="/public/contact.jsp">Contact</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="hero-unit">
			<div class="row-fluid">

				<div class="span12">

					<h2>Staff</h2>
					<div class="span4">
						<!-- put people profile here -->
						<img class="featurette-image pull-right"
							src="../assets/img/examples/browser-icon-chrome.png"
							, width="512" height="512">
					</div>
					<div class="span6"
						style="padding-left: 30px; border-left: 1px solid #ccc;">
						<br>
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th></th>
									<th>Description</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Name</td>
									<td></td>
								</tr>
								<tr>
									<td>Title</td>
									<td></td>
								</tr>
								<tr>
									<td>Phone</td>
									<td></td>
								</tr>
								<tr>
									<td>Email</td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- /container -->
	</div>

	<div class="container-fluid">
		<div class="hero-unit">
			<div class="row-fluid">

				<div class="span12">

					<h2>Location</h2>
					<div class="span4">
						<p class="lead">60 St. George St.,</p>
						<p class="lead">Toronto, Ontario,</p>
						<p class="lead">M5S 1A7, Canada</p>
					</div>
					<div class="span6"
						style="padding-left: 60px; border-left: 1px solid #ccc;">
						<iframe width="467.5" height="385" frameborder="2" scrolling="no"
							marginheight="0" marginwidth="0"
							src="http://maps.google.ca/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=60+St+George+St,+Toronto,+ON&amp;aq=0&amp;oq=60,+St.George&amp;sll=43.656877,-79.32085&amp;sspn=0.492804,0.878906&amp;ie=UTF8&amp;hq=&amp;hnear=60+St+George+St,+Toronto,+Toronto+Division,+Ontario+M5S+3H8&amp;t=m&amp;z=14&amp;ll=43.660762,-79.398086&amp;output=embed"></iframe>
						<br /> <small><a
							href="http://maps.google.ca/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=60+St+George+St,+Toronto,+ON&amp;aq=0&amp;oq=60,+St.George&amp;sll=43.656877,-79.32085&amp;sspn=0.492804,0.878906&amp;ie=UTF8&amp;hq=&amp;hnear=60+St+George+St,+Toronto,+Toronto+Division,+Ontario+M5S+3H8&amp;t=m&amp;z=14&amp;ll=43.660762,-79.398086"
							style="color: #0000FF; text-align: left">View Larger Map</a></small>
					</div>
				</div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<div id="wrap">

		<div id="footer">
			<div class="container">
				<p class="muted credit">
					&copy; 2013 <a href="/">Sonola, Inc</a> &middot; <a href="#">Terms</a>.
				</p>
			</div>
		</div>
	</div>


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../assets/js/jquery.js"></script>
	<script src="../assets/js/bootstrap-transition.js"></script>
	<script src="../assets/js/bootstrap-alert.js"></script>
	<script src="../assets/js/bootstrap-modal.js"></script>
	<script src="../assets/js/bootstrap-dropdown.js"></script>
	<script src="../assets/js/bootstrap-scrollspy.js"></script>
	<script src="../assets/js/bootstrap-tab.js"></script>
	<script src="../assets/js/bootstrap-tooltip.js"></script>
	<script src="../assets/js/bootstrap-popover.js"></script>
	<script src="../assets/js/bootstrap-button.js"></script>
	<script src="../assets/js/bootstrap-collapse.js"></script>
	<script src="../assets/js/bootstrap-carousel.js"></script>
	<script src="../assets/js/bootstrap-typeahead.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>

</body>
</html>
