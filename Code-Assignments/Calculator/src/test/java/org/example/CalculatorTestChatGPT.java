package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// These unit tests were created using ChatGPT.
// Prompt used: Can you create me unit tests using junit for this class?
public class CalculatorTestChatGPT {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        double[] nums = {1.0, 2.0, 3.0};
        assertEquals(6.0, calculator.sum(nums), 0.0001);
    }

    @Test
    public void testSubtract() {
        double[] nums = {10.0, 3.0, 2.0};
        assertEquals(5.0, calculator.subtract(nums), 0.0001);
    }

    @Test
    public void testMultiplication() {
        double[] nums = {2.0, 3.0, 4.0};
        assertEquals(24.0, calculator.Multiplication(nums), 0.0001);
    }

    @Test
    public void testDivide_Normal() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.0001);
    }

    @Test
    public void testDivide_ByZero() {
        assertEquals(Double.MIN_VALUE, calculator.divide(5.0, 0.0), 0.0001);
    }

    @Test
    public void testSquareRoot_Normal() {
        assertEquals(4.0, calculator.squareRoot(16.0), 0.0001);
    }

    @Test
    public void testSquareRoot_Negative() {
        assertEquals(Double.MIN_VALUE, calculator.squareRoot(-25.0), 0.0001);
    }

    @Test
    public void testModulo_Normal() {
        assertEquals(1.0, calculator.moduloOfTwoNum(10, 3), 0.0001);
    }

    @Test
    public void testModulo_ZeroDivisor() {
        assertEquals(Double.MIN_VALUE, calculator.moduloOfTwoNum(10, 0), 0.0001);
    }

    @Test
    public void testAverage_Normal() {
        double[] nums = {2.0, 4.0, 6.0};
        assertEquals(4.0, calculator.Average(nums), 0.0001);
    }

    @Test
    public void testAverage_EmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.Average(new double[]{});
        });
        assertEquals("Input array cannot be empty", exception.getMessage());
    }

    @Test
    public void testFactorial_Positive() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    public void testFactorial_Zero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void testFactorial_Negative() {
        assertEquals(0, calculator.factorial(-3));
    }

}