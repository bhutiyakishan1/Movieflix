(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('movieDetailsController', movieDetailsController);

    movieDetailsController.$inject = ['movieService', '$routeParams', '$location','userService'];
    function movieDetailsController(movieService, $routeParams, $location,userService) {
        var movieVm = this;
        movieVm.deleteMovie = deleteMovie;
        movieVm.addRating = addRating;


        init();
        function init() {
            movieService
                .getTitleById($routeParams.movieId)
                .then(function (title) {
                    movieVm.movie = title;
                }, function (error) {
                    console.log(error);
                });
            userService
                .getUser()
                .then(function(user) {
                    console.log("In movielst getuser controller " + user.userId);
                    movieVm.user = user;
                    movieVm.role = user.role;
                    console.log("In movielst getuser controller Role " + user.role);
                }, function (error) {
                    console.log(error);
                });

            movieService
                .getRatings($routeParams.movieId)
                .then(function (ratings) {
                    movieVm.ratings= ratings;
                }, function (error) {
                    console.log(error);
                });
        }

        function deleteMovie() {
            movieService
                .deleteMovie($routeParams.movieId)
                .then(function (title) {
                    $location.path('/movie-list');
                }, function (error) {
                    console.log(error);
                });
        }

        function addRating(form) {
            movieService
                .getTitleById($routeParams.movieId)
                .then(function (movie) {
                    movieVm.newRating.movie = movie;
                    movieVm.newRating.user = movieVm.user;
                    movieService
                        .addRating(movieVm.newRating)
                        .then(function (rating) {
                            movieVm.submitMessage = 'Rating Added Successfully';
                            clear(form);
                        }, function (error) {
                            console.log(error);
                        });
                }, function (error) {
                    console.log(error);
                });

        }

        function clear() {
            movieVm.newRating = {};
            // Set back to pristine.
            movieVm.reviewForm.$setPristine();
            // Since Angular 1.3, set back to untouched state.
            movieVm.reviewForm.$setUntouched();
        }


    }

})();

