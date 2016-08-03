hadesApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl: 'views/home.html',
		controller: 'HomeController'})
	.when('/facturaform', {
		templateUrl: 'views/FacturaForm.html',
		controller: 'FacturaFormController'})
	.otherwise({
		redirectTo: '/'
	});
}]);
