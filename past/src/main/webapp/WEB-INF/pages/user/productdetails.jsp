

<html>
<head>
<%@ include file="../links.jsp" %>
<title>Insert title here</title>
<script src="files/js/header.js"></script> 

<style>
.thumnail:hover{background-color:#ffc1e0;
}
  .review-head{
float:left;
} 
body{
counter-reset:Serial;
}
.review-data{
clear:left;
color:black;
} 
.item{

border-radius:8px; 
padding-top:20px; 
padding-left:20px; 
padding-bottom:20px;
padding-right:20px;  
border:5px;
width:auto;
height:auto; 
background-color:#ccffe6;


}
/* .reviewcontent{
overflow: visible; 
} */
label{
margin-align:left;
}
/* label:first-child:before{
counter-increment:Serial;
content:counter(Serial);
} */
</style>
</head>
<body background="files/images/wall/bkgrnd4.jpg">
 <%@ include file="../header.jsp" %>	
<br>
<br>
<div class="container" >
<div class="row" >
<div class="item">	



<div class="reviewcontent">
<img src="files/images/desserts/${xiddata.product_id}.jpg" alt="No image" style="width:200px;height:200px;border-radius:5px;"></img>
  <div class="col-xs-6"  class="thumbnail" >   
  	
  
      
   <form action="Addingtocartreq/${xiddata.xid}">
    	
    <!-- 	<label></label>	 -->
       <br> <label style="color:black;"><b>Product Name:${xiddata.product_name}</b></label>
         <br><label style="color:black"><b>Supplier:${xiddata.supplier_name}</b></label>
        <br><label style="color:black"><b>Price:${xiddata.price}</b></label>
        <%-- <br> <label  style="color:black"><b>${xiddata.stock}</b></label> --%>
         <br> <label  style="color:blue;">Quantity:
         <select name="qnty">
         <option value="1" >1</option>
         <option value="2">2</option>
         <option value="3">3</option>
         <option value="4">4</option>
         <option value="5">5</option></select></label>
      

         <br><span class="glyphicon glyphicon-star" style="color:#ffff99;"></span><label style="color:green;">Rating:4.5</label>
         <c:url var="url" value="${xiddata.status}">     </c:url>
         <c:choose>
         <c:when test="${url==true}">
         <br><label  style="color:green"><b>Available</b></label>
          <sec:authorize access="!hasRole('role_admin')">
          <button class="btn btn-info"  ng-click="myFunction()">Add<span  class="glyphicon glyphicon-shopping-cart " > </span></button>
          </sec:authorize>
         </c:when>
          <c:when test="${url==false}"><label  style="color:red"><b>Out Of Stock</b></label>
           <sec:authorize access="!hasRole('role_admin')">
          <button class="btn btn-info disabled"  ng-click="myFunction()">Add<span  class="glyphicon glyphicon-shopping-cart " > </span></button>
 
        </sec:authorize>
        </c:when>
        </c:choose> 
        </form>
     </div>
 <div class="media-body">
 
       <c:if test="${pageContext.request.userPrincipal.name != null}">
      <sec:authorize access="!hasAnyRole('role_admin')">
    <form:form action="Addreview/${xiddata.xid}" commandName="review1">
      <h4 class="review-head"><label>
      ${pageContext.request.userPrincipal.name}:</label></h4>
      <form:input type="text" path="review" style="width:700px;height:50px;" />
       <input type="submit" class="btn btn-info"></button>
       </form:form>
       </sec:authorize>
       </c:if>
      </div> 

  <div class="media">
<%--      <c:url var="url" value="${prd.status}">     
 --%>    <%-- <c:choose >
    <c:when test="${url==true}"> --%>
   <c:forEach var="R" items="${review}">
      <%--  <form:form action="Addreview/" > --%>
      <div class="media-body">
            <h4 class="review-head"><i>${R.getCustomerid().getUsers().getName() }:</i></h4>
      <p class="review-data">${R.review}</p>
      </div>
      <br> 
   <%--  <div class="media-body">
       <c:if test="${pageContext.request.userPrincipal.name != null}">
      <sec:authorize access="!hasAnyRole('role_admin')">
    
      <h4 class="review-head"><label>
      ${pageContext.request.userPrincipal.name}:</label></h4>
      <form:input type="text" path="review" style="width:700px;height:50px;" />
       <button class="btn btn-info">Submit</button>
       </sec:authorize>
       </c:if>
      </div> 
      </form:form> --%>
      </c:forEach>
     <%--  </c:when>
      </c:choose> --%>
<%--     </c:url>
 --%>  </div>
 
  </div> 
  
  
  
  
  
  
  
</div>
 </div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>