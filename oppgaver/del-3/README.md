# scalakurs-blogg #

## Installere mongoDB
1. Last ned [mongoDB](http://http://www.mongodb.org/downloads)
2. Pakk ut : tar zxvf mongodb-linux-x86_64-2.4.8.tgz (eller unzip i windows)
3. Lag katalog til databasen: mkdir -p /home/sjur/mongodbdata (fks)
4. Start mongodb slik: /home/sjur/mongo_installed_here/bin/mongodb --dbpath /home/sjur/mongodbdata
5. cd ~/scalakurs/oppgaver/del-3/

## Build & Run ##

```sh
$ ./sbt
> container:start
> browse
```

Hvis `browse` ikke starter en browser automatisk, åpne [http://localhost:8080/](http://localhost:8080/) manuelt.

* Implementer scalakurs.ArticlesController slik at artikler kan addes og editeres, og kommentarer legges på artikler

* Single page JS-app med ulike sider for hver oppgave. Oppgaven blir å implementere backend.

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.