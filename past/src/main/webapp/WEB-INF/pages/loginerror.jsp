
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="links.jsp" %>
<title>Insert title here</title>
</head>
<body>
 <%@include file="header.jsp"%>
<%@include file="login.jsp"%>
<strong>login unsuccessful</strong>
<div class="alert alert-warning">
    <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
    <strong>Warning!</strong>${err} <br>Login failed please check login credentials.
  </div>
  <%@ include file="footer.jsp" %>
</body>
</html>