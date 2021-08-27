#!/bin/sh
mvn clean;
mvn package;
java -jar target\unit8.jar;
mvn clean