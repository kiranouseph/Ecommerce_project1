<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="cartt.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
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
          <a href="index.jsp"><button type="button" class="btn btn-info btn-lg"  >BUY IT</button></a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">flowers</a></li>
            <li><a href="#">occassions</a></li>
            <li><a href="cart.jsp">Shopping cart</a></li>
            <li><a href="">Checkout</a></li>
            <li>
              <a href="login.jsp">Sign in</a>
            </li>
          </ul>

        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
<h1>SHOPPING CART</h1>
<br>

<br>
<table class="table table-striped">
  <thead>
    <tr>
      <th>#</th>
      <th>image</th>
      <th>product name</th>
      <th>Model</th>
      <th>Quantity</th>
      <th>price</th>
      <th>total</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td></td>
      <td> Basket of Fruits </td>
      <td>CUCO3112 </td>
      <td>2</td>
      <td>200 </td>
      <td>400 </td>
      
    </tr>
    <tr>
      <th scope="row">2</th>
      <td></td>
      <td>Roses One Dozen</td>
      <td>CUF2004</td>
      <td>3</td>
      <td>150</td>
      <td>450</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td></td>
      <td>Graceful Grandeur</td>
      <td>CUF2004</td>
      <td>2</td>
      <td>50</td>
       <td>100</td>
    </tr>
  </tbody>
</table>
</body>
</html>