#!/bin/bash
cd src

javac fr/battleship/*.java polytech/ig/julien/roumagnac/game/*.java polytech/ig/julien/roumagnac/structure/*.java roumagnac/julien/*.java

java roumagnac.julien.Battleship



find . -type f -path "./roumagnac/julien/*" -name "*.class" -exec rm -f {} \;

find . -type f -path "./fr/battleship/*" -name "*.class" -exec rm -f {} \;

find . -type f -path "./polytech/ig/julien/roumagnac/*" -name "*.class" -exec rm -f {} \;
find . -type f -path "./polytech/ig/julien/roumagnac/*/*" -name "*.class" -exec rm -f {} \;