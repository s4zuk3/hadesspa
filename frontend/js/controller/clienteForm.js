hadesApp.controller('ClienteFormController',function($scope,$location,Clientes_service){
	$scope.newCliente = {};
	
	$scope.submit = function(newCliente){
		//Funciones de validaciones
		// Si hay algun error se cambian los scope.error y return;

		//Logica varia

		Clientes_service.createCliente(newCliente).then(function(response) {

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
				alert("Algun error raro sucedió. Status code "+response.status);
			}

         });
		return;
	};
});