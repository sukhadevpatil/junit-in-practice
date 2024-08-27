package com.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithCSVFileTest {

    static Calculator calculator;
    @BeforeEach
    void beforeEachTestMethod() {
        System.out.println("Executing beforeEach method");
        calculator = new Calculator();
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing AfterEach method");
        calculator = null;
    }

    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Running Test " + minuend + "-" + subtrahend + "=" + expectedResult);

        int actualResult = calculator.integerSubtraction(minuend, subtrahend);

        assertEquals(expectedResult, actualResult, () -> minuend + "-" + subtrahend + " did not produce " + actualResult);
    }

}
