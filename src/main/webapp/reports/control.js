var reportsApp = angular.module('reportsApp',['ngRoute']);

var reports_URL = 'rest/inventory';

reportsApp.controller('invenroyReportCtrl', ['$scope', '$http', function ($scope, $http) {



	$(document).ready(function() {

		/**
		 * call the data.php file to fetch the result from db table.
		 */
		$.ajax({
			url :reports_URL ,
			type : "GET",
			success : function(data){
				console.log(data);
				var type = [];
				var quantity = [];

				for(var i in data) {
				type.push(data[i].type);
					quantity.push(data[i].quantity);
				}


				var ctx = $("#pie-chartcanvas-1");
				var ctx1 = $("#doughnut-chartcanvas-1");
				var data = {
					labels : type,
					datasets : [
						{
							label : "Stock Available",
							data : quantity,
							backgroundColor : [
			                    "#DEB887",
			                    "#A9A9A9",
			                    "#DC143C",
			                    "#F4A460",
			                    "#2E8B57"
			                ],
			                borderColor : [
			                    "#CDA776",
			                    "#989898",
			                    "#CB252B",
			                    "#E39371",
			                    "#1D7A46"
			                ],
			                borderWidth : [1, 1, 1, 1, 1]
						}
					]
				};



				var options = {
					title : {
						display : true,
						position : "top",
						text : "Pie Chart",
						fontSize : 18 ,
						fontColor : "#111"
					},
					legend : {
						display : true,
						position : "bottom"
					}
				};

				var chart = new Chart( ctx, {
					type : "pie",
					data : data,
					options : options
				});
				
				var chart = new Chart( ctx1, {
					type : "doughnut",
					data : data,
					options : options
				});

			},
			error : function(data) {
				console.log(data);
			}
		});

	});



}]);
	
	
var reports_URL = 'rest/inventory';

reportsApp.controller('paymentReportCtrl', ['$scope', '$http', function ($scope, $http) {
	
}]);




