hadesApp.controller('FacturaFormController',function($scope,$location,Facturas_service,OT_service,Clientes_service){
	$scope.newFactura = {};
	$scope.clientes = {};
	Clientes_service.getAllClientes().then(function(response) {
        	$scope.clientes = response.data;
        });
	$scope.ots = {}; // prefiero validar las OT, pueden ser muchisimas. Después lo hago, por ahora confiar que se ingresará uno correcto.
	$scope.estados = ['ESTADO 0','ESTADO 1','ESTADO 2'];

	$scope.submit = function(newFactura){
		//Funciones de validaciones
		// Si hay algun error se cambian los scope.error y return;

		//Logica varia

		Facturas_service.createFactura(newFactura).then(function(response) {

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
		return;
	};
});