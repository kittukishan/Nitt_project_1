<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin supplier</title>
<%@include file="../links.jsp" %>

</head>
<body>
<%@include file="../header.jsp"%>
<br>

<div class="view_supplier" border="1">

<div  align="center"><label><h2>List of Suppliers</label></div>
 
<table class="table"  align="center" border="0" style="background-color:#c4ff4d;width:80%;">
<tr>
<td><label style="padding:10px;">Supplier name</label></td>
<td><label style="padding:10px;">Supplier Address</label></td>
<td><label style="padding:10px;">Supplier Contact</label></td>
<td><label style="padding:10px;">Supplier @mail</label></td>
<td><label style="padding:10px;">Supplier Product</label></td>
<td> <label style="padding:10px;">Supplier Status</label></td><td><label>Modify</label></td></tr>
<!-- </table> -->

	<c:forEach var="supp" items="${suppdata}">
<!-- <table align="center" border=1> -->
	<tr >
	
	<td  style="padding:10px;text-align:center;">${supp.supp_name}</td> 
	<td style="padding:10px;text-align:center;">${supp.supp_address}</td>
	<td style="padding:10px;text-align:center;">"${supp.supp_contact}</td>
	<td  style="padding:10px;text-align:center;">${supp.supp_mail}</td> 
	<td  style="padding:10px;text-align:center;">${supp.supp_prod}</td> 
	<td  style="padding:10px;text-align:center;">${supp.supp_status}</td> 
	 
	<td><a class="bttn" href="admin_suppedit?id=${supp.supp_id}">Edit</a>
	</tr>
	</c:forEach>
	</table>
	 
	 <div align="center">
	 <a data-toggle="collapse" href="#addsupplier" class="btn btn-info" class="bttn" >
          <span class="glyphicon glyphicon-plus"></span>
        </a> </div> 
        </div>

	<div class="collapse" id="addsupplier">			
	
	<form:form action="admin_supplier_add" method="post" commandName="supplier" modelAttribute="supplier" >
	<table align="center" border=0>
	<tr><td><label style="padding:10px;">New Supplier name</label></td>
	<td><label style="padding:10px;">New Supplier Address</label></td>
	<td><label style="padding:10px;">New Supplier Contact</label></td>
	<td><label style="padding:10px;">New Supplier @mail</label></td>
	<td><label style="padding:10px;">New Supplier Product</label></td>
	<td> <label style="padding:10px;">New status Status</label></td></tr>
	
	<tr><td style="padding:10px;"><form:input type="text"  path="supp_name"/></td>
	<td style="padding:10px;"><form:input type="text" path="supp_address" /></td>
	<td style="padding:10px;"><form:input type="text" path="supp_contact"/></td>
	<td style="padding:10px;"><form:input type="text" path="supp_mail"/></td>
	<td style="padding:10px;"><form:input type="text" path="supp_prod"/></td>
	<td style="padding:10px;"><form:input type="text" path="supp_status"/></td></tr>
	<tr><td colspan=3 align=center><button class="btn btn-info" class="bttn" type="submit" >Submit </button></td></tr>
	</table>
	</form:form>
	</div>
<%@include file="../footer.jsp" %>
</body>
</html>