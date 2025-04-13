//*******************************************************************
//  __description__ = "Assignment 01 - Unit Testing"
//  __course__ = "ics615"
//  __organization__ = "Information and Computer Sciences Department, University of Hawai‘i at Mānoa"
//  __author__ = "Anthony Peruma"
//  __email__ = "peruma@hawaii.edu"
//  __web__ = "https://www.peruma.me"
//  __version__ = "1.0"
//  __created__ = "2022-08-01"
//  __modified__ = "2023-03-01"
//  __maintainer__ = "Anthony Peruma"
//*******************************************************************
package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
public class ATMTestManual {

    private ATM atm;
    private Customer customer1;
    private Customer customer2;

    @Before
    public void setUp() {
        customer1 = new Customer(12345, 123, 1000.00f);
        customer2 = new Customer(67890, 456, 500.00f);
        List<Customer> customers = Arrays.asList(customer1, customer2);
        atm = new ATM(customers);
//        System.out.println("ATM initialized: " + atm.customers);


    }

    @Test
    public void testVerifyCustomers(){
        assertTrue(atm.verifyCustomer(12345, 123));
        assertFalse((atm.verifyCustomer(54321, 321)));
        assertFalse(atm.verifyCustomer(-12345, 123));
        assertFalse(atm.verifyCustomer(12345, -123));

    }

    @Test
    public void testgetCustomerBalance() throws Exception {
        assertEquals(1000.00f, atm.getCustomerBalance(12345, 123));
        assertThrows(Exception.class, () -> atm.getCustomerBalance(54321, 321));
    }

    @Test
    public void testDepositMoney() {
        ProcessStatus status = atm.depositMoney(12345, 123, 1.00f);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
        assertEquals(1001.00f, customer1.getBalance(), 0.001);

        // depositing neg amt
        status = atm.depositMoney(12345, 123, -1.00f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());

        // depositing in non-existent acct
        ProcessStatus status2 = atm.depositMoney(54321, 321, 1.00f);
        assertFalse(status2.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());
    }

    @Test
    public void testWithdrawMoney() {
        ProcessStatus status = atm.withdrawMoney(12345, 123, 200.00f);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
        assertEquals(800.00f, customer1.getBalance(), 0.001);

        //  insufficient funds
        status = atm.withdrawMoney(12345, 123, 10000000.00f);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());
        assertEquals(1001.00f, customer1.getBalance(), 0.001);
    }

    @Test
    public void testChangePIN(){
        ProcessStatus status = atm.changePIN(12345, 123, 321);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
        assertEquals(321, customer1.getPin());
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());

        // invalid pin change
        ProcessStatus status2 = atm.changePIN(12345, 123, 12);
        assertFalse(status2.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.FAILED, status.getMessage());
    }

    @Test
    public void testTransferFunds() {
        ProcessStatus status = atm.transferFunds(12345, 67890, 321, 100.00f);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());

        //withdraw more than balance
        ProcessStatus status2 = atm.transferFunds(12345, 67890, 321, -10000.00f);
        assertFalse(status2.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());

        //invalid acct
        ProcessStatus status3 = atm.transferFunds(54321, 67890, 321, 100.00f);
        assertFalse(status3.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());

    }


}