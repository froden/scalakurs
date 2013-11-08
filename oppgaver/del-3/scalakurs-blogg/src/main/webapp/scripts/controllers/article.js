'use strict';

function ArticleController($scope, $routeParams, dataService) {
    $scope.showError = false;
    $scope.article = dataService.getArticle(0);
    $scope.comments = dataService.getComments(0);

    function showError(message) {
        $scope.showError = true;
        $scope.errorMessage = message;
    }

    $scope.showArticleEdit = false;
    $scope.toggleShowArticleEdit = function() {
        $scope.showArticleEdit = !$scope.showArticleEdit;
    }

    $scope.delete = function(article) {
        dataService.deleteArticle(article.id).then(
            function() {

            },
            function() {
                showError('feil ved sletting av artikkel');
            }
        );
    }

    $scope.update = function(article) {
        dataService.updateArticle(article).then(
            function() {

            },
            function() {
                showError('feil ved oppdatering av artikkel');
            }
        );
    }
};
