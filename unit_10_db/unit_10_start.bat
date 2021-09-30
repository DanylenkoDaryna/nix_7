@echo off

call mvn clean
call mvn package
call java -jar target\unit10.jar
call mvn clean
