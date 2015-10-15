angular.module("rango-vote").config(function($routeProvider){
  $routeProvider.when("/t104-resultado",{
    templateUrl:"../views/t104-resultado.html",
    controller:function($scope,$timeout,votingservice){
      $scope.resultados = [];
      $scope.filtro={
        data:new Date(),
        grupo:"geral"
      };
      $timeout(function(){
        votingservice.getVotingStatus().then(function(ret){
          $scope.votingstatus=ret.data;
        }).catch(function(err){
          console.debug(err);
        });
        votingservice.listResultadoVotacao().then(function(ret){
          $scope.resultados=ret.data;
        }).catch(function(err){
          console.debug(err);
        });
      },500);
    }
  });
});
