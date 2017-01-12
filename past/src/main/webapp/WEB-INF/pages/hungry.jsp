<html>

<head>
<style>
 tr:hover{background-color:#efe6e2;
 			} 
body {
    background-image: url(files/images/wall/bkgrnd4.jpg);
    background-repeat: no-repeat;
    background-position: center;
   /* background-size:cover; */
   width:100%;
    height:auto; 
    counter-reset:Serial;
	/* opacity:0.5;
	filter:alpha(opacity=40); */
   
}
table.table{
margin-right:100px;

}


/* .bod img{
 background-image: url(files/images/wall/bkgrnd4.jpg);
opacity:0.5;
} 
img:hover{
opacity:1.0;
}  */

tr td:first-child:before{
counter-increment:Serial;
content:counter(Serial);
}

th {
   vertical-align: center; 
    text-align:center;
     padding:20px;
background-color:#eeffcc;
     
} 
</style>
<%@ include file="links.jsp" %>

<script>
function view() {
    var x = document.getElementById('allsupp');
    if (x.style.visibility === 'hidden') {
        x.style.visibility = 'visible';
    } else {
        x.style.visibility = 'hidden';
    }
}
</script>
<script src="files/js/header.js"></script> 
<title>Ready to eat</title>
<!--  -->
</head>


<%@ include file="header.jsp" %>
<body ng-controller="cartcntrl">	<!-- 	 ng-app="headapp" ng-controller="headcntrl"  -->


		<div class="container-fluid">
		        
	
  <table class="table"  >
  <tr>
  		<th><label style="color:red;padding-left:10px;">S No:</label></th>
      <th>  <label style="color:red;padding-left:10px;">product name</label></th>
       <th>  <label style="color:red;padding-left:10px;">supplier name</label></th>
        <th> <label style="color:red;padding-left:10px;">price</label></th>
        <th> <label style="color:red;padding-left:10px;">Stock</label></th>
   		 <th><label style="color:red;padding-left:10px;">Quantity</label></th>
   		 <th><label style="color:red;padding-left:10px;">Status</label></th>
   		 <th><label  style="color:red;padding-left:10px;">Image</label></th>
   	 <th></th>
   	<th></th>
   		 
  </tr>
  
    <c:forEach var="prd" items="${products}"> 
 <form action="Addingtocartreq/${prd.xid}">
    <tr>	
    	<td><label></label></td>	
        <td style="color:black;"><b>${prd.product_name}</td>
        <td style="color:black"><b>${prd.supplier_name}</td>
        <td style="color:black"><b>${prd.price}</td>
        <td  style="color:black"><b>${prd.stock}</td>
         <td  style="color:blue;">
         <select name="qnty">
         <option value="1" >1</option>
         <option value="2">2</option>
         <option value="3">3</option>
         <option value="4">4</option>
         <option value="5">5</option></select></td>
      
    <c:url var="url" value="${prd.status}">     </c:url>
         <c:choose>
         <c:when test="${url==true}">
         <td  style="color:green"><b>Available</td>
          <td ><a href="#"><img id="productimg" src="files/images/desserts/${prd.xid}.jpg" alt="noimage" style="width:200px;height:150px;border-radius:5px"></img></a></td>
          <sec:authorize access="!hasRole('role_admin')">
          <td > <button class="btn btn-info"  ng-click="myFunction()">Add<span  class="glyphicon glyphicon-shopping-cart " > </span></button>
                 <td><span><a  href="viewcartitem?cid=${prd.xid}" class="btn btn-info" style="background-color:#ff4dff;font-family:Comic Sans MS,cursive, sans-serif;">View-Item</a></span>
          </sec:authorize>
         </c:when>
          <c:when test="${url==false}"><td  style="color:red"><b>Out Of Stock</td>
         <td ><a href="#"><img id="productimg" src="files/images/desserts/${prd.xid}.jpg" alt="noimage" style="width:200px;height:150px;border-radius:5px"></img></a></td>
        
           <sec:authorize access="!hasRole('role_admin')">
          <td > <button class="btn btn-info disabled " ng-click="myFunction()">Add<span  class="glyphicon glyphicon-shopping-cart " > </span></button>
        </td>
   <td><span><a  href="viewcartitem?cid=${prd.xid}" class="btn btn-info" style="background-color:#ff4dff;font-family:Comic Sans MS,cursive, sans-serif;">View-Item</a></span>
         </td>
        </sec:authorize>
        </c:when>
        </c:choose> 
 
        
     
 
	  </tr>

  

  </form>
  </c:forEach>
    </table>
</div>

</body>
<%@ include file="footer.jsp" %>
</html>