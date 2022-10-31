package com.tryouts.sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SudokuFileReader {

    List<String> sudokuEntries = new ArrayList<>();
    private String file;

    SudokuFileReader(String file) {
        this.file = file;
    }

    public void readSudokuFile() throws SudokuException, IOException {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            do {
                line = br.readLine();
                if (line != null && line.isEmpty() != true) {
                    sudokuEntries.add(line);
                }
            } while (line != null);
        } catch (IOException ex) {
            throw ex;
        }
    }

    public List<String> getSudokuEntries() {
        return this.sudokuEntries;
    }
}
