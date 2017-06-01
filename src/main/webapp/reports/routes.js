var reportsBaseDir = 'reports';
var reportsTemplateDir = reportsBaseDir +'/templates';

reportsApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
  when('/', {
      templateUrl: (reportsTemplateDir + '/home.html'), controller: 'invenroyReportCtrl'
    }).
       when('/inventoryReport',{
          templateUrl: (reportsTemplateDir + '/inventoryReport.html'), controller: 'invenroyReportCtrl'
        }).
  
     when('/paymentReport',{
      templateUrl: (reportsTemplateDir + '/paymentReport.html'), controller: 'paymentReportCtrl'
    
    });
    
        }]);