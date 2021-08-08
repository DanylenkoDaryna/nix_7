@echo off

call mvn clean
call mvn package
call java -jar target\module1.jar