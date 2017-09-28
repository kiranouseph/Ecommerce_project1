<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="eff.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h4>haiii</h4>
<c:if test="${status eq 1}">

<h1>LIST OF PRODUCTS</h1>
</c:if>
<c:if test="${status eq 2}">

<h1>LIST OF CATEGORIES</h1>

</c:if>

<c:if test="${status eq 3}">

<h1>LIST OF SUBCATEGORIES</h1>
</c:if>

<c:if test="${status eq 4}">

<h1>LIST OF SUPPLIERS</h1>
</c:if>



<c:forEach var="designate" items="${list}">
                       
                           
                       
                   

<table class="table package-table">

                            <thead>
                      
                            
                            
                          
                            </thead>
                                <tbody>
    							
								<c:if test="${status eq 1}">
						
								 <tr> 
								 
                                    <td>${designate.prodname}</td>
                                    <td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" ></td>
                                    <td>
                                    <a href="${designate.id}/1/delete">
                                    <input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="DELETE" >
                                    </a>
                                    </td>
                                   
                                </tr>
								</c:if>
								<c:if test="${status eq 2}">
								
								 <tr> 
								 
                                    <td>${designate.categoryname}</td>
                                   <td>
                                   <a href="${designate.id}/2/update">
                                   <input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" >
                                   </a>
                                   </td>
                                    <td>
                                    <a href="${designate.id}/2/delete">
                                    <input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="DELETE" >
                                    </a>
                                    </td>
                                    
                                </tr>
								</c:if>
								<c:if test="${status eq 3}">
								 <tr> 
								 
                                    <td>${designate.subcategoryname}</td>
                                    <td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" ></td>
                                   <td>
                                    <a href="${designate.id}/3/delete">
                                    <input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="DELETE" >
                                    </a>
                                    </td>
                                    
                                </tr>
								</c:if>
								<c:if test="${status eq 4}">
								 <tr> 
								 
                                    <td>${designate.suppname}</td>
                                   <td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" ></td>
<td>
                                    <a href="${designate.id}/4/delete">
                                    <input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="DELETE" >
                                    </a>
                                    </td>                                    
                                </tr>
								</c:if>
							

                                </tbody>
                            </table>
                             </c:forEach> 



</body>
</html>