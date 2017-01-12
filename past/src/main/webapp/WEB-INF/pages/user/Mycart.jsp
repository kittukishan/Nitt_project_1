<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../links.jsp" %>
<title>My Cart</title>
<style>
body{
    /* background-image: url(files/images/wall/cookie1.gif); */
     background-color:white;
    background-repeat: no-repeat;
    background-position: center;
   background-size:cover; 
     width:100%;
    height:auto; 
    counter-reset:Serial;
	/* opacity:0.5;
	filter:alpha(opacity=40); */
   
}
.cart{
background-image: url("files/images/wall/cookie1.gif");
background-repeat: no-repeat;
}
label:first-child:before{
counter-increment:Serial;
content:counter(Serial);
}
.glyphicon.glyphicon-trash {
    font-size: 20px;
        text-decoration: none;
        
 }
 .glyphicon.glyphicon-trash:hover {
    font-size: 25px;
        text-decoration: none;
        color:red;
        
 }
</style>
<script src="files/js/header.js"></script> 
</head>
<body class="cart">
 <%@ include file="../header.jsp" %>	
<br>
<div class="container" >

<div class="panel panel-default">
    <c:url var="url" value="${val}">     </c:url>

 <c:choose>
 <c:when test="${url==false}">
<div class="panel-heading"><h2 align="center">Items in Cart</h2><span style="margin-right:10px;">

<a class="glyphicon glyphicon-trash" href="clearcart/${customerid }">Clear</a></span></div>
<div class="panel-body">

<div class="row" style="align:center;">
 
<c:forEach var="prd" items="${usercart}">
   <!--  -------------------------------------------------- -->
    <div class="col-md-3"  style="border:1px solid yellow;width:320px;border-radius:8px; margin:20px;padding:5px;background-color:#ffb3ff;">

<img src="files/images/desserts/${id}.jpg" alt="No image" style="width:280px;height:180px;border-radius:5px"></img>

  <div  style="padding:3px">   
  	
      <br><label>Name : ${prd.product_name}</label>
      <br><label>Best price : ${prd.price}</label>      
      <br><label>Supplier : ${prd.supplier_name}</label>
      <br><label>Description :  ${prd.desc}</label>	
       <br><label>Quantity :  ${prd.quantity}</label>
       <br><label>Total Price :  ${prd.totalprice}</label>
     <a href="deleteitem?psid=${prd.cartitemid}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a>
     </div>
</div>

  </c:forEach>
 
  
  
</div>
    <!--  -------------------------------------------------- -->
   <br><div align="center" style="padding:20px;border-radius:5px;background-color:#ff5c33;">
   <a href="checkout?cuid=${customerid}" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span>Order</a></div>
 
  </div>
   </c:when>
 <c:when test="${url==true}">
   <div class="jumbotron">
    <h1  align="center">CartItems</h1>
    <p style="color:red;">You have no items in your cart!please continue to shop:-)</p> 
  </div>
  </c:when>
 </c:choose>
</div>
   </div>

<%@ include file="../footer.jsp" %>

</body>
</html>