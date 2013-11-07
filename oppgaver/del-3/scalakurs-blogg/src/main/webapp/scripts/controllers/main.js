'use strict';

function MainController($scope, dataService) {
    $scope.showError = false;
    $scope.articles = dataService.getAllArticles();

    function showError(message) {
        $scope.showError = true;
        $scope.errorMessage = message;
    }

    $scope.submitArticle = function(article) {
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
