'use strict';

function MainController($scope, dataService) {
    $scope.showError = false;

    dataService.getAllArticles().then(
        function(articles) {
            $scope.articles = articles;
        },
        function() {
            showError('feil ved henting av artikler');
        }
    );;

    function showError(message) {
        $scope.showError = true;
        $scope.errorMessage = message;
    }

    $scope.submitArticle = function(article) {
        dataService.addArticle(article).then(
            function() {
                $scope.articles.push(article);
            },
            function() {
                showError('feil ved lagring av artikkel');
            }
        );
    }
};
