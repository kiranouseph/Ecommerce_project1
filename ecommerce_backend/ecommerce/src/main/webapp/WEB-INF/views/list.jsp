<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Listing</title>

</head>
<body>

    <jsp:include page="header.jsp" />  
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




                       
                           
                       
                   

<table class="table package-table" >

                           
                                <tbody>
                                <thead>
						<tr>
							<th style="width:50%"></th>
							<th style="width:25%"></th>
							<th style="width:25%"></th>
							
							
						</tr>
					</thead>
    						<c:forEach var="designate" items="${list}">	
								<c:if test="${status eq 1}">
						
								 <tr> 
								 
                                    <td>${designate.prodname}</td>
                                   
                                   <td>
                                   <a href="retrieve?id=${designate.id}&num=1">
                                  <button type="button" class="btn btn-success">UPDATE</button>
                                   </a>
                                   </td>

                                    <td>
                                    <a href="delete?id=${designate.id} && num=1">
                               <button type="button" class="btn btn-danger">DELETE</button>
                                    </a>
                                    </td>
                                   
                                </tr>
								</c:if>
								<c:if test="${status eq 2}">
								
								 <tr> 
								 
                                    <td>${designate.categoryname}</td>
                                   <td>
                                   <a href="retrieve?id=${designate.id}&num=2">
                                  <button type="button" class="btn btn-success">UPDATE</button>
                                   </a>
                                   </td>
                                    <td>
                                    <a href="delete?id=${designate.id} && num=2">
                                   <button type="button" class="btn btn-danger">DELETE</button>
                                    </a>
                                    </td>
                                    
                                </tr>
								</c:if>
								<c:if test="${status eq 3}">
								
								 <tr> 
								 
                                    <td>${designate.subcategoryname}</td>
                                   <td>
                                   <a href="retrieve?id=${designate.id}&num=3">
                                   <button type="button" class="btn btn-success">UPDATE</button>
                                   </a>
                                   </td>
                                    <td>
                                    <a href="delete?id=${designate.id} && num=3">
                                    <button type="button" class="btn btn-danger">DELETE</button>
                                    </a>
                                    </td>
                                    
                                </tr>
								</c:if>
							
								<c:if test="${status eq 4}">
								 <tr> 
								 
                                    <td>${designate.suppname}</td>
                                    <td>
                                   <a href="retrieve?id=${designate.id}&num=4">
                                  <button type="button" class="btn btn-success">UPDATE</button>
                                   </a>
                                   </td>
									<td>
                                    <a href="delete?id=${designate.id} && num=4">
                                    <button type="button" class="btn btn-danger">DELETE</button>
                                    </a>
                                    </td>                                    
                                </tr>
								</c:if>
							
 </c:forEach> 
                                </tbody>
                            </table>
                            
                             



   <jsp:include page="footer.jsp" />  

</body>
</html>