<html>
<head>
<%@ include file="../links.jsp" %>
<script>
 var app = angular.module("past-disp", []);

function past_controller($scope, $http) {

	  $scope.sortType     = 'pid'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchProductName   = '';     // set the default search/filter term 
 
        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonCon'
                }).success(function(data, status, headers, config) {
                        $scope.Products = data;alert(data); 
                }).error(function(data, status, headers, config) {
                        
                });

        };
};

</script>

<title>Pastries</title>
</head>
<body class="pastries-page">		
<%@ include file="../header.jsp" %>
<br>

<div   ng-app="past-disp" ng-controller="past_controller">	<!-- -->
   <form>
    <div class="form-group">
    
      <div class="input-group">
       
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        
        <input type="text" class="form-control" placeholder="Search Product" ng-model="searchProduct">
 
      </div>  
         
    </div>
        
  </form>
  <div ng-init="getDataFromServer();">
  <table class="table table-bordered table-striped" border="1">
   <tr>
   <td>item no</td>
        <td>dessert</td>
        <td>description</td>
        <td>price</td>
        <td>offer</td>
   
   </tr>
   
   <tbody>
    <tr ng-repeat="prd in Products">		<!-- | orderBy:sortType:sortReverse | filter:searchProduct -->
        <td>{{prd.item_id}}</td>
        <td>{{prd.item_name}}</td>
        <td>{{prd.desc}}</td>
        <td>{{ prd.status }}</td>
        <td>{{ prd.offer }}</td>
	  </tr>
  </tbody>
  
  </table>
  </div>
<!-- <table class="past-tab">
<tr ><th cospan="5" >Pastries for U!</th></tr>
<tr><td>Item no</td><td>Item</td><td>Description:</td><td>price:</td><td>Off</td></tr>
<tr><td>Item no</td><td>Item</td><td>Description:</td><td>price:</td><td>Off</td></tr>

</table> -->
</div>
</body>
</html>