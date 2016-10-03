(function () {
    'use strict'

    angular
        .module('movieflix')
        .controller('updateMovieController',updateMovieController)

    updateMovieController.$inject = ['movieService','$http','$location','$routeParams']
    function updateMovieController(movieService,$http,$location,$routeParams){
        var updateMovieVm = this;
        updateMovieVm.updateMovie =  updateMovie ;

        init();
        function init() {
            movieService
                .getTitleById($routeParams.movieId)
                .then(function (data) {
                    updateMovieVm.movie = data;
                    console.log(updateMovieVm.movie.title)
                }, function (error) {
                    console.log(error);
                });
        }

        function updateMovie(){
            movieService
                .updateMovie($routeParams.movieId,updateMovieVm.movie)
                .then(function(movie){
                    $location.path('/movies/movieDetails/'  + movie.movieId);
                },function(error){
                    console.log(error);
                })
        }
    }
})();
