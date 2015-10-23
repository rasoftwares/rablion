//'use strict';
// Declare app level module which depends on filters, and services

var gemsBaseDir = 'gems';
var gemsTemplateDir = gemsBaseDir +'/templates';

gemsApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/', {
      templateUrl: (gemsTemplateDir + '/home.html'), controller: 'expenseCtrl'
    }).
  when('/expense',{
      templateUrl: (gemsTemplateDir + '/expense.html'), controller: 'expenseCtrl'
    }).
    when('/report',{
        templateUrl: (gemsTemplateDir + '/report.html'), controller: 'reportCtrl'
   
      });
  
   
}]);