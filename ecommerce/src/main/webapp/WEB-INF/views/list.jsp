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
<style>





.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
    font-color:black;
}


@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}

</style>
</head>
<body>

    <jsp:include page="header.jsp" />  
<c:if test="${status eq 1}">

<h1 style="text-align:center">LIST OF PRODUCTS</h1>
</c:if>
<c:if test="${status eq 2}">

<h1 style="text-align:center">LIST OF CATEGORIES</h1>

</c:if>
<c:if test="${status eq 3}">

<h1 style="text-align:center">LIST OF SUBCATEGORIES</h1>
</c:if>



<c:if test="${status eq 4}">

<h1 style="text-align:center">LIST OF SUPPLIERS</h1>
</c:if>


<font size="10" color="red">${msg }</font>



                       
                           
                       
                   

<table class="table package-table" >

                           
                                
                                <thead>
						<tr>
							<th style="width:80%"></th>
							<th style="width:10%"></th>
							<th style="width:10%"></th>
							
							
							
							
						</tr>
					</thead>
    						<c:forEach var="designate" items="${list}">	
								<c:if test="${status eq 1}">
						<tbody>
								 <tr> 
									<td data-th="Product">
								<div class="row">
									<div class="col-sm-4 "><img src="${pageContext.request.contextPath}/resources/products/${designate.image}" alt="Chania" width="200" height="200" class="img-responsive"/></div>
									<div class="col-sm-8">
										<h4 class="nomargin">${designate.prodname}</h4>
										<h4 class="nomargin">Price       :${designate.price}</h4>
										<h4 class="nomargin">Description :${designate.proddecs}</h4>
										<h4 class="nomargin">Subcategory : ${designate.subcategory.subcategoryname}</h4>
										<h4 class="nomargin">Category    :${designate.subcategory.category.categoryname}</h4>
										
										
										</div>
								</div>
							</td>
							 <td>
                                   <a href="retrieve?id=${designate.id}&num=1">
                                  <i class="fa fa-refresh fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                   </a>
                                   </td>

                                    <td>
                                    <a href="delete?id=${designate.id}&num=1">
                               <i class="fa fa-trash-o fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                    </a>
                                    </td>
                                   
                                </tr>
                                </tbody>
								</c:if>
								<c:if test="${status eq 2}">
								
									<tbody>
								 <tr> 
									<td data-th="Product">
								<div class="row">
									<div class="col-sm-4 "><img src="${pageContext.request.contextPath}/resources/products/${designate.catimage}" alt="Chania" width="200" height="200" class="img-responsive"/></div>
									<div class="col-sm-8">
										<h4 class="nomargin">${designate.categoryname}</h4>
										<h4 class="nomargin">Description:${designate.categorydesc}</h4>
										<p>
    
										</p>	</div>
								</div>
							</td>
							 <td>
                                   <a href="retrieve?id=${designate.id}&num=2">
                                  <i class="fa fa-refresh fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                   </a>
                                   </td>

                                    <td>
                                    <a href="delete?id=${designate.id}&num=2">
                               <i class="fa fa-trash-o fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                    </a>
                                    </td>
                                   
                                </tr>
                                </tbody>
								</c:if>
								<c:if test="${status eq 3}">
								
								<tbody>
								 <tr> 
									<td data-th="Product">
								<div class="row">
									<div class="col-sm-4 "><img src="${pageContext.request.contextPath}/resources/products/${designate.subcatimage}" alt="Chania" width="200" height="200" class="img-responsive"/></div>
									<div class="col-sm-8">
										<h4 class="nomargin">${designate.subcategoryname}</h4>
										<p>
    
										</p>	</div>
								</div>
							</td>
							 <td>
                                   <a href="retrieve?id=${designate.id}&num=3">
                                  <i class="fa fa-refresh fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                   </a>
                                   </td>

                                    <td>
                                    <a href="delete?id=${designate.id}&num=3">
                               <i class="fa fa-trash-o fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                    </a>
                                    </td>
                                   
                                </tr>
                                </tbody>
								</c:if>
							
								<c:if test="${status eq 4}">
									<tbody>
								 <tr> 
									<td data-th="Product">
								<div class="row">
									
									<div class="col-sm-12">
										<h4 class="nomargin">${designate.suppname}</h4>
										<h4 class="nomargin">Address:${designate.suppdesc}</h4>
										
										<p>
    
										</p>	</div>
								</div>
							</td>
							 <td>
                                   <a href="retrieve?id=${designate.id}&num=4">
                                  <i class="fa fa-refresh fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                   </a>
                                   </td>

                                    <td>
                                    <a href="delete?id=${designate.id}&num=4">
                               <i class="fa fa-trash-o fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                    </a>
                                    </td>
                                   
                                </tr>
                                </tbody>
								</c:if>
							
 </c:forEach> 
                                
                            </table>
                            
                             



   <jsp:include page="footer.jsp" />  

</body>
</html>