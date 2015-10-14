angular.module("rango-vote").service("memberservice",function($http){
  // recuperar usuário logado
  this.getCurrentMember=function(){
    return $http({
      url:"../app/controller/getCurrentMember",
      method:"GET",
    });
  };
});
