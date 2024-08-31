package com.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class DemoMethodOrderTest {


    @Test
    public void testA() {
        System.out.println("Running Test A");
    }

    @Test
    public void testB() {
        System.out.println("Running Test B");
    }

    @Test
    public void testC() {
        System.out.println("Running Test C");
    }

    @Test
    public void testD() {
        System.out.println("Running Test D");
    }

}
