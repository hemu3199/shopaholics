<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">      
	<link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="Bootstrap/css/bootstrap-theme.min.css.map" rel="stylesheet">
	<link href="Bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link href="Bootstrap/css/navbar-custom.css" rel="stylesheet"/>
	<link href="Bootstrap/css/sample.css" rel="stylesheet"/>
	<script src = "Bootstrap/js/jquery.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	<script src = "Bootstrap/js/bootstrap.js"></script>
	<script src = "Bootstrap/js/bootstrap.min.js"></script>
	<script src = "Bootstrap/js/bootstrap.npm.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopaholics</title>
</head>
<body>
<div class="container-fluid">
  		<div class="row">
    		<div class="col-sm-6"><img src =./IMG/slogo5.png></div>
    		<div class="col-sm-6"><span class="pull-right"></span><br>
      			<ul class="nav navbar-nav navbar-custom">
        		<li><a href="login.jsp"><span class="glyphicon glyphicon-shopping-cart">
        		<% HttpSession hs = request.getSession();
        		  int cartno = (Integer)hs.getAttribute("cartno");
			      out.print(cartno);%> </span></a></li>
        		<li><a href="login.jsp">Login</a></li>
       			<li><a href="signup.jsp">SignUp</a></li>
       			<li class="active"><a href="LSeller.jsp">seller</a></li>
     			</ul>
    		</div>
   		</div>
	</div>
</body>
</html>