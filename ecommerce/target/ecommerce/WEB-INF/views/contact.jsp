<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

.panel-order .row {
	border-bottom: 1px solid #ccc;
}
.panel-order .row:last-child {
	border: 0px;
}
.panel-order .row .col-md-1  {
	text-align: center;
	padding-top: 15px;
}
.panel-order .row .col-md-1 img {
	width: 50px;
	max-height: 50px;
}
.panel-order .row .row {
	border-bottom: 0;
}
.panel-order .row .col-md-11 {
	border-left: 1px solid #ccc;
}
.panel-order .row .row .col-md-12 {
	padding-top: 7px;
	padding-bottom: 7px; 
}
.panel-order .row .row .col-md-12:last-child {
	font-size: 11px; 
	color: #555;  
	background: #efefef;
}
.panel-order .btn-group {
	margin: 0px;
	padding: 0px;
}
.panel-order .panel-body {
	padding-top: 0px;
	padding-bottom: 0px;
}
.panel-order .panel-deading {
	margin-bottom: 0;
}                    

</style>  
</head>



<body>

<%@ include file = "header.jsp" %>
<div class="panel panel-default panel-order">
  <div class="panel-heading">
      <strong>Pending orders</strong>
      <div class="btn-group pull-right">
          <div class="btn-group">


		  </div>
		</div>
  </div>
  <c:forEach var="designate" items="${contacts}">	


<div class="panel-body">
  	<div class="row">
	  <div class="col-md-1"></div>
	  <div class="col-md-11">
		<div class="row">
		  <div class="col-md-12">
			
			
			<span>NAME</span><p style="font-size: 25px">${designate.name }</p>
			<span>SUBJECT</span><p style="font-size: 25px">${designate.subject }</p>
			<span>MESSAGE</span><p style="font-size: 25px">${designate.message }</p>
			
		  </div>
		 
		</div>
	  </div>
	</div>

</div>


 <div class="col-md-12">
			review made by Email id: ${designate.email}
		  </div>
</c:forEach>
</div>
    




<%@ include file = "footer.jsp" %>

</body>
</html>