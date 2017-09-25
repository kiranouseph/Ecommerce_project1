<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">
<head>
  <title>MY GIFT</title>
  <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="eff.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.company
{
font-color:red;
}
.bg-4 { 
    
    
     opacity: 0.5;
    filter: alpha(opacity=50);
}
.abc
{
color:black;
}
.body { 
background: url(flower/bg.jpg) no-repeat center center fixed; 
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}
.img
{
	width:600px;
height:50px;
	 
	}
.carousel slide
{
	margin-right:5px;
	margin-left:5px;
}
.navbar-brand
{
	font-size:40px;
}

.log
{
	margin-top:5cm;
}
.footer{
	background-color:white;
}
.cardcolor
{
background-color:white;	
}
</style>
</head>
<body >

  
    <!-- Second navbar for sign in -->
    
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
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="" class="img-responsive" alt="Chania" style="width:100%; height:100vh">
    </div>

    <div class="item">
      <img src="" class="img-responsive" alt="Chania" style="width:100%; height:100vh">
    </div>

    <div class="item">
      <img src="" class="img-responsive" alt="Flower" style="width:100%; height:100vh">
    </div>

    <div class="item">
      <img src="" class="img-responsive" alt="Flower" style="width:100%; height:100vh">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
 

<br>
 <div class="container-fluid">
 <div class="row">
  <div class="col-md-3">
  <div class="cardcolor">
   <div class="w3-container">
 

 <div  style="width:50%; height:50% ">
    <img src="flower/4.jpg" alt="Norway" style="width:200%; height:200%">
    <div class="w3-container w3-center" style="width:200%; height:200%">
      <p>Bloosoming Fantasy</p><br>
      <p>A dozen pink carnations in a glass vase with green fillers and some green </p><br>
      <p>500 rs</p><br> 
       <a href="#" class="btn btn-primary">Add to cart</a>
      
    </div>
  </div>
</div>
  
  
  </div>
 </div>
  <div class="col-md-3">
  <div class="cardcolor"> 
 <div class="w3-container">
  

  <div  style="width:50%; height:50% ">
    <img src="flower/3.jpg" alt="Norway" style="width:200%; height:200%">
    <div class="w3-container w3-center" style="width:200%; height:200%">
      <p>Bloosoming Fantasy</p><br>
      <p>A dozen pink carnations in a glass vase with green fillers and some green </p><br>
      <p>500 rs</p><br> 
       <a href="#" class="btn btn-primary">Add to cart</a>
      
    </div>
  </div>
</div>
  
  </div>
  </div>
  
   <div class="col-md-3">
    <div class="cardcolor">
  <div class="w3-container">


 <div  style="width:50%; height:50% ">
    <img src="flower/1.jpg" alt="Norway" style="width:200%; height:200%">
    <div class="w3-container w3-center" style="width:200%; height:200%">
      <p>Bloosoming Fantasy</p><br>
      <p>A dozen pink carnations in a glass vase with green fillers and some green </p><br>
      <p>500 rs</p><br> 
       <a href="#" class="btn btn-primary">Add to cart</a>
      
    </div>
  </div>
</div>
  </div>
   </div>
  
    <div class="col-md-3">
     <div class="cardcolor">
   <div class="w3-container">


  <div  style="width:50%; height:50% ">
    <img src="flower/2.jpg" alt="Norway" style="width:200%; height:200%">
    <div class="w3-container w3-center" style="width:200%; height:200%">
      <p>Bloosoming Fantasy</p><br>
      <p>A dozen pink carnations in a glass vase with green fillers and some green </p><br>
      <p>500 rs</p><br> 
       <a href="#" class="btn btn-primary">Add to cart</a>
      
    </div>
  </div>
</div>
  
    </div>
    </div>
    
   </div>
   </div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>



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





 </p> 

</body>
</html>
