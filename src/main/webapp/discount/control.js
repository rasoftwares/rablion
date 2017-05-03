var discountApp = angular.module('discountApp',['ngRoute']);

var discount_URL = 'rest/discount';

discountApp.controller('discountCtrl', ['$scope', '$http', function ($scope, $http) {
   $http({
	      method: 'GET',
	    	  url: discount_URL,
	    	}).then(function successCallback(response) {
	    		//console.log(response.data);
	    		if($scope.data == undefined){
	                $scope.data = response.data;
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
    $scope.addDiscount = function(newDiscount){
	
        	
$http({
	    	  method: 'POST',
	    	  url: discount_URL,
	    	  data: newDiscount
	    	}).then(function successCallback(response) {
	    		//console.log("Response after insert" + response.data);
	    		if($scope.data == undefined){
	                $scope.data = response.data;
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
		
		$scope.newDiscount={};
    };
		
	
		
		$scope.deleteDiscount= function(index) {
			remove($scope, $http, 'DELETE', discount_URL, 'discount', index); 
		};
		
		    	
    	}]);