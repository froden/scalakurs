Scalakurs
=========

Tidspunkt:
* 9.  oktober - 17.00 - 20.00
* 30. oktober
* 11. november

16.00 - 19.00 + bespisning

Opplegg
=======
  
## [Del 1](oppgaver/del-1): Basic

### Gjennomføring
1. Introdusere konspet med 2 slides
2. Korte oppgaver 10 min
3. Eventuelt gjennomgå i plenum
4. GOTO 1

### Temaer
Oppgaver i [Typseafe activator](http://typesafe.com/platform/getstarted) - Torbjørn setter opp

1. Intro til Scala - bakgrunn, utbredelse, hvorfor er det bra, hva bruker Bekk, java interop
2. Intro til syntax (sourcefiler, variabler, metoder, ekspression oriented, looping)
   * Oppg: Få activator til å kjøre + løse basic oppgave om syntax
4. Klasser, objekter, case classes, traits
   * Oppgaver
5. Collections-håntering og funksjoner
   * Oppgaver
6. Pattern matching og case classes
   * Oppgaver

## [Del 2](oppgaver/del-2): Funksjonell prog
* litt repetisjon av syntaks + intro til SBT
* for comprehensions
* Option
* Try
* Future

## [Del 3](oppgaver/del-3): Scalatra + js-front
* [Scalatra](http://www.scalatra.org/)
* [mongoDB](http://http://www.mongodb.org/)

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


Notater
=======
* [Twitter Scala school](http://twitter.github.io/scala_school/)
* [Sjur og Arilds workshop](https://github.com/arild/scala-workshop)
* [Community docs](http://docs.scala-lang.org/index.html)
* [API-docs](http://www.scala-lang.org/api/current/#package)
* [Scalatra](http://www.scalatra.org/)
* [MongoDB](http://http://www.mongodb.org/)

* [Oppsummering av Casbah med eksempler](http://janxspirit.blogspot.no/2011/11/introduction-to-casbah-scala-mongodb.html)
