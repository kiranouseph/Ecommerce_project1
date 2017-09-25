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
  <link href="log.css" rel="stylesheet" type="text/css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="index.jsp"><button type="button" class="btn btn-info btn-lg"  >BUY IT</button></a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">flowers</a></li>
            <li><a href="#">occassions</a></li>
            <li><a href="cart.jsp">Shoppoing cart</a></li>
            <li><a href="#">Checkout</a></li>
            <li>
              <a href="login.jsp">Sign in</a>
            </li>
          </ul>

        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
        <div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                  <strong>Register</strong>
                </div>
                <div class="panel-body">
                    <f:form class="form-horizontal" role="form" method="post" action="addUser" modelAttribute="user">
                    <div class="form-group">
                        <f:label for="name" class="col-sm-3 control-label" path="name">
                            Name</f:label>
                        <div class="col-sm-9">
                            <f:input type="text" class="form-control" id="name" path="name" placeholder="Enter your name" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <f:label for="mobno" class="col-sm-3 control-label" path="mobno">
                            Mobile number</f:label>
                        <div class="col-sm-9">
                            <f:input type="text" class="form-control" id="mobno"  path="mobno" placeholder="Your mobile number"  pattern=".{10}" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <f:label for="email" class="col-sm-3 control-label" path="email">
                            Email</f:label>
                        <div class="col-sm-9">
                            <f:input type="text" class="form-control" id="inputEmail3" path="email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title=" use someone@domain.com"required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <f:label for="password" class="col-sm-3 control-label" path="password">
                            Password</f:label>
                        <div class="col-sm-9">
                            <f:input type="password" class="form-control" id="inputPassword3" path="password" placeholder="Password" pattern=".{6,}" title="Six or more characters" required/>
                        </div>
                    </div>
                  
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox">
                                    Remember me
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm">
                                Register</button>
                                 <button type="reset" class="btn btn-default btn-sm">
                                Reset</button>
                        </div>
                    </div>
                    </f:form>
                </div>
               
            </div>
        </div>
    </div>
</div>
</body>
</html>