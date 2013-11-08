app.factory('dataService', function($http) {
    return {
        getAllArticles: function() {
            return [
                {
                    title: 'Looking Forward to Instant Transfers',
                    date: 'OCT 8, 2013',
                    author: 'Arild Nilsen'
                },
                {
                    title: 'Simple Insights: What Caused the Spike?',
                    date: 'OCT 1, 2013',
                    author: 'Arild Nilsen'
                }
            ];

            return $http.get('articles').then(function(res) {
                return res;
            });

        },
        storeArticle: function(article) {
            return $http.post('articles', article).then(function(resp) {
                return resp.data;
            });
        }
    }
});
