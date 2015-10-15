angular.module("rango-vote").service("votingservice",function($http){
  this.getVotingStatus=function(){
    return $http({
      url:"../app/controller/getVotingStatus",
      method:"GET"
    })
  };
  this.listCandidatos=function(q){
    return $http({
      url:"../app/controller/listCandidatos?q="+q,
      method:"GET"
    });
  };
  this.vote=function(vote){
    return $http({
      url:"../app/controller/vote",
      data:JSON.stringify(vote),
      method:"POST"
    });
  };
  this.listResultadoVotacao=function(){
    return $http({
      url:"../app/controller/listResultadoVotacao",
      method:"GET"
    });
  };
});
