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
        System.out.println("EmptyPlusEmpty: Q1: " + Q1 + " Q2: " + Q2);
    }

    @Test
    void EqualAppend(){
        assertThrows(IllegalArgumentException.class,()->Q1.append(Q1));
        Q1.offer(2);
        Q2.offer(4);
    }
    @Test
    void FullPlusEmpty(){

        Q1.offer(1);
        Q1.offer(2);
        Q1.append(Q2);
        assertTrue(Q2.isEmpty(), "Wrong result from empty of queue");
        assertEquals(2,Q1.size(),"asdasdasdasd");
        System.out.println("FullPlusEmpty : Q1: " + Q1 + " Q2: " + Q2);
    }

    @Test
    void EmptyPlusFull(){

        Q2.offer(1);
        Q2.offer(2);
        Q1.append(Q2);
        System.out.println(Q1);
        assertTrue(Q2.isEmpty(), "Wrong result from empty of queue");
        System.out.println("EmptyPlusFull: Q1: " + Q1 + " Q2: " + Q2);
        assertEquals(2,Q1.size(),"asdasdasdasd");
    }

    @Test
    void FullPlusFull(){

        Q2.offer(1);
        Q2.offer(2);
        Q1.offer(56);
        Q1.offer(9999);
        Q1.append(Q2);
        assertTrue(Q2.isEmpty(), "Wrong result from empty of queue");
        System.out.println("FullPlusFull : Q1: " + Q1 + " Q2: " + Q2);
        assertEquals(4,Q1.size(),"asdasdasdasd");
    }



}



