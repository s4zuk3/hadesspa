hadesApp.controller('HomeController',function($scope,$location,authUser,sessionControl){
	$scope.user = {
		nombre: sessionControl.get('nombreUsuario'),
		cargo: sessionControl.get('cargo'),
		id: sessionControl.get('idUsuario')
	}

	$scope.logout = function(){
		authUser.logout();
	};
	$scope.isAuth = function(){ // funcion para ver si esta logeado, sirve para los ng-if en el template.
		authUser.isLoggedIn();
	};
});