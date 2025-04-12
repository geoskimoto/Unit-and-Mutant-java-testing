package edu.hawaii.ics.peruma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// These unit tests were created using ChatGPT.
// Prompt used: Can you write me unit tests using junit for these three classes?

public class ProcessStatusTestChatGPT {

    @Test
    public void testSuccessStatus() {
        ProcessStatus status = new ProcessStatus(true, ProcessStatus.ProcessMessage.SUCCESS);
        assertTrue(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
    }

    @Test
    public void testFailureStatus() {
        ProcessStatus status = new ProcessStatus(false, ProcessStatus.ProcessMessage.FAILED);
        assertFalse(status.isSuccess());
        assertEquals(ProcessStatus.ProcessMessage.FAILED, status.getMessage());
    }
}

