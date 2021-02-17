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
    @DisplayName("Divide method")
    class TestDivide {
        // refer to the message convention inside nested class
        @Test
        @DisplayName("when dividing positive number with a positive number")
        void divide1() {
            int expected = 5;
            int actual = nestedTestClasses.divide(20, 4);
            assertEquals(expected, actual, "should return a correct positive number");
        }

        @Test
        @DisplayName("when dividing negative number with a negative number")
        void divide2() {
            int expected = 5;
            int actual = nestedTestClasses.divide(-20, -4);
            assertEquals(expected, actual, "should return a correct positive number");
        }

        @Test
        @DisplayName("when dividing positive number with a negative number")
        void divide3() {
            int expected = -5;
            int actual = nestedTestClasses.divide(20, -4);
            assertEquals(expected, actual, "should return a correct negative number");
        }

        @Test
        @DisplayName("when dividing negative number with a positive number")
        void divide4() {
            int expected = -5;
            int actual = nestedTestClasses.divide(-20, 4);
            assertEquals(expected, actual, "should return a correct negative number");
        }

        @Test
        @DisplayName("when dividing a number with a zero")
        void divide5() {
            assertThrows(ArithmeticException.class, () -> nestedTestClasses.divide(20, 0), "should throw exception");
        }
    }


}