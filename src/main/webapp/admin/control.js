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
	
	/* Delete */
	/*$scope.deleteUser = function(index){
		
		alert("Deleting User : " + index);
		
		$http({
	    	  method: 'DELETE',
	    	  url: user_URL + '/' + index
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
	}


adminApp.controller('userCtrl', ['$scope', '$http', '$filter', function ($scope, $http, $filter) {
	$scope.users = users;
	}])
	/* Get Report Data */
  /*  $scope.getReport = function (reportForm) {
    	$http({
    	  method: 'GET',
    	  url: 'rest/amountSpent?username=' + reportForm.username,
    	  data:	
    		  { username: reportForm.username }
    	}).then(function successCallback(response) {
    		//console.log(response.data);
    		//console.log($scope.reportData + ":" + jQuery.isEmptyObject($scope.reportData));
    		if($scope.reportData == undefined || jQuery.isEmptyObject($scope.reportData)){
                $scope.reportData = response.data;
                renderDataToTable($scope.reportData)
                $scope.reportData = {};
            }
            else{
                //no need to do anything right now...as the data is temporarily stored in the javascript array
            }
    		
    		//TODO: Handle no data found error messages
    		var arr = _(response.data).toArray();
    		if(arr.length == 0){
    			$scope.reportForm_error = true;
    			$scope.reportForm_error_message = "No Expenses found for user " + reportForm.username;
    		}
    		else{
    			$scope.reportForm_error = false;
    			$scope.reportForm_error_message = "";
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
	function renderDataToTable(data) {
		
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
    
}]);*/

