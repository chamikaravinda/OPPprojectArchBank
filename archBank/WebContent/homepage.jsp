<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
	

<!DOCTYPE html PUBLIC "-//W3C//33DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		if(session.getAttribute("AdminID")!= null){
			response.sendRedirect("AdministratorHome.jsp");
		}
		
		String name=(String)session.getAttribute("userFname");  
		String balance=(String)session.getAttribute("Accbalance");
		 if(balance==null){
			 balance="0.00";
		 } 
		
	%>
	
	<div style="background-color: #f4fcff">
		<jsp:include page="header.jsp" />
	</div>

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


	<div class="container-fluid" style="background-color: #f4fcff">

		<div
			class="col-lg-offset-1 col-md-offset-1 col-sm-offset-0 col-xs-offset-0">

			<div class="col-lg-11 col-md-11 col-sm-12 col-xs-12 row">

				<div class="container-fluid" style="background-color: #f4fcff">

					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">

							<h1 style="margin: 10%; margin-bottom: 0%">Hi again,
							<%out.print(name); %>
							</h1>

						</div>

						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">

							<button style="margin: 10%;" type="button"
								class="btn btn-primary btn-md navbar-right" data-toggle="modal"
					data-target="#FundTransfer">
								<span class="glyphicon glyphicon-send"></span> Fund Transfer
							</button>

						</div>

					</div>

					<hr style="width: 80%;">

					<div class="col-lg-2 col-md-3 col-sm-3 col-xs-12">

						<div
							style="border: 3px; border-color: black; background-color: gainsboro; border-radius: 10px; padding: 17px; margin-bottom: 18px">
							<center>
								<h4>Bill Payment</h4>
								<p>Support all the leading services in the country</p>
								<a href="BillPayment.jsp" class="btn btn-primary" style="width: 80%">Pay</a>
							</center>
						</div>

						<div
							style="border: 3px; border-color: black; background-color: gainsboro; border-radius: 10px; padding: 17px; margin-bottom: 18px">
							<center>
								<h4>Cards</h4>
								<p>Arch bank issues both credit and debite cards for the
									customers</p>
								<a href="#" class="btn btn-primary" style="width: 80%">Request</a>
							</center>
						</div>

						<div
							style="border: 3px; border-color: black; background-color: gainsboro; border-radius: 10px; padding: 17px; margin-bottom: 18px">
							<center>
								<h4>Help Desk</h4>
								<p>Arch bank help desk.24H servise</p>
								<a href="#" class="btn btn-primary" style="width: 80%">Enter</a>
							</center>
						</div>


					</div>
					
					<div class="col-lg-10 col-md-9 col-sm-9 col-xs-12"
						style="border: 3px; border-color: black; background-color: gainsboro; border-radius: 10px; padding: 17px; margin-bottom: 18px">

						<h4>Account Summery</h4>
						
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<h5>Bank Balance :Rs.<%out.print(balance); %></h5>
						</div>
						<div class="col-lg-6 col-md-6  col-sm-6 col-xs-12">
						<h5>Updated on :  
						<%
        					 Date date = new Date();
        					 out.print(date.toString());
     					 %>
     					 </h5>
     					 </div>
					</div>
					
					<div class="col-lg-10 col-md-9 col-sm-9 col-xs-12"
						style="border: 3px; border-color: black; background-color: gainsboro; border-radius: 10px; padding: 17px; margin-bottom: 18px">

						<h4>Recent activity</h4>
						<p>Keep track of your most recent stuff here when you shop or
							send payments.</p>

						<p>Don?t see a past payment? Search by date in your activity.</p>

						<p>
							Shopping for something?<a href="">See places that accept
								PayPal.</a>
						</p>
						<center>
							<a href="viewTransaction.jsp" class="btn btn-primary" style="width: 130px">Viwe
								All</a>
						</center>
					</div>

				</div>

			</div>

		</div>

	</div>


	<div class="row">
		<div style="background-color: #f4fcff">
			<jsp:include page="footer.jsp" />
		</div>
	</div>


		<!-- Send payments toggle  -->

		<div id="FundTransfer" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Fund Transfer</h4>
					</div>
					<form action="fundTrasferAccountSelect" method="post">
						<div class="modal-body">

							<div class="input-group-lg">
								<input type="number" class=" loginInput form-control"
									placeholder="Account Number of the Reciver" name="accNo" required />
							</div>
							
						</div>
						<div class="modal-footer">
						
							<input type="submit" value="Continue" class=" btn  btn-primary ">
								
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>s

			</div>
		</div>


		<!-- send payments toggle  -->





	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>