var paymentApp = angular.module('paymentApp',['ngRoute']);

var payment_URL = 'rest/payment';

paymentApp.controller('paymentCtrl', ['$scope', '$http', function ($scope, $http) {
   $http({
	      method: 'GET',
	    	  url: payment_URL,
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
    $scope.addPayment = function(newPayment){
	
        	
$http({
	    	  method: 'POST',
	    	  url: payment_URL,
	    	  data: newPayment
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
		
		$scope.newPayment={};
    };
		
	
		
		$scope.deletePayment= function(index) {
			remove($scope, $http, 'DELETE', payment_URL, 'payment', index); 
		};
		
		    	
    	}]);

