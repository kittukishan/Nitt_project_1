
<html>
<head>

<title>Insert title here</title>
<%@include file="links.jsp" %>
</head>
<body background="files/images/wall/bkgrnd4.jpg">
<%@include file="header.jsp" %>
 <c:forEach var="failed" items="${reg_error}"> 
<div class="alert alert-warning">
    <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
    <strong>Warning!</strong>${reg_error}<br>
  </div>
 </c:forEach> 

<center colspan="2"><h1><label style="color:black;"/>Sign up to login</h1></center>
<form:form action="reg_user" method="post" commandName="users" >
<table align="center";  class="table table-bordered" style="width:80%;margin-left:80px;" border=1;>
<div class="reg_form" align="center">
<br>
<tr><td style="padding-left:20px;width:150px;"><label style="color:green;">user name</td>
<td style="padding-left:20px;width:150px;"><form:input path="name" required="required"/></td></tr>
<br>
<tr><td style="padding-left:20px;width:150px;"><label style="color:green;"/>Password</td>
<td style="padding-left:20px;width:150px;"><form:input type="password" path="password" required="required"/></td></tr>
<br>

<tr><td style="padding-left:20px;width:150px;"><label style="color:green;"/>mobile</td>
<td style="padding-left:20px;width:150px;"><form:input path="mobile" required="required"/></td></tr>
<br>

<tr><td style="padding-left:20px;width:150px;"><label style="color:green;"/>Email</td>
<td style="padding-left:20px;width:150px;"><form:input type="email" path="email" required="required"/></td></tr>
<br>

<tr><td style="padding-left:20px;width:150px;"><label style="color:green;"/>D.O.B</td>
<td style="padding-left:20px;width:150px;"><form:input type="date"  path="dateofbirth" required="required"/></td></tr>
<br>

<tr><td style="padding-left:20px;width:150px;"><label style="color:green;"/>city</td>
<td style="padding-left:20px;width:150px;"><form:input path="city" required="required"/></td></tr>
<br>

<tr><td style="padding-left:20px;width:150px;"><label style="color:green;"/>state</td>
<td style="padding-left:20px;width:150px;"><form:input path="state" required="required"/></td></tr>
<br>
<tr><td ></td>
<td ><input type="submit" value="Register" class="btn btn-success fade in"><span style="padding:10px;"></span>
<input type="reset" value="RESET" class="btn btn-info"></td></tr>
</div>
</table>
</form:form>
<br><br>

</body>
<%@include file="footer.jsp" %>
</html>