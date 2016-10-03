
(function () {
    'use strict'

    angular
        .module('movieflix')
        .controller('loginAdminController',loginAdminController)

    loginAdminController.$inject = ['userService','$http','$location','$routeParams']
    function loginAdminController(userService,$http,$location,$routeParams){
        var vm = this;
        vm.checkAdmin =  checkAdmin;

        function checkAdmin(form){
            console.log('Admin conto');
            vm.user.role = 'Admin'
            console.log('Admin conto User' + vm.user.role);
            console.log('Admin conto User' + vm.user.email);

            userService
                .checkAdmin(vm.user)
                .then(function(Outuser){
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
            // Since Angular 1.3, set back to untouched state.
            vm.loginForm.$setUntouched();
        }
    }
})();