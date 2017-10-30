<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
body {
    background-image: url("${pageContext.request.contextPath}/resources/images/giftt.jpg");
    background-repeat: no-repeat;
     background-size: 100% 70vh;
     text-align: center;
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
<script>

function checkst() {
    var newquantity = document.getElementById("quantnew").value;
    var previousquantity = document.getElementById("quantpre").value;
    var prodstock = document.getElementById("prodstck").value;
    if (prodstock<(newquantity-previousquantity)) {
    	 document.getElementById("error").innerHTML = "Requested quantity is more than stock";
        return false;
    }
    return true;
}



</script>
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

 <font id="error"size="25" color="red">${msg }</font>  

<div class="container">
	<table id="cart"  style="color:black;border-collapse: separate;
    border-spacing: 10px ;" >
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:22%">Quantity</th>
							<th style="width:8%" class="text-center">Subtotal</th>
							
							
						</tr>
					</thead>
					<tbody>
						
					
						<tr>
						
							<td data-th="Product">
								<div class="row">
								
									<div class="col-sm-2 "><img src="${pageContext.request.contextPath}/resources/products/${cartt.product.image}" alt="Chania" width="100" height="100" class="img-responsive"/></div>
									<div class="col-sm-10">
									 
										<h4 class="nomargin">${cartt.product.prodname }</h4>
										<p>
										</p>	</div>
								</div>
							</td>
							<td data-th="Price">${cartt.price }</td>
							<td data-th="Quantity">
							<form action="cartupdate">
							 <input id="prodId" name="id" type="hidden" value="${cartt.cartid}">
							  <input id="prodId" name="prid" type="hidden" value="${cartt.product.id}">
								<input type="number" class="form-control text-center" value="${cartt.quantity }" name="quantity" id="quantnew">
								<input type="hidden" class="form-control text-center" value="${cartt.quantity }" id="quantpre">
									<input type="hidden" class="form-control text-center" value="${cartt.product.stock }" id="prodstck">
							    <input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" style="width:100%" onclick="return checkst()">
							</form>
							</td>
							<td data-th="Subtotal" class="text-center">${cartt.price }</td>
							
							
                                 
						</tr>
						
					
					</tbody>
				
				</table>
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>