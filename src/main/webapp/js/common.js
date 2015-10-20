
/* Parameters
 * $scope	->	angularjs $scope variable
 * $http	->	angularjs $http variable
 * method	-> 	GET / POSt
 * url		->	URL  to be submitted or retrieve data 
NOTUSED * variable	->	form level javascript object that will hold the response data to UI
NOTUSED * data		->	form level javascript object that will be set with the incoming data from datasource,  
 * 				which will be presented to UI
 */
function get($scope, $http, method, url, variable, data){
	
	$http({
  	  method: method,
  	  url: url,
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
}

//$scope, $http, 'POST', expense_URL, 'expenses', newExpense);
function add($scope, $http, method, url, jsObjName, data) {		
	$http({
    	  method: method,
    	  url: url,
    	  data: data
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
	
	$scope.newExpense={};
}


function remove($scope, $http, method, url, jsObjName, index){
	/* Delete */
		$http({
	    	  method: method,
	    	  url: url + '/' + index
	    	  //data: {newExpense:''}
	    	}).then(function successCallback(response) {
	    		alert("Deleted successfully ");
	    		//Remove from the UI Layer table
	    		$("#_" + jsObjName + "_" + index).remove();
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    		  alert("Problem deleting record " + index);
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
	
}
