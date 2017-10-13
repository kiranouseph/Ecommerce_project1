<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Giftery</title>
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





div.wrapper{
	
	
}
div.description{
	position:absolute; /* absolute position (so we can position it where we want)*/
	bottom:0px; /* position will be on bottom */
	left:0px;
	width:100%;
	/* styling bellow */
	
	color:red;
	
}
p.description_content{
	padding:0px;
	margin:0px;
	font-size: 30px;
}







/* BOOTSTRAP 3.x GLOBAL STYLES
-------------------------------------------------- */


.overlay { 
  color:#fff;
  position:absolute;
  z-index:12;
  top:50%;
  left:0;
  width:100%;
  text-align:center;
}


/* CUSTOMIZE THE NAVBAR
-------------------------------------------------- */

/* Special class on .container surrounding .navbar, used for positioning it into place. */
.navbar-wrapper {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  z-index: 10;
}



/* CUSTOMIZE THE CAROUSEL
-------------------------------------------------- */

/* Carousel base class */
.myCarouse1l {
  margin-bottom: 60px;
}
/* Since positioning the image, we need to help out the caption */
.carousel-caption {
  z-index: 1;
}

/* Declare heights because of positioning of img element */
.myCarouse1l .item {
  height: 400px;
  background-color:#555;
}
.myCarouse1l img {
  position: absolute;
  top: 0;
  left: 0;
  min-height: 400px;
}






/* RESPONSIVE CSS
-------------------------------------------------- */

@media (min-width: 768px) {

  /* Navbar positioning foo */
  .navbar-wrapper {
    margin-top: 20px;
    margin-bottom: -90px; /* Negative margin to pull up carousel. 90px is roughly margins and height of navbar. */
  }
  /* The navbar becomes detached from the top, so we round the corners */
  .navbar-wrapper .navbar {
    border-radius: 4px;
  }

  /* Bump up size of carousel content */
 .myCarouse1l-caption p {
    margin-bottom: 20px;
    font-size: 21px;
    line-height: 1.4;
  }
}










