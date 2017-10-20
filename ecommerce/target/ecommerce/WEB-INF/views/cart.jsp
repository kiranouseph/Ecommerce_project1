<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
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
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="addbask.css" rel="stylesheet" type="text/css">
<head>
<title>Shopping cart</title>
  
  </head>
<body>
<%@ include file = "header.jsp" %>
<body>

<c:if test="${fn:length(cartt) eq 0}">

<h2>NO PRODUCTS IN YOUR CART PLEASE ADD AND COME BACK</h2>

</c:if>
<c:if test="${fn:length(cartt) ge 1}">
<div class="container">
	<table id="cart"  style="color:black;border-collapse: separate;
    border-spacing: 10px ;" >
    				<thead>
						<tr>
							<th style="width:40%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th  style="width:5%"></th>
							<th  style="width:5%"></th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="design" items="${cartt}">
					
						<tr>
						
							<td data-th="Product">
								<div class="row">
								
									<div class="col-sm-2 "><img src="${pageContext.request.contextPath}/resources/products/${design.product.image}" alt="Chania" width="100" height="100" class="img-responsive"/></div>
									<div class="col-sm-10">
									 
										<h4 class="nomargin">${design.product.prodname }</h4>
										<p>
										</p>	</div>
								</div>
							</td>
							<td data-th="Price">${design.price }</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="${design.quantity }" readonly>
							</td>
							<td data-th="Subtotal" class="text-center">${design.price*design.quantity }</td>
							<td>
                                   <a href="cartretrieve?id=${design.cartid}">
                                  <i class="fa fa-refresh fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                   </a>
                                   </td>
                                   <td>
                                   <a href="cartdelete?id=${design.cartid}">
                                  <i class="fa fa-trash fa-3x" aria-hidden="true" style="width:50px;height:50px"></i>
                                   </a>
                                   </td>
						</tr>
						</c:forEach>
					
					</tbody>
					<tfoot>
						
						<tr>
							<td><a href="#" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total ${total}</strong></td>
							<td><a href="checkout" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>
</c:if>
<%@ include file = "footer.jsp" %>
</body>
</html>