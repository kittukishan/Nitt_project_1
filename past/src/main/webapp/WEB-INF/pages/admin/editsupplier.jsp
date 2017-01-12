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

<form:form  action="admin_updatesupplier" method="post" commandName="suppiddata"  >
 
<table class="table"  align="center" border="0" style="background-color:#c4ff4d;width:80%;">
	
	<tr><td><label >supplier name</label></td>
	<td style="padding:10px; text-align:center;"><form:input type="text"  path="supp_name" /></td></tr>
	
	<tr><td><label >supplier Contact</label></td>
	<td style="padding:10px; text-align:center;"><form:input type="text" path="supp_contact" /></td></tr>
	
	<tr><td><label >supplier Address</label></td>
	<td style="padding:10px; text-align:center;"><form:input type="text" path="supp_address" /></td></tr>
	
	<tr><td><label >supplier mail</label></td>
	<td style="padding:10px; text-align:center;"><form:input type="text" style="width:150;" path="supp_mail" /></td></tr>
	
	<tr><td><label >supplier products</label></td>
	<td style="padding:10px; text-align:center;"><form:input type="text" path="supp_prod" /></td></tr>
	
	<tr><td> <label >supplier Status</label></td>
	<td style="padding:10px;text-align:center;"><form:input type="text" path="supp_status" /></td></tr><%-- value="${suppiddata.sup_status}" --%>
	
	<tr><td> <label >supplier Id</label></td>
	<td class="id" style="padding:10px;text-align:center;"><form:input type="text"  id="myCheck"  path="supp_id" style="text-color:red;"/></td></tr>
	<tr><td><button type="submit">Update</button></td></tr>
	
		
	<%-- <c:forEach var="cat" items="${catiddata}"> --%>


	<%-- </c:forEach> --%>

	</table>
	 
	</form:form>
	
		</div>
	</div>
</body>
</html>