// Define the module
angular.module("rango-vote",[
  "ngRoute",
  "ngMaterial",
  "ngAria",
  "ngAnimate"
]);
angular.module("rango-vote").config(function($locationProvider){
  $locationProvider.html5Mode(true);
});
