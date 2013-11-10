# scalakurs-blogg #

## Installere mongoDB
1. Last ned [mongoDB](http://http://www.mongodb.org/downloads)
2. Pakk ut : 
```sh
tar zxvf mongodb-linux-x86_64-2.4.8.tgz
``` (eller unzip i windows)
3. Lag katalog til databasen: 
```sh
mkdir -p /home/sjur/mongodbdata
``` (fks)
4. Start mongodb slik: 
```sh
/home/sjur/mongo_installed_here/bin/mongodb --dbpath /home/sjur/mongodbdata
```
5. 
```sh
cd ~/scalakurs/oppgaver/del-3/
```

## Build & Run ##

```sh
$ ./sbt
> container:start
> browse
```

Hvis `browse` ikke starter en browser automatisk, åpne [http://localhost:8080/](http://localhost:8080/) manuelt.

## Oppgave
* Implementer scalakurs.ArticlesController slik at artikler kan addes og editeres, og kommentarer legges på artikler
* Single page JS-app med ulike sider for hver oppgave. Oppgaven blir å implementere backend.

