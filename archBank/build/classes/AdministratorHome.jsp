
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>

<!DOCTYPE  html PUBLIC "-//W3C//33DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
			response.sendRedirect("AdministratorLogin.jsp");
		}

		String fname = (String) session.getAttribute("userFname");
		String totalAccounts = (String) session.getAttribute("totalbankAccounts");
		String totalBalance = (String) session.getAttribute("totalbankBalance");
	%>

	<div class="container-fluid">
		
			<div >
		<jsp:include page="AdminHEDER.jsp" />
	</div>
	
		<div class="row"
			style="background-color: honeydew; padding-top: 4%; padding-bottom: 4%">
			<center>
				<div class="card-deck col-lg-8 col-md-10 col-sm-12 col-lg-offset-2">
					<div class="card col-lg-3">
						<img class="card-img-top" src="image/admin_icon/TotalAccounts.jpg"
							alt="Card image cap" style="width: 80%">
						<div class="card-body">
							<h5 class="card-title">Total Bank Accounts</h5>
							<h3 class="card-text" style="color: gold">
								<%
									out.print(totalAccounts);
								%>
							</h3>
						</div>
						<div class="card-footer"></div>

					</div>
					<div class="card col-lg-3">
						<img class="card-img-top"
							src="image/admin_icon/bank%20balance.jpg" alt="Card image cap"
							style="width: 80%">
						<div class="card-body">
							<h5 class="card-title">Total Bank Balance</h5>
							<h3 class="card-text" style="color: #337ab7">
								<%
									out.print("Rs." + totalBalance);
								%>
							</h3>
						</div>
						<div class="card-footer"></div>
					</div>
					<div class="card col-lg-3">
						<img class="card-img-top"
							src="image/admin_icon/online%20accounts.jpg" alt="Card image cap"
							style="width: 80%">
						<div class="card-body">
							<h5 class="card-title">Online Bank Accounts</h5>
							<h3 class="card-text" style="color: salmon">
								<%
									out.print(session.getAttribute("totalOnlincebankAccounts"));
								%>
							</h3>
						</div>
						<div class="card-footer"></div>
					</div>
					<div class="card col-lg-3">
						<img class="card-img-top"
							src="image/admin_icon/total%20Transactions.jpg"
							alt="Card image cap" style="width: 80%">
						<div class="card-body">
							<h5 class="card-title">Total No. Transactions</h5>
							<h3 class="card-text" style="color: 28a4c9">
								<%
									out.print(session.getAttribute("totalTransactions"));
								%>
							</h3>
						</div>
						<div class="card-footer"></div>
					</div>
					<br> <small class="text-muted">Updated on : <%
 	Date date = new Date();
 	out.print(date.toString());
 %></small>
				</div>

			</center>
		</div>
		<br> <br>

		<div class="container-fluid col-lg-11" style="margin-left: 10%">
			<div class="row col-lg-3">

				<a href="#" class="btn btn-primary btn-primary"
					style="width: 70%; margin: 7px" data-toggle="modal"
					data-target="#AddAccount"><span
					class="glyphicon glyphicon-floppy-open"></span> Add Bank Accounts</a> 
					
					<a href="#" class="btn btn-primary btn-primary"
					style="width: 70%; margin: 7px" data-toggle="modal"
					data-target="#DeleteAccount"><span
					class="glyphicon glyphicon-floppy-remove"></span> Remove Bank
					Accounts</a> 
					
					<a href="#" class="btn btn-primary btn-primary"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-floppy-saved" ></span> View Bank Accounts</a>
			</div>

			<div class=" row col-lg-3">
				<a href="#" class="btn btn-primary btn-success"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-saved" ></span> Add Bill Accounts</a> <a
					href="#" class="btn btn-primary btn-success"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-ok" ></span> View Bill Accounts</a> <a
					href="#" class="btn btn-primary btn-success"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-remove"></span> Delete Bill Accounts</a> <a
					href="#" class="btn btn-primary btn-success"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-sort" ></span> Update Bill Accounts</a>
			</div>

			<div class="row col-lg-3">
				<a href="#" class="btn btn-primary  btn-warning"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-barcode"></span> View All Transactions</a> <a
					href="#" class="btn btn-primary  btn-warning"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-barcode"></span> Delete Transactions</a> <a
					href="#" class="btn btn-primary  btn-warning"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-compressed"></span> System Charges</a>
			</div>

			<div class="row col-lg-3">
				<a href="#" class="btn btn-primary btn-danger"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-user"></span> Add administrators </a> <a
					href="#" class="btn btn-primary btn-danger"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-user"></span> Viwe Admin Profiles </a> <a
					href="#" class="btn btn-primary btn-danger"
					style="width: 70%; margin: 7px" disabled><span
					class="glyphicon glyphicon-warning-sign"></span> Delete Admin
					Profiles </a>
			</div>


		</div>

		<!-- Add bank account toggle  -->

		<div id="AddAccount" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Add Bank Account</h4>
					</div>
					<form action="AddBankAccountAdministrator" method="post">
						<div class="modal-body">

							<div class="input-group-lg">
								<input type="number" class=" loginInput form-control"
									placeholder="Account Number" name="accNo" required />
							</div>
							<br>
							<div class="input-group-lg">
								<input type="number" class=" loginInput form-control"
									placeholder="Current Balance" name="Balance" required />
							</div>


						</div>
						<div class="modal-footer">
						
							<input type="submit" value="Register" class=" btn btn-primary ">
								
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>


		<!-- End of add bank account toggle  -->
		
		<!-- Delete bank account toggle  -->

		<div id="DeleteAccount" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Delete Bank Account</h4>
					</div>
					<form action="DeleteBankAccountAdministrator" method="post">
						<div class="modal-body">

							<div class="input-group-lg">
								<input type="number" class=" loginInput form-control"
									placeholder="Account Number" name="accNo" required />
							</div>
							
						</div>
						<div class="modal-footer">
						
							<input type="submit" value="Delete" class=" btn  btn-primary ">
								
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>s

			</div>
		</div>


		<!-- Delete of add bank account toggle  -->

	</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>