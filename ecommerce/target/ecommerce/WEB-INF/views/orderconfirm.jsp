
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order confirm</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  
  
/*  bhoechie tab */
div.bhoechie-tab-container{
  z-index: 10;
  background-color: #ffffff;
  padding: 0 !important;
  border-radius: 4px;
  -moz-border-radius: 4px;
  border:1px solid #ddd;
  margin-top: 20px;
  margin-left: 50px;
  -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
  box-shadow: 0 6px 12px rgba(0,0,0,.175);
  -moz-box-shadow: 0 6px 12px rgba(0,0,0,.175);
  background-clip: padding-box;
  opacity: 0.97;
  filter: alpha(opacity=97);
}
div.bhoechie-tab-menu{
  padding-right: 0;
  padding-left: 0;
  padding-bottom: 0;
}
div.bhoechie-tab-menu div.list-group{
  margin-bottom: 0;
}
div.bhoechie-tab-menu div.list-group>a{
  margin-bottom: 0;
}
div.bhoechie-tab-menu div.list-group>a .glyphicon,
div.bhoechie-tab-menu div.list-group>a .fa {
  color: green;
}
div.bhoechie-tab-menu div.list-group>a:first-child{
  border-top-right-radius: 0;
  -moz-border-top-right-radius: 0;
}
div.bhoechie-tab-menu div.list-group>a:last-child{
  border-bottom-right-radius: 0;
  -moz-border-bottom-right-radius: 0;
}
div.bhoechie-tab-menu div.list-group>a.active,
div.bhoechie-tab-menu div.list-group>a.active .glyphicon,
div.bhoechie-tab-menu div.list-group>a.active .fa{
  background-color: green;
  background-image: grren;
  color: #ffffff;
}
div.bhoechie-tab-menu div.list-group>a.active:after{
  content: '';
  position: absolute;
  left: 100%;
  top: 50%;
  margin-top: -13px;
  border-left: 0;
  border-bottom: 13px solid transparent;
  border-top: 13px solid transparent;
  border-left: 10px solid #5A55A3;
}

div.bhoechie-tab-content{
  background-color: #ffffff;
  /* border: 1px solid #eeeeee; */
  padding-left: 20px;
  padding-top: 10px;
}

div.bhoechie-tab div.bhoechie-tab-content:not(.active){
  display: none;
}
  </style>
<script>

$(document).ready(function() {
    $("div.bhoechie-tab-menu>div.list-group>a").click(function(e) {
        e.preventDefault();
        $(this).siblings('a.active').removeClass("active");
        $(this).addClass("active");
        var index = $(this).index();
        $("div.bhoechie-tab>div.bhoechie-tab-content").removeClass("active");
        $("div.bhoechie-tab>div.bhoechie-tab-content").eq(index).addClass("active");
    });
});

</script>
</head>
<body>
 <jsp:include page="header.jsp" />  
  <p class="bg-info" style="font-size:50px">Check your order and confirm.</p>
<div class="container">
	<div class="row">
        <div class="col-lg-10 bhoechie-tab-container">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 bhoechie-tab-menu">
              <div class="list-group">
           
                <a href="#" class="list-group-item active  text-center"><h2>BILLING ADDRESS</h2></a>
                <a href="#" class="list-group-item text-center"><h2>SHIPPING  ADDRESS</h2></a>
                <a href="#" class="list-group-item text-center"><h2>PAYMENT</h2> </a>
                <a href="#" class="list-group-item  text-center"><h2>CONFIRM ORDER</h2> </a>
          
               
               
               
               
              </div>
            </div>
            <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 bhoechie-tab">
                <!-- flight section -->
     
             
    
                <!-- hotel search -->
                <div class="bhoechie-tab-content active">
                 
                         <div class="container">
    <div class="row">
        <div class="col-md-6 col-md-6">
            <div class="panel panel-default">
               
                <div class="panel-body">
                
               <c:if test="${bcon==1}">
                    
                    <h3>THE billing address you provided</h3>
                    <p>${orde.baddress}</p>
                    
                    
                    
                    
                    
                    </c:if>
                    
                    
                    
                    
                    
                     <c:if test="${bcon == 0}">
                    
                    
                    
                    
                     <form class="form-horizontal" role="form" method="post" action="badd" >
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label" >
                            Name</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                            Address line 1</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="add1" placeholder="Address line 1"   required>
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                            Address line 2</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="add2" placeholder="Address line 2"   required>
                        </div>
                    </div>
                     <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                            City/Town</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="city" placeholder="City/town"   required>
                        </div>
                    </div>
                    
                     <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                           State / Province / Region
