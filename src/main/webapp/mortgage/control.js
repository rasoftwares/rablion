// JavaScript Document
var mortgageApp = angular.module('mortgageApp',['ngRoute']);

//TODO: Move this to a common place
var loan_URL = 'rest/loan';

mortgageApp.controller('loanCtrl', ['$scope', '$http', function ($scope, $http) {
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
	
	/* Create */
	$scope.addLoan = function(newLoan) {
		
        //TODO: Add validations here
		//if(!newLoan.user){ $scope.loanForm_add_error="Missing Date"; }
		//console.log(newLoan);
		
		newLoan.id = $scope.loan.length+1 ;		
        $scope.loan.push(newLoan);
        
		$scope.newnewLoan = {};
	}
	
	
	/* Delete */
	$scope.deleteLoan = function(index) {
		
        for(i=0; i < $scope.loan.length; i++) {
            
			if($scope.loan[i].id == index) {
                //console.log("for index :" + i + ": index from click :" + index);
				//console.log("Will be deleting loan" + $scope.loan[i].id + ":" + $scope.loan[i].type);                
				$("#_loan_" + index).remove();
                $scope.loan = $.grep($scope.loan, function(value) {
                    return value.id != index;
                });
                console.log("Loans Length :" + $scope.loan.length);
			}
		}		
	}	
}]);