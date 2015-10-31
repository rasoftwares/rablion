//'use strict';
// Declare app level module which depends on filters, and services

var inventoryBaseDir = 'inventory';
var inventoryTemplateDir = inventoryBaseDir +'/templates';

inventoryApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/', {
      templateUrl: (inventoryTemplateDir + '/home.html'), controller: 'inventoryCtrl'
    }).
  when('/inventory',{
      templateUrl: (inventoryTemplateDir + '/inventory.html'), controller: 'inventoryCtrl'
    });
    
}]);