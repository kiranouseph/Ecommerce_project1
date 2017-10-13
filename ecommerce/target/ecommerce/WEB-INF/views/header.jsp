<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>



 
<style>
@import url(http://fonts.googleapis.com/css?family=Open+Sans:400,700);
body {
  font-family: 'Open Sans', 'sans-serif';
}
.mega-dropdown {
  position: static !important;
}
.mega-dropdown-menu {
    
    width: 100%;
    box-shadow: none;
    -webkit-box-shadow: none;
}
.mega-dropdown-menu > li > ul {
  padding: 0;
  margin: 10px;
}
.mega-dropdown-menu > li > ul > li {
  list-style: none;
}
.mega-dropdown-menu > li > ul > li > a {
  display: block;
  color: red;
  
}
.mega-dropdown-menu > li ul > li > a:hover,
.mega-dropdown-menu > li ul > li > a:focus {
  text-decoration: none;
}



h5 {
  font-family: 'Nunito Sans', sans-serif;
}
  ul {
  list-style-type: none;
}

</style>
<script>

$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true,true).slideDown("400");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true,true).slideUp("400");
            $(this).toggleClass('open');       
        }
    );
});


</script>

</head>
<body>
 

  
  
  
  
  
  
  
  
  
  
  
  
  
  <div class="navbar-wrapper">
  <div class="container-fluid">
    <div class="navbar navbar-default navbar-static-top">
      
        <div class="navbar-header">
        <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </a>
        <a class="navbar-brand" href="">GIFTERY</a>
        </div>
        <div class="navbar-collapse collapse">
     <ul class="nav navbar-nav navbar-right">
		    
            
            
           <c:if test="${pageContext.request.userPrincipal.name  == 'admin123@gmail.com'}"> 
            <li><a href="">Home</a></li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name  != 'admin123@gmail.com'}"> 
            <li><a href="">Home</a></li>
            </c:if>
            
            
            
            
            <li><a href="#">About</a></li>
             <c:if test="${pageContext.request.userPrincipal.name  == 'admin123@gmail.com'}">
            <li><a href="admin/admin">ADMIN</a></li>
            </c:if>
                 <c:if test="${pageContext.request.userPrincipal.name  != 'admin123@gmail.com'}">   
			<li class="dropdown mega-dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Choose your gift <span class="caret"></span></a>				
				<ul class="dropdown-menu mega-dropdown-menu">
				
				
				
				
				         <li class="col-md-3"></li>
						<li class="col-md-3">
						<ul>
							                           
                            <div id="menCollection" class="carousel slide" data-ride="carousel">
                              <div class="carousel-inner">
                              
                              
                              
                                <div class="item active">
                                    <a href="#"><img src="resources/products/11.jpg" class="img-responsive" alt="product 1"></a>
                                    <div class="carousel-caption">
        <h3>Top offer in categories</h3>
     
      </div>                                        
                                </div><!-- End Item -->
                                
                                
                                
                                <c:forEach var="designate" items="${catego}">
                                <div class="item">
                                    <a href="#"><img src="resources/products/${designate.catimage}" class="img-responsive" alt="product 3"></a>
                                    <div class="carousel-caption">
        <h3>${designate.categoryname}</h3>
        <br>
        
        
      </div>
                                                                            
                                </div><!-- End Item -->   
                                </c:forEach>    
                                
                                                         
                              </div><!-- End Carousel Inner -->
                              <!-- Controls -->
                              <a class="left carousel-control" href="#menCollection" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                              </a>
                              <a class="right carousel-control" href="#menCollection" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                              </a>
                            </div><!-- /.carousel -->
                            <li class="divider"></li>
                            
						</ul>
					</li>
					<li class="col-sm-4">
						
						 <c:forEach var="designate" items="${catego}">
                       
                           <h5 ><li  style="text-align:center"><a href="selcat?id=${designate.id}">Gift ${designate.categoryname} to ${designate.categorydesc }</a></li></h3>
                           
                       
                    </c:forEach> 	
						
					</li>
					   <li class="col-md-2"></li>
					
					
					
					
					
					
					
					
					
						
					
				
					
				</ul>				
			</li>
			
			
               
            <li><a href="#">Checkout</a></li>
            </c:if>
  <c:if test="${pageContext.request.userPrincipal.name !=  'admin123@gmail.com' }">
  
   <li><a href="user/cart?name=${pageContext.request.userPrincipal.name}">Shopping cart</a></li>
  
  </c:if>
   <c:if test="${pageContext.request.userPrincipal.name == null }">
   
    <li><a href="login"><span class="glyphicon glyphicon-shopping-cart"></span>Shopping cart</a></li>
   
   </c:if>
            
<c:if test="${pageContext.request.userPrincipal.name == null }">
            <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name == null }">
            
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name  != null}">
					<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
					<li><a href='<c:url value="/j_spring_security_logout" />'>Logout</a></li>
				</c:if>                  
          
		</ul>

        </div>

    </div>
  </div><!-- /container -->
  
  </div>
  
  
  
  
  
  
  


</body>
</html>