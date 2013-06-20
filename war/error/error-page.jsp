
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sonola &middot; Error</title>
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
				<a class="brand" href="#">Project name</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="/">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="/public/contact.jsp">Contact</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<h1>Error Page</h1>
		<div class="span9">
			<div class="hero-unit">
				<h2>Status List</h2>
				<br>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Content</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Session</td>
							<%
								if (session.getAttribute("admin") != null) {
							%>
							<td>admin session valid</td>
							<%
								} else {
							%>
							<td>admin session invalid</td>
							<%
								}
							%>
						</tr>
						<tr>
							<td>Servlet Exceptions</td>
							<%
								if (session.getAttribute("servlet-error") != null) {
							%>
							<td><%=session.getAttribute("servlet-error")%></td>
							<%
								session.removeAttribute("servlet-error");
							%>
							<%
								} else {
							%>
							<td>Normal</td>
							<%
								}
							%>
						</tr>

					</tbody>

				</table>
			</div>
		</div>
		<!--/row-->

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
	<!-- /container -->

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

</body>
</html>
