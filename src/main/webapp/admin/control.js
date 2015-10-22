// JavaScript Document
var adminApp = angular.module('adminApp',['ngRoute']);

//TODO: Move this to a common place
var user_URL = 'rest/user';

adminApp.controller('userCtrl', ['$scope', '$http', function ($scope, $http) {
   $http({
	      method: 'GET',
	    	  url: user_URL
	    	}).then(function successCallback(response) {
	    		//console.log(response.data);
	    		if($scope.users == undefined){
	                $scope.users = response.data;
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

		
	}}]);


/*currency*/
var adminApp = angular.module('adminApp',['ngRoute']);

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
		
	/*currency delete*/	
		
		$scope.deleteCurrency= function(index) {
			remove($scope, $http, 'DELETE', currency_URL, 'currency', index); 
		};
		
		/*$scope.deleteCurrency = function(index) {
			
	        for(i=0; i < $scope.currency.length; i++) {
	            
				if($scope.currency[i].id == index) {
	                //console.log("for index :" + i + ": index from click :" + index);
					//console.log("Will be deleting expense" + $scope.expenses[i].id + ":" + $scope.expenses[i].type);                
					$("#_currency_" + index).remove();
	                $scope.currency = $.grep($scope.currency, function(value) {
	                    return value.id != index;
	                });
	                console.log("Currency Length :" + $scope.currency.length);
				}
			}		
		}*/

    	
    	}}]);
