hadesApp.factory('sessionControl', function(){
	return {
		get: function(key){
			return sessionStorage.getItem(key);
		},
		set: function(key, val){
			return sessionStorage.setItem(key,val);
		},
		unset: function(key){
			return sessionStorage.removeItem(key);
		}
	};
});

hadesApp.factory('authUser', function($auth, sessionControl,toastr, $location){
	var cacheSession = function(idUsuario,nombreUsuario, cargo){
		
		sessionControl.set('idUsuario',idUsuario);
		sessionControl.set('nombreUsuario',nombreUsuario);
		sessionControl.set('cargo',cargo);
	};

	var unCacheSession = function(){
		sessionControl.unset('idUsuario');
		sessionControl.unset('nombreUsuario');
		sessionControl.unset('cargo');
	};

	var login = function(loginForm){
		$auth.login(loginForm).then(
			function(response){
				var payload = $auth.getPayload();
				cacheSession(payload.idUsuario,payload.nombreUsuario,payload.cargo);
				$location.path('/');
				toastr.success('Sesión iniciada con éxito.','Mensaje');
			},
			function(error){
				unCacheSession();
				toastr.error(error.data.mensaje, 'Error');
				//console.log(error);
			}

		);
	};
	var isLogged = function(){
		if($auth.isAuthenticated() && sessionControl.get('idUsuario') != null){
			return true;
		}
		else{
			$auth.logout();
			return false;
		}
	};
	return {
		loginApi: function(loginForm){
			login(loginForm);
		},
		isLoggedIn: function(){
			return isLogged();
		},
		logout: function(){
			$auth.logout();
			unCacheSession();
			toastr.success('Sesión cerrada con éxito.','Mensaje');
			$location.path('/login');			
		}
	}
});