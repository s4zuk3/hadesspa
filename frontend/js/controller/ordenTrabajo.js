hadesApp.controller('OrdenesTrabajoController',function($scope,OT_service){

	/*	0 - Listo
		1 - haciendo
		2 - pendiente
	*/

	$scope.buscarTodosBool = false;
	$scope.buscarUnoBool = false;
	$scope.estados = ["Listo","Haciendo","Pendiente"];

	$scope.buscarUno = function(OT){
		OT_service.getOT(OT).then(function(response) {
			$scope.buscarTodosBool = false;
			$scope.buscarUnoBool = true;
			$scope.ordenesTrabajo = response.data;
         });
	};

	$scope.buscarTodos = function(){
		OT_service.getAllOT().then(function(response) {
			$scope.buscarTodosBool = true;
			$scope.buscarUnoBool = false;
			$scope.ordenesTrabajo = response.data;
         });
	};

	$scope.buscarTodosPorCotizacion = function(idCotizacion){
		OT_service.getAllOTPorIdCotizacion(idCotizacion).then(function(response) {
			$scope.buscarTodosBool = true;
			$scope.buscarUnoBool = false;
			$scope.ordenesTrabajo = response.data;
         });
	};

	$scope.buscarTodosPorFecha = function(fecha){
		OT_service.getAllOTPorFecha(fecha.toISOString().slice(0,10)).then(function(response) {
			$scope.buscarTodosBool = true;
			$scope.buscarUnoBool = false;
			$scope.ordenesTrabajo = response.data;
         });
	};

});
