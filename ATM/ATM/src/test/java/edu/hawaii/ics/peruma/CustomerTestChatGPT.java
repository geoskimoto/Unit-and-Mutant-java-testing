package edu.hawaii.ics.peruma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// These unit tests were created using ChatGPT.
// Prompt used: Can you write me unit tests using junit for these three classes?

public class CustomerTestChatGPT {

    @Test
    public void testCustomerConstructorAndGetters() {
        Customer customer = new Customer(1234, 111, 500.0f);
        assertEquals(1234, customer.getAccountNumber());
        assertEquals(111, customer.getPin());
        assertEquals(500.0f, customer.getBalance());
    }

    @Test
    public void testSetBalance() {
        Customer customer = new Customer(1234, 111, 500.0f);
        customer.setBalance(600.0f);
        assertEquals(600.0f, customer.getBalance());
    }

    @Test
    public void testSetPin() {
        Customer customer = new Customer(1234, 111, 500.0f);
        customer.setPin(222);
        assertEquals(222, customer.getPin());
    }
}

