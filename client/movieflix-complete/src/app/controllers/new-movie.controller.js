
(function () {
    'use strict'

    angular
        .module('movieflix')
        .controller('newMovieController',newMovieController)

    newMovieController.$inject = ['movieService','$http','$location']
    function newMovieController(movieService,$http,$location){
        var vm = this;
        vm.createMovie =  createMovie;

        function createMovie(){
            movieService
                .createMovie(vm.newMovie)
                .then(function(movie){
                    console.log(movie);
                    $location.path('/movie-list');
                },function(error){
                    console.log(error);
                })
        }
    }
})();