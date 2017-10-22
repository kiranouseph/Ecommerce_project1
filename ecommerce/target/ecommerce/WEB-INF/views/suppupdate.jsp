<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product update by supplier</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%@ include file = "header.jsp" %>
<div style="padding-left:25%; padding-top:15%">
<form action="suppupdatee" method="post" enctype="multipart/form-data">
      <table >
     
  
  <tr><td >PRODUCT ID</td><td><input type="number"  name="prid"  style=" opacity: 0.65; cursor: not-allowed; width:100%" value="${listt.id }"></td></tr>
<tr><td>NAME</td><td><input type="text"  name="name" required style="width:100%" value="${listt.prodname }"></td></tr>
<tr><td>DESCRIPTION</td><td><textarea rows="4" cols="50" name="desc" style="width:100%" >${listt.proddecs}</textarea></td></tr>
<tr><td>PRICE</td><td><input type="number"  name="price" required style="width:100%" value="${listt.price }"></td></tr>
<tr><td>STOCK</td><td><input type="number"  name="stock" required style="width:100%" value="${listt.stock }"></td></tr>
<tr><td>IMAGE</td><td><input type="file" name="image" value="${listt.image}"accept="D:/PRODIMAGES/${listt.image}"></td></tr>
<tr><td><img src="D:/PRODIMAGES/${listt.image}" style="width:100px;height:100px"></td></tr>
<tr><td>CATEGORY</td><td><select name="cat" style="width:100%">
<option value="${listt.subcategory.category.id}" selected>${listt.subcategory.category.categoryname}</option>
<c:forEach var="designatee" items="${catego}">
                       
                            <option value="${designatee.id}">${designatee.categoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>

<tr><td>SUBCATEGORY</td><td><select name="scat" style="width:100%">
<option value="${listt.subcategory.id}" selected>${listt.subcategory.subcategoryname}</option>
<c:forEach var="designatee" items="${subcatego}">
                       
                            <option value="${designatee.id}">${designatee.subcategoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>



<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD" style="width:100%"></td></tr>
</table>
</form>
</div>

<%@ include file = "footer.jsp" %>
</body>
</html>