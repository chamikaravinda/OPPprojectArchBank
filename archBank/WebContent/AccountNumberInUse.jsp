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

String name = (String)request.getSession().getAttribute("authority");  

if(name != null){
	
		session.removeAttribute("authority");
		session.invalidate();
		}


else{
	 response.sendRedirect("index.jsp");
}

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1

response.setHeader("Pragma","no-cache");//HTTP 1.0;

response.setHeader("Expires","0");//proxies
 
%>

<div class="container">
    <div class="col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-1">

        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-10 ">
            <center>
                <br>
                <br>
            <a href="index.jsp"><img src="image/banklogo.png" style="width:50%;margin: 30px"></a>
           
            <h2>This Account Number already has a Online Bank Account</h2>
            <p> The bank account Number your trying to use already has an online bank account.You can log in to your bank account from <a href="login.jsp">here</a>.
            If that account isn't your please contact our customer care service.</p>
            <br>
            <br>
            <a  href="index.jsp" class=" btn btn-lg btn-primary " style="width:30%">Back Home</a>
            
                    <br>
              
            </center>
        </div>

    </div>
</div>

<div style="margin-top: 207.5px ">
<jsp:include page="footer.jsp" />
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>