package com.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DemoRepeatedTest {

    @DisplayName("Test 7-2 = 5")
    @RepeatedTest(3)
    void integerSubtractionTest(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition # " + repetitionInfo.getCurrentRepetition()
                + " of total :: " + repetitionInfo.getTotalRepetitions());
        int minuend = 7;
        int subtrahend = 2;
        int expectedResult = 5;
        Calculator calculator = new Calculator();
        int actualResult = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, actualResult, () -> minuend + "-" + subtrahend + " did not produce result = " + expectedResult);
    }

}
