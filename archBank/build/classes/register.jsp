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

		if (session.getAttribute("username") != null) {
			response.sendRedirect("homepage.jsp");
		}
		
		
	%>

<div class="container-fluid" style="margin-left: -15px">
    <div class="container-fluid" style="margin-bottom: -22px;">
        <div>
            <nav class="navbar navbar-default" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp"><img src="image/banklogo.png" class="menu-logo"></a>
                </div>

                <a class="btn btn-primary navbar-btn navbar-right loginButton" href="login.jsp" role="button">Login</a>
            </nav>
        </div>
    </div>

    <div class="col-lg-5 col-md-6 col-sm-6 hidden-xs registerBanner">
       <center>
           <img src="image/banklogo.png" style="width: 60%;margin-top: 30%">
           <p style="color: #5e5e5e">Private Limited</p>
       </center>

    </div>

    <div class="col-lg-1 col-md-1 col-sm-1"></div>

    <div class="col-lg-5 col-md-5 col-sm-5">
    
        <h2>Registation</h2>
        <h4>Join millions around the world who shop and send money at the speed of light</h4>
        <br><br>
        
        <form action="Register" method="post">

            <div class="input-group-lg">
                <input type="text" class=" loginInput form-control " placeholder="First Name" name="fname" required/>
            </div>
            
            	  <%
              if(request.getAttribute("errorFname") != null){ %>
    		 <br>
    		 <div class="alert alert-danger">
   			 <strong>Warrning!</strong> <%out.print(request.getAttribute("errorFname")); %>
  				</div>	
				<% } %>
           
            <br>
            <div class="input-group-lg">
                <input type="text" class=" loginInput form-control" placeholder="Last Name" name="lname" required />
            </div>
                	  <%
              if(request.getAttribute("errorlname") != null){ %>
    		 <br>
    		 <div class="alert alert-danger">
   			 <strong>Warrning!</strong> <%out.print(request.getAttribute("errorlname")); %>
  				</div>	
				<% } %>
				 	
    
            <br>
            <div class="input-group-lg">
                <input type="text" class=" loginInput form-control" placeholder="E mail" name="email" required/>
            </div>
            
             <%
              if(request.getAttribute("errorEmail") != null){ %>
    		 <br>
    		 <div class="alert alert-danger">
   			 <strong>Warrning!</strong>  <%out.print(request.getAttribute("errorEmail")); %>
  				</div>	
				<% } %>
					
			 <%
              if(request.getAttribute("errorEmail2") != null){ %>
    		 <br>
    		 <div class="alert alert-danger">
   			 <strong>Warrning!</strong> <%out.print(request.getAttribute("errorEmail2")); %><a href="login.jsp" >Click here to Login</a>
  				</div>	
				<% } %>
				
            <br>
            <div class="input-group-lg">
                <input type="number" class=" loginInput form-control" placeholder="Account Number" name="accNo" required/>
            </div>
            
            <%
              if(request.getAttribute("errorACCNO") != null){ %>
    		 <br>
    		 <div class="alert alert-danger">
   			 <strong>Warrning!</strong><%out.print(request.getAttribute("errorACCNO")); %>
  				</div>	
				<% } %>
				
			<!-- Security key check -->
			
			 <br>
            <div class="input-group-lg">
                <input type="text" class=" loginInput form-control" placeholder="Security Key" name="securityKey" required/>
            </div>
            
            <%
              if(request.getAttribute("errorSecurityKey") != null){ %>
    		 <br>
    		 <div class="alert alert-danger">
   			 <strong>Warrning!</strong><%out.print(request.getAttribute("errorSecurityKey"));%>
  				</div>	
				<% } %>
				
            <br>
            <div class="input-group-lg">
                <input type="password" class=" loginInput form-control" placeholder="Creat Password" name="creatPass" required/>
            </div>
            <br>
            <div class="input-group-lg">
                <input type="password" class=" loginInput form-control" placeholder="Confirm Password" name="ConfirmPass" required/>
            </div>
            
            <%
              if(request.getAttribute("errorPass") != null){ %>
    		 <br>
    		 <div class="alert alert-danger">
   			 <strong>Warrning!</strong> <%out.print(request.getAttribute("errorPass"));%>
  				</div>	
				<% } %>
				
				
            <br>
            <input type="submit" value="Register" class=" btn btn-lg btn-primary " style="width:60%">
        </form>
        <br>
        <h5>Already a member ? <a href="login.jsp">Login here</a> </h5>

    </div>


</div>

<div>
<jsp:include page="footer.jsp" />
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>