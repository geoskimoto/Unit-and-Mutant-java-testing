package edu.hawaii.ics.peruma;
import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

// These unit tests were created using Deepseek.
// Prompt used: Can you write me unit tests using junit for these three classes?

public class ATMTestDeepseek {

    private ATM atm;
    private Customer customer1;
    private Customer customer2;

    @Before
    public void setUp() {
        customer1 = new Customer(12345, 123, 1000.00f);
        customer2 = new Customer(67890, 456, 500.00f);
        List<Customer> customers = Arrays.asList(customer1, customer2);
        atm = new ATM(customers);
        System.out.println("ATM initialized: " + atm);
    }

    @Test
    public void testVerifyCustomerSuccess() {
        assertTrue(atm.verifyCustomer(12345, 123));
        assertTrue(atm.verifyCustomer(67890, 456));
    }

    @Test
    public void testVerifyCustomerFailure() {
        assertFalse(atm.verifyCustomer(99999, 123)); // Wrong account
        assertFalse(atm.verifyCustomer(12345, 999)); // Wrong PIN
        assertFalse(atm.verifyCustomer(99999, 999)); // Both wrong
    }

    @Test
    public void testGetCustomerBalanceSuccess() throws Exception {
        assertEquals(1000.00f, atm.getCustomerBalance(12345, 123), 0.001);
        assertEquals(500.00f, atm.getCustomerBalance(67890, 456), 0.001);
    }

    @Test
    public void testGetCustomerBalanceFailure() {
        assertThrows(Exception.class, () -> atm.getCustomerBalance(99999, 123));
    }

    @Test
    public void testDepositMoneySuccess() {
        ProcessStatus status = atm.depositMoney(12345, 123, 200.00f);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
        assertEquals(1200.00f, customer1.getBalance(), 0.001);
    }

    @Test
    public void testDepositMoneyInvalidAccount() {
        ProcessStatus status = atm.depositMoney(99999, 123, 200.00f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());
    }

    @Test
    public void testDepositMoneyInvalidAmount() {
        ProcessStatus status = atm.depositMoney(12345, 123, -100.00f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());
    }

    @Test
    public void testWithdrawMoneySuccess() {
        ProcessStatus status = atm.withdrawMoney(12345, 123, 200.00f);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
        assertEquals(800.00f, customer1.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawMoneyInsufficientFunds() {
        ProcessStatus status = atm.withdrawMoney(12345, 123, 2000.00f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());
        assertEquals(1000.00f, customer1.getBalance(), 0.001); // Balance unchanged
    }

    @Test
    public void testChangePINSuccess() {
        ProcessStatus status = atm.changePIN(12345, 123, 789);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
        assertEquals(789, customer1.getPin());
    }

    @Test
    public void testChangePINSamePIN() {
        ProcessStatus status = atm.changePIN(12345, 123, 123);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.FAILED, status.getMessage());
        assertEquals(123, customer1.getPin()); // PIN unchanged
    }

    @Test
    public void testChangePINInvalidNewPIN() {
        ProcessStatus status = atm.changePIN(12345, 123, 99); // Too low
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.FAILED, status.getMessage());

        status = atm.changePIN(12345, 123, 1000); // Too high
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.FAILED, status.getMessage());
    }

//    @Test
//    public void testTransferFundsSuccess() {
//        ProcessStatus status = atm.transferFunds(12345, 67890, 123, 200.00f);
//        assertTrue(status.isSuccess());
//        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
//        assertEquals(800.00f, customer1.getBalance(), 0.001);
//        assertEquals(700.00f, customer2.getBalance(), 0.001);
//    }

    @Test
    public void testTransferFundsInsufficientFunds() {
        ProcessStatus status = atm.transferFunds(12345, 67890, 123, 2000.00f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());
        assertEquals(1000.00f, customer1.getBalance(), 0.001); // Balances unchanged
        assertEquals(500.00f, customer2.getBalance(), 0.001);
    }

    @Test
    public void testTransferFundsInvalidAccount() {
        ProcessStatus status = atm.transferFunds(99999, 67890, 123, 200.00f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());
    }
}
