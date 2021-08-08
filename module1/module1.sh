#!/bin/sh
mvn clean;
mvn package;
java -jar target\module1.jar;
mvn clean