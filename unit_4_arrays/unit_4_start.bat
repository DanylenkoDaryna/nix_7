@echo off

call mvn clean
call mvn package
call java "-Dfile.encoding=UTF8" -jar target\unit_4.jar