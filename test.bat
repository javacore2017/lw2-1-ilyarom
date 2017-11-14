@echo off

javac -sourcepath ./src/net/volgatech -d build src/net/volgatech/Handler/Main.java
java -cp build/ net/volgatech/Handler/Main.Main