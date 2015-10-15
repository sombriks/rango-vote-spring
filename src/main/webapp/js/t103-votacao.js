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

      $timeout(list,500);
      $timeout(function(){
        memberservice.getCurrentMember().then(function(ret){
          $scope.membro=ret.data;
        }).catch(function(err){
          console.debug(err);
        });
      },500)

      $scope.votaRestaurante=function(restaurante){
        if($scope.membro){
          if(confirm("Confirma voto no restaurante ["+restaurante.nomeRestaurante+"] ?")){
            votingservice.vote({
              restaurante:restaurante,
              membro:$scope.membro,
            }).then(function(ret){
              
            }).catch(function(err){
              alert("Problema ao votar. Você já votou hoje?");
              console.debug(err);
            });
          }
        }
      }
    }
  });
});
