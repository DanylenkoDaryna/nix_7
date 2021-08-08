@echo off

call mvn clean
call mvn package
call java -jar target\module_1.jar