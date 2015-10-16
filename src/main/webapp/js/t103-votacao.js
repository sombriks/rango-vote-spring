angular.module("rango-vote").config(function($routeProvider){
  $routeProvider.when("/t103-votacao",{
    templateUrl:"../views/t103-votacao.html",
    controller:function($scope,$timeout,votingservice,memberservice){

      $scope.restaurantes=[];
      $scope.filtro={
        nomerest:""
      };

      $scope.filtrarest=function(){
        list();
      };

      function list(){
        votingservice.listCandidatos($scope.filtro.nomerest).then(function(ret){
          $scope.restaurantes=ret.data;
        }).catch(function(err){
          console.debug(err);
        });
      }

      $timeout(function(){
        votingservice.getVotingStatus().then(function(ret){
          $scope.votingstatus=ret.data;
          $scope.membro = $scope.votingstatus.membro;
        }).catch(function(err){
          console.debug(err);
        });
        list();
      },500)

      $scope.votaRestaurante=function(restaurante){
        if($scope.membro){
          if(confirm("Confirma voto no restaurante ["+restaurante.nomeRestaurante+"] ?")){
            votingservice.vote({
              restaurante:restaurante,
              membro:$scope.membro,
            }).then(function(ret){
              window.loaction.reload();
            }).catch(function(err){
              if("voteclosed" == err.data)
                alert("A votação não está aberta no momento.");
              else
                alert("Problema ao votar. Você já votou hoje?");
              console.debug(err);
            });
          }
        }
      }
    }
  });
});
