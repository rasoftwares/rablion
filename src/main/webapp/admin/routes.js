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
        });
        }]);