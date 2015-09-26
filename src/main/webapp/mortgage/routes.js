//'use strict';
// Declare app level module which depends on filters, and services

var gemsBaseDir = 'mortgage';
var gemsTemplateDir = gemsBaseDir +'/templates';

mortgageApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/', {
      templateUrl: (gemsTemplateDir + '/home.html'), controller: 'loanCtrl'
    }).
  when('/loan',{
      templateUrl: (gemsTemplateDir + '/loan.html'), controller: 'loanCtrl'
    });
  
    $routeProvider.
        otherwise({redirectTo: '/'});
}]);