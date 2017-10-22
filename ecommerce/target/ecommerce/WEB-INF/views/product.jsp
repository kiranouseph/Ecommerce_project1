<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product desc</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="eff.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style>
  ul {
  list-style-type: none;
}
}
/* cellpadding */
th, td { padding: 5px; }

/* cellspacing */
table { border-collapse: separate; border-spacing: 5px; } 


  </style>
  <script>
  function plus() {
	    int n=document.getElementById("num").innerHTML;
	    n=n+1;
	    document.getElementById("num").innerHTML=n;
	    
	}
  function minus() {
	  int n=document.getElementById("num").innerHTML;
	    n=n-1;
	    document.getElementById("num").innerHTML=n;
	    
	    	}
  

  </script>
</head>
<body>
   <jsp:include page="header.jsp" />  


            <div class="container">
             <div class="row">
             
             
             
                  <div class="col-md-6 col-sm-6">
                     <div class="single-product-image-inner">
                        <div class="tab-content">
                          
                        </div>
                        <!-- Nav tabs -->
                        <ul class="product-tabs" role="tablist">
                           
                           <li role="presentation"><a href="#three" aria-controls="three" role="tab" data-toggle="tab"><img src="${pageContext.request.contextPath}/resources/products/${prod.image}" alt="" style="width:300px;height:300px"></a></li>
                        </ul>
                     </div>
                  </div>
                  
                  
                  
                  
                
                  <div class="col-md-offset-1 col-md-5 col-sm-6">
                     <div class="single-product-details">
                       
                        <h2>${prod.prodname}</h2>
                       <c:if test="${prod.stock == 0}">
                       <p style="color:red">OUT OF STOCK</p>
                       </c:if> 
                        
                       <c:if test="${prod.stock != 0}">  
                      <h4>${prod.stock} left</h4>
                      </c:if>
                        <p>${prod.proddecs}</p>
                        <div class="single-product-price">
                        <c:if test="${prod.offer eq 1}">

 <h2><i class="fa fa-inr"></i><strike>${prod.price}</strike>         <i class="fa fa-inr"></i>${prod.offerprice}  ${prod.offerper}% off</h2>
</c:if>
                        
                        
                         <c:if test="${prod.offer eq 0}">
                        
                           <h2><i class="fa fa-inr"></i>${prod.price}</h2>
                           </c:if>
                           
                        </div>                        
                        <div class="product-attributes clearfix">
                           
                       
                        </div>
                        
                        <table>
                        
                        <tr>
                         <c:if test="${prod.stock eq 0}">
                          
                     
                            
<input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADDTO CART" style="cursor: not-allowed" readonly >

                          
                         
                        </c:if>
                        
                        
                         <c:if test="${prod.stock ge 1}">
           <form action="addcart">
                     <input type="number" name="quan" value=1 id="quant">
                       <input id="prodId" name="id" type="hidden" value="${prod.id}">      
<input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD TO CART" >

                        </form>                        </c:if>
                        
                        
                        
                        </tr>
                       </table>
            
                        
                       
                        <div class="add-to-wishlist">
                           <a class="wish-btn" href="cart.html?ref=designcollection">
                           <i class="fa fa-heart-o"></i>
                           <span>ADD TO WISHLIST</span>
                           </a>
                        </div>
                        <div class="single-product-categories">

                           <div class="clear"></div>
                           
                           <span>Cash On Delivery available?</span>
                           <div class="clear"></div>
                           <span>30 Days Exchange Policy?</span>
                           <div class="clear"></div>
                           <label>Payment Method</label>
                           <span>Safe and Secure Payments. Easy returns.</span>
                        </div>
                     </div>
                  </div>
                  
                  
                  
                  
                  
                  
                  
            </div>
            </div>
                  
                  
            
            
       
     <div class="container">
             <div class="row">
     <div class="col-md-12">
     
     <div id="exTab2" class="container">	
<ul class="nav nav-tabs">
			<li class="active">
        <a  href="#1" data-toggle="tab">Description</a>
			</li>
			<li><a href="#2" data-toggle="tab">Reviews</a>
			</li>
			<li><a href="#3" data-toggle="tab">Feedback</a>
			</li>
		</ul>

			<div class="tab-content ">
			  <div class="tab-pane active" id="1">
          <h3>From a perfect dozen long stem red roses for Valentine's Day to a 100 roses bouquet to mark your 30th anniversary, we can put together a range of exciting and beautiful rose bouquets for that special someone in your life. ... Our standard rose bouquets are available in red, white, pink, gold, yellow, and purple.
          </h3>
				</div>
				<div class="tab-pane" id="2">
    						<c:forEach var="designate" items="${rev}">	
<table>
<tr>
<td>
${designate.custname}


</td>
<td>
says
</td>
<td>
${designate.review}
</td>

</tr>




</table>





</c:forEach>          
          
          
          
          
				</div>
        <div class="tab-pane" id="3">
           <form action="review?prid=${prod.id}" method="post">
        
                <table >
     
  
 
<tr><td>NAME</td><td><input type="text"  name="name"  style="width:100%" required></td></tr>
<tr><td>Feedback</td><td><textarea rows="4" cols="50" name="desc" style="width:100%" required></textarea></td></tr>
<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="SUBMIT" style="width:100%"></td></tr>
</table>
</form>


				</div>
			</div>
  </div>     
     </div>
         </div>
      </div>
   
    

   <jsp:include page="footer.jsp" />     
</body>
</html>