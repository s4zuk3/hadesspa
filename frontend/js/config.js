hadesApp.config(['$routeProvider', function($routeProvider) {
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
	.otherwise({
		redirectTo: '/'
	});
}]);
