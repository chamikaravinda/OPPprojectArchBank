<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1

		response.setHeader("Pragma", "no-cache");//HTTP 1.0;

		response.setHeader("Expires", "0");//proxies

		if (session.getAttribute("username") == null) {
			response.sendRedirect("AdministratorLogin.jsp");
		}

		String fname = (String) session.getAttribute("userFname");
		%>
		<div class="container-fluid" style="margin-bottom: -22px;">
			<div>
				<nav class="navbar navbar-default" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="index.jsp"><img
						src="image/banklogo.png" class="menu-logo"></a>
				</div>

				<a class="btn btn-primary navbar-btn navbar-right loginButton"
					href="logout" role="button">LogOut</a>

				<h4 class=" navbar-right "
					style="margin-right: 30px; margin-top: 15px">
					Welcome
					<%
					out.print("  " + fname);
				%>
				</h4>
				</nav>
			</div>
		</div>
</body>
</html>