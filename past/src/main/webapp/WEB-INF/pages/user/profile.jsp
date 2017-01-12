<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="../links.jsp" %>

<style>

tr:hover{background-color:#c1ffe0;

}
</style>
<script src="files/js/header.js"></script> 
<!-- <script>
var app = angular.module('myApp', []);

function ToysController($scope, $http) {

	  $scope.sortType     = 'pid'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchProductName   = '';     // set the default search/filter term

        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'profile'
                }).success(function(data, status, headers, config) {
                        $scope.userdata = data;
                }).error(function(data, status, headers, config) {
                        
                });

        };
};
</script> -->

<title>Insert title here</title>
</head>

<body background="files/images/wall/bkgrnd4.jpg">
<%@ include file="../header.jsp" %>
<center colspan="2"><h1><label style="color:red;"/>User Profile</h1></center> 
 <form:form name="myForm" action="update_profile" method="POST" commandName="users" >
  <table  class="table table-bordered" style="width:80%;margin-left:80px;">   <!-- style="align:center;margin-left:100px;" border=1; -->
    
   <center  ng-repeat="prd in userdata | orderBy:sortType:sortReverse | filter:searchProduct">
   
      <tr >
     	 <td style="padding-left:20px;width:150px;">
            <a href="#" ng-click="sortType = 'pid'; sortReverse = !sortReverse">
             <label>User Name</label> 
             <span ng-show="sortType == 'pid' && !sortReverse" class="fa fa-caret-down"></span>
             <span ng-show="sortType == 'pid' && sortReverse" class="fa fa-caret-up"></span>
           </a>
        </td><td style="padding-left:20px;width:150px;"><form:input path="name"></form:input></td></tr>
        
        <tr>
        <td style="padding-left:20px;width:150px;">
          <a href="#" ng-click="sortType = 'pname'; sortReverse = !sortReverse">
            <label>Mobile</label>
            <span ng-show="sortType == 'pname' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'pname' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td><td style="padding-left:20px;width:150px;"><form:input type="text" path="mobile"/></td></tr>
        
        <tr>      
       <td style="padding-left:20px;width:150px;">
          <a href="#" ng-click="sortType = 'pdesc'; sortReverse = !sortReverse">
          	<label>Email</label>
            <span ng-show="sortType == 'pdesc' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'pdesc' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td><td style="padding-left:20px;width:150px;"><form:input type="mail" path="email"/></td></tr>
       
        <tr>      
       <td style="padding-left:20px;width:150px;">
          <a href="#" ng-click="sortType = 'pprice'; sortReverse = !sortReverse">
          <label>city</label> 
            <span ng-show="sortType == 'pprice' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'pprice' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td> <td style="padding-left:20px;width:150px;"><form:input type="text" path="city"/></td>       
    </tr>
    
     <tr>      
       <td style="padding-left:20px;width:150px;">
          <a href="#">
          <label>State</label> 
            
          </a>
        </td> <td style="padding-left:20px;width:150px;"><form:input type="text" path="state"/></td>       
    </tr>
       <tr>      
       <td style="padding-left:20px;width:150px;">
          <a href="#">
          <label>Password</label> 
            </a>
        </td> <td style="padding-left:20px;width:150px;" ><form:input type="password"  path="password" ></form:input>
        </td>       
    </tr>
       <tr>      
       <td style="padding-left:20px;width:150px;">
          <a href="#" ng-click="sortType = 'pprice'; sortReverse = !sortReverse">
          <label>Date of Birth</label> 
            <span ng-show="sortType == 'pprice' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'pprice' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td> <td style="padding-left:20px;width:150px;"><form:input type="date" path="dateofbirth"/></td>       
    </tr>
       <tr ><td colspan="2"><div align="center"><button class="btn btn-success fade in" >Update</button>	</div></td></tr>
    </center>
         
  </table>
</form:form>
</body>
</html>



















