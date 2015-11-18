var catalog = angular.module('catalogApp', ['ngRoute']);

var catalog_URL = 'rest/catalog';

catalog.controller('catalogCtrl', ['$scope', '$http', function ($scope, $http) {
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
	    
}]);