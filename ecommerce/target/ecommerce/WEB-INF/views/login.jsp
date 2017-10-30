<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


  <link href="log.css" rel="stylesheet" type="text/css">


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
<style>

html {
  font-family: "Abel", sans-serif;
  color: #FFF;
 
  
}



#overlay {
  background:white;
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  opacity: 0;
  z-index: -1;
  -o-transition: 1s;
  -ms-transition: 1s;
  -moz-transition: 1s;
  -webkit-transition: 1s;
  transition: 1s;
}

#info {
  position: fixed;
  top: 70%;
  left: 50%;

  width: 90%;
  max-width: 400px;
  padding: 40px;
  opacity: 0;
  overflow: hidden;
  visibility: hidden;
  transition: all 1s;
  z-index: 99;
 
  -ms-transform: translate(-50%, -50%);
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}


#info button:hover {
  color: #999;
}

#info label#close {
  position: absolute;
  top: 0;
  right: 0;
  width: 40px;
  margin: 15px;
  font-size: 1.6em;
    color:black;
  cursor: pointer;
  
}

input[type="radio"] {
  display: none;
}

input[type="radio"][id="open"]:checked ~ #overlay {
  opacity: .8;
  z-index: 98;
}

input[type="radio"][id="open"]:checked ~ #info {
  visibility: visible;
  opacity: 1;
  position: fixed;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}


#button {
 
 
  color:black;
  cursor: pointer;
 
}
#loginn
{
opacity:0.9;
-ms-transform: rotate(7deg); /* IE 9 */
    -webkit-transform: rotate(4deg); /* Chrome, Safari, Opera */
    transform: rotate(4deg);
}
body {
    background-image: url("${pageContext.request.contextPath}/resources/images/giftcard.jpg");
    background-repeat: no-repeat;
     background-size: 100% 100vh;
}

</style>

</head>
<body >
    <jsp:include page="header.jsp" />  
    
    <br>
    <br>
    <br>
    <br>
    <br>
     <div  id="loginn">
    <div class="row">
        <div class="col-md-4 col-md-offset-5">
            <div >
                <div >
                 
                </div>
                <div>
                    <form class="form-horizontal" role="form" action="j_spring_security_check" method="post">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">
                            Email</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmail3" name="j_username" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title=""  required >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">
                            Password</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword3" name="j_password" placeholder="Password" pattern=".{6,}" title="Six or more characters" required>
                        </div>
                    </div>
                      <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <div class="checkbox">
                               <label for="inputPassword3" class="col-sm-9 control-label" style="font-color:red">
                           ${MESSAGE}</label>
                            </div>
                        </div>
                    </div>
                
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm" >
                                Sign in</button>
                                 <button type="reset" class="btn btn-default btn-sm">
                                Reset</button>
                        </div>
                    </div>
                    </form>
                </div>
                <div >
                
                    Not Registered? <a href="signup?err=0" >Register here</a><br>
                    
                    
<div id="wrapper">
  <input type="radio" id="open" name="popup">
  <input type="radio" id="close" name="popup">
  <div id="popup">
    <label id="button" for="open">New supplier here</label>
  </div>
  <div id="overlay"></div>
  <div id="info">
    <h1>Welcome supplier</h1>
   As per the discussions we made earlier we are glad to sell your products through our online platform giftery.You have been recieved an email containing a password and you can login in normal login screen with your provided email and recieved password .And then will be redirected to a change password and you should change it at the first login.Any violation to the rules and policy of giftery will result in the termination of your account
   <br>
   <a href="supd"><button class="btn btn-success btn-sm" style="width:100%">LOGIN</button></a>  
    
    <label id="close" for="close"><i class="fa fa-times-circle fa-lg"></i></label>
  </div>
</div>

            </div>
        </div>
    </div>
</div>
</div>

   <jsp:include page="footer.jsp" />  

</body>
</html>