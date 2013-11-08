'use strict';

function ArticleController($scope, $routeParams, dataService) {
    $scope.showError = false;
    $scope.article = dataService.getArticle(0);

    function showError(message) {
        $scope.showError = true;
        $scope.errorMessage = message;
    }

    $scope.deleteArticle = function(article) {
        dataService.storeArticle(article).then(
            function() {
                $scope.articles.push(article);
            },
            function() {
                showError('failed storing article');
            }
        );
    }
};
