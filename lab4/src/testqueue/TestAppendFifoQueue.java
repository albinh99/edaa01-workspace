package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import queue_singlelinkedlist.FifoQueue;

import java.util.Queue;

class TestAppendFifoQueue {
    private FifoQueue<Integer> Q1;
    private FifoQueue<Integer> Q2;

    @BeforeEach
    void setUp() {
        Q1 = new FifoQueue<Integer>();
        Q2 = new FifoQueue<Integer>();
    }

    @AfterEach
    void tearDown(){
        Q1 = null;
        Q2 = null;
    }

    @Test
    void AppendEmpty(){
        Q1.append(Q2);
        assertEquals(null, Q1, "Poll of empty queue should return null") ;
        assertEquals(null, Q2, "Poll of empty queue should return null") ;

    }
}
