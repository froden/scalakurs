app.factory('dataService', function($http) {
    return {
        getAllArticles: function() {
            return $http.get('/articles').then(function(resp) {
                return resp.data;
            });

        },
        addArticle: function(article) {
            return $http.post('/articles', article).then(function(resp) {
                return resp.data;
            });
        },
        getArticle: function(id) {
            return $http.get('/articles/' + id).then(function(resp) {
                return resp.data;
            });

        },
        deleteArticle: function(id) {
            return $http.delete('/articles/' + id).then(function(resp) {
                return resp.data;
            })
        },
        updateArticle: function(article) {
            return $http.put('/articles/' + article._id, article).then(function(resp) {
                return resp.data;
            })
        },
        getComments: function(articleId) {
            return $http.get('/articles/' + articleId  + '/comments').then(function(resp) {
                return resp.data;
            })
        },
        addComment: function(articleId, comment) {
            console.log('addComment: ', articleId, comment);
            return $http.post('/articles/' + articleId + '/comments', comment).then(function(resp) {
                return resp.data;
            });
        },
        deleteAllComments: function(articleId) {
            return $http.delete('/articles/' + articleId + '/comments').then(function(resp) {
                return resp.data;
            })
        }
    }
});
