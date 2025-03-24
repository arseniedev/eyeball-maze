// from http://www.vogella.com/tutorials/JUnit/article.html
package org.example;
//package com.vogella.junit.first;
//
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    public Calculator calculator;

    @BeforeAll
    static void setup() {
        // Initialize connection to file.
        System.out.println("@BeforeAll - Execute once before all test methods in this class.");
    }

    @AfterAll
    static void done() {
        // Closes connection to the file
        System.out.println("@AfterAll - This method is called after all test methods.");
    }

    @BeforeEach
    void init() {
        // Insert some sample data before each test
        System.out.println("@BeforeEach - Executed before each test method in this class.");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        // Reset the file content.
        System.out.println("@AfterEach - This method is called after each test method.");
    }

    @DisplayName("Test expects Exception")
    @Test
    public void testExceptionIsThrown() {
        // arrange
        final String EXPECTED_MESSAGE = "X should be less than 1000";

        // act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.multiply(1000, 5));
        final String ACTUAL_MESSAGE = exception.getMessage();

        // assert
        assertTrue(ACTUAL_MESSAGE.contains(EXPECTED_MESSAGE));
    }

    @Test
    public void testMultiply() {
		/*
		assertEquals(50, calculator.multiply(10, 5), "10 x 5 must be 50");
		*/

        // arrange
        final int EXPECTED = 50;
        final String ERROR_MESSAGE = "10 x 5 must be 50";
        final int VALUE1 = 10;
        final int VALUE2 = 5;

        // act
        int actual = calculator.multiply(VALUE1, VALUE2);

        // assert
        assertEquals(EXPECTED, actual, ERROR_MESSAGE);
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        final String message = "Multiple with zero should be zero";
        final int expected = 0;
        final int a = 0, b = 5;

        int actual = calculator.multiply(a, b);
        assertEquals(expected, actual, message);

        actual = calculator.multiply(b, a);
        assertEquals(expected, actual, message);
    }
}














