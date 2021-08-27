@echo off

call mvn clean
call mvn package
call java -jar target\unit8.jar
call mvn clean