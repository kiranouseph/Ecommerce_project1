<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>updatesupplier</title>
</head>
<body>
<c:if test="${status eq 1}">
<form action="" method="post">
      <table >
     
  
  <tr><td >PRODUCT ID</td><td><input type="number"  name="prid"  style=" opacity: 0.65; cursor: not-allowed; width:100%" placeholder="${listt.id }"></td></tr>
<tr><td>NAME</td><td><input type="text"  name="name" required style="width:100%" placeholder="${listt.prodname }"></td></tr>
<tr><td>DESCRIPTION</td><td><textarea rows="4" cols="50" name="desc" style="width:100%" placeholder="${listt.proddecs }"></textarea></td></tr>
<tr><td>PRICE</td><td><input type="number"  name="price" required style="width:100%" placeholder="${listt.price }"></td></tr>
<tr><td>STOCK</td><td><input type="number"  name="stock" required style="width:100%" placeholder="${listt.stock }"></td></tr>


<tr><td>CATEGORY</td><td><select name="cat" style="width:100%">
<option value="desigType">${listt.subcategory.category.categoryname}</option>
<c:forEach var="designatee" items="${catego}">
                       
                            <option value="${designatee.id}">${designatee.categoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>

<tr><td>SUBCATEGORY</td><td><select name="scat" style="width:100%">
<option value="desigType">${listt.subcategory.subcategoryname}</option>
<c:forEach var="designatee" items="${subcatego}">
                       
                            <option value="${designatee.id}">${designatee.subcategoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>
<tr><td>SUPPLIER</td><td><select name="supp" style="width:100%">
<option value="desigType">${ listt.supplier.suppname}</option>
 <c:forEach var="designate" items="${suppli}">
                       
                            <option value="${designate.id}">${designate.suppname}</option>
                       
                    </c:forEach> 
</select></td></tr>



<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD" style="width:100%"></td></tr>
</table>
</form>


</c:if>


<c:if test="${status eq 2}">

<form action="" method="post">

      <table >
     

<tr><td>CATEGORY  ID</td><td><input type="number"   name="suppid"   placeholder="${listt.id }" style="opacity: 0.65; cursor: not-allowed;width:100%" ></td></tr>
<tr><td>CATEGORY NAME</td><td><input type="text"  name="suppname" required style="width:100%"  placeholder="${listt.categoryname }"></td></tr>


<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" style="width:100%"></td></tr>

</table>

</form> 
</c:if>
<c:if test="${status eq 3}">
<tr><td>SUBCATEGORY  ID</td><td><input type="number"   name="suppid"   placeholder="${listt.id }" style="opacity: 0.65; cursor: not-allowed;width:100%" ></td></tr>
<tr><td>SUBCATEGORY NAME</td><td><input type="text"  name="suppname" required style="width:100%"  placeholder="${listt.subcategoryname }"></td></tr>
<tr><td>CATEGORY</td><td><select name="cat" style="width:100%">
<option value="desigType">${listt.category.categoryname}</option>
<c:forEach var="designatee" items="${catego}">
                       
                            <option value="${designatee.id}">${designatee.categoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>
<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" style="width:100%"></td></tr>

</c:if>
<c:if test="${status eq 4}">


<form action="${listt.id}/4/update" method="post">

      <table >
     

<tr><td>SUPPLIER ID</td><td><input type="number"   name="suppid"   placeholder="${listt.id }" style="opacity: 0.65; cursor: not-allowed;width:100%" ></td></tr>
<tr><td>SUPPLIER NAME</td><td><input type="text"  name="suppname" required style="width:100%"  placeholder="${listt.suppname }"></td></tr>
<tr><td>SUPPLIER<br> ADDRESS</td><td><textarea rows="4" cols="50" name="suppaddress" style="width:100%"  placeholder="${listt.suppdesc }"></textarea></td></tr>

<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" style="width:100%"></td></tr>

</table>

</form> 



</c:if>
</body>
</html>