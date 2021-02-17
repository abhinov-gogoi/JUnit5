package io.javabrains;
// https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa4ad5JISViSb2FVG8Vwa4o

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD) default-> JUnit creates a new instance of the test class before running each test method
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) -> enables us to ask JUnit to create only one instance of the test class and reuse it between tests
class MathUtilsTest {
    MathUtils mathutils;

    /*   */

    @BeforeAll
    /** This is executed even before an instance of MathUtilsTest is created (So it has to be static) */
    static void beforeAllInit() {
        System.out.println("It runs only once at the very beginning");
    }

    @BeforeEach
    /** This is executed before each individual test functions are run */
    void init() {
        mathutils = new MathUtils();
    }

    @AfterEach
    /** This is executed after each individual test function is completed */
    void cleanup() {
        System.out.println("Cleaning up after each test...");
    }

    @AfterAll
    /** It is executed after at the end after every test inside THIS particular class is complete. */
    static void testsComplete() {
        System.out.println("It runs only once at the very end");
    }

    @Test
    void add() {
        int expected = 3;
        int actual = mathutils.add(1, 2);
        assertEquals(expected, actual, "The add method should add two numbers");
    }

    @Test
    void divide() {
        assertThrows( ArithmeticException.class, () -> mathutils.divide(1,0), "Divide by zero should throw");
    }

    @Test
    @DisplayName("Area Of Circle Test")
    void computeCircleArea() {
        double expected = 314.1592653589793;
        double actual = mathutils.computeCircleArea(10);
        //  due to lambda function the String message is lazily evaluated here.
        //  it is only evaluated if test fails
        //  Otherwise if we don't write lambda, it is always evaluated before assertEquals is called
        //  lazy evaluation saves resources and time if message is complex
        assertEquals(expected, actual, ()-> "The add method should give are of a circle. Expected "+expected+" but actual "+actual);
    }

    @Test
    @Disabled
    @DisplayName(" A FAILED TEST")
    void alwaysFail() {
        fail("This test will fail");
    }

    @Test
    @DisplayName("ASSUME SERVER RUNNING")
    void serverStatusTest() {
        // say we have some methods that check server status and returns the result which we then store in isServerUp
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        /*
            We are assuming isServerUp is true, If its False JUnit will not run after this line.
            as assumeTrue(false) here, code after this line wont run.
         */
        fail(); // So test won't fail
    }
}


    /**
     JUnit lifecycle hooks - BeforeAll, AfterAll, BeforeEach, AfterEach

     ---------------------------- ANNOTATIONS -------------------
     @DisplayName -> annotation is used to provide a custom name for the test class and test methods
     fail() -> deliberately marks the test as failed
     @Disabled -> disable/skip a test. It can be applied to a test method as well as on the Class itself

     ----------------------Conditional Executions----------------------
     @EnabledOnOs(OS.LINUX)
     @EnabledOnJre(JRE.JAVA_11)
     @EnabledIf
     @EnabledIfSystemProperty
     @EnabledIfEnvironmentVariable

     ----------------------Assertions & Assumptions---------------------
     assumeTrue(some_value)
     assertEquals(expected_value, actual_value, message)
     assertThrows(The Exception.class, A Lambda that throws an exception)

     */