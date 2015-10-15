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
});
