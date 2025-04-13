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
 *This class represents the status of an operation in the ATM
 */
public class ProcessStatus {
    private boolean isSuccess;
    private ProcessMessage message;

    /**
     * @param isSuccess - true if the process was successful, false otherwise
     * @param message - message of the process
     */
    public ProcessStatus(boolean isSuccess, ProcessMessage message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    /**
     * @return true if the process was successful, false otherwise
     */
    public boolean isSuccess() {
        return isSuccess;
    }


    /**
     * @return message of the process
     */
    public ProcessMessage getMessage() {
        return message;
    }

    /**
     * Enum for the process message
     */
    public enum ProcessMessage {
    SUCCESS, INSUFFICIENT_FUNDS, INVALID_ACCOUNT, FAILED
    }
}
