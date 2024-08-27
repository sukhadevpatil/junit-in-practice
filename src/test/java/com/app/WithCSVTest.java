package com.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithCSVTest {

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
    //@MethodSource
    @CsvSource({
            "33,1,32",
            "24, 1, 23",
            "54, 1, 53"
    })
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Running Test " + minuend + "-" + subtrahend + "=" + expectedResult);

        int actualResult = calculator.integerSubtraction(minuend, subtrahend);

        assertEquals(expectedResult, actualResult, () -> minuend + "-" + subtrahend + " did not produce " + actualResult);
    }

//    private static Stream<Arguments> integerSubtraction() {
//        return Stream.of(
//                Arguments.of(33, 1, 32),
//                Arguments.of(51, 1, 50),
//                Arguments.of(101, 1, 100)
//        );
//    }
}
