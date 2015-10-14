angular.module("rango-vote").config(function($routeProvider){
  $routeProvider.when("/t104-resultado",{
    templateUrl:"../views/t104-resultado.html",
    controller:function($scope,$timeout){
      $scope.resultados = [];
      $scope.filtro={
        data:new Date(),
        grupo:"geral"
      };
    }
  });
});
