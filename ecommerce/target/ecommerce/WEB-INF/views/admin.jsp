<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="addbask.css" rel="stylesheet" type="text/css">
<style>
/* USER PROFILE PAGE */






.btn-pref .btn {
    -webkit-border-radius:0 !important;
}

.btnns
{
	margin-top:5cm;
	margin-left:6cm;
}
table
{
	
   
border-collapse: separate;
    border-spacing: 10px ;
}
.m
{
	margin-left: 14cm;
}
</style>
<script>

<script type="text/javascript">
$(window).load(function(){
    $('#test').modal('show');
});
$(document).ready(function() {
	$(".btn-pref .btn").click(function () {
	    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
	    // $(".tab").addClass("active"); // instead of this do the below 
	    $(this).removeClass("btn-default").addClass("btn-primary");   
	});
	});
</script>
  </head>
<body bgcolor="black">
    <jsp:include page="header.jsp" />  


<c:if test="${suppexist eq 1}">
<h1 style="color:red" align="center">Supplier already exist or provided email id is not valid </h1>

</c:if>
<div class="container"><h1 style="margin-left: 30%;">ADMIN  </h1></div>
<div id="exTab1" class="container">	
<ul  class="nav nav-pills">
			<li class="active">
        <a  href="#1a" data-toggle="tab">PRODUCTS</a>
			</li>
			<li class=""><a href="#2a" data-toggle="tab">SUPPLIER</a>
			</li>
			<li><a href="#3a" data-toggle="tab">CATEGORY</a>
			</li>
			<li><a href="#4a" data-toggle="tab">SUBCATEGORY</a>
			</li>
  		
				<li >
        <a  href="#5a" data-toggle="tab">MODIFICATIONS</a>
			</li>
		</ul>
		
		
		

			<div class="tab-content clearfix">
			
			
			
			  <div class="tab-pane active" id="1a">
     
     <form action="product" method="post" enctype="multipart/form-data">
      <table >
     
  

<tr><td>NAME</td><td><input type="text"  name="name" required style="width:100%"></td></tr>
<tr><td>DESCRIPTION</td><td><textarea rows="4" cols="50" name="desc" style="width:100%"> </textarea></td></tr>
<tr><td>PRICE</td><td><input type="number"  name="price" required style="width:100%" min="1" max="100000"></td></tr>
<tr><td>STOCK</td><td><input type="number"  name="stock" required style="width:100%" min="1" max="100000"></td></tr>
<tr><td>IMAGE</td><td><input type="file" name="image" required></td></tr>


<tr><td>CATEGORY</td><td><select name="cat" style="width:100%">
<option value="desigType">Select Designation</option>
<c:forEach var="designatee" items="${catego}">
                       
                            <option value="${designatee.id}">${designatee.categoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>

<tr><td>SUBCATEGORY</td><td><select name="scat" style="width:100%">
<option value="desigType">Select Designation</option>
<c:forEach var="designatee" items="${subcatego}">
                       
                            <option value="${designatee.id}">${designatee.subcategoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>
<tr><td>SUPPLIER</td><td><select name="supp" style="width:100%">
<option value="desigType">Select Designation</option>
 <c:forEach var="designate" items="${suppli}">
                       
                            <option value="${designate.id}">${designate.suppname}</option>
                       
                    </c:forEach> 
</select></td></tr>



<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD" style="width:100%"></td></tr>
</table>
</form>
     
     
     
     
     
				</div>
				
				
				
				
				
				<div class="tab-pane" id="2a">
         

<form action="supplier" method="post" >
      <table >
     
      
<tr><td>SUPPLIER ID</td><td><input type="number"  name="suppid" required style="width:100%"></td></tr>
<tr><td>SUPPLIER NAME</td><td><input type="text"  name="suppname" required style="width:100%"></td></tr>
<tr><td>SUPPLIER<br> ADDRESS</td><td><textarea rows="4" cols="50" name="suppaddress" style="width:100%"> </textarea></td></tr>
<tr><td>SUPPLIER<br> EMAIL</td><td><input type="text"  name="suppemail" required style="width:100%"></td></tr>
<tr><td>SUPPLIER<br> MOBILE NO:</td><td><input type="number"  name="suppmob" required style="width:100%"></td></tr>

<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD" style="width:100%"></td></tr>
</table>
</form> 
        </div>
        
        
        
        
        
        
        
      <div class="tab-pane" id="3a">   
                        <form action="category" method="post" enctype="multipart/form-data">
      <table >
     
      
<tr><td>CATEGORY ID</td><td><input type="number"  name="catid" required style="width:200%"></td></tr>
<tr><td>CATEGORY NAME</td><td><input type="text"  name="catname" required style="width:200%"></td></tr>
<tr><td>CATEGORY DESCRIPTION</td><td><input type="text"  name="catdesc" required style="width:200%"></td></tr>
<tr><td>IMAGE</td><td><input type="file" name="image" required></td></tr>
<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD" style="width:200%"></td></tr>
</table>
</form>




				</div>
				
				
				
				
				
				
				
				
				
        <div class="tab-pane" id="4a">
        

<form action="subcategory" method="post" enctype="multipart/form-data">
      <table >
     
<tr><td>CATEGORY</td><td><select name="scat" style="width:200%">
<option value="desigType">Select Designation</option>
<c:forEach var="designatee" items="${catego}">
                       
                            <option value="${designatee.id}">${designatee.categoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>
      
<tr><td>SUBCATEGORY ID</td><td><input type="number"  name="scatid" required style="width:200%"></td></tr>
<tr><td>SUBCATEGORY NAME</td><td><input type="text"  name="scatname" required style="width:200%"></td></tr>
<tr><td>IMAGE</td><td><input type="file" name="image" required></td></tr>

<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD" style="width:200%"></td></tr>
</table>
</form>




				</div>
         
				
							<div class="tab-pane" id="5a">
         <a href="list?num=1&&f=">LIST OF PRODUCTS</a><br><br>
         <a href="list?num=2&&f=">LIST OF CATEGORIES</a><br><br>
       <a href="list?num=3&&f=">LIST OF SUBCATEGORIES</a><br><br>
         <a href="list?num=4&&f=">LIST OF SUPPLIERS</a><br><br>
          <a href="offers">OFFERS</a><br><br>
                    <a href="messages">MESSAGES</a><br><br>
  <a href="orders">ORDERS</a><br><br>
          
         
				</div>
				
				
				
			</div>
  </div>


 
 
  
   <jsp:include page="footer.jsp" />  
</body>
</html>