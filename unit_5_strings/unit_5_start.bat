@echo off

call mvn clean
call mvn validate
call mvn install:install-file -Dfile=src\main\java\ua\com\alevel\lib\StringManipulationUtil.jar -DgroupId=ua.com.alevel -DartifactId=StringLib -Dversion=1.0-SNAPSHOT -Dpackaging=jar
call mvn clean install
call mvn package
call java "-Dfile.encoding=UTF8" -jar target\unit_5.jar
