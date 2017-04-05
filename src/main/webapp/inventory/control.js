// JavaScript Document
var inventoryApp = angular.module('inventoryApp',['ngRoute']);





//TODO: Move this to a common place
var inventory_URL = 'rest/inventory';
var users = ["Fowmi","Mohammed","Ramesh","Rajesh","Suhail"];



inventoryApp.controller('inventoryCtrl', ['$scope','$http','$filter',function ($scope, $http,filteredListService,$filter) {
	$scope.alertlimit= ["3", "5", "10", "20", "50", "70"];
	$scope.currentPage = 0;
	$scope.itemsPerPage = 5;
	
	$scope.onLoad = function (e, reader, file, fileList, fileOjects, fileObj) {
		  alert('this is handler for file reader onload event!');
		};

	   
	 /* Read */
    //$scope, $http, method, url, entityname, formEntity
	//$scope.data = get($scope, $http, 'GET', inventory_URL, 'inventory', $scope.data);
	
	
	//$scope.inventoryForm_add_error = "";
	
	/* Create */
	//$scope, $http, method, entityName, EntityObject, url,  
	//$scope.addInventory = function(newInventory){
		//add($scope, $http, 'POST', inventory_URL, 'inventory', newInventory); 
	//};

 $http({
	      method: 'GET',
	    	  url: inventory_URL
	    	}).then(function successCallback(response) {
	    		    				
	    		//console.log(response.data);
	    		if($scope.data== undefined){
	                $scope.data = response.data;
	                for (var i = 0; i < $scope.data.length; i++) {
	    	            if (i % $scope.itemsPerPage === 0) {
	    	                $scope.data[Math.floor(i / $scope.itemsPerPage)] = [ $scope.data[i] ];
	    	            } else {
	    	                $scope.data[Math.floor(i / $scope.itemsPerPage)].push($scope.data[i]);
	    	            }
	    	        }
	                $scope.range = function (start, end) {
	    		        var ret = [];
	    		        if (!end) {
	    		            end = start;
	    		            start = 0;
	    		        }
	    		        for (var i = start; i < end/5; i++) {
	    		            ret.push(i);
	    		        }
	    		        return ret;
	    		    };
	    		    
	    		    $scope.prevPage = function () {
	    		        if ($scope.currentPage > 0) {
	    		            $scope.currentPage--;
	    		        }
	    		    };
	    		    
	    		    $scope.nextPage = function () {
	    		        if ($scope.currentPage < $scope.data.length/5 - 1) {
	    		            $scope.currentPage++;
	    		        }
	    		    };
	    		    
	    		    $scope.setPage = function () {
	    		        $scope.currentPage = this.n;
	    		    }

                 	            }
	            else{
	                //no need to do anything right now...as the data is temporarily stored in the javascript array
	            }
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	          });	


	$scope.dataForm_add_error = "";
	
	/* Create */
	$scope.addInventory = function(newInventory){
		
		
        //TODO: Add validations here1
		//if(!newExpense.user){ $scope.expenseForm_add_error="Missing Date"; }
		//console.log(newExpense);
		
$http({
	    	  method: 'POST',
	    	  url: inventory_URL,
	    	  data: newInventory
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
		
		$scope.newInventory={};
	    
	};
	
	/*	delete */
		 $scope.deleteInventory= function(index) {
			remove($scope, $http, 'DELETE', inventory_URL, 'inventory', index); 
		};
		
			
	}]);



/*image Upload*/

function readFile() {
	 var filesSelected = document.getElementById("inputFileToLoad").files;
	    if (filesSelected.length > 0) {
	      var fileToLoad = filesSelected[0];

	      var fileReader = new FileReader();

	      fileReader.onload = function(fileLoadedEvent) {
	        var srcData = fileLoadedEvent.target.result; // <--- data: base64
	        var textbox = document.getElementById('fill');
	       // var newImage = document.createElement('img');
	        //newImage.src = srcData;
	       
	        document.getElementById("fill").value =srcData ;
	        //alert("Converted Base64 version is " + document.getElementById("imgTest").innerHTML);
	        //console.log("Converted Base64 version is " + document.getElementById("imgTest").innerHTML);
	      }
	      fileReader.readAsDataURL(fileToLoad);
	    }
	  
	}

	/*
		    if (files && file) {
		        var reader = new FileReader();

		        reader.onload = function(readerEvt) {
		            var binaryString = readerEvt.target.result;
		            document.getElementById("base64textarea").value = btoa(binaryString);
		        };

		        reader.readAsBinaryString(file);
		    }
		};

		if (window.File && window.FileReader && window.FileList && window.Blob) {
		    document.getElementById('filePicker').addEventListener('change', handleFileSelect, false);
		} ;
		
				
	


    /* //the image
		    you need this function to convert the dataURI
 function dataURItoBlob(dataURI) {
    var binary = atob(dataURI.split(',')[1]);
    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];
    var array = [];
    for (var i = 0; i < binary.length; i++) {
      array.push(binary.charCodeAt(i));
    }
    return new Blob([new Uint8Array(array)], {
      type: mimeString
    });
  }*/

// directive
/*   inventoryApp.directive("fileread", [
  function() {
  return {
    scope: {
      fileread: "="
    },
    link: function(scope, element, attributes) {
      element.bind("change", function(changeEvent) {
        var reader = new FileReader();
        reader.onload = function(loadEvent) {
          scope.$apply(function() {
            scope.fileread = loadEvent.target.result;
          });
        };
        reader.readAsDataURL(changeEvent.target.files[0]);
      });
    }
  }
}
]);*/
