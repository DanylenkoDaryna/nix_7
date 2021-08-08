#!/bin/sh
mvn clean;
mvn package;
java -jar target\unit6.jar;
mvn clean