<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About us</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
function biograph(e) {
	if(e.className == 'about__slot') {
		e.className = 'about__slot bio';
	}
	else {
		e.className = 'about__slot';
	}
}




</script>
<style>

.jumbotron {
background: #358CCE;
color: #FFF;
border-radius: 0px;
}
.jumbotron-sm { padding-top: 24px;
padding-bottom: 24px; }
.jumbotron small {
color: #FFF;
}
.h1 small {
font-size: 24px;
}


body {
    background-image: url("${pageContext.request.contextPath}/resources/images/about.jpg");
    background-repeat: no-repeat;
     background-size: cover;
}
#abo
{

opacity:.9;



}

.about__section {
  width:960px;
  margin:auto;
}

.about__section .about__slot {
  width:33%;
  box-sizing: border-box;
  background-color:#f5f5f5;
  /*border:1px solid #ccc;*/
  border-right:none;
  border-top:none;
  height:15vw;
  min-height:300px;
  min-width:220px;
  display:inline-block;
  vertical-align:top;
  text-align:center;
  cursor:pointer;
  position:relative;
  background-size:0% auto;
  -webkit-transition:all 0.3s linear;
  background-position:center center;
  background-repeat:no-repeat;
  overflow:hidden;
}

.about__slot .bioText {
  opacity:0;
  color:rgba(242,242,242,0);
  pointer-events:none;
  position:absolute;
  top:350px;
  left:0;
  right:0;
  padding:10%;;
  padding-top:25px;
  padding-bottom:25px;
  width:80%;
  height:0;
  -webkit-transition:all 0.3s linear;
  margin:auto;
}

.about__slot.bio .about__info {
  top:0px;
  bottom:200px;
  background-color:rgba(0,0,0,0.42);
  box-shadow:inset 0px -5px 10px 0 rgba(0,0,0,1);
}

.about__slot.bio .bioText  {
  opacity:1;
  border-radius:0;
 position:absolute;
  top:50px;
  padding-top:200px;
  left:0;
  right:0;
  bottom:0;
  width:80%;
  height:250px;
  color:rgba(255,255,255,1);
  background-color:rgba(42,42,42,0.7);
  z-index:8;
  margin:auto;
  font-family:sans-serif;
  overflow:auto;
}

.about__slot .about__info {
  position:absolute;
  left:0;
  bottom:0;
  top:210px;
  right:0;
  pointer-events:none;
  z-index:9;
  -webkit-transition:all 0.3s linear;
  
}
/*BOOM */
.about__slot .headshot {
  margin:auto;
  margin-top:19px;
  width:172px;
  height:172px;
  /*border:10px double #424242;*/
  background-size:200px 200px;
  background-position:center 15%;
  border-radius:100%;
  box-shadow:0px 2px 10px 2px rgba(0,0,0,0.42);
  -webkit-transition:all 0.1s ease-in-out;
}

.about__slot.bio .headshot {
  -webkit-filter:blur(3px);
  opacity:1;
  width:100%;
  height:300px;
  border-radius:0;
  margin-top:0;
  background-size:375px 375px !important;
  border:0;
  top:0;
  left:0;
  botttom:0;
  right:0;

}

.about__slot .name {
  font-family:"Typo Grotesk",sans-serif;
  font-size:20px;
  font-weight:800;
  color:#424242;
  margin-bottom:0px;
  -webkit-transition:all 0.3s linear;
}

.about__slot .title {
   font-family:"Typo Grotesk",sans-serif;
  font-size:16px;
  font-weight:300;
  margin-top:5px;
  color:#ccc;
  -webkit-transition:all 0.3s linear;
}

.about__slot.bio .name {
  color:#f5f5f5;
}

.about__section .about__slot:hover .headshot {
  opacity:1;
  width:100%;
  height:300px;
  border-radius:0;
  margin-top:0;
  background-size:325px 325px;
  border:0;
  top:0;
  left:0;
  botttom:0;
  right:0;
}

.about__section .about__slot:hover .name {
  color:#f5f5f5 !important;
}

.about__section .about__slot:hover .about__info {
    background-color:rgba(0,0,0,0.42);
}

</style>
<body>

    <jsp:include page="header.jsp" />  
