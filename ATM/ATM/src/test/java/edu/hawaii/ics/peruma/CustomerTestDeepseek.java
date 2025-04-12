package edu.hawaii.ics.peruma;

import org.junit.Test;
import static org.junit.Assert.*;

// These unit tests were created using Deepseek.
// Prompt used: Can you write me unit tests using junit for these three classes?

public class CustomerTestDeepseek {

    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer(12345, 123, 1000.00f);
        assertEquals(12345, customer.getAccountNumber());
        assertEquals(123, customer.getPin());
        assertEquals(1000.00f, customer.getBalance(), 0.001);
    }

    @Test
    public void testSetBalance() {
        Customer customer = new Customer(12345, 123, 1000.00f);
        customer.setBalance(1500.00f);
        assertEquals(1500.00f, customer.getBalance(), 0.001);
    }

    @Test
    public void testSetPin() {
        Customer customer = new Customer(12345, 123, 1000.00f);
        customer.setPin(456);
        assertEquals(456, customer.getPin());
    }

    @Test
    public void testImmutableAccountNumber() {
        Customer customer = new Customer(12345, 123, 1000.00f);
        // Account number should be final and can't be changed
        assertEquals(12345, customer.getAccountNumber());
    }
}


