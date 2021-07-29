@echo off

call mvn clean
call mvn package
call java -jar target\unit_4.jar