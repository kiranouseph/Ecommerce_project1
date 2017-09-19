<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add to basket</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="addbask.css" rel="stylesheet" type="text/css">
<style>
.btnns
{
	margin-top:5cm;
	margin-left:6cm;
}
table
{
	
    margin-left: 3.5cm;
border-collapse: separate;
    border-spacing: 10px ;
}
.m
{
	margin-left: 14cm;
}

</style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class ="btnns">
<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModal1">PRODUCT</button><br><br>
<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModal2">CATEGORY</button><br><br>
<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModal3">SUPPLIER</button>
</div>
</div>
<div class="m">
         
          <div id="myModal1" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add to your gifts</h4>
      </div>
      <div class="modal-body">
      <form action="product">
      <table >
     
  
  <tr><td>PRODUCT ID</td><td><input type="number"  name="prid" required></td></tr>
<tr><td>NAME</td><td><input type="text"  name="name" required></td></tr>
<tr><td>DESCRIPTION</td><td><textarea rows="4" cols="50" name="desc"> </textarea></td></tr>
<tr><td>PRICE</td><td><input type="number"  name="price" required></td></tr>
<tr><td>STOCK</td><td><input type="number"  name="stock" required></td></tr>
<tr><td>CATEGORY</td><td><select name="cat">
  <option value="cat1">cat1</option>
  <option value="cat2">cat2</option>
  <option value="cat3">cat3</option>
  <option value="cat4">cat4</option>
</select></td></tr>
<tr><td>SUPPLIER</td><td><select name="supp">
  <option value="supp1">supp1</option>
  <option value="supp2">supp2</option>
  <option value="supp3">supp3</option>
  <option value="supp4">supp4</option>
</select></td></tr>


<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD"></td></tr>
</table>
</form>

      </div>
      
    </div>

  </div>
</div>
</div>
      <div class="m">   
          <div id="myModal2" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add to your gift categories</h4>
      </div>
      <div class="modal-body">
            <form action="category">
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
</div>
      <div class="m">   
          <div id="myModal3" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add your gift suppliers</h4>
      </div>
      <div class="modal-body">
            <form action="supplier">
      <table >
     
      
<tr><td>SUPPLIER ID</td><td><input type="number"  name="suppid" required></td></tr>
<tr><td>SUPPLIER NAME</td><td><input type="text"  name="suppname" required></td></tr>
<tr><td>SUPPLIER ADDRESS</td><td><textarea rows="4" cols="50" name="suppaddress"> </textarea></td></tr>

<tr><td></td><td><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="ADD"></td></tr>
</table>
</form>

      </div>
      
    </div>

  </div>
</div>
</div>
</body>
</html>