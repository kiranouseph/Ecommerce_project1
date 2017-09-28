<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  
  
  <style>
  
  
  
  @import url(https://fonts.googleapis.com/css?family=Poppins:300,700);
.snip1581 {
  font-family: 'Poppins:400,700', Arial, sans-serif;
  position: relative;
  display: inline-block;
  overflow: hidden;
  margin: 8px;
  min-width: 250px;
  max-width: 310px;
  width: 100%;
  background-color: #000000;
  color: #ffffff;
  text-align: left;
  font-size: 16px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
}
.snip1581 * {
  -webkit-transition: all 0.35s;
  transition: all 0.35s;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
.snip1581 img {
  max-width: 100%;
  vertical-align: top;
}
.snip1581 figcaption {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 20px;
  background-image: -webkit-linear-gradient(bottom, rgba(0, 0, 0, 0.8) 0%, transparent 100%);
  background-image: linear-gradient(to top, rgba(0, 0, 0, 0.8) 0%, transparent 100%);
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
}
.snip1581 h3 {
  font-size: 44px;
  font-weight: 400;
  line-height: 1;
  letter-spacing: 1px;
  text-transform: uppercase;
  margin: 3px 0;
}
.snip1581 .title1 {
  font-weight: 700;
}
.snip1581 .title2 {
  color: #a58e7c;
  font-weight: 300;
}
.snip1581 .title3 {
  font-weight: 700;
  font-size: 25px;
}
.snip1581 a {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
.snip1581:hover img,
.snip1581.hover img {
  -webkit-transform: scale(1.3) rotate(5deg);
  transform: scale(1.3) rotate(5deg);
}
/* Demo purposes only */
body {
  background-color: #212121;
  text-align: center;
}
  
  
  
  
  </style>
  
  
  
  <script>



  /* Demo purposes only */
  $(".hover").mouseleave(
    function () {
      $(this).removeClass("hover");
    }
  );


  </script>
</head>
<body>

<c:forEach items="${subcate}" var="designate"  varStatus="loop">

<br>
<br>
<br>


<div class = "col-sm-3" align="center">
 <div id="mydiv" style="width:200px;background:white" onmouseover="this.style.background='grey';" onmouseout="this.style.background='white';">

<figure class="snip1581"><img src="https://static.pexels.com/photos/36753/flower-purple-lical-blosso.jpg" alt="profile-sample2"/>
  <figcaption>
    <h3 class="title1">  ${designate.subcategoryname}</h3>
    <h3 class="title2"> ${designate.subcategoryname}</h3>
    <h3 class="title3"> ${designate.subcategoryname}</h3>
  </figcaption>
</figure>
</div>
<br>
</div>




<c:if test="${(loop.count) % 5== 0}">


</c:if>
</c:forEach>


















</body>
</html>