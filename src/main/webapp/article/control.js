// JavaScript Document
var articleApp = angular.module('articleApp',['ngRoute']);


//TODO: Move this to a common place
var article_URL = 'rest/article';
articleApp.controller('articleCtrl', ['$scope','$http',function ($scope, $http) {
	$scope.currentPage = 0;
	$scope.itemsPerPage = 5;
	   
	 /* Read */
    //$scope, $http, method, url, entityname, formEntity
	//$scope.data = get($scope, $http, 'GET', inventory_URL, 'inventory', $scope.data);
	
	
	//$scope.inventoryForm_add_error = "";
	
	/* Create */
	//$scope, $http, method, entityName, EntityObject, url,  
	//$scope.addInventory = function(newInventory){
		//add($scope, $http, 'POST', inventory_URL, 'inventory', newInventory); 
	//};

 $http({
	      method: 'GET',
	    	  url: article_URL
	    	}).then(function successCallback(response) {
	    		    				
	    		//console.log(response.data);
	    		if($scope.data== undefined){
	                $scope.data = response.data;
	               	    		}
                 	            
	            else{
	                //no need to do anything right now...as the data is temporarily stored in the javascript array
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	        
	    	  });	


	$scope.dataForm_add_error = "";
	
	/* Create */
	$scope.addArticle = function(newArticle){
		
		
        //TODO: Add validations here1
		//if(!newExpense.user){ $scope.expenseForm_add_error="Missing Date"; }
		//console.log(newExpense);
		
$http({
	    	  method: 'POST',
	    	  url: article_URL,
	    	  data: newArticle
	    	}).then(function successCallback(response) {
	    		//console.log("Response after insert" + response.data);
	    		if($scope.data== undefined){
	                $scope.data= response.data;
	            }
	            else {
	            	//console.log("have to push the data into the array" + response.data) ;
	            	$scope.data.push(response.data);
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
		
		$scope.newArticle={};
	    
	};
	
	/*	delete */
		 $scope.deleteArticle= function(index) {
			remove($scope, $http, 'DELETE', article_URL, 'article', index); 
		};
		
			
	}]);



