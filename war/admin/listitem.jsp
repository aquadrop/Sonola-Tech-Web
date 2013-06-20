
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="sonola.appengine.models.Item"%>


<!DOCTYPE html>
<html lang="en">
<head>

<script>
	function modal_show(img_url, title, description) {
		$(document).ready(function() {

			$('#thumb_modal').attr("src", img_url);
			$('textarea#title_modal').text(title);
			$('textarea#description_modal').text(description);
			$('#detailModal').modal('show');
		});

	}
</script>

<meta charset="utf-8">
<title>Sonola &middot; Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
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
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Sonola</a>
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

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Operations</li>
						<li><a href="/admin/Welcome">Home</a></li>
						<li><a href="/admin/UploadItem">Upload Item</a></li>
						<li class="active"><a href="/admin/ListItem">List Items</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9">
				<div class="hero-unit">
					<h2>Item List</h2>
					<br>
					<%
						List<Item> items = (List<Item>) request.getAttribute("items");
						if (items == null||items.size()==0) {
					%>
					<p class="lead">Empty List</p>
					<%
						} else {
					%>
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Title</th>
								<th>Details</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Item item : items) {
							%>
							<tr>
								<td><%=item.getTitle()%></td>
								<td>
									<div>
										<!-- show img, title, description -->
										<a class="btn btn-small btn-primary details"
											onClick="modal_show('<%=item.getImgUrl()%>','<%=item.getTitle()%>','<%=item.getDescription().getValue()%>')">Details</a>
									</div>
								</td>
								<td>
									<div>
										<a href="#updateModal" role="button"
											class="btn btn-small btn-primary" data-toggle="modal">Update</a>
									</div>
								</td>
								<td>
									<div>
										<a class="btn btn-small btn-primary" input type="submit"
											name="DeleteItem"
											href="DeleteItem?DeleteItem=<%=item.getKey().getId()%>"
											icon="sitemap">Delete</a>
									</div>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>

					</table>
					<%
						}
					%>
				</div>
			</div>
			<!--/row-->
		</div>
		<!--/span-->

		<div id="detailModal" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h3 id="modalHeader">Details</h3>
			</div>
			<div class="modal-body">
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span6">
							<img id="thumb_modal" src="" alt="Thumbnail" width="288"
								height="288">
						</div>
						<div class="span6"
							style="padding-left: 15px; border-left: 1px solid #ccc;">
							<h3>Title</h3>
							<textarea readonly name="title_modal" id="title_modal" rows="1"
								cols="20"></textarea>
							<br>
							<h3>Description</h3>
							<textarea readonly name="description_modal"
								id="description_modal" rows="5" cols="20"></textarea>
						</div>
					</div>
				</div>

			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			</div>

		</div>

		<div id="deleteModal" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h3 id="modalHeader">Details</h3>
			</div>
			<div class="modal-body">
				<img src="" alt="Thumbnail">
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			</div>

		</div>

		<div id="updateModal" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h3 id="modalHeader">Details</h3>
			</div>
			<div class="modal-body">
				<img src="" alt="Thumbnail">
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			</div>

		</div>


	</div>
	<!--/row-->

	<hr>

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
	<script type="text/javascript"
		src="http://latex.codecogs.com/latexit.js">
	</script>

</body>
</html>
