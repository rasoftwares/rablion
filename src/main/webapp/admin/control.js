// JavaScript Document
var adminApp = angular.module('adminApp',['ngRoute']);

//TODO: Move this to a common place
var user_URL = 'rest/user';
var users = ["Fowmi","Mohammed","Ramesh","Rajesh","Suhail"];

adminApp.controller('userCtrl', ['$scope', '$http', function ($scope, $http) {
	$scope.users = users;
	$scope.type= ["Owner", "UserA", "UserB", "Guest"];
	 /* Read */
   //$scope, $http, method, url, entityname, formEntity
	//$scope.data = get($scope, $http, 'GET', user_URL, 'user', $scope.data);
	
	
	//$scope.userForm_add_error = "";
	
	/* Create */
	//$scope, $http, method, entityName, EntityObject, url,  
	//$scope.adduser = function(newUser){
		//add($scope, $http, 'POST', user_URL, 'user', newUser); 
	//};

	$http({
	      method: 'GET',
	    	  url: user_URL
	    	}).then(function successCallback(response) {
	    		//console.log(response.data);
	    		if($scope.user == undefined){
	                $scope.user = response.data;
	            }
	            else{
	                //no need to do anything right now...as the data is temporarily stored in the javascript array
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
	    
	    
    
	$scope.userForm_add_error = "";
	
	/* Create */
	$scope.addUser = function(newUser){
		
        //TODO: Add validations here1
		//if(!newExpense.user){ $scope.expenseForm_add_error="Missing Date"; }
		//console.log(newExpense);
		
$http({
	    	  method: 'POST',
	    	  url: user_URL,
	    	  data: newUser
	    	}).then(function successCallback(response) {
	    		//console.log("Response after insert" + response.data);
	    		if($scope.user == undefined){
	                $scope.user = response.data;
	            }
	            else {
	            	//console.log("have to push the data into the array" + response.data) ;
	            	$scope.user.push(response.data);
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
		
		$scope.newUser={};
	};
		
		/*Delete*/
		$scope.deleteUser= function(index) {
			remove($scope, $http, 'DELETE', user_URL, 'user', index); 
		};

		
	}]);

/*currency*/

var currency_URL = 'rest/currency';

adminApp.controller('currencyCtrl', ['$scope', '$http', function ($scope, $http) {
   $http({
	      method: 'GET',
	    	  url: currency_URL,
	    	}).then(function successCallback(response) {
	    		//console.log(response.data);
	    		if($scope.currency == undefined){
	                $scope.currency = response.data;
	            }
	            else{
	                //no need to do anything right now...as the data is temporarily stored in the javascript array
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
	    
	  
  /*create*/
    $scope.addCurrency = function(newCurrency){
	
        	
$http({
	    	  method: 'POST',
	    	  url: currency_URL,
	    	  data: newCurrency
	    	}).then(function successCallback(response) {
	    		//console.log("Response after insert" + response.data);
	    		if($scope.currency == undefined){
	                $scope.currency = response.data;
	            }
	            else {
	            	//console.log("have to push the data into the array" + response.data) ;
	            	$scope.currency.push(response.data);
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	    });
		
		$scope.newCurrency={};
    };
		
	
		
		$scope.deleteCurrency= function(index) {
			remove($scope, $http, 'DELETE', currency_URL, 'currency', index); 
		};
		
		    	
    	}]);


/*catalog*/

var catalog_URL = 'rest/catalog';

adminApp.controller('catalogCtrl', ['$scope', '$http', function ($scope, $http) {
   $http({
	      method: 'GET',
	    	  url: catalog_URL,
	    	}).then(function successCallback(response) {
	    		//console.log(response.data);
	    		if($scope.catalog == undefined){
	                $scope.catalog = response.data;
	            }
	            else{
	                //no need to do anything right now...as the data is temporarily stored in the javascript array
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
	    
	  
  /*create*/
  
  
   
   $scope.addCatalog = function(newCatalog){
	
        	
$http({
	    	  method: 'POST',
	    	  url: catalog_URL,
	    	  data: newCatalog
	    	}).then(function successCallback(response) {
	    		//console.log("Response after insert" + response.data);
	    		if($scope.catalog == undefined){
	                $scope.catalog = response.data;
	            }
	            else {
	            	//console.log("have to push the data into the array" + response.data) ;
	            	$scope.catalog.push(response.data);
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	    });
		
		$scope.newCatalog={};
   };
		
			
		$scope.deleteCatalog= function(index) {
			remove($scope, $http, 'DELETE', catalog_URL, 'catalog', index); 
		};
		
		

    	
   }]);
