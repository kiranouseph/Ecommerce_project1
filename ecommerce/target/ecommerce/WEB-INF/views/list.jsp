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

<c:forEach var="designate" items="${list}">
                       
                           
                       
                   

<table class="table package-table">

                            
                                <tbody>
    							
								<c:if test="${(status)}==1">
								 <tr> 
								 
                                    <td>list.prodname</td>
                                    <td>UPDATE</td>
                                    <td>DELETE</td>
                                    
                                </tr>
								</c:if>
								<c:if test="${(status)}==2">
								 <tr> 
								 
                                    <td>list.categoryname</td>
                                   <td>UPDATE</td>
                                    <td>DELETE</td>
                                    
                                </tr>
								</c:if>
								<c:if test="${(status)}==3">
								 <tr> 
								 
                                    <td>list.subcategoryname</td>
                                    <td>UPDATE</td>
                                    <td>DELETE</td>
                                    
                                </tr>
								</c:if>
								<c:if test="${(status)}==4">
								 <tr> 
								 
                                    <td>list.suppname</td>
                                   <td>UPDATE</td>
                                    <td>DELETE</td>
                                    
                                </tr>
								</c:if>
							

                                </tbody>
                            </table>
                             </c:forEach> 



</body>
</html>