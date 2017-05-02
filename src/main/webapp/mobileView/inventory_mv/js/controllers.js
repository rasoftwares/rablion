angular.module('app.controllers', [])

  
.controller('menuCtrl', function($scope,$http,sharedCartService,sharedFilterService) {

	//put cart after menu
	var cart = sharedCartService.cart;
	
	//loads the menu----onload event
	$scope.$on('$stateChangeSuccess', function () {
	str=sharedFilterService.getUrl();
	console.log("http://localhost:9095/rest/inventory");
	$http.get("http://localhost:9095/rest/inventory").success(function (response){$scope.menu_items = response;});	
	console.log('MenuCtrl',sessionStorage.getItem('loggedin_id'));		
	});

	 //show product page
	$scope.showProductInfo=function (id,itemtype,img,itemname,purchaseprice,discountpercentage) {	 
		 sessionStorage.setItem('product_info_id', id);
		 sessionStorage.setItem('product_info_itemtype', itemtype);
		 sessionStorage.setItem('product_info_img', img);
		 sessionStorage.setItem('product_info_itemname', itemname);
		 sessionStorage.setItem('product_info_purchaseprice', purchaseprice);
		 sessionStorage.setItem('product_info_discountpercentage', discountpercentage);
		 window.location.href = "#/page13";
	 };

	 //add to cart function
	 $scope.addToCart=function(id,image,itemname,purchaseprice,discountpercentage){    
		cart.add(id,image,itemname,purchaseprice,discountpercentage,1);	
	 };	 
})
   
.controller('cartCtrl', function($scope,sharedCartService,$ionicPopup,$state) {
		
		//onload event-- to set the values
		$scope.$on('$stateChangeSuccess', function () {
			$scope.cart=sharedCartService.cart;
			$scope.total_qty=sharedCartService.total_qty;
			$scope.total_amount=sharedCartService.total_amount;		
		});
		
		//remove function
		
	
		$scope.removeFromCart=function(c_id){
			$scope.cart.drop(c_id);	
			$scope.total_qty=sharedCartService.total_qty;
			$scope.total_amount=sharedCartService.total_amount;
			
		};
		
		$scope.inc=function(c_id){
			$scope.cart.increment(c_id);
			$scope.total_qty=sharedCartService.total_qty;
			$scope.total_amount=sharedCartService.total_amount;
		};
		
		$scope.dec=function(c_id){
			$scope.cart.decrement(c_id);
			$scope.total_qty=sharedCartService.total_qty;
			$scope.total_amount=sharedCartService.total_amount;
		};
		
		$scope.checkout=function(){
			if($scope.total_amount>0){
				$state.go('checkOut');
			}
			else{
				var alertPopup = $ionicPopup.alert({
					title: 'No item in your Cart',
					template: 'Please add Some Items!'
				});
			}
		};

})
   
.controller('checkOutCtrl', function($scope) {
	$scope.loggedin=function(){
		if(sessionStorage.getItem('loggedin_id')==null){return 1;}
		else{
			$scope.loggedin_name= sessionStorage.getItem('loggedin_name');
			$scope.loggedin_id= sessionStorage.getItem('loggedin_id');
			$scope.loggedin_phone= sessionStorage.getItem('loggedin_phone');
			$scope.loggedin_address= sessionStorage.getItem('loggedin_address');
			$scope.loggedin_pincode= sessionStorage.getItem('loggedin_pincode');
			return 0;
		}
	};
	
	

})

.controller('indexCtrl', function($scope,sharedCartService) {
	//$scope.total = 10; 
})
   
.controller('loginCtrl', function($scope,$http,$ionicPopup,$state,$ionicHistory) {
		$scope.user = {};
		
		$scope.login = function() {
			str="http://www.mywebsite.com/foodcart/server_side/user-details.php?e="+$scope.user.email+"&p="+$scope.user.password;
			$http.get(str)
			.success(function (response){
				$scope.user_details = response.records;
				sessionStorage.setItem('loggedin_name', $scope.user_details.u_name);
				sessionStorage.setItem('loggedin_id', $scope.user_details.u_id );
				sessionStorage.setItem('loggedin_phone', $scope.user_details.u_phone);
				sessionStorage.setItem('loggedin_address', $scope.user_details.u_address);
				sessionStorage.setItem('loggedin_pincode', $scope.user_details.u_pincode);
				
				$ionicHistory.nextViewOptions({
					disableAnimate: true,
					disableBack: true
				});
				lastView = $ionicHistory.backView();
				console.log('Last View',lastView);
				if(lastView.stateId=="checkOut"){ $state.go('checkOut', {}, {location: "replace", reload: true}); }
				else{$state.go('profile', {}, {location: "replace", reload: true});}
				
			}).error(function() {
					var alertPopup = $ionicPopup.alert({
						title: 'Login failed!',
						template: 'Please check your credentials!'
					});
			});
		};
		
})
   
