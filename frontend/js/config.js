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
	.otherwise({
		redirectTo: '/'
	});
}]);
