hadesApp.controller('FacturaFormController',function($scope,$location,Facturas_service){
	$scope.error_text = '';
	$scope.error = false;
	$scope.newFactura = {}
	$scope.submit = function(){
		//Funciones de validaciones
		// Si hay algun error se cambian los scope.error y return;

		//Logica varia

		Facturas_service.createFactura($scope.newFactura)
		.then(function(response) {
        	$location.path("/"); // redireccionar a algun lado?
        });
	};
});