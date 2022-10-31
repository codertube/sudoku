package com.tryouts.sudoku;

import java.util.*;

public class SudokuMatrix {

    int matrix[][] = new int[9][9];
    public static final String SUDOKU_INVALID_FORMAT_ERROR = "Input Sudoku file not in expected format.";
    public static final String SUDOKU_INVALID_LINE_ERROR = "Invalid Sudoku entry line.";
    public static final String SUDOKU_VALIDATION_ERROR = "Sudoku validation failed.";

    /**
     * Create a 9x9 Matrix using a list of string containing digits in range of [1-9].
     *
     * @param sudokuEntries - List of string of digits.
     * @return true  - Matrix initialize with valid input
     */
    public boolean initialize(List<String> sudokuEntries) throws SudokuException, ArrayIndexOutOfBoundsException {

        /**
         * Iterate String as character of digits,
         * convert into int and save to Matrix.
         */
        if (sudokuEntries == null || sudokuEntries.size() != 9) {
            throw new SudokuException(SudokuMatrix.SUDOKU_INVALID_FORMAT_ERROR);
        }
        int row = 0;
        for (String entry : sudokuEntries) {
            entry = entry.replaceAll(",", "");
            if (entry.length() != 9) {
                throw new SudokuException(SudokuMatrix.SUDOKU_INVALID_LINE_ERROR);
            }
            if (!entry.chars().allMatch(Character::isDigit)) {
                throw new SudokuException(SudokuMatrix.SUDOKU_INVALID_FORMAT_ERROR);
            }
            int col = 0;
            for (char ch : entry.toCharArray()) {
                int val = Character.getNumericValue(ch);
                this.matrix[row][col++] = val;
            }
            ++row;
        }
        return true;
    }

    /**
     * Validate 9x9 Matrix is Sudoku valid.
     *
     * @return true  - Valid Sudoku Matrix.
     */
    public boolean isValidSudoku() throws SudokuException {
        HashSet entryPresent = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!entryPresent.add("row" + i + matrix[i][j]) || !entryPresent.add("column" + j + matrix[i][j])) {
                    throw new SudokuException(SudokuMatrix.SUDOKU_VALIDATION_ERROR);
                }
                if (!entryPresent.add("box" + (i / 3) * 3 + j / 3 + matrix[i][j])) {
                    throw new SudokuException(SudokuMatrix.SUDOKU_VALIDATION_ERROR);
                }
            }
        }
        return true;
    }
}
