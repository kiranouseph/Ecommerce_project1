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
  <script src="http://thecodeplayer.com/uploads/js/jquery-1.7.1.min.js" type="text/javascript"></script>
  <script src="http://thecodeplayer.com/uploads/js/prefixfree.js" type="text/javascript"></script>

  <style>
.magnify {
    position: relative;
    cursor: none
}

.magnify-large {
    position: absolute;
    display: none;
    width: 175px;
    height: 175px;

    -webkit-box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 0 0 7px 7px rgba(0, 0, 0, 0.25), inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
       -moz-box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 0 0 7px 7px rgba(0, 0, 0, 0.25), inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
            box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 0 0 7px 7px rgba(0, 0, 0, 0.25), inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
     
    -webkit-border-radius: 100%;
       -moz-border-radius: 100%;
             border-radius: 100%
}

  
  ul {
  list-style-type: none;
}
}
/* cellpadding */
th, td { padding: 5px; }

/* cellspacing */
table { border-collapse: separate; border-spacing: 5px; } 

#rev
{
 background-image: url("${pageContext.request.contextPath}/resources/images/revbg.jpg");
    background-repeat: no-repeat;
     background-size: cover;
     opacity:.9;

}
  </style>
  <script>

  function checkstock() {
      var quantity = document.getElementById("quant").value;
      var stock = document.getElementById("stock").value;
      if (quantity > stock) {
      	 document.getElementById("error").innerHTML = "Requested quantity is more than stock";
          return false;
      }
      return true;
  }
  

  !function ($) {

	    "use strict"; // jshint ;_;


	    /* MAGNIFY PUBLIC CLASS DEFINITION
	     * =============================== */

	    var Magnify = function (element, options) {
	        this.init('magnify', element, options)
	    }

	    Magnify.prototype = {

	        constructor: Magnify

	        , init: function (type, element, options) {
	            var event = 'mousemove'
	                , eventOut = 'mouseleave';

	            this.type = type
	            this.$element = $(element)
	            this.options = this.getOptions(options)
	            this.nativeWidth = 0
	            this.nativeHeight = 0

	            this.$element.wrap('<div class="magnify" \>');
	            this.$element.parent('.magnify').append('<div class="magnify-large" \>');
	            this.$element.siblings(".magnify-large").css("background","url('" + this.$element.attr("src") + "') no-repeat");

	            this.$element.parent('.magnify').on(event + '.' + this.type, $.proxy(this.check, this));
	            this.$element.parent('.magnify').on(eventOut + '.' + this.type, $.proxy(this.check, this));
	        }

	        , getOptions: function (options) {
	            options = $.extend({}, $.fn[this.type].defaults, options, this.$element.data())

	            if (options.delay && typeof options.delay == 'number') {
	                options.delay = {
	                    show: options.delay
	                    , hide: options.delay
	                }
	            }

	            return options
	        }

	        , check: function (e) {
	            var container = $(e.currentTarget);
	            var self = container.children('img');
	            var mag = container.children(".magnify-large");

	            // Get the native dimensions of the image
	            if(!this.nativeWidth && !this.nativeHeight) {
	                var image = new Image();
	                image.src = self.attr("src");

	                this.nativeWidth = image.width;
	                this.nativeHeight = image.height;

	            } else {

	                var magnifyOffset = container.offset();
	                var mx = e.pageX - magnifyOffset.left;
	                var my = e.pageY - magnifyOffset.top;

	                if (mx < container.width() && my < container.height() && mx > 0 && my > 0) {
	                    mag.fadeIn(100);
	                } else {
	                    mag.fadeOut(100);
	                }

	                if(mag.is(":visible"))
	                {
	                    var rx = Math.round(mx/container.width()*this.nativeWidth - mag.width()/2)*-1;
	                    var ry = Math.round(my/container.height()*this.nativeHeight - mag.height()/2)*-1;
	                    var bgp = rx + "px " + ry + "px";

	                    var px = mx - mag.width()/2;
	                    var py = my - mag.height()/2;

	                    mag.css({left: px, top: py, backgroundPosition: bgp});
	                }
	            }

	        }
	    }


	    /* MAGNIFY PLUGIN DEFINITION
	     * ========================= */

	    $.fn.magnify = function ( option ) {
	        return this.each(function () {
	            var $this = $(this)
	                , data = $this.data('magnify')
	                , options = typeof option == 'object' && option
	            if (!data) $this.data('tooltip', (data = new Magnify(this, options)))
	            if (typeof option == 'string') data[option]()
	        })
	    }

	    $.fn.magnify.Constructor = Magnify

	    $.fn.magnify.defaults = {
	        delay: 0
	    }


	    /* MAGNIFY DATA-API
	     * ================ */

	    $(window).on('load', function () {
	        $('[data-toggle="magnify"]').each(function () {
	            var $mag = $(this);
	            $mag.magnify()
	        })
	    })

	} ( window.jQuery );

	
  

  
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
                           
                           <li role="presentation"><a href="#three" aria-controls="three" role="tab" data-toggle="tab">
                           
                          
<div class="magnify">
	
	<!-- This is the magnifying glass which will contain the original/large version -->
	<div class="large"></div>
	
	<!-- This is the small image -->
	<img class="small" src="${pageContext.request.contextPath}/resources/products/${prod.image}" style="width:500px;height:500px" data-toggle="magnify"/>
	
</div>

                           
                           
                           </a></li>
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
                       <input id="stock" name="id" type="hidden" value="${prod.stock}"> 
<input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD TO CART" onclick="return checkstock()">

                        </form>                        
                        <p id="error"></p>
                        
                        
                        </c:if>
                        
                        
                        
                        </tr>
                       </table>
            
                        
                       
                       
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
                  
                  
            
            
       
     <div class="container" id="rev" style="height:400px">
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
			  <br>
			  <br>
			  <br>
			  <br>
			  <br>
			           <div class="row">
     <div class="col-md-6">
          <h3>${prod.proddecs}
          </h3>
          </div>
          </div>
				</div>
				<div class="tab-pane" id="2">
				<br>
				<br>
				<br>
				<br>
				<br>
    						<c:forEach var="designate" items="${rev}" begin="0" end="3">	
<table style="font-size:30px">
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
        <br>
        <br>
        <br>
        <br>
        <br>
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