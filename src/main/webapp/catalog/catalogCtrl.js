var catalog = angular.module('catalogApp', ['ngRoute']);

var a = [
         {
        	 "name" :"HalfSaree",
        	 "image" : "catalog/images/1.jpg",
			 "price" :"1750",
			 "discount":"$ 500",
        	 "description" : " cotton"
         },
         {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/2.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton"
        		 
         },
         {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/3.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/4.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/2.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton"
        		 
         },
		 {
        	 "name" :"Halfsaree",
             "image" : "catalog/images/5.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : "cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/4.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton"
        		 
         },
         {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/2.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : "cotton "
		},
		{
        	 "name" :"HalfSaree",
        	 "image" : "catalog/images/1.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton"
         },
         {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/2.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton"
        		 
         },
         {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/3.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/1.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/2.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
             "image" : "catalog/images/5.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/2.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/3.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/4.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/1.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/2.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/3.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
         {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/4.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
         {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/1.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
         {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/2.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         },
		 
		 {
        	 "name" :"Halfsaree",
        	 "image" : "catalog/images/4.jpg",
			 "price" :"1750",
			 "discount":"500",
        	 "description" : " cotton "
        		 
         }
         ];

catalog.controller('catalogCtrl', ['$scope', '$http', function ($scope, $http) {
	$scope.productList = a;
}]);