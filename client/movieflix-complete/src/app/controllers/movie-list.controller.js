(function () {
    'use strict'

    angular
        .module('movieflix')
        .controller('movieListController',movieListController)

    movieListController.$inject = ['movieService','$scope','userService','$location']
    function movieListController(movieService,$scope,userService,$location){
        var vm = this;
        vm.getTitlesByType = getTitlesByType;
        vm.logout =  logout;

        init()
        function init(){
            movieService
                .getTitles()
                .then(function(titles) {
                    vm.titles= titles;
                }, function (error) {
                    console.log(error);
                });
            userService
                .getUser()
                .then(function(user) {
                    console.log("In movielst getuser controller User Id " + user.userId);
                    vm.userId = user.userId;
                    vm.role= user.role;
                    console.log("In movielst getuser controller Role " + user.role);
                }, function (error) {
                    console.log(error);
                });
        }

        function getTitlesByType(type){
            movieService
                .getTitlesByType(type)
                .then(function(titles) {
                    vm.titles = titles;
                }, function (error) {
                    console.log(error);
                });
        }

        function logout() {
            userService.logout()
            $location.path('/home');
        }
        $scope.search = function (item) {
            if ($scope.searchText == undefined) {
                return true;
            }
            else {
                if (item.title.toLowerCase()
                        .indexOf($scope.searchText.toLowerCase()) != -1 ||
                    item.genre.toLowerCase()
                        .indexOf($scope.searchText.toLowerCase()) != -1 ||
                    item.year.toLowerCase()
                        .indexOf($scope.searchText.toLowerCase()) != -1) {
                    return true;
                }
            }
            return false;
        };
    }

})();