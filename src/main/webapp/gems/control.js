// JavaScript Document
var gemsApp = angular.module('gemsApp',['ngRoute']);

//TODO: Move this to a common place
var expense_URL = 'rest/expense';

var users= ["Fowmi","Mohammed","Ramesh","Rajesh","Suhail"];

gemsApp.controller('expenseCtrl', ['$scope', '$http', function ($scope, $http) {
    
    $scope.users = users; 
    $scope.expenseTypes= ["Travel", "Food", "Hotel", "Show-case", "Mobile", "Others"];
    
    $scope.countries= ["India", "China", "Shanghai"];
    $scope.city= ["Beijing", "Shanghai", "Guangzhou"];

    /* Read */
    //$scope.exp  = function getExpense() {
	    $http({
	    	  method: 'GET',
	    	  url: expense_URL
	    	}).then(function successCallback(response) {
	    		//console.log(response.data);
	    		if($scope.expenses == undefined){
	                $scope.expenses = response.data;
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
	    
	    
    
	$scope.expenseForm_add_error = "";
	
	/* Create */
	$scope.addExpense = function(newExpense) {
		
        //TODO: Add validations here
		//if(!newExpense.user){ $scope.expenseForm_add_error="Missing Date"; }
		//console.log(newExpense);
		
		$http({
	    	  method: 'POST',
	    	  url: expense_URL,
	    	  data: newExpense
	    	}).then(function successCallback(response) {
	    		//console.log("Response after insert" + response.data);
	    		if($scope.expenses == undefined){
	                $scope.expenses = response.data;
	            }
	            else {
	            	//console.log("have to push the data into the array" + response.data) ;
	            	$scope.expenses.push(response.data);
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
		
		
        //newExpense.id = $scope.expenses.length+1 ;		
        //$scope.expenses.push(newExpense);
        
		$scope.newExpense={};
	}
	
	
	/* Delete */
	$scope.deleteExpense = function(index) {
		
		alert("Deleting Expense : " +index);
		$http({
	    	  method: 'DELETE',
	    	  url: expense_URL + '/' +index
	    	  //data: {newExpense:''}
	    	}).then(function successCallback(response) {
	    		//console.log("Response after delete" + response.data);
	    		//console.log("Response" + response);
	    		if($scope.expenses == undefined){
	                //$scope.expenses = response.data;
	            }
	            else {
	            	//console.log("have to push the data into the array" + response.data) ;
	            	//$scope.expenses.push(response.data);
	            }
	    		
	    		//Remove from the UI Layer
	    		$("#_expense_" + index).remove();
	    		
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    	  });
		
        /*for(i=0; i < $scope.expenses.length; i++) {
            
			if($scope.expenses[i].id == index) {
                //console.log("for index :" + i + ": index from click :" + index);
				//console.log("Will be deleting expense" + $scope.expenses[i].id + ":" + $scope.expenses[i].type);                
				$("#_expense_" + index).remove();
                $scope.expenses = $.grep($scope.expenses, function(value) {
                    return value.id != index;
                });
                console.log("Expenses Length :" + $scope.expenses.length);
			}
		}*/		
	}
}]);

gemsApp.controller('reportCtrl', ['$scope', '$http', '$filter', function ($scope, $http, $filter) {
	$scope.users = users;
	
	/* Get Report Data */
    $scope.getReport = function (reportForm) {
    	$http({
    	  method: 'GET',
    	  url: 'rest/amountSpent?username=' + reportForm.username,
    	  data:	
    		  { username: reportForm.username }
    	}).then(function successCallback(response) {
    		//console.log(response.data);
    		console.log($scope.reportData + ":" + jQuery.isEmptyObject($scope.reportData));
    		if($scope.reportData == undefined || jQuery.isEmptyObject($scope.reportData)){
                $scope.reportData = response.data;
                renderDataToTable($scope.reportData)
                $scope.reportData = {};
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
    
    $scope.clearTable = function clearTable() {
    	$('#basicTable').remove();
    	creatingFlag = false;
    }
    
    var creatingFlag = false;
  //Render data to Table
	function renderDataToTable(data){
		
		
		//if the table was there, remove the same before adding a new one.
		if(creatingFlag) {
			$scope.clearTable();
		}
		
		var monthHeader = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
		var weekHeader = ["Week 1","Week 2","Week 3","Week 4","Week 5"];
		
		var row;
		var mytable = $('<table border="1" class="table table-striped" id="reportTable"></table>').attr({ id: "basicTable" });
		row = $('<tr></tr>').appendTo(mytable);
		$('<td></td>').html("").appendTo(row);
		$.each(weekHeader , function(){
			$('<td></td>').html("<B> <center>" + this +"</center></B>").appendTo(row);
		});
		
		row ="";
		
		var month = 0;
		var week = 0;
		
		var colCount = 0;
		var maxColCount = 6;
		$.each(data , function() {
			if(month != this.month){
				
				while(colCount != 0 && colCount < maxColCount){
					$('<td></td>').html("").appendTo(row);
					colCount +=1;
				}
				
				row = $('<tr></tr>').appendTo(mytable);
				$('<td></td>').html("<B> <center>" + monthHeader[this.month-1] +"</center></B>").appendTo(row);
				$('<td></td>').html("<center>" + ( $filter('currency')(this.amount, 'INR ', 2) ) +"</center>").appendTo(row);
				colCount = 2;
			}else{
				
				$('<td></td>').html("<center> " + ( $filter('currency')(this.amount, 'INR ', 2) ) + "</center>").appendTo(row);
				colCount += 1;
			}
			month = this.month;
		});
		
		while(colCount != 0 && colCount < maxColCount){
			$('<td></td>').html("").appendTo(row);
			colCount +=1;
		}
		
		creatingFlag = true;
		
		mytable.appendTo("#box");
	}
    
}]);

