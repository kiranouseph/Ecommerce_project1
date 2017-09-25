<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
 
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="eff.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .cardcolor
{
background-color:white;	
}
table, th, td {
    border-collapse: separate;
    border-spacing: 10px ;
    
}


  </style>
</head>
<body>
 <nav class="navbar navbar-default">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            
          </button>
          <a href="index.jsp"><button type="button" class="btn btn-info btn-lg"  >BUY IT</button></a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
           <li><input class="form-control mr-sm-2" type="text" placeholder="Search"></li>
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="admin">ADMIN</a></li>
           <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
         <c:forEach var="designate" items="${catego}">
                       
                           <li><a href="${designate.id}">${designate.categoryname}</a></li>
                       
                    </c:forEach> 
          
          
           
         
        </ul>
      </li>
            <li><a href="cart">Shopping cart</a></li>
            <li><a href="#">Checkout</a></li>
            
            <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </ul>
     

        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
<div class = "container">



<c:forEach items="${prods}" var="designate"  varStatus="loop">
<c:if test="${(loop.count) % 5== 0}">
<br>
<br>
<br>
</c:if>
<a href="${designate.category.id}/${designate.id}">
<div class = "col-sm-3" align="center">
 <div id="mydiv" style="width:200px;background:white" onmouseover="this.style.background='yellow';" onmouseout="this.style.background='white';">

<table cellspacing="10" >
<tr>
<td><img src="https://static.pexels.com/photos/36753/flower-purple-lical-blosso.jpg" alt="Mountain View" style="width:100px;height:100px;"></td>
</tr>
<tr>


      
      <td >  
      
      ${designate.prodname}<br>
      ${designate.proddecs}<br>
      <i class="fa fa-rupee"></i>${designate.price} <br>
      ${designate.stock}<br>
      
     </td>




</tr>

</table>
</div>
<br>
</div>
</a>



<c:if test="${(loop.count) % 5== 0}">


</c:if>
</c:forEach>
</div>
</body>
</html>