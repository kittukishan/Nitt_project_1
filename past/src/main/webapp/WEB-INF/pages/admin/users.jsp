<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users data</title>
<%-- <%@ include file="../links.jsp" %> --%>
<script>
var app=angular.module('userapp',[]);
app.controller('mycontroller',function($scope,$http){
	$scope.get_users_data=function(){
		$http({method:'GET',URL:'showusers'})
		console.log("gson init in users")
		.success(function(data){
		
			$scope.users=data;
		})
	};
	
});
</script>
 <script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script> 
<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body ng-app="userapp" ng-controller="mycontroller">
<div class="container-fluid" ng-init="get_users_data()">
<div class="row">
<span class="col-sm-4"></span>
<span class="col-sm-4"><div><label>User Name:</label>
<label>Email:</label>
<label>Status:</label></div>
<div ng-repeat="usr in users">
<div>{{usr.name}}</div>
<!-- <div>{{usr.name}}</div>
<div>{{usr.name}}</div> -->

</div></span>

<span class="col-sm-4"></span>
</div>
<form action="" commandName="userdata">
<div class="row">
<span class="col-sm-4"></span>
<span class="col-sm-4">
<div ng-repeat="usr in users">
<div>{{usr.name}}</div>
<div>{{usr.name}}</div>
<div>{{usr.name}}</div>
</div>
</span>

<span class="col-sm-4"></span>
</div>
</form>

</div>

</body>
</html>