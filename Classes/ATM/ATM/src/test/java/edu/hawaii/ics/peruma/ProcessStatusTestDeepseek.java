package edu.hawaii.ics.peruma;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

// These unit tests were created using Deepseek.
// Prompt used: Can you write me unit tests using junit for these three classes?

public class ProcessStatusTestDeepseek{
    @Test
    public void testProcessStatusCreation() {
        ProcessStatus status = new ProcessStatus(true, ProcessStatus.ProcessMessage.SUCCESS);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
    }

    @Test
    public void testAllProcessMessages() {
        for (ProcessStatus.ProcessMessage message : ProcessStatus.ProcessMessage.values()) {
            ProcessStatus status = new ProcessStatus(true, message);
            assertEquals(message, status.getMessage());
        }
    }

    @Test
    public void testFailedStatus() {
        ProcessStatus status = new ProcessStatus(false, ProcessStatus.ProcessMessage.FAILED);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.FAILED, status.getMessage());
    }
}

