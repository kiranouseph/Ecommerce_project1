<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>footer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<style>


/************************************************************
*************************Footer******************************
*************************************************************/

@import url(http://fonts.googleapis.com/css?family=Fjalla+One);
@import url(http://fonts.googleapis.com/css?family=Gudea);
.footer1 {
    background: #fff url("../images/footer/footer-bg.png") repeat scroll left top;
	padding-top: 40px;
	padding-right: 0;
	padding-bottom: 20px;
	padding-left: 0;/*	border-top-width: 4px;
	border-top-style: solid;
	border-top-color: #003;*/
}



.title-widget {
	color: #898989;
	font-size: 20px;
	font-weight: 300;
	line-height: 1;
	position: relative;
	text-transform: uppercase;
	font-family: 'Fjalla One', sans-serif;
	margin-top: 0;
	margin-right: 0;
	margin-bottom: 25px;
	margin-left: 0;
	padding-left: 28px;
}

.title-widget::before {
    background-color: #ea5644;
    content: "";
    height: 22px;
    left: 0px;
    position: absolute;
    top: -2px;
    width: 5px;
}



.widget_nav_menu ul {
    list-style: outside none none;
    padding-left: 0;
}

.widget_archive ul li {
    background-color: rgba(0, 0, 0, 0.3);
    content: "";
    height: 3px;
    left: 0;
    position: absolute;
    top: 7px;
    width: 3px;
}


.widget_nav_menu ul li {
    font-size: 13px;
    font-weight: 700;
    line-height: 20px;
	position: relative;
    text-transform: uppercase;
	border-bottom: 1px solid rgba(0, 0, 0, 0.05);
    margin-bottom: 7px;
    padding-bottom: 7px;
	width:95%;
}



.title-median {
    color: #636363;
    font-size: 20px;
    line-height: 20px;
    margin: 0 0 15px;
    text-transform: uppercase;
	font-family: 'Fjalla One', sans-serif;
}

.footerp p {font-family: 'Gudea', sans-serif; }


#social:hover {
    			-webkit-transform:scale(1.1); 
-moz-transform:scale(1.1); 
-o-transform:scale(1.1); 
			}
			#social {
				-webkit-transform:scale(0.8);
                /* Browser Variations: */
-moz-transform:scale(0.8);
-o-transform:scale(0.8); 
-webkit-transition-duration: 0.5s; 
-moz-transition-duration: 0.5s;
-o-transition-duration: 0.5s;
			}           
/* 
    Only Needed in Multi-Coloured Variation 
                                               */
			.social-fb:hover {
				color: #3B5998;
			}
			.social-tw:hover {
				color: #4099FF;
			}
			.social-gp:hover {
				color: #d34836;
			}
			.social-em:hover {
				color: #f39c12;
			}
			.nomargin { margin:0px; padding:0px;}





.footer-bottom {
    background-color: #15224f;
    min-height: 30px;
    width: 100%;
}
.copyright {
    color: #fff;
    line-height: 30px;
    min-height: 30px;
    padding: 7px 0;
}
.design {
    color: #fff;
    line-height: 30px;
    min-height: 30px;
    padding: 7px 0;
    text-align: right;
}
.design a {
    color: #fff;
}


/************************************************************
*************************Footer******************************
*************************************************************/
div.cont {
   
    position: relative;
      margin: 0;

    position: absolute;
    top: 50%;
    left: 50%;
    margin-right: -50%;
    transform: translate(-50%, -50%) 
     }


</style>

</head>
<body>




<!--footer-->
<footer class="footer1" style="margin-top:150px;text-align:center;bottom:0">
<div class="container">

<div class="row"><!-- row -->
            
               
                
         
                <div class="col-lg-12 col-md-12"><!-- widgets column center -->
                
                   
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_recent_news"><!-- widgets list -->
                    
                                <h1 class="title-widget">Contact Detail </h1>
                                
                                <div class="footerp"> 
                                
                                <h2 class="title-median">NIIT ltd</h2>
                                <p><b>Email id:</b> <a href="#">kiranouseph@gmail.com</a></p>
                                <p><b>Helpline Numbers </b>

    <b style="color:#ffc106;">(8AM to 10PM):</b>  8129925706  </p>
    
   
                                </div>
                                
                                <div class="social-icons">
                                
                                	<ul class="nomargin">
                                    
                <a href="#"><i class="fa fa-facebook-square fa-3x social-fb" id="social"></i></a>
	            <a href="#"><i class="fa fa-twitter-square fa-3x social-tw" id="social"></i></a>
	            <a href="#"><i class="fa fa-google-plus-square fa-3x social-gp" id="social"></i></a>
	            <a href="#"><i class="fa fa-envelope-square fa-3x social-em" id="social"></i></a>
                                    
                                    </ul>
                                </div>
                    		</li>
                          </ul>
                       </div>
                        
                </div>
                </div>

</footer>
<!--header-->

<div class="footer-bottom">

	<div class="container">

		<div class="row">

			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

				<div class="copyright">

					� 2017,Giftery, All rights reserved

				</div>

			</div>

			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

				<div class="design">

					 <a href="https://www.facebook.com/kiranouseph">contact </a> |  <a target="_blank" href="http://www.webenlance.com">Web Design & Development by kiran</a>

				</div>

			</div>

		</div>

	</div>
</div>
       
</body>
</html>