</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="state" placeholder="state/ region/ provice"   required>
                        </div>
                    </div>
                    
                          <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                            Zip / Postal Code
</label>
                        <div class="col-sm-9">
                            <input type="number" class="form-control" id="mobno"  name="pin" placeholder="Zip/Postal code"  required>
                        </div>
                    </div>
                    
                 
                  
                  
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm">
                               SUBMIT</button>
                                

                        </div>
                    </div>
                    
                    
                    
                    
                    
                    </form>
                    </c:if>
                    
                </div>
               
            </div>
        </div>
    </div>
</div>

                 
                
	</div>

                 
                 
                   
                
                <div class="bhoechie-tab-content">
                   
                                           <div class="container">
    <div class="row">
        <div class="col-md-6 col-md-6">
            <div class="panel panel-default">
               
                <div class="panel-body">
                 <c:if test="${scon==1}}">
                   
             <h3>THE shipping address you provided</h3>
                    <p>${orde.saddress}</p>
            
            
            
                    </c:if>
                    
                    
                     <c:if test="${scon==0}">
                   
            
            
            
            
            
             <form class="form-horizontal" role="form" method="post" action="sadd" >
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label" >
                            Name</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                            Address line 1</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="add1" placeholder="Address line 1"   required>
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                            Address line 2</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="add2" placeholder="Address line 2"   required>
                        </div>
                    </div>
                     <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                            City/Town</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="city" placeholder="City/town"   required>
                        </div>
                    </div>
                    
                     <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                           State / Province / Region
</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="state" placeholder="State/province/region"   required>
                        </div>
                    </div>
                    
                          <div class="form-group">
                        <label for="mobno" class="col-sm-3 control-label">
                            Zip / Postal Code
</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobno"  name="pin" placeholder="Zip/postalcode"  required>
                        </div>
                    </div>
                    
                 
                  
                  
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm">
                               SUBMIT</button>
                                

                        </div>
                    </div>
                    
                    
                    
                    </form>
                    </c:if>
                </div>
               
            </div>
        </div>
    </div>
