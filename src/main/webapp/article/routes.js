//'use strict';
// Declare app level module which depends on filters, and services

var articleBaseDir = 'article';
var articleTemplateDir = articleBaseDir +'/templates';

articleApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/', {
      templateUrl: (articleTemplateDir + '/home.html'), controller: 'articleCtrl'
    }).
  when('/article',{
      templateUrl: (articleTemplateDir + '/article.html'), controller: 'articleCtrl'
    });
    
}]);