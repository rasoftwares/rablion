//'use strict';
// Declare app level module which depends on filters, and services

var mortgageBaseDir = 'mortgage';
var mortgageTemplateDir = mortgageBaseDir +'/templates';

mortgageApp.config(['$routeProvider', function($routeProvider){
  $routeProvider.
    when('/', {
      templateUrl: (mortgageTemplateDir + '/home.html'), controller: 'mortgageCtrl'
    }).
  when('/loan',{
      templateUrl: (mortgageTemplateDir + '/loan.html'), controller: 'mortgageCtrl'
    });
  
    //$routeProvider.otherwise({redirectTo: '/'});
}]);