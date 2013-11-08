app.factory('dataService', function($http) {
    return {
        getAllArticles: function() {
//            return [
//                {
//                    id: 0,
//                    title: 'Helt spiste gjennom en glidelås',
//                    author: 'Arild Nilsen'
//                },
//                {
//                    id: 1,
//                    title: 'Kanarifugl flamberte',
//                    author: 'Arild Nilsen'
//                },
//                {
//                    id: 2,
//                    title: 'Indianer snakket på en stol',
//                    author: 'Arild Nilsen'
//                }
//            ];

            return $http.get('/articles').then(function(res) {
                return res.data;
            });

        },
        addArticle: function(article) {
            return $http.post('/articles', article).then(function(resp) {
                return resp.data;
            });
        },
        getArticle: function(id) {
//            if (id == 0) {
//                return {
//                    id: 0,
//                    title: 'Helt spiste gjennom en glidelås',
//                    content: 'En snekker tok med seg tjue bilstereoer inn til stammelederen. En kjempefinnmarking narret stiften til tyranosaurusene. Løvinna tok med seg 266 osthøveler inn til narkolangeren. En oter gjenopplivde sangerinna hasardiøst. Plutselig var krigeren der gjennom den fantastiske biffen, og sprayet alle cowboyene hastig. Ei katte løftet en parkeringsautomat. En soldat malte en politiker til han lekte rått bak den mangelfulle flygemaskinen. Egypteren var rettferdig og lilla. En svensk russer pusset syv ganger på 16 timer.',
//                    author: 'Arild Nilsen'
//                };
//            }
//            else if (id == 1) {
//                return {
//                    id: 1,
//                    title: 'Kanarifugl flamberte',
//                    content: 'En ork løp videoen latterlig langt foran en sleip bil. De så en ørn som gurglet provoserende ganske nært en luftballong. Åtte gråe superhelter møtte 44 ondskapsfulle araberer. Ei annen prinsesse luktet fisken usikkert over en hurtig biff. Tjueen sabeltanntigerer lekte en rå knapp på fem dager.',
//                    author: 'Arild Nilsen'
//                }
//            }
            return $http.get('/articles/' + id).then(function(res) {
                return res;
            });

        },
        deleteArticle: function(id) {
            return $http.delete('/articles/' + id).then(function(resp) {
                return resp.data;
            })
        },
        updateArticle: function(article) {
            return $http.put('/articles/' + article.id, article).then(function(resp) {
                return resp.data;
            })
        },
        getComments: function(articleId) {
//            if (articleId == 0) {
//                return [
//                    {
//                        content: 'Snekkeren børstet servitøren rett. De så aspiranten som ropte sjokkert bak en statue. En sjørøver gjenopplivde en helt rett. Da felte tyskeren ei jente høflig. 500 bjørner filosoferte en mørkegrønn propell på syv dager.',
//                        author: 'Arild Nilsen'
//                    },
//                    {
//                        content: 'Det var en gang noen servitører som lempet andre amerikanerer. Ringpermene ankom, mens rytterene lå litt bak medisinballen. De små dvergene kjørte i skjul.',
//                        author: 'Arild Nilsen'
//                    }
//                ];
//            }
//            else if (articleId == 1) {
//                return [
//                    {
//                        content: 'De så tanta som kjørte treffsikkert ganske nært en gradestokk. Da børstet tjukkasen en sjørøver fint. Sjefstyskeren spant fisken, laksen og brasilianerene.',
//                        author: 'Arild Nilsen'
//                    }
//                ];
//            }

            return $http.get('/articles/' + articleId  + '/comments').then(function(resp) {
                return resp.data;
            })
        },
        addComment: function(articleId, comment) {
            return $http.post('/articles/' + articleId + '/comments', comment).then(function(res) {
                return res;
            });
        },
        deleteAllComments: function(articleId) {
            return $http.delete('/articles/' + articleId + '/comments').then(function(resp) {
                return resp.data;
            })
        }
    }
});
