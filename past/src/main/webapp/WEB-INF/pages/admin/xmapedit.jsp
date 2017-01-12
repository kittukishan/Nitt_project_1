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
<body onload="loadImage()" ><!-- style="background-color:#d301f1;" -->
<%@include file="../header.jsp"%>

<div class="view_product" >
<form:form action="admin_xmap_update" commandName="xmap1" method="POST">

<table class="table"  align="center" border="0" style="background-color:#c4ff4d;width:80%;">

    <tr>		<td ><label style="padding:10px;">product id</label></td>
    		<td><form:select path="product_id"><c:forEach var="x" items="${value1}">	
		<form:option value="${x}">${x}</form:option>
		</c:forEach></form:select>
	</td></tr>
    			<%-- <td style="padding:10px;"><form:input type="text" path="product_id"/></td> --%>
        		 <tr><td ><label style="padding:10px;">supplier id</label></td>
        		 <td><form:select  path="supp_id"><c:forEach var="x" items="${value2}">
		<form:option value="${x}">${x}</form:option>
	</c:forEach></form:select>
	</td>
        		 <%-- <td style="padding:10px;"><form:input type="text" path="supp_id"/></td> --%></tr>
        		 <tr> <td ><label style="padding:10px;">category id</label></td>
        		 <td><form:select path="cat_id"><c:forEach var="xc" items="${value3}">
	<form:option value="${xc}" >${xc}</form:option>
	</c:forEach>
	</form:select>
	</td></tr>
        		<%--  <td style="padding:10px;"><form:input type="text" path="cat_id"/></td> --%>
       			 <tr> <td ><label style="padding:10px;">price</label></td>
       			 <td style="padding:10px;"><form:input type="text" path="price"/></td></tr>
       			 <tr> <td><label style="padding:10px;">stock </label> </td>
       			 <td style="padding:10px;"><form:input type="text" path="stock"/></td></tr>
       			 <tr> <td ><label style="padding:10px;">status</label></td>
       			 <td><form:radiobutton value="true" checked="checked" path="status"/><b>Available</b>
					 <form:radiobutton value="false" path="status"/><b>Out of Stock</b></td></tr>
				<tr><td ><label style="padding:10px;">X-map id</label></td>
    			<td style="padding:10px;"><form:input id="myCheck" type="text" path="xid"/></td></tr>
       			 <tr><td><button type="submit">Update</button></td></tr>
       			</table>
       			</form:form>
	</div>
</body>
</html>