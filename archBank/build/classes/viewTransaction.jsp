<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
	<%@page import="com.my.service.*" %>
	

<!DOCTYPE html PUBLIC "-//W3C//33DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"  content="text/html; charset=ISO-8859-1">

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
        <style>
table {
    border-collapse: collapse;
    width: 80%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}
div.ex1 {
    background-color: #f4fcff;
    width: 1000px;
    height: 410px;
    overflow: auto;
}
</style>

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
		
		String AccNo=(String)session.getAttribute("AccNo");
		System.out.println(AccNo);
		
		
	%>
	
	<div style="background-color: #f4fcff">
		<jsp:include page="header.jsp" />
	</div>
	<br>

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
	<br><br>
	<br><br>
	<br><br>
	<center>
	<div class=ex1 >
		<br>
		<br>
	
		<table border="0">
	
	<tr>
		<th>AccountID</th>
		<th>TransID</th>
		<th>Amount</th>
		<th>DRorCR</th>
	</tr>
	
	<%
	
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM transaction  WHERE AccountID='"+AccNo+"'";
		
		try{
			conn = db.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				%>
				
					<tr>
						<td ><%out.print(rs.getString(1)); %></td>
						<td ><%out.print(rs.getString(2)); %></td>
						<td ><%out.print(rs.getString(3)); %></td>
						<td ><%out.print(rs.getString(4)); %></td>
						
					</tr>
					
				
				<%
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	%>
</table>



</div>
</center>
<br>

	


	<div class="row">
		<div style="background-color: #f4fcff">
			<jsp:include page="footer.jsp" />
		</div>
	</div>






	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>