# Oppgaver del-2

## Før kurset

### Installér Scala-plugin til Eclipse eller IntelliJ

#### Eclipse

* [Scala IDE for Eclipse bundle](http://scala-ide.org/download/sdk.html) (anbefales)
* [Scala IDE for Eclipse plugin](http://scala-ide.org/download/current.html)
* [ScalaTest plugin](https://github.com/scalatest/scalatest-eclipse-plugin)

#### IntelliJ

* `Settings --> Plugins --> Install JetBrains plugin... --> Scala`

#### Annen valgfri editor

Siden compilering og kjøring av tester kan gjøres med SBT er det ingenting i veien for å bruke en annen editor.

### Last ned kildekoden og sbt-avhengigheter

    git clone git@github.com:froden/scalakurs.git
    cd scalakurs/oppgaver/del-2
    ./sbt test
    
    sbt.bat test (for windows)

Sbt vil starte, laste ned nødvendige avhengigheter og kjøre alle tester. Mange av testene vil være røde eller gule (pending). Det er greit :)

*slutt på forberedelser*

## Komme i gang med SBT

### Start SBT interaktivt

    $ cd scalakurs/oppgaver/del-2
    $ ./sbt
    [info] Loading project definition from /Users/frode/dev/scalaogjvm/scalakurs/oppgaver/del-2/project
    [info] Set current project to scalakurs-ntnu-del2 (in build file:/Users/frode/dev/scalaogjvm/scalakurs/oppgaver/del-2/)
    >

### Kjør testene kontinuerlig

    > ~test

Stopp ved å trykke &lt;enter&gt;

### Andre nyttige kommandoer

    > clean
    > compile
    > run

### Generere prosjektfiler for Eclipse og IntelliJ

Eclipse

    > eclipse

IntelliJ

    > gen-idea

Prosjektet kan deretter åpnes fra File -> Open -> scalakurs/oppgaver/del-2

## Hvordan løse oppgavene

* Les oppgaveteksten nedenfor
* Kjør testene kontinuerlig i sbt `~test`
* Fullfør tester og implementasjon der dette kreves for å få testene grønne

## Oppgave 1 - Repetisjon av basic syntaks

## Oppgave 2 - for comprehensions

## Oppgave 3 - Option

## Oppgave 4 - Try

## Oppgave 5 - Future
