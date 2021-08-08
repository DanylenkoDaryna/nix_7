#!/bin/sh
mvn clean;
mvn package
java -jar target\unit4.jar
mvn clean