.controller('signupCtrl', function($scope,$http,$ionicPopup,$state,$ionicHistory) {

	$scope.signup=function(data){
			
			var link = 'http://www.mywebsite.com/foodcart/server_side/signup.php';
			$http.post(link, {n : data.name, un : data.username, ps : data.password , ph: data.phone , add : data.address , pin : data.pincode })
			.then(function (res){	
				$scope.response = res.data.result; 
				

				
				if($scope.response.created=="1"){
					$scope.title="Account Created!";
					$scope.template="Your account has been successfully created!";
					
					//no back option
					$ionicHistory.nextViewOptions({
						disableAnimate: true,
						disableBack: true
					});
					$state.go('login', {}, {location: "replace", reload: true});
				
				}else if($scope.response.exists=="1"){
					$scope.title="Email Already exists";
					$scope.template="Please click forgot password if necessary";
				
				}else{
					$scope.title="Failed";
					$scope.template="Contact Our Technical Team";
				}
				
				var alertPopup = $ionicPopup.alert({
						title: $scope.title,
						template: $scope.template
				});
				
				
			});
			
	}
})
   
.controller('filterByCtrl', function($scope,sharedFilterService) {

  $scope.Categories = [
    {id: 1, name: 'software'},
    {id: 2, name: 'hardware'}
  ];
  
  $scope.getCategory = function(cat_list){
    categoryAdded = cat_list;
	var c_string=""; // will hold the category as string
	
	for(var i=0;i<categoryAdded.length;i++){ c_string+=(categoryAdded[i].id+"||"); }
	
	c_string = c_string.substr(0, c_string.length-2);
	sharedFilterService.category=c_string;
	window.location.href = "#/page1";
  };
	

})
   
.controller('sortByCtrl', function($scope,sharedFilterService) {
	$scope.sort=function(sort_by){
		sharedFilterService.sort=sort_by;
		console.log('sort',sort_by);		
		window.location.href = "#/page1";
	};
})
   
.controller('paymentCtrl', function($scope) {

})
   
.controller('profileCtrl', function($scope,$rootScope,$ionicHistory,$state) {

		$scope.loggedin_name= sessionStorage.getItem('loggedin_name');
		$scope.loggedin_id= sessionStorage.getItem('loggedin_id');
		$scope.loggedin_phone= sessionStorage.getItem('loggedin_phone');
		$scope.loggedin_address= sessionStorage.getItem('loggedin_address');
		$scope.loggedin_pincode= sessionStorage.getItem('loggedin_pincode');
		
		
		$scope.logout=function(){
				delete sessionStorage.loggedin_name;
				delete sessionStorage.loggedin_id;
				delete sessionStorage.loggedin_phone;
				delete sessionStorage.loggedin_address;
				delete sessionStorage.loggedin_pincode;
				
				console.log('Logoutctrl',sessionStorage.getItem('loggedin_id'));
				
				$ionicHistory.nextViewOptions({
					disableAnimate: true,
					disableBack: true
				});
				$state.go('menu', {}, {location: "replace", reload: true});
		};
})
   
.controller('myOrdersCtrl', function($scope) {

})
   
.controller('editProfileCtrl', function($scope) {

})
   
.controller('favoratesCtrl', function($scope) {

})
   
.controller('productPageCtrl', function($scope) {

	//onload event
	angular.element(document).ready(function () {
		$scope.id= sessionStorage.getItem('product_info_id');
		$scope.itemtype= sessionStorage.getItem('product_info_itemtype');
		$scope.img= "img/"+ sessionStorage.getItem('product_info_img')+".jpg";
		$scope.itemname= sessionStorage.getItem('product_info_itemname');
		$scope.purchaseprice= sessionStorage.getItem('product_info_purchaseprice');
		$scope.discountpercentage= sessionStorage.getItem('product_info_discountpercentage');
	});


})
 