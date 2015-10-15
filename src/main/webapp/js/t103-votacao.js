angular.module("rango-vote").config(function($routeProvider){
  $routeProvider.when("/t103-votacao",{
    templateUrl:"../views/t103-votacao.html",
    controller:function($scope,$timeout,votingservice){

      $scope.filtro={
        nomerest:""
      };

      function list(){
        votingservice.listCandidatos($scope.filtro.nomerest).then(function(ret){
          $scope.restaurantes=ret.data;
        }).catch(function(err){
          console.debug(err);
        });
      }

      $timeout(list,500);
      $scope.filtrarest=function(){
        list();
      };
      $scope.restaurantes=[];
    }
  });
});
