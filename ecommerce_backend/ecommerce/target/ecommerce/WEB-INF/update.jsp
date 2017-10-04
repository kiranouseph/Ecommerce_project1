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
<title>Insert title here</title>
</head>
<body>
<c:if test="${status eq 1}">


</c:if>


<c:if test="${status eq 2}">


</c:if>
<c:if test="${status eq 3}">


</c:if>
<c:if test="${status eq 4}">
<form action="${designate.id}/4/update" method="post">
      <table >
     
      
<tr><td>SUPPLIER ID</td><td><input type="number"  required name="suppid"   placeholder="${listt.id }" style="opacity: 0.65; cursor: not-allowed;width:100%" ></td></tr>
<tr><td>SUPPLIER NAME</td><td><input type="text"  name="suppname" required style="width:100%"  placeholder="${listt.suppname }"></td></tr>
<tr><td>SUPPLIER<br> ADDRESS</td><td><textarea rows="4" cols="50" name="suppaddress" style="width:100%"  placeholder="${listt.suppdesc }"> </textarea></td></tr>

<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" style="width:100%"></td></tr>
</table>
</form> 

</c:if>
</body>
</html>