package io.javabrains;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class NestedTestClassesTest {
    private static NestedTestClasses nestedTestClasses;
    @BeforeAll
    static void beforeAll() {
        nestedTestClasses = new NestedTestClasses();
    }

    // for testing different edge cases in divide, we write separate test cases, and put inside a nested class
    // However, in this case a better approach is the AssertAllExampleTest
    @Nested
    class TestDivide {
        @Test
        @DisplayName("Test Divide function1")
        void divide1() {
            int expected = 5;
            int actual = nestedTestClasses.divide(20, 4);
            assertEquals(expected, actual, "The add method should divide two numbers");
        }

        @Test
        @DisplayName("Test Divide function2")
        void divide2() {
            int expected = 5;
            int actual = nestedTestClasses.divide(-20, -4);
            assertEquals(expected, actual, "The add method should divide two numbers");
        }

        @Test
        @DisplayName("Test Divide function3")
        void divide3() {
            int expected = -5;
            int actual = nestedTestClasses.divide(20, -4);
            assertEquals(expected, actual, "The add method should divide two numbers");
        }

        @Test
        @DisplayName("Test Divide function4")
        void divide4() {
            int expected = -5;
            int actual = nestedTestClasses.divide(-20, 4);
            assertEquals(expected, actual, "The add method should divide two numbers");
        }

        @Test
        @DisplayName("Test Divide function5")
        void divide5() {
            assertThrows(ArithmeticException.class, () -> nestedTestClasses.divide(20, 0), "The add method should divide two numbers");
        }
    }


}