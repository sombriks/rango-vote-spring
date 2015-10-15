//
angular.module("rango-vote")//
  .controller("t102",function($scope,$timeout,memberservice){

    $timeout(function(){
      memberservice.getCurrentMember().then(function(ret){
        $scope.membro=ret.data;
      }).catch(function(err){
        console.debug(err);
      });
    },500);

    $scope.logout=function(){

    };
});
