//'use strict';
// Declare app level module which depends on filters, and services

gemsApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/', {
      templateUrl: 'home.html', controller: 'expenseCtrl'
    }).
  when('/expense',{
      templateUrl: 'expense.html', controller: 'expenseCtrl'
    });
  
    $routeProvider.
        otherwise({redirectTo: '/'});
}]);