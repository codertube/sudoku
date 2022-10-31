@echo off
echo "Unzipping code ..."
tar -xf sudoku.zip
echo "changing to project directory ..."
cd C:\Sudoku\sudoku
echo "executing maven build ..."
call mvn clean install
echo "generating test reports ..."
call mvn site
echo "moving to target directory ..."
cd C:\Sudoku\sudoku\target
echo "executing jar with sudoku input file ..."
java -jar sudoku-1.0-SNAPSHOT-jar-with-dependencies.jar %1
pause