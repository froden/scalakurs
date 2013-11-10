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
1. Last ned [mongoDB](http://http://www.mongodb.org/downloads)
2. Pakk ut : tar zxvf mongodb-linux-x86_64-2.4.8.tgz (eller unzip i windows)
3. Lag katalog til databasen: mkdir -p /home/sjur/mongodbdata (fks)
4. Start mongodb slik: /home/sjur/mongo_installed_here/bin/mongodb --dbpath /home/sjur/mongodbdata
5. cd ~/scalakurs/oppgaver/del-3/
6. ./sbt run
7. Åpne http://localhost:7002 i en browser
8. Implementer scalakurs.ArticlesController slik at artikler kan addes og editeres, og kommentarer legges på artikler

* Single page JS-app med ulike sider for hver oppgave. Oppgaven blir å implementere backend.

Notater
=======
* [Twitter Scala school](http://twitter.github.io/scala_school/)
* [Sjur og Arilds workshop](https://github.com/arild/scala-workshop)
* [Community docs](http://docs.scala-lang.org/index.html)
* [API-docs](http://www.scala-lang.org/api/current/#package)
* [Scalatra](http://www.scalatra.org/)
* [MongoDB](http://http://www.mongodb.org/)
