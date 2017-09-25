<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add to basket</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="addbask.css" rel="stylesheet" type="text/css">
<style>
/* USER PROFILE PAGE */
 .card {
    margin-top: 20px;
    padding: 30px;
    background-color: rgba(214, 224, 226, 0.2);
    -webkit-border-top-left-radius:5px;
    -moz-border-top-left-radius:5px;
    border-top-left-radius:5px;
    -webkit-border-top-right-radius:5px;
    -moz-border-top-right-radius:5px;
    border-top-right-radius:5px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.card.hovercard {
    position: relative;
    padding-top: 0;
    overflow: hidden;
    text-align: center;
    background-color: #fff;
    background-color: rgba(255, 255, 255, 1);
}
.card.hovercard .card-background {
    height: 130px;
}
.card-background img {
    -webkit-filter: blur(25px);
    -moz-filter: blur(25px);
    -o-filter: blur(25px);
    -ms-filter: blur(25px);
    filter: blur(25px);
    margin-left: -100px;
    margin-top: -200px;
    min-width: 130%;
}
.card.hovercard .useravatar {
    position: absolute;
    top: 15px;
    left: 0;
    right: 0;
}
.card.hovercard .useravatar img {
    width: 100px;
    height: 100px;
    max-width: 100px;
    max-height: 100px;
    -webkit-border-radius: 50%;
    -moz-border-radius: 50%;
    border-radius: 50%;
    border: 5px solid rgba(255, 255, 255, 0.5);
}
.card.hovercard .card-info {
    position: absolute;
    bottom: 14px;
    left: 0;
    right: 0;
}
.card.hovercard .card-info .card-title {
    padding:0 5px;
    font-size: 20px;
    line-height: 1;
    color: #262626;
    background-color: rgba(255, 255, 255, 0.1);
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
}
.card.hovercard .card-info {
    overflow: hidden;
    font-size: 12px;
    line-height: 20px;
    color: #737373;
    text-overflow: ellipsis;
}
.card.hovercard .bottom {
    padding: 0 20px;
    margin-bottom: 17px;
}
.btn-pref .btn {
    -webkit-border-radius:0 !important;
}

.btnns
{
	margin-top:5cm;
	margin-left:6cm;
}
table
{
	
   
border-collapse: separate;
    border-spacing: 10px ;
}
.m
{
	margin-left: 14cm;
}
</style>
<script>
$(document).ready(function() {
	$(".btn-pref .btn").click(function () {
	    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
	    // $(".tab").addClass("active"); // instead of this do the below 
	    $(this).removeClass("btn-default").addClass("btn-primary");   
	});
	});
</script>
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
          <a href="index.jsp"><button type="button" class="btn btn-info btn-lg" style="margin-top:5px; ">BUY IT</button></a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
           
            <li><a href="#" data-toggle="modal" data-target="#myModal1">list categories</a></li>
            <li><a href="#" data-toggle="modal" data-target="#myModal2">list of suppliers</a></li>
            <li><a href="" data-toggle="modal" data-target="#myModal3">list of products</a></li>
         
            <li><a href="#">offers cart</a></li>
            
            
            <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </ul>
     

        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
      <form class="navbar-form navbar-right">
  <div class="input-group">
    <input type="text" class="form-control" placeholder="Search">
    <div class="input-group-btn">
      <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </div>
  </div>
    </nav><!-- /.navbar -->


<div class="col-lg-6 col-sm-6">
    <div class="card hovercard">
        <div class="card-background">
            <img class="card-bkimg" alt="" src="">
          
        </div>
        <div class="useravatar">
            <img alt="" src="">
        </div>
        <div class="card-info"> <span class="card-title">ADMIN</span>

        </div>
    </div>
    <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" id="products" class="btn btn-primary" href="#tab1" data-toggle="tab">
                <div class="hidden-xs">PRODUCTS</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="suppliers" class="btn btn-default" href="#tab2" data-toggle="tab">
                <div class="hidden-xs">SUPPLIERS</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="categories" class="btn btn-default" href="#tab3" data-toggle="tab">
                <div class="hidden-xs">CATEGORIES</div>
            </button>
        </div>
    </div>

        <div class="well">
      <div class="tab-content">
        <div class="tab-pane fade in active" id="tab1">
             <form action="product" method="post">
      <table >
     
  
  <tr><td>PRODUCT ID</td><td><input type="number"  name="prid" required></td></tr>
<tr><td>NAME</td><td><input type="text"  name="name" required></td></tr>
<tr><td>DESCRIPTION</td><td><textarea rows="4" cols="50" name="desc"> </textarea></td></tr>
<tr><td>PRICE</td><td><input type="number"  name="price" required></td></tr>
<tr><td>STOCK</td><td><input type="number"  name="stock" required></td></tr>


<tr><td>CATEGORY</td><td><select name="cat">
<option value="desigType">Select Designation</option>
<c:forEach var="designatee" items="${catego}">
                       
                            <option value="${designatee.id}">${designatee.categoryname}</option>
                       
                    </c:forEach>         
        

  
</select></td></tr>
<tr><td>SUPPLIER</td><td><select name="supp">
<option value="desigType">Select Designation</option>
 <c:forEach var="designate" items="${suppli}">
                       
                            <option value="${designate.id}">${designate.suppname}</option>
                       
                    </c:forEach> 
</select></td></tr>


<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD"></td></tr>
</table>
</form>
        </div>
        <div class="tab-pane fade in" id="tab2">
         <form action="supplier" method="post">
      <table >
     
      
<tr><td>SUPPLIER ID</td><td><input type="number"  name="suppid" required></td></tr>
<tr><td>SUPPLIER NAME</td><td><input type="text"  name="suppname" required></td></tr>
<tr><td>SUPPLIER ADDRESS</td><td><textarea rows="4" cols="50" name="suppaddress"> </textarea></td></tr>

<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD"></td></tr>
</table>
</form> 
        </div>
        <div class="tab-pane fade in" id="tab3">
                     <form action="category" method="post">
      <table >
     
      
<tr><td>CATEGORY ID</td><td><input type="number"  name="catid" required></td></tr>
<tr><td>CATEGORY NAME</td><td><input type="text"  name="catname" required></td></tr>


<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD"></td></tr>
</table>
</form>
        </div>
      </div>
    </div>
    
    </div>
            
     <div id="myModal1" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">categories</h4>
      </div>
      <div class="modal-body">
       
       <c:forEach var="designatee" items="${catego}" varStatus="loop">
       <table>
       <tr>
     
                       
                            <td> ${loop.count} </td>  
                                   <td>${designatee.id}</td> 
                                         <td>${designatee.categoryname}</td> 
                                         <td><a href="admin/update/${designatee.id}"><button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal" >UPDATE</button></a></td> 
                                          <td><a href="admin/delete/${designatee.id}"><button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal">DELETE</button></a></td> 
               </tr>      </table>   
                    </c:forEach>         
       
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
 <div id="myModal2" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">suppliers </h4>
      </div>
      <div class="modal-body">
       <c:forEach var="designatee" items="${suppli}" varStatus="loop">
       <table>
       <tr>
     
                       
                            <td> ${loop.count} </td>  
                                   <td>${designatee.id}</td> 
                                         <td>${designatee.categoryname}</td> 
                                         <td><a href="admin/update/${designatee.id}"><button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal" >UPDATE</button></a></td> 
                                          <td><a href="admin/delete/${designatee.id}"><button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal">DELETE</button></a></td> 
               </tr>      </table>   
                    </c:forEach>         
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
 <div id="myModal3" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">products</h4>
      </div>
      <div class="modal-body">
        <p>Some text in the modal.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>   
</body>
</html>