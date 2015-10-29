var apps = angular.module('apps', ['ngRoute']);

var a = [
         {
        	 "name" :"Gems",
        	 "page" : "gemsApp.html",
        	 "icon" : "images/diamond36.png",
        	 "description" : " Gems Application "
         },
         {
        	 "name" :"Mortgage",
        	 "page" : "mortgageApp.html",
        	 "icon" : "images/house256.png",
        	 "description" : " Mortgage  Application "
        		 
         },
         {
        	 "name" :"Admin",
        	 "page" : "adminApp.html",
        	 "icon" : "images/tools6.png",
        	 "description" : " Administration  Application "
        		 
         },
         {
        	 "name" :"Todo",
        	 "page" : "todoApp.html",
        	 "icon" : "images/checked20.png",
        	 "description" : " TODO Application "
        		 
         },
         
         {
        	 "name" :"Inventory",
        	 "page" : "inventoryApp.html",
        	 "icon" : "images/Inventory-maintenance-256.png",
        	 "description" : " INVENTORY Application "
        		 
         },
         ];

apps.controller('appsCtrl', ['$scope', '$http', function ($scope, $http) {
	$scope.appList = a;
}]);