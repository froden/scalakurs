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

### Generere prosjektfiler for Eclipse og IntelliJ

Eclipse

    ./sbt eclipse

IntelliJ

    ./sbt gen-idea

Prosjektet kan deretter åpnes fra File -> Open -> scalakurs/oppgaver/del-2

*slutt på forberedelser*

## På kurset

### Komme i gang med SBT

#### Start SBT interaktivt

    $ cd scalakurs/oppgaver/del-2
    $ ./sbt
    [info] Loading project definition from /Users/frode/dev/scalaogjvm/scalakurs/oppgaver/del-2/project
    [info] Set current project to scalakurs-ntnu-del2 (in build file:/Users/frode/dev/scalaogjvm/scalakurs/oppgaver/del-2/)
    >

#### Kjør testene kontinuerlig

    > ~test

Stopp ved å trykke &lt;enter&gt;

#### Andre nyttige kommandoer

    > clean
    > compile
    > run

### Hvordan løse oppgavene

* Kjør testene kontinuerlig i sbt `~test`
* Alle tester som vises som pending (gule) eller feilet (røde) må fikses
* Åpne testklassen du vil jobbe med (f.eks. oppg1_intro/IntroTest.scala)
* Ta for deg èn og èn test og les kommentarene og testbeskrivelsen
* Fullfør testen og implementasjon der dette kreves for å få testen grønn (sjekk sbt-consolet)
* Fortsett med neste test
* Fullfør så mange tester som mulig til hvert emne, men gå videre når noe nytt blir gjennomgått slik at du får prøvd deg på litt av alt.

#### Testklassene finner du her:

* src/test/scala/oppg1_intro
* src/test/scala/oppg2_forcomprehensions
* src/test/scala/oppg3_option
* src/test/scala/oppg4_try
* src/test/scala/oppg5_futures

#### Slides finner du [her](http://froden.github.io/scalakurs/#/36)
