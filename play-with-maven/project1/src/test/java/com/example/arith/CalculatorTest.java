package com.example.arith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    // Arrange
    // Act
    // Assert

    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(108, result);

    }

}
