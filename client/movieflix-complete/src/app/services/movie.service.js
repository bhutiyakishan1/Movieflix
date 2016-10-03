(function () {
    'use strict'
    angular
        .module('movieflix')
        .service('movieService',movieService)

    movieService.inject = ['$http','$q','CONFIG'];

    function movieService($http,$q,CONFIG){
        var vm = this;
        vm.getTitles =  getTitles;
        vm.getTitlesByType =  getTitlesByType;
        vm.getTitleById =  getTitleById;
        vm.createMovie =  createMovie;
        vm.successFn =  successFn;
        vm.errorFn = errorFn;
        vm.deleteMovie =  deleteMovie;
        vm.addRating =  addRating;
        vm.updateMovie = updateMovie;
        vm.getRatings =  getRatings;

        function getTitles(){
            return $http.get(CONFIG.API_HOST + '/movies').then(successFn,errorFn)
        };

        function addRating(rating){
            return $http({
                method:'POST',
                url: CONFIG.API_HOST + '/ratings',
                data:rating
            }).then(successFn,errorFn)};

        function getRatings(movieId){
            return $http.get(CONFIG.API_HOST + '/ratings/getComments/' + movieId).then(successFn,errorFn)
        };


        function getTitlesByType(type){
            return $http.get(CONFIG.API_HOST + '/movies/type/' + type).then(successFn,errorFn)
        };

        function getTitleById(movieId){
            return $http.get(CONFIG.API_HOST + '/movies/findTitleById/' + movieId).then(successFn,errorFn)
        };


        function createMovie(movie){
            return $http({
                method:'POST',
                url: CONFIG.API_HOST + '/movies',
                data:movie
            }).then(successFn,errorFn)};

        function deleteMovie(movieId){
            return $http({
                method:'DELETE',
                url: CONFIG.API_HOST + '/movies/' + movieId,
            }).then(successFn,errorFn)};

        function updateMovie(movieId,movie){
            return $http({
                method:'PUT',
                url: CONFIG.API_HOST + '/movies/' + movieId,
                data:movie
            }).then(successFn,errorFn)};



        function successFn(response){
            return response.data;
        }
        function errorFn(response){
            return $q.reject('ERROR: ' + response.statusText);;
        }
    }
})()