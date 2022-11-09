package testqueue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue_singlelinkedlist.FifoQueue;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class TestAppendFifoQueueTest {


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

    /**
     * Test if a newly created queue is empty.
     */
    @Test
    void testNewFifoQueue() {

        assertEquals(0, Q2.size(), "Wrong size of empty queue");
    }
    @Test
    void AppendTwoEmpty(){
        Q1.append(Q2);
        assertTrue(Q1.isEmpty(), "Wrong result from empty of queue");
        assertTrue(Q2.isEmpty(), "Wrong result from empty of queue");
    }

    @Test
    void EqualAppend(){
        assertThrows(IllegalArgumentException.class,()->Q1.append(Q1));
    }
    @Test
    void FullPlusEmpty(){

        Q1.offer(1);
        Q1.offer(2);
        FifoQueue<Integer> Q3 = Q1;
        Q1.append(Q2);
        assertTrue(Q2.isEmpty(), "Wrong result from empty of queue");
        assertEquals(Q3,Q1,"asdasdasdasd");
    }

    @Test
    void EmptyPlusFull(){

        Q2.offer(1);
        Q2.offer(2);
        FifoQueue<Integer> Q3 = Q2;
        Q1.append(Q2);
        assertTrue(Q2.isEmpty(), "Wrong result from empty of queue");

        assertEquals(Q3,Q1,"asdasdasdasd");
    }



}



