@echo off

cd unit_2_compile_DanylenkoDaryna/console_compile
::javac -sourcepath src/ -d build/classes/ src/ua/com/alevel/MainWorkspace.java
::java -cp build/classes/ ua.com.alevel.MainWorkspace
:: DEL "ua\com\alevel\*.class" /S /Q

javac -sourcepath src/ -d build/classes/ -cp libs/joda-time-2.10.10.jar;libs/hirondelle-date4j-1.5.1.jar  src/ua/com/alevel/task/Task.java  src/ua/com/alevel/MainWorkspace.java
java -cp build/classes/;libs/joda-time-2.10.10.jar;libs/hirondelle-date4j-1.5.1.jar ua.com.alevel.MainWorkspace
jar cf console_compile.jar *






