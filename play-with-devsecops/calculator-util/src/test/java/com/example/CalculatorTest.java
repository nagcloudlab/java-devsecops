package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    void testMultiply() {
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }

    @Test
    void testDivide() {
        double result = calculator.divide(6, 3);
        assertEquals(2, result);
    }

    @Test
    void testDivideByZero() {
        try {
            calculator.divide(6, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }

}
