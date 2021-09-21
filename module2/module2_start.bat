@echo off

call mvn clean
call mvn validate
call mvn install:install-file -Dfile=src\main\java\ua\com\alevel\lib\formatter.jar -DgroupId=ua.com.alevel -DartifactId=DateFormatter -Dversion=1.0-SNAPSHOT-DANKO -Dpackaging=jar
call mvn install:install-file -Dfile=src\main\java\ua\com\alevel\lib\name_sorter.jar -DgroupId=ua.com.alevel -DartifactId=NameSorter -Dversion=1.0-SNAPSHOT-DANKO -Dpackaging=jar
call mvn install:install-file -Dfile=src\main\java\ua\com\alevel\lib\path_searcher.jar -DgroupId=ua.com.alevel -DartifactId=PathSearcher -Dversion=1.0-SNAPSHOT-DANKO -Dpackaging=jar
call mvn package
call java "-Dfile.encoding=UTF8" -jar target\module2.jar
