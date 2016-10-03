(function(){
    'use strict'

    angular
        .module('movieflix',['ngMessages','ngRoute','ui.bootstrap'])
        .config(moduleconfig)
        .run(modulerun)

    moduleconfig.$inject =  ['$routeProvider'];

    function moduleconfig($routeProvider){
        $routeProvider
            .when('/movie-list',{
                templateUrl:'app/views/movie-list.tmpl.html',
                controller:'movieListController',
                controllerAs:'movieListVm'
            })
            .when('/movies/movieDetails/:movieId',{
                templateUrl:'app/views/movie-detail.tmpl.html',
                controller:'movieDetailsController',
                controllerAs:'movieVm'
            })
            .when('/add-movie',{
                templateUrl:'app/views/new-movie.tmpl.html',
                controller:'newMovieController',
                controllerAs:'newMovieVm'
            })
            .when('/movies/movieDetails/update-movie/:movieId',{
                templateUrl:'app/views/edit-movie.tmpl.html',
                controller:'updateMovieController',
                controllerAs:'updateMovieVm'
            })
            .when('/login',{
                templateUrl:'app/views/login.tmpl.html',
                controller:'loginController',
                controllerAs:'loginVm'
            })
            .when('/loginAdmin',{
                templateUrl:'app/views/login-admin.tmpl.html',
                controller:'loginAdminController',
                controllerAs:'adminVm'
            })
            .when('/signup/:role',{
                templateUrl:'app/views/signup.tmpl.html',
                controller:'signupController',
                controllerAs:'signupVm'
            })
            .when('/update-user/:userId',{
                templateUrl:'app/views/update-user.tmpl.html',
                controller:'updateUserController',
                controllerAs:'updateUserVm'
            })
            .when('/home',{
                templateUrl:'app/views/home.tmpl.html'
            })
            .otherwise({
                redirectTo:'/home'
            })
    }



    modulerun.$inject = [];
    function modulerun(){

    }


})()