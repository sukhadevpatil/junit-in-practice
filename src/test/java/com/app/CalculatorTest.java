package com.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operation in calculator class")
class CalculatorTest {
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

    @DisplayName("Test 4/2 = 2")
    @Test
    void testDivisionIntegers() {
        int result = calculator.divisionIntegers(4, 2);
        assertEquals(2, result, "Division did not work correctly, check input values");
    }

    @DisplayName("Test 7-2 = 5")
    @Test
    void integerSubtractionTest() {
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

    @Test
    void divisionByZero() {
        int dividend = 4;
        int divisor = 0;

        String expectedExceptionMessage = "/ by zero";

        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
           calculator.divisionIntegers(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic exception");

        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }

    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
    @MethodSource
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Running Test " + minuend + "-" + subtrahend + "=" + expectedResult);

        int actualResult = calculator.integerSubtraction(minuend, subtrahend);

        assertEquals(expectedResult, actualResult, () -> minuend + "-" + subtrahend + " did not produce " + actualResult);
    }

    private static Stream<Arguments> integerSubtraction() {
        return Stream.of(
          Arguments.of(33, 1, 32),
          Arguments.of(51, 1, 50),
          Arguments.of(101, 1, 100)
        );
    }



}