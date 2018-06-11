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


 if (session.getAttribute("username") != null){
	 response.sendRedirect("homepage.jsp");
 }
%>

<div class="container-fluid homeBannerImage">

    <div class="row">
        <div class="col-lg-offset-1 col-md-offset-1 col-sm-offset-0 col-xs-offset-0">

            <div class="col-lg-11 col-md-11 col-sm-12 col-xs-12">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle Navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>

                            <a class="navbar-brand" href="#"><img src="image/banklogo.png" class="menu-logo"></a>

                        </div>

                        <!--<ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Login</a></li>
                        </ul>-->
                        <a class="btn btn-primary navbar-btn navbar-right loginButton" href="login.jsp" role="button">Login</a>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">Home<span class="sr-only">(current)</span></a></li>
                                <li><a href="#">About US</a></li>
                                <li><a href="#">Contac US</a></li>
                                <li><a href="#">Career</a></li>

                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Download<span class="caret"></span></a>

                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Lights</a></li>
                                        <li><a href="#">Camera</a></li>
                                        <li><a href="#">Action</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div><!-- navbar collapse end -->
                    </div><!-- container-fluid end -->
                </nav>

            </div>

        </div>
    </div>
            <div class="col-lg-offset-4 col-md-offset-3 col-sm-offset-2 col-xs-offset-0">
                <div class="col-lg-6 col-md-6 col-sm-8 col-xs-12 ">
                    <div class="homeBanner">
                        <h1 >Your money, in a good place.</h1>
                        <br><br>
                        <p>Millions of customers around the world use us for one simple reason: itâ€™s simple.
                            Just an email address and password will get you through to
                            checkout before you can reach for your wallet.</p>
                            <br>
                            <br>
                        <a class="btn regbutton btn-default btn-lg " href="register.jsp" role="button">Register</a>
                        <a class="btn regbutton btn-default btn-lg " href="#" role="button">Learn More</a>


                    </div>

                </div>
            </div>
</div>

<div class="container-fluid worldShoping">

    <div class="col-lg-offset-7 col-md-offset-7 col-sm-offset-2 col-xs-offset-0">
        <div class="col-lg-8 col-md-10 col-sm-8 col-xs-12 ">
            <div class="worldPayBanner">
                <br>
                <h1 >Shop around the world.</h1>
                <br><br>

                <p>No need to book a flight ticket to shop worldwide.
                    With a PayPal account you can shop at thousands
                    of stores around the world in just a few easy clicks,
                    knowing your card details are never shared with the seller.
                    Currency conversion fees may apply.
                </p>

                <br>

                <a href="#">Start Shopping</a>

            </div>
        </div>
    </div>
</div>

<div class="container-fluid mobilebank">

    <div class="col-lg-offset-1 col-md-offset-1 col-sm-offset-2 col-xs-offset-0">

        <div class="col-lg-4 col-md-6 col-sm-8 col-xs-12 ">
            <div class="mobilebankingBanner">
                <br>
                <h1 >Support All your Devices</h1>
                <br><br>
                <p>Our Mobile and Tablet Banking apps and mobile site (when searching via browser banksa.com.au)
                    are available on a wide range of devices with Android and iOS operating systems.
                </p>
                <br>
                <p>
                    While we support many devices, experiences and performances may vary,
                    certain features are not available on jailbroken or rooted devices.

                </p>
                <br>
                <a href="#">More about accessing the site via mobile devices</a>
            </div>
        </div>
    </div>


</div>

<div class="container-fluid onlineshoping">

    <div class="col-lg-offset-7 col-md-offset-7 col-sm-offset-2 col-xs-offset-0">

        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 ">
            <div class="onlineshoppingBanner">
                <br><br>
                <h1 >We got you coverd</h1>
                <br><br>
                <p>Shop with peace of mind, knowing we protect your eligible purchases.
                    If an eligible item doesnâ€™t show up, or turns out to be different
                    than described, weâ€™ll help sort things out with the seller.
                    Conditions apply.
                </p>
                <br>
                <a href="#">More about archBank Buyer Protection</a>
            </div>
        </div>
    </div>


</div>

<div class="container-fluid socialbar">
    <div style="margin-top:15px ">
        <center>

            <button class="socialiconbutton btn btn-default" href="facebook.com"><a href="https://www.facebook.com"><img src="image/socia_icon/facebook.png" class="socialicon"></a></button>
            <button class="socialiconbutton btn btn-default" ><a href="#"><img src="image/socia_icon/twitter.png" class="socialicon"></a></button>
            <button class="socialiconbutton btn btn-default"> <a href="#"><img src="image/socia_icon/linkind.png" class="socialicon"></a></button>
            <button class="socialiconbutton btn btn-default" ><a href="#"><img src="image/socia_icon/youtube.png" class="socialicon"></a></button>
            <button class="socialiconbutton btn btn-default" ><a href="#"><img src="image/socia_icon/insta.png" class="socialicon"></a></button>


        </center>
    </div>

    <div>
        <h6 style="color: white;text-align:center;background-color: #333333">Consumer advisory - archBank Pte.
            Ltd., the holder of archBank's stored value facility,
            does not require the approval of
            the Monetary Authority of Singapore. Users are advised
            to read the terms and conditions carefully.</h6>
    </div>


<div class="row">
    <div class="copywright">
        <center>
            <h4>Since 1999-€“2018 All rights reserved.archBank Incoparation</h4>
            <p><a href=AdministratorLogin.jsp>Admin Login</a></p>
        </center>
    </div>

</div>



</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>