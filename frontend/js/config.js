hadesApp.config(['$routeProvider','$authProvider', function($routeProvider,$authProvider) {
	$authProvider.loginUrl = URL_API + '/auth/login';
	$routeProvider
	.when('/', {
		templateUrl: 'views/home.html',
		controller: 'HomeController'})
	.when('/facturaform', {
		templateUrl: 'views/facturaForm.html',
		controller: 'FacturaFormController'})
	.when('/clienteform', {
		templateUrl: 'views/clienteForm.html',
		controller: 'ClienteFormController'})
	.when('/login', {
		templateUrl: 'views/login.html',
		controller: 'LoginController'})
	.when('/crearordentrabajo', {
		templateUrl: 'views/crearOrdenTrabajo.html',
		controller: 'CrearOrdenTrabajoController'})
	.when('/ordenestrabajo', {
		templateUrl: 'views/ordenesTrabajo.html',
		controller: 'OrdenesTrabajoController'})
	.otherwise({
		redirectTo: '/'
	});
}]);
