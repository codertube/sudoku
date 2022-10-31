# Sudoku Validator

## How to run

Project was coded using Java 8.

To run, 
1. create directory named 'Sudoku' in C: drive.
2. copy sudoku code zip file and sudoku_input.txt file into 'Sudoku' folder.
3. run sudoku_validate.bat file passing sudoku_input.txt as argument using following command 
 
    sudoku_validate.bat C:/Sudoku/sudoku_input.txt 

Pass absolute file path like above to avoid error.

The project also has several test cases using JUnit5 which is ran and HTML test report is generated using Maven surefire plugin which can be accessed from target/site folder.

__Sample Run Output__

```sh
Input file read successfully.
0 :: Sudoku is valid.

Input file read successfully.
-1 :: Sudoku validation failed.

-1 :: Input Sudoku file not in expected format.
```

Below is a valid Sudoku test input file.

## sudoku_input.txt

```pre
534678912
672195348
198342567
859761423
426853791
713924856
961537284
287419635
345286179
```
