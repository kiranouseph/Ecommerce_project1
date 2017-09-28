<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<head>
<title>Shopping cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<body style=" background-color:white">
    <nav class="navbar navbar-default">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            
          </button>
          <a href="index.jsp"><button type="button" class="btn btn-info btn-lg" style="margin-top:5px; ">BUY IT</button></a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
           
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="admin">ADMIN</a></li>
           <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
         <c:forEach var="designate" items="${catego}">
                       
                           <li><a href="${designate.id}">${designate.categoryname}</a></li>
                       
                    </c:forEach> 
          
          
           
         
        </ul>
      </li>
            <li><a href="cart">Shopping cart</a></li>
            <li><a href="#">Checkout</a></li>
            
            <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </ul>
     

        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
      <form class="navbar-form navbar-right">
  <div class="input-group">
    <input type="text" class="form-control" placeholder="Search">
    <div class="input-group-btn">
      <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </div>
  </div>
    </nav><!-- /.navbar -->
  

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
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-4 "><img src="https://static.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg" alt="Chania" width="200" height="200" class="img-responsive"/></div>
									<div class="col-sm-8">
										<h4 class="nomargin">ROSE</h4>
										<p>   R ed,pink and in so many colours 
       O bviously the king of the flowers 
       S cents with the purest divinity 
        E ven if you have it's enmity 
										</p>	</div>
								</div>
							</td>
							<td data-th="Price">$29.99</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="1"/>
							</td>
							<td data-th="Subtotal" class="text-center">29.99</td>
							
						</tr>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total 29.99</strong></td>
						</tr>
						<tr>
							<td><a href="#" class="btn btn-warning"><i class="fa fa-angle-left"></i>Continue 
							Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total $29.99</strong></td>
							<td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>
<footer>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/Ecommerce/all_help">HELP</a></li>
      <li><a href="/Ecommerce/all_about">About</a></li>
      <li><a href="/Ecommerce/all_help">Contact</a></li>
      <li><a href="/Ecommerce/all_policy">Policies</a></li>
      <li><a>@Copyright</a></li>
    </ul>
    
  </div>
</nav>
</footer>
</body>
</html>