</div>

    
                </div>
                   <div class="bhoechie-tab-content">
                 
                 <div class="container">
    <div class="row">
        <!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
        <div class="col-xs-12 col-md-4">
        
        
            <!-- CREDIT CARD FORM STARTS HERE -->
            <div class="panel panel-default credit-card-box">
                <div class="panel-heading display-table" >
                    <div class="row display-tr" >
                        <h3 class="panel-title display-td" >Payment Details</h3>
                        <div class="display-td" >                            
                            <img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">
                        </div>
                    </div>                    
                </div>
                <div class="panel-body">
                 <c:if test="${paycon==1}"> 
 
 
  <h3>THE payment details you provided</h3>
                    <p>CV NUMBER            ${orde.cvnumber}</p>
                    <p>CARD NUMBER          ${orde.cardnumber }</p>
                    <p>CARD EXPIRY DATE     ${orde.expdate }</p>
                    <p>COUPEN CODE          ${orde.ccode }</p>
 
 
 
                    </c:if>
                    
                    
                    
                    <c:if test="${paycon==0}">
 
 
 <form role="form" id="payment-form" method="POST" action="pay">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label for="cardNumber">CARD NUMBER</label>
                                    <div class="input-group">
                                        <input 
                                            type="tel"
                                            class="form-control"
                                            name="cardnum"
                                            placeholder="Valid Card Number"
                                            autocomplete="cc-number"
                                            required autofocus 
                                        />
                                        <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                    </div>
                                </div>                            
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-7 col-md-7">
                                <div class="form-group">
                                    <label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span class="visible-xs-inline">EXP</span> DATE</label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        name="cardexp"
                                        placeholder="MM / YY"
                                        autocomplete="cc-exp"
                                        required 
                                    />
                                </div>
                            </div>
                            <div class="col-xs-5 col-md-5 pull-right">
                                <div class="form-group">
                                    <label for="cardCVC">CV CODE</label>
                                    <input 
                                        type="tel" 
                                        class="form-control"
                                        name="cardcv"
                                        placeholder="CVC"
                                        autocomplete="cc-csc"
                                        required
                                    />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label for="couponcode">COUPON CODE</label>
                                    <input type="text" class="form-control" name="coupencode" />
                                </div>
                            </div>                        
                        </div>
                         <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                   
                                    <button type="submit" class="btn btn-success btn-sm">
                               SUBMIT</button>
                                </div>
                            </div>                        
                        </div>
                       
                       
                    </form>
 
 
 
                    </c:if>
                    
                    
                    
                </div>
            </div>            
            <!-- CREDIT CARD FORM ENDS HERE -->
            
            
        </div>            
        
  
        
    </div>
</div>
                 
                 
                 
                 
                    
                </div>
                   <!-- train section -->
                <div class="bhoechie-tab-content">
                 
                                  <c:if test="${status eq 1}">

<table style="border-collapse: separate;
    border-spacing: 50px ;cellspacing:25%">
<tr>
<th>Name</th>
<th>price</th>
<th>Quantity</th>
<th>Total</th>
</tr>
<tr>
<td>${product.prodname}</td>
<td>${price}</td>
 

<td>${num }</td>

<td>${num*price}</td>
</tr>
<tr>
<td></td>
<td></td>
<td>SUBTOTAL</td>
<td>${num*price}</td>



</tr>
<tr><td><input type="checkbox">
                                   CONFIRM(Cannot be undone)</td></tr>
                                   <tr><td>  <a href="placeorder"><button class="subscribe btn btn-success btn-lg btn-block" type="button">Place order</button></a></td></tr>
</table>



</c:if>
                 
  <c:if test="${status eq 2}">
  
  
 
  <table style="border-collapse: separate;
    border-spacing: 50px ;cellspacing:25%">
<tr>
<th>Name</th>
<th>price</th>
<th>Quantity</th>
<th>Total</th>
</tr>
<c:forEach var="product" items="${cartt}">
<tr>
<td>${product.product.prodname }</td>
<td>${product.price}</td>
 

<td>${product.quantity}</td>

<td>${product.price*product.quantity}</td>
</tr>
</c:forEach>
<tr>
<td></td>
<td></td>
<td>SUBTOTAL</td>
<td>${total}</td>



</tr>
<tr><td><input type="checkbox">
                                   CONFIRM(Cannot be undone)</td></tr>
                                   
                                     <c:if test="${bcon==0 || scon==0 || paycon==0}">
                                   
                                   <tr><td> <input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="PLACE ORDER" style="width:100%; cursor: not-allowed" readonly></td></tr>
                                   </c:if>
                                        <c:if test="${bcon==1 && scon==1 && paycon==1}">
                                   
                                   <tr><td> <a href="placeorder"><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="PLACE ORDER" style="width:100%; "></a></td></tr>
                                   </c:if>
</table>
  



</c:if>               
                 
      
                 
                 
                 
                    
                </div>
    
              
            </div>
        </div>
  </div>
</div>
   <jsp:include page="footer.jsp" />   
</body>
</html>