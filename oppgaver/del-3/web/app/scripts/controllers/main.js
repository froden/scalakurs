'use strict';

function MainController($scope, dataService) {
    $scope.articles = dataService.getAllArticles();

    $scope.submitArticle = function(article) {
        console.log('submitting article');
        console.log(article);
        dataService.storeArticle(article);
    }
};
