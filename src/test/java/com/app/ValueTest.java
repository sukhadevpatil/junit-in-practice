package com.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ValueTest {

    @ParameterizedTest
    @ValueSource(strings = {"John", "Kate", "Alice"})
    void valueSourceDemo(String name) {
        System.out.println("Demo Test :: " + name);
        assertNotNull(name);
    }

}
