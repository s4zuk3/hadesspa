hadesApp.controller('OrdenesTrabajoController',function($scope,OT_service){
	
	$scope.buscarTodosBool = false;
	$scope.buscarUnoBool = false;
	
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
	
});