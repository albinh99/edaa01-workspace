package testqueue;

import queue_singlelinkedlist.FifoQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {
    public static void main(String[] args) {
        FifoQueue<Integer> a = new FifoQueue<>();
        FifoQueue<Integer> b = new FifoQueue<>();
        a.offer(2);
        a.offer(55);
        b.offer(99);
        b.offer(999);
        a.append(b);
        for(int i = 0; i<10; i++){
        System.out.println(a.iterator().next());}



    }
}
