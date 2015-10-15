//
angular.module("rango-vote")//
  .controller("t101",function($scope,$timeout,memberservice){

    $scope.membro={};

    $scope.doLogin=function(){
      $scope.membro.hashSenhaMembro = md5($scope.membro.hashSenhaMembro);
      memberservice.login($scope.membro).then(function(ret){
        alert("Olá, "+$scope.membro.emailMembro);
        window.location.href="t102-votacao-resultado.html";
      }).catch(function(err){
        alert("Problema ao efetuar o login. Revise seus dados ou tente novamete mais tarde");
        window.location.reload();
      });
    };

    $scope.esqueciSenha=function(){
      alert("** implementar **");
    };
});
