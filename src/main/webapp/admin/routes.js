//'use strict';
// Declare app level module which depends on filters, and services

var adminBaseDir = 'admin';
var adminTemplateDir = adminBaseDir +'/templates';

adminApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
  when('/', {
      templateUrl: (adminTemplateDir + '/home.html'), controller: 'userCtrl'
    }).
       when('/user',{
          templateUrl: (adminTemplateDir + '/user.html'), controller: 'userCtrl'
        }).
  
     when('/currency',{
      templateUrl: (adminTemplateDir + '/currency.html'), controller: 'currencyCtrl'
     }).
     
     when('/payment',{
         templateUrl: (adminTemplateDir + '/payment.html'), controller: 'paymentCtrl'
     }).
        
     when('/discount',{
            templateUrl: (adminTemplateDir + '/discount.html'), controller: 'discountCtrl'
     }).
             
     when('/customer',{
      templateUrl: (adminTemplateDir + '/customer.html'), controller: 'customerCtrl'
    });
  
  
        }]);