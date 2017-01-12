<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin products</title>
<%@include file="../links.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="../header.jsp"%>
<br>

<div class="view_product" border="1">

<div  ><label><h2>List of products</h2></label></div>
<%-- <form:form action="product_modify" method="POST" > --%>
<table class="table"  align="center" border="0" style="background-color:#c4ff4d;width:80%;">
<tr>
<td></td>
<td><label style="padding:10px;">Product name</label></td>
<td><label style="padding:10px;">Product Description</label></td>
<td> <label style="padding:10px;">Product Status</label></td><td><label>Modify</label></td></tr>
<!-- </table> -->

	<c:forEach var="pd" items="${productdata}">
<!-- <table align="center" border=1> -->
	<tr >
	<td  style="padding:10px;text-align:center;width:150;"><img src="files/images/desserts/${pd.getItem_id()}.jpg" alt="noimage" style="width:160px;height:130px;border-radius:5px"></td> 
	<td  style="padding:10px;text-align:center;width:150;">${pd.getItem_name()}</td> 
	<td style="padding:10px;text-align:center;width:150;">${pd.getDesc()}</td> 
	<td style="padding:10px;text-align:center;width:150;">${pd.getStatus()}</td>
	<td><a class="bttn" href="admin_productedit?id=${pd.getItem_id()}">
	<span class="glyphicon glyphicon-wrench"></span>Edit</a></td>
		<td ><a class="btn btn-danger btn lg" href="admin_productdelete?id=${pd.getItem_id()}">
		<span class="glyphicon glyphicon-trash"></span></a></td>
	
	</tr>
	</c:forEach>
	</table>
	<%-- </form:form> --%>
	 <button type="button" data-toggle="collapse" data-target="#addproduct" class="btn btn-info" >
          <span class="glyphicon glyphicon-plus"></span>
        </button> 



	<div class="panel-collapse collapse" id="addproduct">			<!-- add_product -->
	
	<form:form action="admin_products_add" method="post" commandName="products" enctype="multipart/form-data">
	<table align="center" border=0>
	<tr><td><label style="padding:10px;">New Product name</label></td>
	<td><label style="padding:10px;">New Product Description</label></td>
	<td> <label style="padding:10px;">New Product Status</label></td></tr>
	<tr><td style="padding:10px;"><form:input type="text"  path="item_name"/></td>
	<td style="padding:10px;"><form:input type="text" path="desc"/></td>
	<td style="padding:10px;"><form:input type="text" path="status"/></td>
	<td>Image Upload :<form:input type="file" path="image1"  /></td></tr>
	<tr><td colspan=3 align=center><button class="btn btn-info" class="bttn" type="submit" >Submit </button></td></tr>
	</table>
	</form:form>
	</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>