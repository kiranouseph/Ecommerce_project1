<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<head>
<title>Shopping cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  </head>
<body>
<%@ include file = "header.jsp" %>
<body>

  

<div class="container">
	<table id="cart"  style="color:black" >
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="design" items="${cartt}">
						<tr>
						
							<td data-th="Product">
								<div class="row">
								
									<div class="col-sm-2 "><img src="resources/img/Herrera-Man-United-Jersey-Gallery.jpg" alt="Chania" width="100" height="100" class="img-responsive"/></div>
									<div class="col-sm-10">
									 
										<h4 class="nomargin">MAN UTD JERSEY</h4>
										<p>paul pogba man utd t shirt NO 6
										</p>	</div>
								</div>
							</td>
							<td data-th="Price">${design.price }</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="${design.quantity }">
							</td>
							<td data-th="Subtotal" class="text-center">${design.price }</td>
							
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>${design.price }</strong></td>
						</tr>
						<tr>
							<td><a href="#" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total $29.99</strong></td>
							<td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>