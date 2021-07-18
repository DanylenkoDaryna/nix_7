@echo off

cd console_compile
call start_console.bat
cd ..

cd ant_compile
call start_ant.bat
cd ..

cd maven_compile\app
call start_maven.bat
call java -jar target\maven_compile.jar




