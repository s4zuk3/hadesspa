angular.module('MyApp', ['ngMaterial'])
  .controller('AppCtrl', function($scope,$http) {

  $scope.cursos = {};
  $http.get("ojala.min.json")
    .then(function(response) {
        $scope.cursos = response.data;
    });
  });