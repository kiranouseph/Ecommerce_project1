<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offers</title>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
table
{
	
   
border-collapse: separate;
    border-spacing: 10px ;
    cell-spacing:10px;

</style>
<body>
  <jsp:include page="header.jsp" />  












     <div class="container">
             <div class="row">
     <div class="col-md-12">
     
     <div id="exTab2" class="container">	
<ul class="nav nav-tabs">
			<li class="active">
        <a  href="#1" data-toggle="tab">MAKE OFFERS</a>
			</li>
			<li><a href="#2" data-toggle="tab">OFFERLIST</a>
			</li>
			
		</ul>

			<div class="tab-content ">
			  <div class="tab-pane active" id="1">
			  <div class="container">
			  
		
			<div class="row">
				<c:forEach var="designate" items="${prods}">
   
   
   
      <table class="table">
     
       <form action="offersset?prid=${designate.id}&orgprice=${designate.price}" method="post">
<tr>

<td style='width: 200px'>${designate.prodname}</td>
<td>${designate.price}</td>
     
<td><input type="number" name="offerprice" value="${designate.offerprice}" min="1"></td>

<td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="SUBMIT" ></td>

</tr>
</form> 
</table>



                </c:forEach>         


         
         
         
         
         </div>
         </div>

				
				</div>
				<div class="tab-pane" id="2">
				
				
				
				
				
 <table>
<thead>
						<tr>
							<th style="width:30%">Productname</th>
							<th style="width:20%">actual price</th>
							<th style="width:20%">offerprice</th>
							<th style="width:30%" class="text-center"></th>
							
						</tr>
					</thead>
					<tbody>
					<c:forEach var="designate" items="${offproducts}">

  
<tr>
<td>${designate.prodname}</td>
                                   
 
<td>
${designate.price}
</td>

                                  
                                       
                                       
                                       
                                    <td>${designate.offerprice}</td>
                                      <td> 
                                    
                                      <a href="offersdel?prid=${designate.id}"><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="DELETE"></a>
                                       </td>
                                       
                                       
                             
                              
                                   
                                </tr>
                                
 </c:forEach>
                                </tbody>
								
								
 

 
 
 </table>
				
				
				
				
        










				</div>
    

			</div>
			</div>
			</div>
			</div>
			</div>



  <jsp:include page="footer.jsp" />  

</body>
</html>