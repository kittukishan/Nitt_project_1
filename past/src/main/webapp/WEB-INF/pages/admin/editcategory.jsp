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
<body onload="loadImage()" style="background-color=#d301f1;">
<%@include file="../header.jsp"%>

<div class="view_product" border="1">

<div  ><label>List of products</label></div>

<form:form  action="admin_updatecategory" method="post" commandName="catiddata" >
 
<table class="table"  align="center" border="0" style="background-color:#c4ff4d;width:80%;">
	
	<tr><td><label >Category name</label></td>
	<td style="padding:10px; text-align:center;"><form:input type="text"  path="cat_name" /></td></tr>
	
	<tr><td><label >Category Description</label></td> 
	<td style="padding:10px; text-align:center;"><form:input type="text" path="cat_desc"/></td></tr>
	
	<tr><td> <label >Category Status</label></td>
	<td style="padding:10px;text-align:center;"><form:radiobutton value="true" checked="checked" path="status"/><b>true</b>
												<form:radiobutton value="false" path="status"/><b>False</b></td></tr>
	
	<tr><td> <label >Category Id</label></td>
	<td class="id" style="padding:10px;text-align:center;"><form:input type="text"  id="myCheck"  path="cat_id" style="text-color:red;"/></td></tr>
	<tr><td><button type="submit">Update</button></td></tr>
	
		
	<%-- <c:forEach var="cat" items="${catiddata}"> --%>


	<%-- </c:forEach> --%>

	</table>
	 
	</form:form>
	
		</div>
	</div>
</body>
</html>