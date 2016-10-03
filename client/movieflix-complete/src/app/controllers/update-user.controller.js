(function () {
    'use strict'
    angular
        .module('movieflix')
        .controller('updateUserController',updateUserController)

    updateUserController.$inject = ['userService','$http','$location','$routeParams']
    function updateUserController(userService,$http,$location,$routeParams) {
        var updateUserVm = this;
        updateUserVm.updateUser =updateUser;

        init();
        function init() {
            userService
                .getUserById($routeParams.userId)
                .then(function (user) {
                    updateUserVm.user = user;
                }, function (error) {
                    console.log(error);
                });
        }


        function updateUser(form){
            userService
                .updateUser($routeParams.userId,updateUserVm.user)
                .then(function(user){
                    updateUserVm.submitMessage = 'Account Updated';
                    clear(form);
                },function(error){
                    console.log(error);
                })
        }

        function clear() {
            updateUserVm.user = {};
            // Set back to pristine.
            updateUserVm.updateForm.$setPristine();
            // Since Angular 1.3, set back to untouched state.
            updateUserVm.updateForm.$setUntouched();
        }
    }
})();
