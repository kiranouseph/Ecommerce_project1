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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  /*Some CSS*/
* {margin: 0; padding: 0;}
.magnify {width: 200px; margin: 50px auto; position: relative; cursor: none}

/*Lets create the magnifying glass*/
.large {
	width: 175px; height: 175px;
	position: absolute;
	border-radius: 100%;
	
	/*Multiple box shadows to achieve the glass effect*/
	box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 
	0 0 7px 7px rgba(0, 0, 0, 0.25), 
	inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
	
	/*hide the glass by default*/
	display: none;
}

/*To solve overlap bug at the edges during magnification*/
.small { display: block; }
  table
{
	
   
border-collapse: separate;
    border-spacing: 10px ;
}
  </style>
  <script>

  $(document).ready(function(){

		var native_width = 0;
		var native_height = 0;
	  $(".large").css("background","url('" + $(".small").attr("src") + "') no-repeat");

		//Now the mousemove function
		$(".magnify").mousemove(function(e){
			//When the user hovers on the image, the script will first calculate
			//the native dimensions if they don't exist. Only after the native dimensions
			//are available, the script will show the zoomed version.
			if(!native_width && !native_height)
			{
				//This will create a new image object with the same image as that in .small
				//We cannot directly get the dimensions from .small because of the 
				//width specified to 200px in the html. To get the actual dimensions we have
				//created this image object.
				var image_object = new Image();
				image_object.src = $(".small").attr("src");
				
				//This code is wrapped in the .load function which is important.
				//width and height of the object would return 0 if accessed before 
				//the image gets loaded.
				native_width = image_object.width;
				native_height = image_object.height;
			}
			else
			{
				//x/y coordinates of the mouse
				//This is the position of .magnify with respect to the document.
				var magnify_offset = $(this).offset();
				//We will deduct the positions of .magnify from the mouse positions with
				//respect to the document to get the mouse positions with respect to the 
				//container(.magnify)
				var mx = e.pageX - magnify_offset.left;
				var my = e.pageY - magnify_offset.top;
				
				//Finally the code to fade out the glass if the mouse is outside the container
				if(mx < $(this).width() && my < $(this).height() && mx > 0 && my > 0)
				{
					$(".large").fadeIn(100);
				}
				else
				{
					$(".large").fadeOut(100);
				}
				if($(".large").is(":visible"))
				{
					//The background position of .large will be changed according to the position
					//of the mouse over the .small image. So we will get the ratio of the pixel
					//under the mouse pointer with respect to the image and use that to position the 
					//large image inside the magnifying glass
					var rx = Math.round(mx/$(".small").width()*native_width - $(".large").width()/2)*-1;
					var ry = Math.round(my/$(".small").height()*native_height - $(".large").height()/2)*-1;
					var bgp = rx + "px " + ry + "px";
					
					//Time to move the magnifying glass with the mouse
					var px = mx - $(".large").width()/2;
					var py = my - $(".large").height()/2;
					//Now the glass moves with the mouse
					//The logic is to deduct half of the glass's width and height from the 
					//mouse coordinates to place it with its center at the mouse coordinates
					
					//If you hover on the image now, you should see the magnifying glass in action
					$(".large").css({left: px, top: py, backgroundPosition: bgp});
				}
			}
		})
	})

  </script>
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
           <li><input class="form-control mr-sm-2" type="text" placeholder="Search"></li>
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
    </nav><!-- /.navbar -->
<div class="container">
	<table id="cart"  style="color:black" >
    				<thead>
						<tr>
							<th style="width:50%"></th>
							<th style="width:50%"></th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<div class="row">
								 
  
  
 <div class="col-sm-12 ">  
<div class="magnify">
	
	
	<div class="large"></div>
									<img class="small" src="https://static.pexels.com/photos/36753/flower-purple-lical-blosso.jpg" style="width:100%; height:100%"/></div></div>
									<div class="col-sm-12 ">
									<a href="#" class="btn btn-warning btn-block">ADD TO CART	</a><br>
									<a href="#" class="btn btn-success btn-block">CONTINUE SHOPPING</a>
								</div>	
								</div>
							</td>
							<td>
							<c:forEach items="${prod}" var="designate"  varStatus="loop">
							 <h2>${designate.prodname}</h2><br>
							  <h2> <i class="fa fa-rupee"></i>${designate.price} <br></h2><br>
							   <h2> ONLY  ${designate.stock} LEFT </h2><br>
							    <h2>Category:${designate.category.id}</h2><br>
							     <h2>${designate.supplier.id}</h2><br>
							
							</c:forEach>
							
							
							</td>
							
							
						
							
						</tr>
				
				
						
						
					</tbody>
				</table>
</div>    
    
    
    
    
</body>
</html>