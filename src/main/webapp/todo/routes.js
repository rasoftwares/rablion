//'use strict';
// Declare app level module which depends on filters, and services

var todoBaseDir = 'todo';
var todoTemplateDir = todoBaseDir +'/templates';

todoApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/', {
      templateUrl: (todoTemplateDir + '/home.html'), controller: 'todoCtrl'
    }).
  when('/todo',{
      templateUrl: (todoTemplateDir + '/todo.html'), controller: 'todoCtrl'
    }).
    when('/report',{
        templateUrl: (todoTemplateDir + '/report.html'), controller: 'todoCtrl'
      })
  
    }]);