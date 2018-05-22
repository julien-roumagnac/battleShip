#!/bin/bash
cd src

javac fr/battleship/*.java polytech/ig/julien/roumagnac/game/*.java polytech/ig/julien/roumagnac/structure/*.java roumagnac/julien/*.java

java fr.battleship.TestIA

java roumagnac.julien.Battleship