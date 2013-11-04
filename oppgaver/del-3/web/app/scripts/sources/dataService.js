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

            return $http.get('article').then(function(res) {
                return res;
            });

        },
        storeArticle: function(article) {
            return $http.post('article', article).then(function(res) {
                return res;
            });
        }
    }
});
