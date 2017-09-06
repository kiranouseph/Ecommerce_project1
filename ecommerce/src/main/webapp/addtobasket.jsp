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

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class ="btnns">
<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModal1">ADD TO FLOWERS</button><br><br>
<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModal2">ADD TO OCCASSIONS</button>
</div>
</div>
<div class="m">
         
          <div id="myModal1" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add to your flowers</h4>
      </div>
      <div class="modal-body">
      <form>
      <table >
     
      <tr>
        <td>FLOWER</td><td><select>
  <option value="volvo">ROSE</option>
  <option value="saab">LILLIES</option>
  <option value="mercedes">TULIPS</option>
  <option value="audi">ORCHIDS</option>
   <option value="audi">CUSTOM PHOTO VAISES</option>
</select></td></tr>
<tr><td>NAME</td><td><input type="text"  name="age" required></td></tr>
<tr><td>BRAND</td><td><input type="text"  name="age" required></td></tr>
<tr><td>PRODUCT CODE</td><td><input type="text"  name="mob" required></td></tr>
<tr><td>NUMBER</td><td><input type="text"  name="mob" required></td></tr>
<tr><td>AMOUNT</td><td><input type="text"  name="mob" required></td></tr>
<tr><td>DESCRIPTION</td><td><textarea rows="4" cols="50"> </textarea></td></tr>
<tr><td>IMAGE</td><td> <input type="file" name="pic" accept="image/*"></td></tr>

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
        <h4 class="modal-title">Add to your occassional gifts</h4>
      </div>
      <div class="modal-body">
            <form>
      <table >
     
      <tr>
        <td>FLOWER</td><td><select>
  <option value="volvo">BIRTHDAY</option>
  <option value="saab">SYMBATHY</option>
  <option value="mercedes">LOVE AND ROMANCE </option>
  <option value="audi">GETWELL</option>
   <option value="audi">FUNERAL</option>
   <option value="audi">NEW BABY</option>
   <option value="audi">THANK YOU</option>
   <option value="audi">I'M SORRY</option>
</select></td></tr>
<tr><td>NAME</td><td><input type="text"  name="age" required></td></tr>
<tr><td>BRAND</td><td><input type="text"  name="age" required></td></tr>
<tr><td>PRODUCT CODE</td><td><input type="text"  name="mob" required></td></tr>
<tr><td>NUMBER</td><td><input type="text"  name="mob" required></td></tr>
<tr><td>AMOUNT</td><td><input type="text"  name="mob" required></td></tr>
<tr><td>DESCRIPTION</td><td><textarea rows="4" cols="50"> </textarea></td></tr>
<tr><td>IMAGE</td><td> <input type="file" name="pic" accept="image/*"></td></tr>

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