.MultiCarousel { float: left; overflow: hidden; padding: 15px; width: 100%; position:relative; }
    .MultiCarousel .MultiCarousel-inner { transition: 1s ease all; float: left; }
        .MultiCarousel .MultiCarousel-inner .item { float: left;}
        .MultiCarousel .MultiCarousel-inner .item > div { text-align: center; padding:10px; margin:10px; background:#f1f1f1; color:#666;}
    .MultiCarousel .leftLst, .MultiCarousel .rightLst { position:absolute; border-radius:50%;top:calc(50% - 20px); }
    .MultiCarousel .leftLst { left:0; }
    .MultiCarousel .rightLst { right:0; }
    
        .MultiCarousel .leftLst.over, .MultiCarousel .rightLst.over { pointer-events: none; background:#ccc; }
        
        
        
        
        
        
        
        
        
        
        
      
</style>


<script>
$(document).ready(function () {
    var itemsMainDiv = ('.MultiCarousel');
    var itemsDiv = ('.MultiCarousel-inner');
    var itemWidth = "";

    $('.leftLst, .rightLst').click(function () {
        var condition = $(this).hasClass("leftLst");
        if (condition)
            click(0, this);
        else
            click(1, this)
    });

    ResCarouselSize();




    $(window).resize(function () {
        ResCarouselSize();
    });

    //this function define the size of the items
    function ResCarouselSize() {
        var incno = 0;
        var dataItems = ("data-items");
        var itemClass = ('.item');
        var id = 0;
        var btnParentSb = '';
        var itemsSplit = '';
        var sampwidth = $(itemsMainDiv).width();
        var bodyWidth = $('body').width();
        $(itemsDiv).each(function () {
            id = id + 1;
            var itemNumbers = $(this).find(itemClass).length;
            btnParentSb = $(this).parent().attr(dataItems);
            itemsSplit = btnParentSb.split(',');
            $(this).parent().attr("id", "MultiCarousel" + id);


            if (bodyWidth >= 1200) {
                incno = itemsSplit[3];
                itemWidth = sampwidth / incno;
            }
            else if (bodyWidth >= 992) {
                incno = itemsSplit[2];
                itemWidth = sampwidth / incno;
            }
            else if (bodyWidth >= 768) {
                incno = itemsSplit[1];
                itemWidth = sampwidth / incno;
            }
            else {
                incno = itemsSplit[0];
                itemWidth = sampwidth / incno;
            }
            $(this).css({ 'transform': 'translateX(0px)', 'width': itemWidth * itemNumbers });
            $(this).find(itemClass).each(function () {
                $(this).outerWidth(itemWidth);
            });

            $(".leftLst").addClass("over");
            $(".rightLst").removeClass("over");

        });
    }


    //this function used to move the items
    function ResCarousel(e, el, s) {
        var leftBtn = ('.leftLst');
        var rightBtn = ('.rightLst');
        var translateXval = '';
        var divStyle = $(el + ' ' + itemsDiv).css('transform');
        var values = divStyle.match(/-?[\d\.]+/g);
        var xds = Math.abs(values[4]);
        if (e == 0) {
            translateXval = parseInt(xds) - parseInt(itemWidth * s);
            $(el + ' ' + rightBtn).removeClass("over");

            if (translateXval <= itemWidth / 2) {
                translateXval = 0;
                $(el + ' ' + leftBtn).addClass("over");
            }
        }
        else if (e == 1) {
            var itemsCondition = $(el).find(itemsDiv).width() - $(el).width();
            translateXval = parseInt(xds) + parseInt(itemWidth * s);
            $(el + ' ' + leftBtn).removeClass("over");

            if (translateXval >= itemsCondition - itemWidth / 2) {
                translateXval = itemsCondition;
                $(el + ' ' + rightBtn).addClass("over");
            }
        }
        $(el + ' ' + itemsDiv).css('transform', 'translateX(' + -translateXval + 'px)');
    }

    //It is used to get some elements from btn
    function click(ell, ee) {
        var Parent = "#" + $(ee).parent().attr("id");
        var slide = $(Parent).attr("data-slide");
        ResCarousel(ell, Parent, slide);
    }

});

// Sets interval...what is transition slide speed?
$('#myCarousel').carousel({
interval: 2000
});
</script>
</head>
<body >

    <jsp:include page="header.jsp" />  
   
<div style="height:100%"> 



<div id="myCarousel" class="carousel slide">
  <!-- Indicators -->
  
  <div class="carousel-inner">
    <div class="item active">
       <img src="resources/images/1.jpg" class="img-responsive" alt="Chania" style="width:100%; height:100vh">
      <div class="container">
        <div class="carousel-caption">
        <h1>Share happiness with giftery gifts</h1>
        <h3>SCROLL DOWN FOR MORE OFFERS</h3>
        <span class="glyphicons glyphicons-circle-arrow-down"></span>
          </div>
      </div>
    </div>
    
    <c:forEach var="designate" items="${catego}">
    <div class="item">
       <img src="resources/products/${designate.catimage}" class="img-responsive" alt="Chania" style="width:100%; height:100vh">
      <div class="container">
        <div class="carousel-caption">
          <h1>${designate.categoryname}</h1>
           <h3>SCROLL DOWN FOR MORE OFFERS</h3>
           <span class="glyphicons glyphicons-circle-arrow-down"></span>
          
        </div>
      </div>
    </div>
   </c:forEach>
  </div>
 
  <!-- Controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <i class="glyphicon glyphicon-chevron-left"></i>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <i class="glyphicon glyphicon-chevron-right"></i>
  </a>  
</div>
<!-- /.carousel -->
</div>
<br>
<br>














 <div class="container"  style="text-align:center">
 
             <div class="row">
            
             
             
             
                  <div class="col-md-3">
                  <a href="prod?id=${offp1.id}">
                  <div class='wrapper'>
	<!-- image -->
	<img src='https://i.ytimg.com/vi/EJA5nU9L6zU/maxresdefault.jpg' style="width:100%; height:100%"/>
	<!-- description div -->
	<div class='description'>
		<!-- description content -->
		<p class='description_content'><strong>${offp1.prodname}<br>${offp1.offerper}%OFF</strong></p>
		<!-- end description content -->
	</div>
	<!-- end description div -->
</div>
</a>
                  </div>
                   <div class="col-md-3">
                   <a href="prod?id=${offp2.id}">
                 <div class='wrapper'>
	<!-- image -->
	<img src='https://i.ytimg.com/vi/EJA5nU9L6zU/maxresdefault.jpg' style="width:100%; height:100%"/>
	<!-- description div -->
	<div class='description'>
		<!-- description content -->
		<p class='description_content'><strong>${offp2.prodname}<br>${offp2.offerper}%OFF</strong></p>
		<!-- end description content -->
	</div>
	<!-- end description div -->
</div>
</a>
                  </div>
                   <div class="col-md-3">
                   <a href="prod?id=${offp3.id}">
                 <div class='wrapper'>
	<!-- image -->
	<img src='https://i.ytimg.com/vi/EJA5nU9L6zU/maxresdefault.jpg' style="width:100%; height:100%"/>
	<!-- description div -->
	<div class='description'>
		<!-- description content -->
		<p class='description_content'><strong>${offp3.prodname}<br>${offp3.offerper}%OFF</strong></p>
		<!-- end description content -->
	</div>
	<!-- end description div -->
</div>
</a>
                  </div>
                   <div class="col-md-3">
                   <a href="prod?id=${offp4.id}">
                 <div class='wrapper'>
	<!-- image -->
	<img src='https://i.ytimg.com/vi/EJA5nU9L6zU/maxresdefault.jpg' style="width:100%; height:100%"/>
	<!-- description div -->
	<div class='description'>
		<!-- description content -->
		<p class='description_content'><strong>${offp4.prodname}<br>${offp4.offerper}%OFF</strong></p>
		<!-- end description content -->
	</div>
	<!-- end description div -->
</div>
</a>
                  </div>
                  
                  </div>
                  </div>


	
    


	<c:forEach var="designate" items="${catego}">



<h3>Offers for ${designate.categoryname}</h3>
<div class="container">
	<div class="row">
	
	
		<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1" id="MultiCarousel"  data-interval="1000">
            <div class="MultiCarousel-inner">
            
            
            <c:forEach var="des" items="${offproducts}">
            <c:if test="${designate.id eq des.catnum}">
                <div class="item">
                    <div class="pad15">
                    <img src="resources/images/2.jpg" class="img-responsive" alt="abcd" style="width:100%; height:100%">
                        <p class="lead">${des.prodname}</p>
                        <p> ${des.price}</p>
                        <p>${des.offerprice}</p>
                        <p>${des.offerper }%</p>
                    </div>
                </div>
                </c:if>
</c:forEach>              
              
            </div>
            <button class="btn btn-primary leftLst"><</button>
            <button class="btn btn-primary rightLst">></button>
        </div>
	</div>

</div>


<br><br>
</c:forEach>

<jsp:include page="footer.jsp" /> 









  

</body>
</html>