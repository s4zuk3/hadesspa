
hadesApp.run(['$rootScope','$location', 'authUser','toastr',  function($rootScope,$location,authUser,toastr) {
	    var rutasPrivadas = [
	    	'/',
	    	'/facturaform',
	    	'/clienteform'
	    ];
	    var rutaLogin = ['/login'];

	   	$rootScope.$on('$routeChangeStart', function(){
	   		
	   		if(($.inArray($location.path(), rutasPrivadas) != -1 && !authUser.isLoggedIn())  ){
	   		// Si intenta entrar a una ruta privada, se redirige a login.
	   			toastr.error('Debe iniciar sesión para poder continuar.','Mensaje');
	   			$location.path('/login');
	   		}else if(($.inArray($location.path(), rutaLogin) != -1 && authUser.isLoggedIn())  ){ 
	   		// Si intenta entrar a /login estando logeado, se redirige a home.
	   			$location.path('/');
	   		}
	   });


}]);