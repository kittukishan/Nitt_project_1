<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../links.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div>
       
     <div class="view_product"  >
     <div>List of xmap data</div>
    <table class="table" align="center" border="0" style="background-color:#c4ff4d;width:80%;">
    <tr>		<td></td>
    			<td ><label style="padding:10px;">product id</label></td>
        		<td ><label style="padding:10px;">supplier id</label></td>
        		 <td ><label style="padding:10px;">category id</label></td>
       			 <td ><label style="padding:10px;">price</label></td>
       			 <td><label style="padding:10px;">stock </label> </td>
       			 <td ><label style="padding:10px;">status</label></td>
       			<td><label style="padding:10px;">modify</label></td>
       			</tr>
        		
        	
        <c:forEach var="x" items="${value}">
       
<tr>
<td style="padding:10px;"><img src="files/images/desserts/${x.xid}.jpg" alt="noimage" style="width:120px;height:80px;border-radius:5px"></td>
<td style="padding:10px;">${x.product_id}</td>
<td style="padding:10px;">${x.supp_id}</td>
<td style="padding:10px;">${x.cat_id}</td>
<td style="padding:10px;">${x.price}</td>
<td style="padding:10px;">${x.stock}</td>
<td style="padding:10px;">${x.status}</td>
<td style="padding:10px;"><a class="btn btn-info btn lg" style="width:60px;height:30px;" href="admin_xmap_edit?id=${x.xid}">Edit<span class="glyphicon glyphicon-pencil"></span></a>
						  <%-- <a class="btn btn-danger btn lg" href="admin_xmapdelete?id=${x.product_id}">
		<span class="glyphicon glyphicon-trash"></span></a> --%></td>

</tr></c:forEach>
      	  </table>
      	 
	  </div>
	
	  <div align="center">
	 <a type="button" data-toggle="collapse" href="#addxmap" class="btn btn-info" aria-expanded="false">
          <span class="glyphicon glyphicon-plus"></span>
        </a> 
		</div>
		
		<div class="collapse" id="addxmap">			<!-- add_product -->
	
	<form:form action="admin_xmap_add" method="post" commandName="xmap" enctype="multipart/form-data">
	<table border=0 align="center"  class="prod">
	<tr><td><label style="padding:10px;">product id</label></td><td><label style="padding:10px;">supplier id</label></td>
	<td><label style="padding:10px;">category id</label></td><td ><label style="padding:10px;">price</label></td>
	<td><label style="padding:10px;">stock </label> </td><td ><label style="padding:10px;">status</label></td></tr>
	
	<tr>
	<td><form:select path="product_id"><c:forEach var="x" items="${value1}">	
		<form:option value="${x}">${x}</form:option>
		</c:forEach></form:select>
	</td>
	<td><form:select  path="supp_id"><c:forEach var="x" items="${value2}">
		<form:option value="${x}">${x}</form:option>
	</c:forEach></form:select>
	</td>
	
	<td><form:select path="cat_id"><c:forEach var="xc" items="${value3}">
	<form:option value="${xc}" >${xc}</form:option>
	</c:forEach>
	</form:select>
	</td>
	<td style="padding:10px;"><form:input style="width:60px" type="text" path="price"/></td>
	<td style="padding:10px;"><form:input style="width:60px" type="text" path="stock"/></td>
	<td><form:radiobutton path="status" value="true" checked="checked"/><b>Available
	<form:radiobutton value="false" path="status" /><b>Out Of Stock</td>
	<td>Image Upload :<form:input type="file" path="image1"  /></td></tr>
	<tr><td colspan="6" style="text-align:center;"><button type="submit"  class="btn btn-success">Add</button></td></tr>
	</table>
	
	</form:form>
   </div >
<%@ include file="../footer.jsp" %>
</body>
</html>