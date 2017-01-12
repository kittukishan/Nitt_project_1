<html>
<head>

<%@include file="links.jsp"%>
<!-- <script>
var app = angular.module('headapp', []);
app.controller('headcntrl', function($scope,$http) {
	$scope.startmethod=function(){
		
		$http({ method : 'GET',
            url : 'cartitemscount'})
            .success(function(data, status, headers, config){
            	$scope.no=data;       	
            } )					
                     		            
            .error(function(data, status, headers, config) {         });
		}
});

</script> -->
<script src="files/js/header.js"></script> 
<title>hOME PAgE</title>

</head>


<body background="files/images/wall/bkgrnd.jpg">
<%@include file="header.jsp"%>
<sec:authorize access="hasAnyRole('role_admin')">
       <div><img src="files/images/wall/welcome.jpg" align:middle></div> 
       
        </sec:authorize>


<c:forEach var="failed" items="${err}">
<div class="alert alert-warning">
    <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
    <strong>Warning!</strong>${err}<br>
  </div>
</c:forEach>

<%@include file="carousel.jsp"%>
<br>

<%@include file="footer.jsp"%>
</body>
</html>