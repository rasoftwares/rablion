// JavaScript Document
var todoApp = angular.module('todoApp',['ngRoute']);

//TODO: Move this to a common place
var todo_URL = 'rest/todo';
var users= ["raj", "foemi", "karan"];

todoApp.controller('todoCtrl', ['$scope', '$http', function ($scope, $http) {
	$scope.users= ["raj", "foemi", "karan"];
	$scope.users= ["raj", "foemi", "karan"];
	$scope.users= ["raj", "foemi", "karan"];

	
	 /* Read */
   //$scope, $http, method, url, entityname, formEntity
	$scope.data = get($scope, $http, 'GET',todo_URL, 'todo', $scope.data);
	
	
	$scope.userForm_add_error = "";
	
	/* Create */
	//$scope, $http, method, entityName, EntityObject, url,  
	$scope.adduser = function(newTodo){
		add($scope, $http, 'POST', todo_URL, 'todo', newTodo); 
	};

    /* Read */


	    $http({
	    	  method: 'GET',
	    	  url: todo_URL
	    	}).then(function successCallback(response) {
	    		//console.log(response.data);
	    		if($scope.todo== undefined){
	                $scope.todo= response.data;
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
	    
	    
    
	$scope.todoForm_add_error = "";
	
	/* Create */
	/*$scope.addTodo = function(newTodo) {
		
        //TODO: Add validations here
		//if(!newExpense.user){ $scope.expenseForm_add_error="Missing Date"; }
		//console.log(newExpense);
		
		$http({
	    	  method: 'POST',
	    	  url: todo_URL,
	    	  data: newTodo
	    	}).then(function successCallback(response) {
	    		//console.log("Response after insert" + response.data);
	    		if($scope.todo == undefined){
	                $scope.todo = response.data;
	            }
	            else {
	            	//console.log("have to push the data into the array" + response.data) ;
	            	$scope.todo.push(response.data);
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
		
		$scope.newTodo={};
	}*/
	
	
	/* Delete */
/*	$scope.deleteExpense = function(index) {
		
		alert("Deleting Expense : " + index);
		
		$http({
	    	  method: 'DELETE',
	    	  url: expense_URL + '/' + index
	    	  //data: {newExpense:''}
	    	}).then(function successCallback(response) {
	    		alert("Deleted successfully ");
	    		//Remove from the UI Layer
	    		$("#_expense_" + index).remove();
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    		  alert("Problem deleting record " + index);
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
	}*/
}]);

