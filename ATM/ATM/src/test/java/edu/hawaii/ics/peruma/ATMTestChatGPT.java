package edu.hawaii.ics.peruma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// These unit tests were created using ChatGPT.
// Prompt used: Can you write me unit tests using junit for these three classes?

public class ATMTestChatGPT {

    private ATM atm;
    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    public void setUp() {
        customer1 = new Customer(1234, 111, 500.0f);
        customer2 = new Customer(5678, 222, 1000.0f);
        List<Customer> customers = Arrays.asList(customer1, customer2);
        atm = new ATM(customers);
    }

    @Test
    public void testVerifyCustomer_Valid() {
        assertTrue(atm.verifyCustomer(1234, 111));
    }

    @Test
    public void testVerifyCustomer_Invalid() {
        assertFalse(atm.verifyCustomer(1234, 999));
    }

    @Test
    public void testGetCustomerBalance_Valid() throws Exception {
        assertEquals(500.0f, atm.getCustomerBalance(1234, 111));
    }

    @Test
    public void testGetCustomerBalance_InvalidCustomer() {
        assertThrows(Exception.class, () -> atm.getCustomerBalance(1234, 999));
    }

    @Test
    public void testDepositMoney_Valid() {
        ProcessStatus status = atm.depositMoney(1234, 111, 100.0f);
        assertTrue(status.isSuccess());
        assertEquals(600.0f, customer1.getBalance());
    }

    @Test
    public void testDepositMoney_InvalidCustomer() {
        ProcessStatus status = atm.depositMoney(9999, 111, 100.0f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());
    }

    @Test
    public void testDepositMoney_NegativeAmount() {
        ProcessStatus status = atm.depositMoney(1234, 111, -50.0f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());
    }

    @Test
    public void testWithdrawMoney_Valid() {
        ProcessStatus status = atm.withdrawMoney(1234, 111, 200.0f);
        assertTrue(status.isSuccess());
        assertEquals(300.0f, customer1.getBalance());
    }

    @Test
    public void testWithdrawMoney_InsufficientFunds() {
        ProcessStatus status = atm.withdrawMoney(1234, 111, 1000.0f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());
    }

    @Test
    public void testWithdrawMoney_InvalidCustomer() {
        ProcessStatus status = atm.withdrawMoney(9999, 111, 50.0f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());
    }

    @Test
    public void testChangePIN_Valid() {
        ProcessStatus status = atm.changePIN(1234, 111, 222);
        assertTrue(status.isSuccess());
        assertEquals(222, customer1.getPin());
    }

    @Test
    public void testChangePIN_InvalidCustomer() {
        ProcessStatus status = atm.changePIN(1234, 999, 222);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());
    }

    @Test
    public void testChangePIN_SameAsOldPIN() {
        ProcessStatus status = atm.changePIN(1234, 111, 111);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.FAILED, status.getMessage());
    }

    @Test
    public void testChangePIN_InvalidNewPIN() {
        ProcessStatus status = atm.changePIN(1234, 111, 99); // Less than 100
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.FAILED, status.getMessage());
    }

    @Test
    public void testTransferFunds_Valid() {
        ProcessStatus status = atm.transferFunds(1234, 5678, 111, 100.0f);
        assertTrue(status.isSuccess());
        assertEquals(400.0f, customer1.getBalance());
        assertEquals(1100.0f, customer2.getBalance());
    }

    @Test
    public void testTransferFunds_InvalidOriginAccount() {
        ProcessStatus status = atm.transferFunds(9999, 5678, 111, 100.0f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());
    }

    @Test
    public void testTransferFunds_InsufficientFunds() {
        ProcessStatus status = atm.transferFunds(1234, 5678, 111, 1000.0f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());
    }
}
