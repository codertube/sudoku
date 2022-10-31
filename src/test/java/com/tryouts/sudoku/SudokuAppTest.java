package com.tryouts.sudoku;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;

public class SudokuAppTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testInitializeValidInput() throws SudokuException {
    String arr[] = {
        "534678912",
        "672195348",
        "198342567",
        "859761423",
        "426853791",
        "713924856",
        "961537284",
        "287419635",
        "345286179"
    };
    List<String> list = Arrays.asList(arr);
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
  }

  @Test
  void testInitializeEmptyInput() {
    String arr[] = {};
    List<String> list = Arrays.asList(arr);
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> new SudokuMatrix().initialize(list),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_INVALID_FORMAT_ERROR));
  }

  @Test
  void testInitializeNullInput() {
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> new SudokuMatrix().initialize(null),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_INVALID_FORMAT_ERROR));
  }

  @Test
  void testInitializeOversizedList() {
    String arr[] = {
        "534672198",
        "678195342",
        "912348567",
        "859426713",
        "761853924",
        "423791856",
        "961287345",
        "537419286",
        "284635179",
        "284635179"
    };
    List<String> list = Arrays.asList(arr);
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> new SudokuMatrix().initialize(list),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_INVALID_FORMAT_ERROR));
  }

  @Test
  void testInitializeUndersizedList() {
    String arr[] = {
        "534672198",
        "678195342",
        "912348567",
        "859426713",
        "761853924",
        "423791856",
        "961287345",
        "537419286"
    };
    List<String> list = Arrays.asList(arr);
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> new SudokuMatrix().initialize(list),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_INVALID_FORMAT_ERROR));
  }

  @Test
  void testInitializeOversizedLine() {
    String arr[] = {
        "5346721982",
        "678195342",
        "912348567",
        "859426713",
        "761853924",
        "423791856",
        "961287345",
        "537419286",
        "284635179"
    };
    List<String> list = Arrays.asList(arr);
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> new SudokuMatrix().initialize(list),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_INVALID_LINE_ERROR));
  }

  @Test
  void testInitializeUndersizedLine() {
    List<String> list = new ArrayList<>();

    String arr[] = {
        "53467219",
        "678195342",
        "912348567",
        "859426713",
        "761853924",
        "423791856",
        "961287345",
        "537419286",
        "284635179"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> new SudokuMatrix().initialize(list),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_INVALID_LINE_ERROR));
  }

  @Test
  void testInitializeInvalidValue() {
    String arr[] = {
            "534672198",
            "678195342",
            "912348567",
            "85942-1713",
            "761853924",
            "423791856",
            "961287345",
            "537419286",
            "284635179"
    };
    List<String> list = Arrays.asList(arr);
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> new SudokuMatrix().initialize(list),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_INVALID_LINE_ERROR));
  }

  @Test
  void testInitializeSpecialChar() {
    String arr[] = {
            "534672198",
            "678195342",
            "912348567",
            "85942&713",
            "761853924",
            "423791856",
            "961287345",
            "537419286",
            "284635179"
    };
    List<String> list = Arrays.asList(arr);
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> new SudokuMatrix().initialize(list),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_INVALID_FORMAT_ERROR));
  }

  @Test
  void testInitializeValidateRows() throws SudokuException {
    String arr[] = {
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789"
    };
    List<String> list = Arrays.asList(arr);
    SudokuMatrix s = new SudokuMatrix();
    s.initialize(list);
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> s.isValidSudoku(),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_VALIDATION_ERROR));
  }

  @Test
  void testValidateGoodSudoku() throws SudokuException {
    String arr[] = {
        "534678912",
        "672195348",
        "198342567",
        "859761423",
        "426853791",
        "713924856",
        "961537284",
        "287419635",
        "345286179"
    };
    List<String> list = Arrays.asList(arr);
    SudokuMatrix s = new SudokuMatrix();
    s.initialize(list);
    assertTrue(s.isValidSudoku());
  }

  @Test
  void testValidateBadSudoku() throws SudokuException {
    String arr[] = {
        "534678912",
        "672195348",
        "198342567",
        "859761423",
        "426853791",
        "713924856",
        "961537254",
        "287419635",
        "345286179"
    };
    List<String> list = Arrays.asList(arr);
    SudokuMatrix s = new SudokuMatrix();
    s.initialize(list);
    Exception exception = Assertions.assertThrows(SudokuException.class, () -> s.isValidSudoku(),
            "SudokuException was expected");
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(SudokuMatrix.SUDOKU_VALIDATION_ERROR));
  }

}
