@echo off

javac -sourcepath ./src -d build src/net/volgatech/Handler/Main.java
java -cp build/ net/volgatech/Handler/Main