<center><h1>OUR TEAM</h1></center>
<div id="abo">
<div class="about__section"> <!-- Specificity container -->
<a href="javascript:void(0);" title="Koby Conrad - CEO"><div class="about__slot"><div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('${pageContext.request.contextPath}/resources/images/kiran.jpg');"></div>
  <div class="about__info">
  <h4 class="name">Kiran ouseph</h4>
  <h5 class="title">Chief Executive Officer</h5>
  </div>
  <div class="bioText"><br><br></div>
  
  </div></a><a href="javascript:void(0);" title="Koby Conrad - CEO"><div class="about__slot"><div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('${pageContext.request.contextPath}/resources/images/jithin.jpg');"></div>
  <div class="about__info">
  <h4 class="name">Jithin Shaji</h4>
  <h5 class="title">Chief Executive Officer</h5>
  </div>
  <div class="bioText"><br><br></div>
  
  </div></a><a href="javascript:void(0);" title="Riley Brunet - Creative Director"><div class="about__slot"><div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('${pageContext.request.contextPath}/resources/images/plavin.jpg');"></div>
  <div class="about__info">
  <h4 class="name">Plavin Paul</h4>
  <h5 class="title">Creative Director</h5>
  </div>
  <div class="bioText"><br><br></div>
  
  </div></a><a href="javascript:void(0);" title="Harbor Neher - Account Manager"><div class="about__slot">
    <div class="headshot"  onclick="biograph(this.parentNode);" style="background-image:url('${pageContext.request.contextPath}/resources/images/hrishi.jpg');"></div>
  
  <div class="about__info">
  <h4 class="name">Hrishikesh </h4>
  <h5 class="title">Account Manager</h5>
  </div>
      <div class="bioText">.<br><br></div>
  
  </div></a><a href="javascript:void(0);" title="Sarah Spoja - CTO"><div class="about__slot">
    <div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('');"></div>
  
  <div class="about__info">
  <h4 class="name">Sonu Soman</h4>
  <h5 class="title">Staff Writer</h5>
  </div>
    <div class="bioText"><br><br></div>
  
  
  </div></a><a href="javascript:void(0);" title="Malik Ali - Account Manager"><div class="about__slot">
    <div class="headshot"  onclick="biograph(this.parentNode);" style="background-image:url('${pageContext.request.contextPath}/resources/images/shifia.jpg');"></div>
  
  <div class="about__info">
  <h4 class="name">Shiphia philip</h4>
  <h5 class="title">Account Manager</h5>
  </div>
      <div class="bioText"><br><br></div>
  
  </div></a>
 <a href="javascript:void(0);" title="Koby Conrad - CEO"><div class="about__slot"><div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('${pageContext.request.contextPath}/resources/images/merin.jpg');"></div>
  <div class="about__info">
  <h4 class="name">Merin Grace Ben</h4>
  <h5 class="title">Chief Executive Officer</h5>
  </div>
  <div class="bioText"><br><br></div>
  
  </div></a>
  <a href="javascript:void(0);" title="Koby Conrad - CEO"><div class="about__slot"><div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url("");"></div>
  <div class="about__info">
  <h4 class="name">Lovely ps</h4>
  <h5 class="title">Chief Executive Officer</h5>
  </div>
  <div class="bioText"><br><br></div>
  
  </div></a>
  
  </div>
<br>
<div class="jumbotron jumbotron-sm">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">
                    Contact us <small>Feel free to contact us</small></h1>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="well well-sm">
                <form action="contact">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Name</label>
                            <input type="text" name="name" class="form-control" id="name" placeholder="Enter name" required="required" />
                        </div>
                        <div class="form-group">
                            <label for="email">
                                Email Address</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" name="email"class="form-control" id="email" placeholder="Enter email" required="required" /></div>
                        </div>
                        <div class="form-group">
                            <label for="subject">
                                Subject</label>
                            <select id="subject" name="subject" class="form-control" required="required">
                                <option value="na" selected="">Choose One:</option>
                                <option value="service">General Customer Service</option>
                                <option value="suggestions">Suggestions</option>
                                <option value="product">Product Support</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Message</label>
                            <textarea name="message" id="message" name="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder="Message"></textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                            Send Message</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <form>
            <legend><span class="glyphicon glyphicon-globe"></span> Our office</legend>
            <address>
                <strong>Niit ltd</strong><br>
                Chandran Arcade <br>
                Shornur road<br>
                Thrissur<br>
                <abbr title="Phone">
                    P:</abbr>
                (123) 456-7890
            </address>
            <address>
                <strong>Full Name</strong><br>
                <a href="mailto:#">kiranouseph@gmail.com</a>
            </address>
            </form>
        </div>
    </div>
</div>
</div>
    <jsp:include page="footer.jsp" />  
</body>
</html>