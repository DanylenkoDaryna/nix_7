@echo off

cd unit_2_compile_DanylenkoDaryna/console_compile
javac -sourcepath src/ -d build/classes/ -cp libs/joda-time-2.10.10.jar;libs/hirondelle-date4j-1.5.1.jar  src/ua/com/alevel/task/Task.java  src/ua/com/alevel/MainWorkspace.java
java -cp build/classes/;libs/joda-time-2.10.10.jar;libs/hirondelle-date4j-1.5.1.jar ua.com.alevel.MainWorkspace
jar cf console_compile.jar *

cd ..
cd ant_compile
call ant clean
call ant compile
call ant jar
call ant run

cd ..
cd maven_compile
cd app
call mvn clean
call mvn package
call java -jar target\maven_compile.jar




