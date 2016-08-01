angular.module('ojalaApp', ['ngMaterial'])
.controller('AppCtrl', function($scope,$http) {

  $scope.cursos = {};
  $http.get("ojala.min.json")
    .then(function(response) {
        $scope.cursos = response.data;
    });
});



angular.module('ojalaApp2', ['ngMaterial'])
  .controller('AppCtrl', function($scope) {
    $scope.cursos = [{
      "title":"asdf",
      "category":"IOS",
      "img":"/images/covers/excel-datesmedio.jpg"
    },
     {
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },
                    {
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    },{
      "title":"asdf",
      "category":"IOS22",
      "img":"/images/covers/excel-datesmedio.jpg"
    }]
  });