<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- importing custom style sheet-->
<link href="archBankStyleSheet.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1

		response.setHeader("Pragma", "no-cache");//HTTP 1.0;

		response.setHeader("Expires", "0");//proxies

		if (session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>

	<div class="container-fluid">

		<nav class="navbar navbar-default  bg-primary navbar-fixed-top"
			role="navigation"
			style="background-color: #337ab7;padding-left:10%;padding-right: 10%">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle Navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="homepage.jsp"><img
					src="image/banklogo_white.png" class="menu-logo"></a>

			</div>

			<a class="btn btn-primary navbar-btn navbar-right loginButton"
				href="logout" style="width: 80px; height: 35px; margin-left: 10px"
				role="button">Log Out</a>

			<div class="dropdown">
				<button
					class="btn btn-default navbar-btn navbar-right  loginButton dropdown-toggle"
					type="button" style="width: 80px; height: 36px; margin-right: 10px"
					data-toggle="dropdown">
					Setting <span class="caret"></span>
				</button>
				<ul class="dropdown-menu dropdown-menu-right" style="margin-top:45px">
					<li><a href="updateAccount.jsp">Details Update</a></li>
					<li><a href="updatePassword.jsp">Password Update</a></li>

				</ul>
			</div>

			<!--   <a
				class="btn btn-default navbar-btn navbar-right loginButton" href="updateAccount.jsp"
				style="width: 80px; height: 36px; margin-right: 10px" role="button">Setting</a>
				-->



			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="homepage.jsp" style="color: white">Summery</a></li>
					<li><a href="#" style="color: white">Activity</a></li>
					<li><a href="#" style="color: white">Messages</a></li>
					<li><a href="#" style="color: white">Help</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"
						style="color: white">More<span class="caret"></span></a>

						<ul class="dropdown-menu" role="menu">
							<li><a href="#">About Us</a></li>
							<li><a href="#">Contac Us</a></li>
							<li><a href="#">Career</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- navbar collapse end -->
		</div>
		<!-- container-fluid end --> </nav>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>