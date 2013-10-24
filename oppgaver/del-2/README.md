# Oppgaver del-2

## Før kurset

### Installer Scala-plugin til Eclipse eller IntelliJ

For Eclipse er det enklest å gå for [http://scala-ide.org/download/sdk.html](Scala IDE Bundle)
Scala IDE er også tilgjengelig som [http://scala-ide.org/download/current.html](plugin)
For å kunne kjøre testene direkte i Eclipse må man installere [https://github.com/scalatest/scalatest-eclipse-plugin](ScalaTest plugin) for Eclipse


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
