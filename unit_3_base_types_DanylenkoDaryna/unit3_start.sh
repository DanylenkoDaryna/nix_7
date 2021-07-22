#!/usr/bin/env bash
mvn clean
mvn package
java -jar target\unit_3.jar
