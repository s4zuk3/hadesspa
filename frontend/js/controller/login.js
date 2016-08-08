hadesApp.controller('LoginController',function($scope,authUser){
	$scope.loginForm = {
		idUsuario: 0,
		contrasena: ''
	};
	$scope.login = function(){
		authUser.loginApi($scope.loginForm);
	};
});