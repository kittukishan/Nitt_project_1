<html>
<head>

<title>admin category</title>
<%@include file="../links.jsp" %>
</head>
<body style="background-image:url("../images/wall/wall1.jpg");">
<!-- <script type="text/javascript">
$(document).ready(function(){
	$(".myCheck").prop("disabled", true);
	
    $(".enable").click(function(){
        $(".myCheck").prop("disabled", true);
    });
    $(".disable").click(function(){
        $(".myCheck").prop("disabled", false);
    });
});
</script> -->
<%@include file="../header.jsp"%>
<br>

<div class="view_product" border="1">

<div  ><label>List of category</label></div>

<table class="table"  align="center" border="0" style="background-color:#c4ff4d;width:80%;">
<tr><td><label style="padding:10px;">Category name</label></td>
<td><label style="padding:10px;">Category Description</label></td>
<td> <label style="padding:10px;">Category Status</label></td><td><label>Modify</label></td></tr>
<!-- <tr ><td colspan="6"align="center"><button type="button" class="enable">Disable Edit</button><button type="button" class="disable">Edit</button></td></tr> -->


	<c:forEach var="cat" items="${catdata}"> 
	
<!-- <table align="center" border=1> -->

	
	<tr >
	<!-- <td><button type="button" class="enable">Enable</button><button type="button" class="disable">Disable</button></td> -->
	<td  style="padding:10px;">${cat.cat_name}</td> 
	<td  style="padding:10px;">${cat.cat_desc}</td> 
	<td  style="padding:10px;">${cat.status}</td>
	<td><a class="bttn" href="admin_catedit?id=${cat.cat_id}">Edit</a><td>		<!-- /<a href="#">Disable</a> -->
	
	<%-- <td><a href="catedit/${cat.cat_id}">Edit</a> --%>
	</tr>
	 </c:forEach>
	</table>
	</div>
	<div align="center">
	 <a type="button" data-toggle="collapse" href="#addcategory" class="btn btn-info" aria-expanded="false">
          <span class="glyphicon glyphicon-plus"></span>
        </a> 
</div>

	<div class="collapse" id="addcategory">			<!-- add_product -->
	
	<form:form action="admin_category_add" method="post" commandName="category" modelAttribute="category" >
	<table align="center" border=0>
	<tr><td><label style="padding:10px;">New Category name</label></td>
	<td><label style="padding:10px;">New Category Description</label></td>
	<td> <label style="padding:10px;">New Category Status</label></td></tr>
<tr><td style="padding:10px;"><form:select items="${selectcategory}" path="cat_name"/></td>
	<td style="padding:10px;"><form:input type="text" path="cat_desc"/></td>
	<td style="padding:10px;"><form:select items="${selectstatus}" type="text" path="status"/></td></tr>
	<tr><td colspan=3 align=center><button class="btn btn-info" class="bttn" type="submit" >Submit </button></td></tr>
	</table>
	</form:form>
	</div>
<%@include file="../footer.jsp" %>
</body>
</html>