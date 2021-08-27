#!/bin/sh
mvn clean;
mvn package;
java -jar target\unit7.jar;
mvn clean