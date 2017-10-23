<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="log.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("pass").value;
        var confirmPassword = document.getElementById("cpass").value;
        if (password != confirmPassword) {
        	 document.getElementById("error").innerHTML = "PASSWORD MISMATCH";
            return false;
        }
        return true;
    }
</script>
<style>
#reg
{

opacity:0.9;
}
body {
    background-image: url("${pageContext.request.contextPath}/resources/images/giftcard.jpg");
    background-repeat: no-repeat;
     background-size: 100% 70vh;
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
        <div class="container" id="reg">
    <div class="row">
        <div class="col-md-4 col-md-offset-5">
            <div >
                <div>
               
                </div>
                <div >
                    <form class="form-horizontal" role="form" method="post" action="addUser" >
                    <div class="form-group">
                        <label for="name" class="col-sm-5 control-label" >
                            Name</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobno" class="col-sm-5 control-label">
                            Mobile number</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="mobno"  name="mobno" placeholder="Your mobile number"  pattern=".{10}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-5 control-label" >
                            Email</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="inputEmail3" name="email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title=" use someone@domain.com"required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-5 control-label" >
                            Password</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" id="pass" name="password" placeholder="Password" pattern=".{6,}" title="Six or more characters" required>
                        </div>
                    </div>
                       <div class="form-group">
                        <label for="password" class="col-sm-5 control-label" >
                            Confirm Password</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" id="cpass" name="cpassword" placeholder="confirm Password" pattern=".{6,}" title="Six or more characters" required>
                        </div>
                    </div>
                  <p id="error"></p>
                                     <div class="form-group last">
                        <div class="col-sm-offset-5 col-sm-7">
                            <button type="submit" class="btn btn-success btn-sm" onclick="return Validate()">
                                Register</button>
                                 <button type="reset" class="btn btn-default btn-sm">
                                Reset</button>
                        </div>
                    </div>
                    </form>
                </div>
               
            </div>
        </div>
    </div>
</div>

   <jsp:include page="footer.jsp" />  
</body>
</html>