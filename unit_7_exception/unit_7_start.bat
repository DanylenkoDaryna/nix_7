@echo off

call mvn clean
call mvn package
call java -jar target\unit7.jar
call mvn clean