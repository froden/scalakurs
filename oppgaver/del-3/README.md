# scalakurs-blogg #

## Installere mongoDB
1. Last ned [mongoDB](http://http://www.mongodb.org/downloads)

2. Pakk ut : 
```sh
$ tar zxvf mongodb-linux-x86_64-2.4.8.tgz
```

(eller unzip i windows)

3. Lag katalog til databasen: 
```sh
$ mkdir -p /home/sjur/mongodbdata
```

(fks)

4. Start mongodb slik: 
```sh
$ /home/sjur/mongo_installed_here/bin/mongodb --dbpath /home/sjur/mongodbdata
```

5. 
```sh
$ cd ~/scalakurs/oppgaver/del-3/
```


## Kjøre tester kontinuerlig ##

```sh
$ ./sbt
> ~test
```

## Kjøre appen med autorestart ved kodeendringer ##

```sh
$ ./sbt
> ~re-start
```

Åpne [http://localhost:8080/](http://localhost:8080/) i nettleseren

### Stoppe appen

```sh
> re-stop
```

## Oppgave
* Implementer scalakurs.ArticlesController slik at artikler kan addes og editeres, og kommentarer legges på artikler

### Følgende API i backend forventes av front-end appen:
```
GET    /articles               #get all articles
POST   /articles               #create new article
GET    /articles/:id           #get single article
PUT    /articles/:id           #update existing article
DELETE /articles/:id           #remoeve article
POST   /articles/:id/comments  #create new comment on article
DELETE /articles/:id/comments  #delete all comments from article

#article with comments
{
    "_id": "1234zxcvdas",
    "author": "Frode",
    "title": "A blogpost",
    "content": "Loong and informative post"
    "comments": [
        {"author": "Sjur", "content": "Nice post!", "author": "Arild", "content": "Could be shorter."}
    ]
}
```

