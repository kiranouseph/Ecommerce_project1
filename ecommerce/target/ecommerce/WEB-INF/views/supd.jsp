<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>password change</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
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
<body>
   <div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                  <strong>Login</strong><br>
                  <h4>Please enter new password</h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="spasupd" method="post">
                  
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">
                            Password</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="pass" name="pass" placeholder="Password" title="Six or more characters" required>
                        </div>
                    </div>
                
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">
                            Confirm Password</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="cpass" name="cpass" placeholder="confirm Password" title="Six or more characters" required>
                        </div>
                    </div>
                   <p id="error"></p>
                  
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm" onclick="return Validate()">
                                UPDATE</button>
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
</body>
</html>