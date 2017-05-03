//'use strict';
// Declare app level module which depends on filters, and services

var discountBaseDir = 'discount';
var discountTemplateDir = discountBaseDir +'/templates';

discountApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/', {
      templateUrl: (discountTemplateDir + '/home.html'), controller: 'discountCtrl'
    }).
  when('/discount',{
      templateUrl: (discountTemplateDir + '/discount.html'), controller: 'discountCtrl'
    });
    
}]);