@echo off

call mvn clean
call mvn package
call java -jar target\unit12.jar
call mvn clean
