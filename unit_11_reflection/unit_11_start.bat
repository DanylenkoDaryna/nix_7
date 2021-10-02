@echo off

call mvn clean
call mvn package
call java -jar target\unit11.jar
call mvn clean
