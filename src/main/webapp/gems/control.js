// JavaScript Document
var gemsApp = angular.module('gemsApp',['ngRoute']);

//TODO: Move this to a common place
var expense_URL = 'rest/expense';

gemsApp.controller('expenseCtrl', ['$scope', '$http', function ($scope, $http, rtmFactory) {
    
    $scope.users= ["Fowmi","Mohammed","Ramesh","Rajesh","Suhail"];
    $scope.expenseTypes= ["Travel", "Food", "Hotel", "Show-case", "Mobile", "Others"];
    
    $scope.countries= ["India", "China", "Shanghai"];
    $scope.city= ["Beijing", "Shanghai", "Guangzhou"];

    /* Read */
	$http.get(expense_URL).success(function(data) {
            console.log($scope.expenses);
                if($scope.expenses == undefined){
                    $scope.expenses = data;
                }
                else{
                    //no need to do anything right now...as the data is temporarily stored in the javascript array
                }
		});
	$scope.expenseForm_add_error = "";
	
	/* Create */
	$scope.addExpense = function(newExpense) {
		
        //TODO: Add validations here
		//if(!newExpense.user){ $scope.expenseForm_add_error="Missing Date"; }
		//console.log(newExpense);
		
        newExpense.id = $scope.expenses.length+1 ;		
        $scope.expenses.push(newExpense);
        
		$scope.newExpense={};
	}
	
	
	/* Delete */
	$scope.deleteExpense = function(index) {
		
        for(i=0; i < $scope.expenses.length; i++) {
            
			if($scope.expenses[i].id == index) {
                //console.log("for index :" + i + ": index from click :" + index);
				//console.log("Will be deleting expense" + $scope.expenses[i].id + ":" + $scope.expenses[i].type);                
				$("#_expense_" + index).remove();
                $scope.expenses = $.grep($scope.expenses, function(value) {
                    return value.id != index;
                });
                console.log("Expenses Length :" + $scope.expenses.length);
			}
		}		
	}	
}]);