hadesApp.controller('CrearOrdenTrabajoController',function($scope,OT_service){
	
	// estado ot
	/*	0 - Listo
		1 - haciendo
		2 - pendiente
	*/
	
	
	$scope.newOT = {
		estado: 2,
		fecha: new Date()
	};
	
	$scope.submit = function(newOT){
		OT_service.createOT(newOT).then(function(response) {

			if(response.status == 200) // creacion OK
			{
				 alert("Creación correcta. Status code 200");
			}
			else if(response.status == 403) // ya existe ID
			{
				 alert(response.data.mensaje+". Status code 403");
			}
			else
			{
				$scope.newFactura = JSON.stringify(response);
				alert("Algun error raro sucedió. Status code "+response.status);
			}

         });
	};
});