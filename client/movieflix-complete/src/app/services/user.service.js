(function () {
    'use strict'
    angular
        .module('movieflix')
        .service('userService',userService)

    userService.inject = ['$http','$q','CONFIG'];

    function userService($http,$q,CONFIG){
        var signupVm = this;
        signupVm.getUserById =  getUserById;
        signupVm.getUserByEmail =  getUserByEmail;
        signupVm.createUser =  createUser;
        signupVm.deleteUser =  deleteUser;
        signupVm.updateUser = updateUser;
        signupVm.checkUser = checkUser;
        signupVm.checkAdmin = checkAdmin;
        signupVm.getUser =  getUser;
        signupVm.successFn =  successFn;
        signupVm.errorFn = errorFn;
        signupVm.logout =  logout;

        function getUserById(userId){
            return $http.get(CONFIG.API_HOST + '/users/userId/' + userId).then(successFn,errorFn)
        };
        function getUserByEmail(email){
            return $http.get(CONFIG.API_HOST + '/users/email/' + userEmail).then(successFn,errorFn)
        };

        function logout() {
            signupVm.user = {};

        }

        function checkAdmin(admin){
            console.log('Admin Service');
            return $http({
                method:'POST',
                url: CONFIG.API_HOST + '/users/login/admin',
                data:admin
            }).then(successFn,errorFn)};


        function checkUser(user){
            console.log("In check user service " + user);
            return $http({
                method:'POST',
                url: CONFIG.API_HOST + '/users/login/user',
                data:user
            }).then(successFn,errorFn)};

        function createUser(user){
            return $http({
                method:'POST',
                url: CONFIG.API_HOST + '/users',
                data:user
            }).then(successFn,errorFn)};


        function deleteUser(userId){
            return $http({
                method:'DELETE',
                url: CONFIG.API_HOST + '/users/' + userId,
            }).then(successFn,errorFn)};

        function updateUser(userId,user){
            return $http({
                method:'PUT',
                url: CONFIG.API_HOST +  '/users/' + userId,
                data:user
            }).then(successFn,errorFn)};

        function successFn(response){
            signupVm.user =  response.data;
            return response.data;
        }

        function errorFn(response){
            return $q.reject('ERROR: ' + response.statusText);;
        }

        function getUserId(userId) {
            return getUserById(userId);
        }

        function getUser(){
            return getUserById(signupVm.user.userId);
        }

    }
})()
