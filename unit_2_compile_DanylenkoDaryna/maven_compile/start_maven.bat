cd ..\maven_compile
cd app
call mvn clean
call mvn package
call java -jar target\maven_compile.jar