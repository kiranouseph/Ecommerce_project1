<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
$(document).ready(function() {
	$(".btn-pref .btn").click(function () {
	    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
	    // $(".tab").addClass("active"); // instead of this do the below 
	    $(this).removeClass("btn-default").addClass("btn-primary");   
	});
	});
</script>


</head>
<body>

 <jsp:include page="header.jsp" />  



<div class="container"><h1 style="margin-left: 30%;"> WELCOME ${pageContext.request.userPrincipal.name} </h1></div>
<c:if test="${flag eq 0 }">
<h2>Cannot delete.This product is in someone's cart</h2>
</c:if>
<div id="exTab1" class="container">	
<ul  class="nav nav-pills">
			<li class="active">
        <a  href="#1a" data-toggle="tab">ADD PRODUCTS</a>
			</li>
			<li class=""><a href="#2a" data-toggle="tab">VIEW PRODUCTS</a>
			</li>
			<li><a href="#3a" data-toggle="tab">SET OFFER</a>
			</li>
		
  		
	
		</ul>
		
		
		

			<div class="tab-content clearfix">
			
			
			
			  <div class="tab-pane active" id="1a">
     
     <form action="addprobysupp" method="post" enctype="multipart/form-data">
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




<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD" style="width:100%"></td></tr>
</table>
</form>
     
     
     
     
     
				</div>
				
				
				
				
				
				<div class="tab-pane" id="2a">
				
				
				
				
				
<table class="table package-table" >

                           
                                
                                <thead>
						<tr>
							<th style="width:80%"></th>
							<th style="width:10%"></th>
							<th style="width:10%"></th>
							
							
							
							
						</tr>
					</thead>
    						<c:forEach var="designate" items="${suppproo}">	
							
						<tbody>
								 <tr> 
									<td data-th="Product">
								<div class="row">
									<div class="col-sm-4 "><img src="${pageContext.request.contextPath}/resources/products/${designate.image}" alt="Chania" width="200" height="200" class="img-responsive"/></div>
									<div class="col-sm-8">
										<h4 class="nomargin">${designate.prodname}</h4>
										<p>
    
										</p>	</div>
								</div>
							</td>
							 <td>
                                   <a href="suppretrieve?id=${designate.id}">
                                  <i class="fa fa-refresh fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                   </a>
                                   </td>

                                    <td>
                                    <a href="suppdelete?id=${designate.id}">
                               <i class="fa fa-trash-o fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                    </a>
                                    </td>
                                   
                                </tr>
                                </tbody>
							
								</c:forEach>
								</table>
         

        </div>
        
        
        
        
        
        
        
      <div class="tab-pane" id="3a">   




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
			<c:forEach var="designate" items="${suppproo}">	
         <form action="suppoffersset?prid=${designate.id}&orgprice=${designate.price}" method="post">
      <table >
     
      
<tr>

<td>${designate.prodname}</td>
<td>${designate.price}</td>
<td><input type="number" name="offerprice" value="${designate.offerprice}"></td>

<td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="SUBMIT" ></td>
</tr>
</table>
</form> 
         


         
         
         
         
         
         
                </c:forEach>
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
					<c:forEach var="designate" items="${suppproo}">

  <c:if test="${designate.offer eq 1}">
<tr>
<td>${designate.prodname}</td>
                                   
 
<td>
${designate.price}
</td>

                                  
                                       
                                       
                                       
                                    <td>${designate.offerprice}</td>
                                      <td> 
                                    
                                      <a href="suppoffersdel?prid=${designate.id}"><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="DELETE"></a>
                                       </td>
                                       
                                       
                             
                              
                                   
                                </tr>
                                
    </c:if>                           
 </c:forEach>
                                </tbody>
								
								
 

 
 
 </table>
				
				
				
				
        










				</div>
    

			</div>
			</div>
			</div>
			</div>
			</div>







				</div>
				
				
				
				
				
				
				
				
				


				
			</div>
  </div>


 
 
  
   <jsp:include page="footer.jsp" />  


</body>
</html>