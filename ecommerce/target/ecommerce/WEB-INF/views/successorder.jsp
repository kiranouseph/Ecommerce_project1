<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body {
    background-image: url("${pageContext.request.contextPath}/resources/images/blancard.jpg");
    background-repeat: no-repeat;
    background-size:cover;
     
}

#slanting
{
-ms-transform: rotate(-25deg); /* IE 9 */
    -webkit-transform: rotate(-25deg); /* Chrome, Safari, Opera */
    transform: rotate(-25deg);
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">

<div class="row">
<div class="col-md-4 col-md-offset-4">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div id="slanting">
<h3> THANK YOU FOR SHOPPING FROM GIFTERY</h3>
<h5>Your gift will be delivered soon</h5>
<h5>Check email for the details</h5>
<a href="./" class="btn btn-success btn-outline-rounded green"> continue shopping <span style="margin-left:10px;" class="glyphicon glyphicon-shopping-cart"></span></a>
</div>

</div>

</div>
</div>
<br><br>       
      <jsp:include page="footer.jsp"/>             
</body>
</html>