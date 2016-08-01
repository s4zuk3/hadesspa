angular.module('MyApp', ['ngMaterial','ngAnimate', 'ui.bootstrap'])
  .controller('AppCtrl', function($scope,$http) {

  $scope.cursos = {};
  $http.get("ojala.min.json")
    .then(function(response) {
        $scope.cursos = response.data;
    });

  });