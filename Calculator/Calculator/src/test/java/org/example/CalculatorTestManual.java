package org.example;

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
        assertEquals(6.0, calculator.sum(new double[]{1.0,2.0,3.0}), 0.0001);
        assertEquals(-3, calculator.sum(new double[]{-7,6,-2}));
    }

    @Test
    public void testSubtract() {
        ;
        assertEquals(2.5, calculator.subtract(new double[]{10.0, 5.0, 2.5}), 0.0001);
        assertEquals(-12.5, calculator.subtract(new double[]{-10.0, -5.0, 2.5}), 0.0001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(3.0, calculator.Multiplication(new double[]{1, 2, 3, .5}), 0.0001);
        assertEquals(25, calculator.Multiplication(new double[]{-5,-5}), 0.0001);
        assertEquals(0, calculator.divide(1, 0)
        );
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calculator.divide(5,2), 0.0001);
        assertEquals(10, calculator.divide(100,10), 0.0001);
        assertEquals(-5, calculator.divide(-10,2), 0.0001);
    }

    @Test
    public void testSquareRoot() {
        assertEquals(5, calculator.squareRoot(25), 0.0001);
        assertEquals(Double.MIN_VALUE, calculator.squareRoot(-25.0), 0.0001);
        assertEquals(2.65, calculator.squareRoot(7), 0.0001);


    }

    @Test
    public void testModulo() {
        assertEquals(1.0, calculator.moduloOfTwoNum(10, 3), 0.0001);
        assertEquals(1.0, calculator.moduloOfTwoNum(-10, 3), 0.0001);
        assertEquals(1.0, calculator.moduloOfTwoNum(10, -3), 0.0001);
        assertEquals(Double.MIN_VALUE, calculator.moduloOfTwoNum(5, 0), 0.0001);
    };

    @Test
    public void testAverage() {
        assertEquals(10.0, calculator.Average(new double[]{16, 83, 1}), 0.0001);
        assertEquals(4.0, calculator.Average(new double[]{16, -4, 0}), 0.0001);
        assertEquals(-5, calculator.Average(new double[]{-12,-3,-1, -4, -5}), 0.0001);
    }



    @Test
    public void testFactorial() {

        assertEquals(24, calculator.factorial(4));
        assertEquals(1, calculator.factorial(0));
        assertEquals(0, calculator.factorial(-1));
    }

}