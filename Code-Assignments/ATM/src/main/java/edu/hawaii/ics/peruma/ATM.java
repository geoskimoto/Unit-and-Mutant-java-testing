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

import java.util.List;
import java.util.Optional;

/**
 * The ATM class is used to simulate an automated teller machine.
 * It contains methods to verify a customer, get a customer's balance, deposit money, withdraw money,
 * change a customer's PIN, and transfer money from one account to another.
 */
public class ATM {

    List<Customer> customers;


    /**
     * @param customers - list of customers
     */
    public ATM(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * This method is used to verify a customer based on the account number and PIN
     * @param accountNumber - account number of the customer who is being verified
     * @param pin - pin of the customer who is being verified
     * @return true if the customer is valid, false otherwise
     */
    public boolean verifyCustomer(int accountNumber, int pin) {
        Optional<Customer> customer = customers.stream().filter(c -> c.getAccountNumber() == accountNumber && c.getPin() == pin).findFirst();
        return customer.isPresent();
    }

    /**
     * This method obtains the balance of a customers account
     * @param accountNumber - account number of the customer who is checking their balance
     * @param pin - pin of the customer who is checking their balance
     * @return the balance of the customer
     * @throws Exception - if the customer is not valid
     */
    public float getCustomerBalance(int accountNumber, int pin) throws Exception {
        if (verifyCustomer(accountNumber, pin)) {
            Optional<Customer> customer = customers.stream().filter(c -> c.getAccountNumber() == accountNumber && c.getPin() == pin).findFirst();
            return customer.get().getBalance();
        } else {
            throw new Exception("Invalid Customer");
        }
    }

    /**
     * This method is used to deposit a specific amount of money into the specified account
     * @param accountNumber - account number of the customer who is depositing money
     * @param pin - pin of the customer who is depositing money
     * @param amount - amount of money to deposit
     * @return true if the deposit was successful, false otherwise
     */
    public ProcessStatus depositMoney(int accountNumber, int pin, float amount)  {
        if (amount <= 0.0f)
            return new ProcessStatus(false, ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS);

        if (verifyCustomer(accountNumber, pin)) {
            Optional<Customer> customer = customers.stream().filter(c -> c.getAccountNumber() == accountNumber && c.getPin() == pin).findFirst();
            float currentBalance = customer.get().getBalance();
            customer.get().setBalance(currentBalance + amount);
            return new ProcessStatus(true, ProcessStatus.ProcessMessage.SUCCESS);
        } else {
            return new ProcessStatus(false, ProcessStatus.ProcessMessage.INVALID_ACCOUNT);
        }
    }

    /**
     * This method is used to withdraw a specific amount of money from the specified account
     * @param accountNumber - account number of the customer who is withdrawing money
     * @param pin - pin of the customer who is withdrawing money
     * @param amount - amount of money to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public ProcessStatus withdrawMoney(int accountNumber, int pin, float amount) {
        if (verifyCustomer(accountNumber, pin)) {
            Optional<Customer> customer = customers.stream().filter(c -> c.getAccountNumber() == accountNumber && c.getPin() == pin).findFirst();
            float currentBalance = customer.get().getBalance();
            float newBalance = currentBalance - amount;
            if (newBalance >= 0.0f) {
                customer.get().setBalance(newBalance);
                return new ProcessStatus(true, ProcessStatus.ProcessMessage.SUCCESS);
            } else {
                return new ProcessStatus(false, ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS);
            }
        } else {
            return new ProcessStatus(false, ProcessStatus.ProcessMessage.INVALID_ACCOUNT);
        }
    }


    /**
     * This method is used to change the PIN of a customer
     * @param accountNumber - account number of the customer who is transferring money
     * @param oldPIN - old pin of the customer who is transferring money
     * @param newPIN - new pin of the customer who is transferring money
     * @return true if the pin change was successful, false otherwise
     */
    public ProcessStatus changePIN(int accountNumber, int oldPIN, int newPIN)  {
        if (verifyCustomer(accountNumber, oldPIN)) {
            if (oldPIN == newPIN)
                return new ProcessStatus(false, ProcessStatus.ProcessMessage.FAILED);
            if (!(100 <= newPIN && newPIN <= 999))
                return new ProcessStatus(false, ProcessStatus.ProcessMessage.FAILED);
            Optional<Customer> customer = customers.stream().filter(c -> c.getAccountNumber() == accountNumber && c.getPin() == oldPIN).findFirst();
            customer.get().setPin(newPIN);
            return new ProcessStatus(true, ProcessStatus.ProcessMessage.SUCCESS);
        }
        else {
            return new ProcessStatus(false, ProcessStatus.ProcessMessage.INVALID_ACCOUNT);
        }
    }

    /**
     * This method transfers funds from one account to another
     * @param originAccountNumber - account number of the customer who is transferring funds
     * @param destinationAccountNumber - account number of the customer who is receiving funds
     * @param pin - pin of the customer who is transferring funds
     * @param amount -  amount of money to transfer
     * @return true if the transfer was successful, false otherwise
     */
    public ProcessStatus transferFunds(int originAccountNumber, int destinationAccountNumber, int pin, float amount) {
        if (verifyCustomer(originAccountNumber, pin)) {
            ProcessStatus withdrawStatus = withdrawMoney(originAccountNumber, pin, amount);
            if (withdrawStatus.isSuccess()) {
                depositMoney(destinationAccountNumber, pin, amount);
                return new ProcessStatus(true, ProcessStatus.ProcessMessage.SUCCESS);
            } else {
                return withdrawStatus;
            }
        } else {
            return new ProcessStatus(false, ProcessStatus.ProcessMessage.INVALID_ACCOUNT);
        }
    }

}
