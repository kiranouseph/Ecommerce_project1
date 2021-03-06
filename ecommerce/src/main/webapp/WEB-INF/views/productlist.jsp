<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Product list</title>
 
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="eff.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  
  body {
    background-image: url("${pageContext.request.contextPath}/resources/images/bglist.jpg");
    background-repeat: no-repeat;
     background-size: 100% 150vh;
     text-align: center;
}
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
    <jsp:include page="header.jsp" />  
<div class = "container">



<c:forEach items="${prods}" var="designate"  varStatus="loop">

<div class="col-lg-3 col-sm-4 hero-feature text-center">



      
        <!-- Thumbnail Images -->
        <div class="thumbnail"> <a href="prod?id=${designate.id}" class="link-p"> <img src="resources/products/${designate.image }" alt=""style="width:100%;height:200px"> </a>
          <!-- Offer Tag-->
       
          <div class="caption prod-caption"> 
            <div class="pro-name"><a href="prod?id=${designate.id}" class="animated fadeInRightShort go">${designate.prodname }</a></div>
            <c:if test="${designate.offerprice eq 0}">
            <p>
           
            </p><div class="btn-group"> <a href="prod?id=${designate.id}" class="btn btn-default"> <i class="fa fa-inr"></i> ${designate.price}</a> <a href="prod?id=${designate.id}" class="btn btn-primary"><span class="glyphicons glyphicons-zoom-in"></span>QUICK VIEW</a> </div>
            <p></p>
            </c:if>
                        <c:if test="${designate.offerprice ge 1}">
            <p>
           
            </p><div class="btn-group"> <a href="prod?id=${designate.id}" class="btn btn-default"> <i class="fa fa-inr"></i> ${designate.offerprice}</a> <a href="prod?id=${designate.id}" class="btn btn-primary"><span class="glyphicons glyphicons-zoom-in"></span>QUICK VIEW</a> </div>
            <p></p>
            </c:if>
          </div>
        </div>
      
 



</div>





</c:forEach>
</div>
<br>
<br>
<br>
<br>
<br>
  <jsp:include page="footer.jsp" />  

</body>
</html>