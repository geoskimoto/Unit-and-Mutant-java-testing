package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// These unit tests were created using Deepseek.
// Prompt used: Can you create me unit tests using junit for this class?
public class CalculatorTestDeepseek {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        assertEquals(10.0, calculator.sum(new double[]{1, 2, 3, 4}), 0.001);
        assertEquals(0.0, calculator.sum(new double[]{}), 0.001);
        assertEquals(-5.0, calculator.sum(new double[]{-2, -3}), 0.001);
        assertEquals(1.5, calculator.sum(new double[]{1.5}), 0.001);
    }

    @Test
    public void testSubtract() {
        assertEquals(2.0, calculator.subtract(new double[]{10, 5, 3}), 0.001);
        assertEquals(-10.0, calculator.subtract(new double[]{-5, 5}), 0.001);
        assertEquals(5.0, calculator.subtract(new double[]{5}), 0.001);
        assertEquals(0.0, calculator.subtract(new double[]{10, 5, 5}), 0.001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(24.0, calculator.Multiplication(new double[]{2, 3, 4}), 0.001);
        assertEquals(0.0, calculator.Multiplication(new double[]{5, 0}), 0.001);
        assertEquals(-6.0, calculator.Multiplication(new double[]{2, -3}), 0.001);
        assertEquals(1.0, calculator.Multiplication(new double[]{1}), 0.001);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(10, 5), 0.001);
        assertEquals(-2.0, calculator.divide(-10, 5), 0.001);
        assertEquals(Double.MIN_VALUE, calculator.divide(5, 0), 0.001);
        assertEquals(0.5, calculator.divide(1, 2), 0.001);
    }

    @Test
    public void testSquareRoot() {
        assertEquals(4.0, calculator.squareRoot(16), 0.001);
        assertEquals(0.0, calculator.squareRoot(0), 0.001);
        assertEquals(Double.MIN_VALUE, calculator.squareRoot(-4), 0.001);
        assertEquals(1.414, calculator.squareRoot(2), 0.001);
    }

    @Test
    public void testModuloOfTwoNum() {
        assertEquals(1.0, calculator.moduloOfTwoNum(10, 3), 0.001);
        assertEquals(0.0, calculator.moduloOfTwoNum(10, 5), 0.001);
        assertEquals(1.0, calculator.moduloOfTwoNum(-10, 3), 0.001);
        assertEquals(Double.MIN_VALUE, calculator.moduloOfTwoNum(5, 0), 0.001);
        assertEquals(2.0, calculator.moduloOfTwoNum(5, 3), 0.001);
    }

    @Test
    public void testAverage() {
        assertEquals(2.5, calculator.Average(new double[]{1, 2, 3, 4}), 0.001);
        assertEquals(0.0, calculator.Average(new double[]{-2, 0, 2}), 0.001);
        assertEquals(5.0, calculator.Average(new double[]{5}), 0.001);
        assertThrows(IllegalArgumentException.class, () -> calculator.Average(new double[]{}));
    }

    @Test
    public void testFactorial() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(0, calculator.factorial(-5));
        assertEquals(3628800, calculator.factorial(10));
    }
}