(function () {
    'use strict'

    angular
        .module('movieflix')
        .controller('loginController',loginController)

    loginController.$inject = ['userService','$http','$location','$routeParams']
    function loginController(userService,$http,$location,$routeParams){
        var vm = this;
        vm.checkUser =  checkUser;

        function checkUser(form){
            vm.role=  'User'
            userService
                .checkUser(vm.user)
                .then(function(Outuser){
                    console.log(Outuser);

                    $location.path('/movie-list');
                },function(error){
                    clear(form);
                    vm.errorMessage = 'Invalid User';
                })
        }


        function clear() {
            vm.user = {};
            // Set back to pristine.
            vm.loginForm.$setPristine();
            vm.loginForm.$setUntouched();
        }
    }
})();