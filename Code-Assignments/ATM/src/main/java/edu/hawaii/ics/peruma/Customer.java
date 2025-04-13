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

/**
 * Customer class
 */
public class Customer {
    private final int accountNumber;
    private int pin;
    private float balance;

    /**
     * @param accountNumber - account number of the customer
     * @param pin - pin of the customer
     * @param balance - balance of the customer
     */
    public Customer(int accountNumber, int pin, float balance){
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    /**
     * @return balance of the customer
     */
    public float getBalance() {
        return balance;
    }

    /**
     * @param balance - balance of the customer
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * @return account number of the customer
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return pin of the customer
     */
    public int getPin() {
        return pin;
    }

    /**
     * @param pin - pin of the customer
     */
    public void setPin(int pin) {
        this.pin = pin;
    }
}
