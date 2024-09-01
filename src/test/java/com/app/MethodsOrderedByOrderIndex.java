package com.app;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndex {

    @Order(1)
    @Test
    public void testD() {
        System.out.println("Running Test D");
    }

    @Order(2)
    @Test
    public void testA() {
        System.out.println("Running Test A");
    }

    @Order(3)
    @Test
    public void testC() {
        System.out.println("Running Test C");
    }

    @Order(4)
    @Test
    public void testB() {
        System.out.println("Running Test B");
    }
}
