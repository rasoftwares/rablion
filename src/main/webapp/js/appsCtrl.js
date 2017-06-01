var apps = angular.module('apps', ['ngRoute']);

var a = [
        {
        	 "name" :"Admin",
        	 "page" : "adminApp.html",
        	 "icon" : "images/tools6.png",
        	 "description" : " Administration  Application "
        		 
         },
         {
        	 "name" :"Reports",
        	 "page" : "reportApp.html",
        	 "icon" : "images/circular22.png",
        	 "description" : " Reports Application "
        		 
         },
         {
        	 "name" :"Payment",
        	 "page" : "paymentApp.html",
        	 "icon" : "images/payment.png",
        	 "description" : " Payment Application "
        		 
         },
         {
        	 "name" :"Inventory",
        	 "page" : "inventoryApp.html",
        	 "icon" : "images/inventory.png",
        	 "description" : " INVENTORY Application "
        		 
         },
        
         
         {
        	 "name" :"Discount",
        	 "page" : "discountApp.html",
        	 "icon" : "images/discount.png",
        	 "description" : " discount Application "
        		 
         },
        
         ];

apps.controller('appsCtrl', ['$scope', '$http', function ($scope, $http) {
	$scope.appList = a;
}]);