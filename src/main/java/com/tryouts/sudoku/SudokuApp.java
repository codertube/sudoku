package com.tryouts.sudoku;

import java.io.IOException;

public class SudokuApp {

    static void validateSudoku(String filePath) {
        SudokuFileReader reader;
        try {
            reader = new SudokuFileReader(filePath);
            reader.readSudokuFile();
            SudokuMatrix m = new SudokuMatrix();
            if (m.initialize(reader.getSudokuEntries())) {
                System.out.println("Input file read successfully.");
            }
            if (m.isValidSudoku()) {
                System.out.println("0 :: Sudoku is valid.");
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | SudokuException e) {
            System.out.println("-1 :: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = args[0];
        validateSudoku(filePath);
    }

}
