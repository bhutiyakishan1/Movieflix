(function () {
    'use strict'

    angular
        .module('movieflix')
        .controller('signupController',signupController)

    signupController.$inject = ['userService','$http','$location','$routeParams']
    function signupController(userService,$http,$location,$routeParams){
        var vm = this;
        vm.createUser =  createUser;

        function createUser(){
            vm.newUser.role = $routeParams.role
            userService
                .createUser(vm.newUser)
                .then(function(user){
                    vm.userId = user.userId;
                    vm.user =  user;
                    $location.path('/movie-list');
                },function(error){
                    console.log(error);
                })
        }
    }
})();

