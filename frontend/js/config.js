hadesApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl: 'views/home.html',
		controller: 'HomeController'})
	.when('/', {
		templateUrl: 'views/FacturaFormController.html',
		controller: 'FacturaFormController'})
	.otherwise({
		redirectTo: '/'
	});
}]);
