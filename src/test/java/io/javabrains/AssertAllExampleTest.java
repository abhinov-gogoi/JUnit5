package io.javabrains;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertAllExampleTest {
    private static AssertAllExample assertAllExample;

    @BeforeAll
    static void beforeAll() {
        assertAllExample = new AssertAllExample();
    }

    @Test
    @DisplayName("ASSERT ALL, DIVIDE")
    void divide() {
        // takes in a bunch of Executables/lambdas
        assertAll(
                ()-> assertEquals(5, assertAllExample.divide(20, 4), "This method should divide two numbers"),
                ()-> assertEquals(5, assertAllExample.divide(-20, -4),"This method should divide two numbers"),
                ()-> assertEquals(-5, assertAllExample.divide(-20, 4),"This method should divide two numbers"),
                ()-> assertEquals(-5, assertAllExample.divide(20, -4), "This method should divide two numbers"),
                ()-> assertEquals(0, assertAllExample.divide(0, 4), "This method should divide two numbers"),
                ()-> assertEquals(0, assertAllExample.divide(0, -4), "This method should divide two numbers"),
                ()-> assertThrows(ArithmeticException.class , ()-> assertAllExample.divide(20, 0),"This method should divide two numbers")
        );
    }
}