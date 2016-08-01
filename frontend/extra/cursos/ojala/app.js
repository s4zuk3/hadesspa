angular.module('ojalaApp', ['ngMaterial'])
.controller('AppCtrl', function($scope,$http) {
  $scope.imagePath = 'img/washedout.png';
  $scope.cursos = {};
  $http.get("ojala.json")
    .then(function(response) {
        $scope.cursos = response.data;
    });
});

