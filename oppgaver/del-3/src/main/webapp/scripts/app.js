'use strict';

var app = angular.module('scalakursApp', ['ui.bootstrap']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html',
            controller: 'MainController'
        })
        .when('/article/:id', {
            templateUrl: 'views/article.html',
            controller: 'ArticleController'
        })
        .otherwise({
            redirectTo: '/'
        });
  });
