package com.app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operation in calculator class")
class CalculatorTest {

    @DisplayName("Test 4/2 = 2")
    @Test
    void testDivisionIntegers() {
        Calculator calculator = new Calculator();
        int result = calculator.divisionIntegers(4, 2);
        assertEquals(2, result, "Division did not work correctly, check input values");
    }

    @DisplayName("Test 7-2 = 5")
    @Test
    void integerSubtraction() {
        int minuend = 7;
        int subtrahend = 2;
        int expectedResult = 5;
        Calculator calculator = new Calculator();
        int actualResult = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, actualResult, () -> minuend + "-" + subtrahend + " did not produce result = " + expectedResult);
    }

    @Disabled("TODO : Need to work on it")       //This disables the test execution
    @DisplayName("Division by zero")
    @Test
    void testDivideByZero() {
        fail("not implemented yet");
    }
}