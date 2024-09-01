package com.app;

import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SameInstanceOfTest {

    StringBuilder builder = new StringBuilder();

    @AfterEach
    void afterEach() {
        System.out.println("The state of instance object is :: " + builder);
    }

    @Order(1)
    @Test
    public void testD() {
        System.out.println("Running Test D");
        builder.append(1);
    }

    @Order(2)
    @Test
    public void testA() {
        System.out.println("Running Test A");
        builder.append(2);
    }

    @Order(3)
    @Test
    public void testC() {
        System.out.println("Running Test C");
        builder.append(3);
    }

    @Order(4)
    @Test
    public void testB() {
        System.out.println("Running Test B");
        builder.append(4);
    }
}
