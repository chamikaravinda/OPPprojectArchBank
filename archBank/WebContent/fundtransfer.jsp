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
		String authority = (String) request.getSession().getAttribute("authority");

		if (authority != null) {

			session.removeAttribute("authority");
		}

		else {
			response.sendRedirect("homepage.jsp");
		}

		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1

		response.setHeader("Pragma", "no-cache");//HTTP 1.0;

		response.setHeader("Expires", "0");//proxies
	%>

	<div class="container">
		<div
			class="col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-1">

			<div class="col-lg-8 col-md-8 col-sm-8 col-xs-10 ">
				<center>
					<br> <br> <a href="index.jsp"><img
						src="image/banklogo.png" style="width: 50%; margin: 30px"></a>
					<%if(session.getAttribute("trafname")!=null){ %>
					<h3>
						Fund Transferring to :
						<%
						out.print(session.getAttribute("trafname") + " " + session.getAttribute("tralname"));
					%>
					</h3>
					
					<br>
					<h4>
						Account No :
						<%
						out.print(session.getAttribute("traaccNo"));
					%>
					</h4>
					<br>

					<form action="pay" method="post">

						<div class="input-group-lg">
							<input type="text" class=" loginInput form-control "
								placeholder="Amount" name="amount" required />
						</div>
						<br> <input type="submit" class=" btn btn-lg btn-primary "
							style="width: 30%"value ="Pay">
					</form>
					<br>
					<%} %>	
					
					<%if(request.getParameter("InvalidAccountNo")!=null){ %>
					<h3>
						Fund Transferring to :
						<%
						out.print(request.getParameter("InvalidAccountNo"));
					
					System.out.print(request.getParameter("InvalidAccountNo"));

					%>
					</h3>
					<%} %>			
				</center>
			</div>

		</div>
	</div>

	<div style="margin-top: 207.5px">
		<jsp:include page="footer.jsp" />
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>