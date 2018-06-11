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

		String fname = (String) session.getAttribute("userFname");
		String email = (String) session.getAttribute("username");//email
		String accbal = (String) session.getAttribute("Accbalance");
		String lname = (String) session.getAttribute("userLname");
		String AccNo = (String) session.getAttribute("AccNo");
	%>

	<!-- bellow 4 dives are to create responsive space between page and navi bar -->

	<div class="col-lg-12 hidden-md hidden-sm hidden-xs"
		style="height: 70px; background-color: #f4fcff"></div>

	<div class="hidden-lg col-md-12  hidden-sm hidden-xs"
		style="height: 70px; background-color: #f4fcff"></div>

	<div class="hidden-lg hidden-md col-sm-12  hidden-xs"
		style="height: 100px; background-color: #f4fcff"></div>

	<div class="hidden-lg hidden-md hidden-sm  col-xs-12"
		style="height: 130px; background-color: #f4fcff"></div>

	<!-- end of space classes -->

	<div style="background-color: #f4fcff">
		<jsp:include page="header.jsp" />
	</div>
	<div class="row">
		<br>
		<br>
		<h2 style="margin-left: 40px">Update Details</h2>
		<br> <br>
	</div>
	<div class="row">
		<center>
			<div class="col-lg-offset-4 col-md-offset-4 col-sm-offset-4">
				<div class="col-lg-6 col-md-6 col-sm-6">

					<form action="UpdateDetails" method="post">

						<div class="input-group-lg">
							<input type="text" class=" loginInput form-control "
								placeholder="First Name" name="fname"
								value="<%out.print(fname);%>" required />
						</div>

						<%
							if (request.getAttribute("errorFname") != null) {
						%>
						<br>
						<div class="alert alert-danger">
							<strong>Warrning!</strong> <% out.print(request.getAttribute("errorFname")); %>
						</div>
						<%
							}
						%>

						<br>
						<div class="input-group-lg">
							<input type="text" class=" loginInput form-control"
								placeholder="Last Name" name="lname"
								value="<%out.print(lname);%>" required />
						</div>
						<%
							if (request.getAttribute("errorLname") != null) {
						%>
						<br>
						<div class="alert alert-danger">
							<strong>Warrning!</strong> <% out.print(request.getAttribute("errorLname")); %>
						</div>
						<%
							}
						%>


						<br>
						<div class="input-group-lg">
							<input type="text" class=" loginInput form-control"
								placeholder="E mail" name="email" value="<%out.print(email);%>"
								required />
						</div>

						<%
							if (request.getAttribute("errorEmail") != null) {
						%>
						<br>
						<div class="alert alert-danger">
							<strong>Warrning!</strong><% out.print(request.getAttribute("errorEmail")); %>
						</div>
						<%
							}
						%>

						<%
							if (request.getAttribute("errorEmail2") != null) {
								
						%>
						<br>
						<div class="alert alert-danger">
							<strong>Warrning!</strong> <% out.print(request.getAttribute("errorEmail2")); %>
						</div>
						<%
							}
						%>

						<br>
						<div class="input-group-lg">
							<input type="number" class=" loginInput form-control"
								name="accNo" value="<%out.print(AccNo);%>" readonly />
						</div>

						<br>
						<div class="input-group-lg">
							<input type="password" class=" loginInput form-control"
								placeholder="Current Password" name="CurrentPass" required />
						</div>



						<%
							if (request.getAttribute("errorPass") != null) {
						%>
						<br>
						<div class="alert alert-danger">
							<strong>Warrning!</strong>  <% out.print(request.getAttribute("errorPass")); %>
						</div>
						<%
							}
						%>

						<br> <br> <input type="submit" value="Update"
							class=" btn btn-lg btn-primary " style="width: 60%">
							<br>

						<%
							if (request.getAttribute("errorUpdate") != null) {
						%>
						<br>
						<div class="alert alert-danger">
							<strong>Warrning!</strong> <% out.print(request.getAttribute("errorUpdate")); %>
						</div>
						<%
							}
						%>
					</form>
				</div>
			</div>
		</center>
	</div>


	</div>
	<br>
	<br>
	<div class="row">
		<jsp:include page="footer.jsp" />
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>