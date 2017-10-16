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

html, body {
  padding:0;
  margin:0;
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
<div class="about__section"> <!-- Specificity container -->
<a href="javascript:void(0);" title="Koby Conrad - CEO"><div class="about__slot"><div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('http://placekitten.com/254/254');"></div>
  <div class="about__info">
  <h4 class="name">Koby Conrad</h4>
  <h5 class="title">Chief Executive Officer</h5>
  </div>
  <div class="bioText">Koby Conrad is a lorem ipsum dalor set amet consectur adipscing.<br><br>f g+ tw li</div>
  
  </div></a><a href="javascript:void(0);" title="Nicholas Butler - CTO"><div class="about__slot bio">
    <div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('http://dizin.x10.bz/codepen/yJQzdy/n_butler-bg.jpg');"></div>
  
  <div class="about__info">
  <h4 class="name">Nicholas Butler</h4>
  <h5 class="title">Chief Technology Officer</h5>
  </div>
    <div class="bioText">Nicholas Butler is a full stack developer, graphic designer, and entrepreneur.<br><br>f g+ tw li</div>
  
  
  </div></a><a href="javascript:void(0);" title="Riley Brunet - Creative Director"><div class="about__slot"><div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('http://placekitten.com/224/224');"></div>
  <div class="about__info">
  <h4 class="name">Riley Brunett</h4>
  <h5 class="title">Creative Director</h5>
  </div>
  <div class="bioText">Riley Brunett is a lorem ipsum dalor set amet consectur adipscing.<br><br>f g+ tw li</div>
  
  </div></a><a href="javascript:void(0);" title="Harbor Neher - Account Manager"><div class="about__slot">
    <div class="headshot"  onclick="biograph(this.parentNode);" style="background-image:url('http://placekitten.com/326/326');"></div>
  
  <div class="about__info">
  <h4 class="name">Harbor Neher</h4>
  <h5 class="title">Account Manager</h5>
  </div>
      <div class="bioText">Harbor Neher is a lorem ipsum dalor set amet consectur adipscing.<br><br>f g+ tw li</div>
  
  </div></a><a href="javascript:void(0);" title="Sarah Spoja - CTO"><div class="about__slot">
    <div class="headshot" onclick="biograph(this.parentNode);" style="background-image:url('http://placekitten.com/284/284');"></div>
  
  <div class="about__info">
  <h4 class="name">Sarah Spoja</h4>
  <h5 class="title">Staff Writer</h5>
  </div>
    <div class="bioText">Sarah Spoja is a lorem ipsum dalor set amet consectur adipscing.<br><br>f g+ tw li</div>
  
  
  </div></a><a href="javascript:void(0);" title="Malik Ali - Account Manager"><div class="about__slot">
    <div class="headshot"  onclick="biograph(this.parentNode);" style="background-image:url('http://placekitten.com/294/294');"></div>
  
  <div class="about__info">
  <h4 class="name">Malik Ali</h4>
  <h5 class="title">Account Manager</h5>
  </div>
      <div class="bioText">Malik Ali is a lorem ipsum dalor set amet consectur adipscing.<br><br>f g+ tw li</div>
  
  </div></a>
  
  </div>


</body>
</html>