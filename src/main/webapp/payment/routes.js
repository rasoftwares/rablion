//'use strict';
// Declare app level module which depends on filters, and services

var paymentBaseDir = 'payment';
var paymentTemplateDir = paymentBaseDir +'/templates';

paymentApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/', {
      templateUrl: (paymentTemplateDir + '/home.html'), controller: 'paymentCtrl'
    }).
  when('/payment',{
      templateUrl: (paymentTemplateDir + '/payment.html'), controller: 'paymentCtrl'
    });
    
}]);