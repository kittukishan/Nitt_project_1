 

<div ng-init="startmethod()"  ng-app="headapp" ng-controller="headcntrl" ><!-- class="container-fluid"  data-role="header" data-position="fixed" -->
<div class="header">
<div class="menu1">
<ul class="menu-list1">
  <li><a href="Home-req"><span class="glyphicon glyphicon-home">Home</span></a></li>
  
 
   <div class="hungry">
 	 <li><a href="Hungry-req" >Hungry</a>
  		<div class="hungry_item">
  			<a href="Starters-req">Starters</a>
  			<a href="Main course-req">main course</a>
 			 <a href="Desserts-req">Desserts</a>
  			<a href="fluid-req">Fluids</a>
 		</div></li>
  </div>
<li><a href="Aboutus-req">About Us</a></li>
</ul>
</div>

 <div class="ico">
<a href="https://www.facebook.com/"><img src="files/images/icons/facebook.jpg" alt="icon" ></a>
<a href="https://plus.google.com/"><img src="files/images/icons/google.png" alt="icon" ></a>
<a href="https://twitter.com/"><img src="files/images/icons/Twitter.png" alt="icon" ></a>
</div>


<div class="menu2">
 <ul class="menu-list2">
<sec:authorize access="hasAnyRole('role_user')">
       <li><a href="usercart" class="btn btn-success "><span class="glyphicon glyphicon-shopping-cart" ><span class="badge">{{no}}</span> </span></a>
</li>
        </sec:authorize>
   <c:if test="${pageContext.request.userPrincipal.name != null}">
<li><a href="j_spring_security_logout" ><span class="glyphicon glyphicon-off">logout</span></a></li> 
<sec:authorize access="hasAnyRole('role_admin')">
       <li><a href="adminprofile-req">Welcome :${pageContext.request.userPrincipal.name}</a></li>
        </sec:authorize>
  <sec:authorize access="hasAnyRole('role_user')">
       <li><a href="userprofile-req">Welcome :${pageContext.request.userPrincipal.name}</a></li>
        </sec:authorize>
   </c:if> 
   
   
   <c:if test="${pageContext.request.userPrincipal.name == null}">
 <li><a href="register-req">Sign Up</a></li>
<li><a href="#" data-toggle="modal" data-target="#LoginModal" ><span class="glyphicon glyphicon-user">login</span></a></li> 

   </c:if>
</ul>
</div>
</div>
 <sec:authorize access="hasAnyRole('role_admin')">
        <%@include file="admin/nav.jsp"%>
        </sec:authorize>
        <%@include file="login.jsp"%>
</div> 