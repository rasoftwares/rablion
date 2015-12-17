// JavaScript Document
var mortgageApp = angular.module('mortgageApp',['ngRoute']);

//TODO: Move this to a common place
var loan_URL = 'rest/loan';

var users = ["Fowmi","Mohammed","Ramesh","Rajesh","Suhail"];

mortgageApp.controller('mortgageCtrl', ['$scope', '$http', function ($scope, $http) {
	    $scope.users=users;
	
		$scope.Item = ["bangle", "ring", "chain"];
		 /* Read */
	    //$scope, $http, method, url, entityname, formEntity
		//$scope.data = get($scope, $http, 'GET', loan_URL, 'loan', $scope.data);
		
		
		//$scope.loanForm_add_error = "";
		
		/* Create */
		//$scope, $http, method, entityName, EntityObject, url,  
		//$scope.addLoan = function(newLoan){
			//add($scope, $http, 'POST', loan_URL, 'loan', newLoan); 
		//};

    /* Read */
	$http.get(loan_URL).success(function(data) {
           
                if($scope.loan == undefined){
                    $scope.loan = data;
                }
                else{
                    //no need to do anything right now...as the data is temporarily stored in the javascript array
                }
		});
	$scope.loanForm_add_error = "";
	$http({
	      method: 'GET',
	    	  url: loan_URL
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
	    	    // or server returns response with an error status.
	    	  });
	    
	    
  
	$scope.dataForm_add_error = "";
	
	/* Create */
	$scope.addLoan = function(newLoan){
		
      //TODO: Add validations here1
		//if(!newExpense.user){ $scope.expenseForm_add_error="Missing Date"; }
		//console.log(newExpense);
		
$http({
	    	  method: 'POST',
	    	  url: loan_URL,
	    	  data: newLoan
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
		
		$scope.newLoan={};
	};
		
		$scope.deleteLoan= function(index) {
			remove($scope, $http, 'DELETE', loan_URL, 'loan', index); 
		};

		
	}]);




/* Create */
	/*$scope.addLoan = function(newLoan) {
		
        //TODO: Add validations here
		//if(!newLoan.user){ $scope.loanForm_add_error="Missing Date"; }
		//console.log(newLoan);
		
		newLoan.id = $scope.loan.length+1 ;		
        $scope.loan.push(newLoan);
        
		$scope.newnewLoan = {};
	}


	
	
	/* Delete */
	/*$scope.deleteLoan = function(index) {
		
        for(i=0; i < $scope.loan.length; i++) {
            
			if($scope.loan[i].id == index) {
                //console.log("for index :" + i + ": index from click :" + index);
				//console.log("Will be deleting loan" + $scope.loan[i].id + ":" + $scope.loan[i].type);                
				$("#_loan_" + index).remove();
                $scope.loan = $.grep($scope.loan, function(value) {
                    return value.id != index;
                });
                console.log("Loans Length :" + $scope.loan.length);
			}}};
	*/
				
	
