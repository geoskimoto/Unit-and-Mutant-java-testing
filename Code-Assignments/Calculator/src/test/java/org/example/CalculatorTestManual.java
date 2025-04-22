package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Manually created unit tests

public class CalculatorTestManual {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        assertEquals(6.0, calculator.sum(new double[]{1.0, 2.0, 3.0}), 0.0001);
        assertEquals(-3.0, calculator.sum(new double[]{-7, 6, -2}), 0.0001);
    }

    @Test
    public void testSubtract() {
        assertEquals(2.5, calculator.subtract(new double[]{10.0, 5.0, 2.5}), 0.0001);
        assertEquals(-7.5, calculator.subtract(new double[]{-10.0, -5.0, 2.5}), 0.0001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(3.0, calculator.Multiplication(new double[]{1, 2, 3, 0.5}), 0.0001);
        assertEquals(25.0, calculator.Multiplication(new double[]{-5, -5}), 0.0001);
        assertEquals(0.0, calculator.divide(1, 0), 0.0001);  // assuming divide by zero returns 0.0 here
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        assertEquals(10.0, calculator.divide(100, 10), 0.0001);
        assertEquals(-5.0, calculator.divide(-10, 2), 0.0001);
    }

    @Test
    public void testSquareRoot() {
        assertEquals(5.0, calculator.squareRoot(25), 0.0001);
        assertEquals(Double.MIN_VALUE, calculator.squareRoot(-25.0), 0.0001);
        assertEquals(2.6458, calculator.squareRoot(7), 0.0001);  // sqrt(7) ≈ 2.6458
    }

}