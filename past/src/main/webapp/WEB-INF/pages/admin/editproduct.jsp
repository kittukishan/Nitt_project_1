<html>
<head>
<title>edit products</title>
<%@include file="../links.jsp" %>
<script>
function loadImage() {
	 document.getElementById("myCheck").readOnly = true;
}
</script>
<style>
.id{

    border-style: ridge;
    border-color: red;

}
</style>
</head>
<body onload="loadImage()">
<%@include file="../header.jsp"%>

<div class="admin_view_product" border="1">

<div  ><label>List of products</label></div>

<form:form  action="admin_updateproduct" method="post" commandName="proiddata"  >
 
	<!-- <table align="center" class="prod" > -->
	<table class="table"  align="center" border="0" style="background-color:#c4ff4d;width:80%;">
	
	
	<tr><td><label >Product name</label></td>
	<td style="padding:10px; text-align:center;"><form:input type="text"  path="item_name"  /></td></tr>
	
	<tr><td><label >Category Description</label></td>
	<td style="padding:10px; text-align:center;"><form:input type="text" path="desc" /></td></tr><%-- value="${proiddata.desc}" --%>
	
	<tr><td> <label >Category Status</label></td>
	<td style="padding:10px;text-align:center;"><form:input type="text" path="status" /></td></tr><%-- value="${proiddata.status}" --%>
	<tr><td> <label >Category image</label></td>
	<td style="padding:10px;text-align:center;"><a href=""></a></td></tr><%-- value="${proiddata.image}" --%>
	<tr><td> <label >Category Id</label></td>
	<td class="id" style="padding:10px;"><form:input type="text"  id="myCheck"  path="item_id" style="text-color:red;" /></td></tr><%-- value="${proiddata.item_id}" --%>
	
	<tr><td><button type="submit">Update</button></td></tr>
	
		
	<%-- <c:forEach var="cat" items="${catiddata}"> --%>


	<%-- </c:forEach> --%>

	</table>
	 
	</form:form>
	
		</div>
	</div>
</body>
</html>