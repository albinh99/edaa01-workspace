package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {

		QueueNode<E> n = new QueueNode<>(e);
		if (last == null){
			last = n;
			last.next = last;
			//System.out.println("last: " + last.element);
		}
		else{
		n.next = last.next;
		last.next = n;
		last = n;
		}
		size ++;
		//System.out.println("lastttt: " + last.element);
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (size == 0)
		{
			return null;
		}
		return last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {

		if (last == null){
			//System.out.println("jag körs");
			return null;
		}
		E temp = last.next.element;
		QueueNode<E> p = last;
		if (size == 1){
			size --;
			last = null;
			return temp;
		}

		last.next = last.next.next;
		size --;
		/*
		for (int i = 1 ; i < size-1; i ++)
		{
			p = p.next;
		}
		size --;
		last = p;
		System.out.println("nu jag");

		 */
		return temp;
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {

		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private int counter;
		private QueueIterator() {
			counter = 0;
			pos = last;
		}
		public boolean hasNext() {
			if (counter < size-1){
				counter ++;
				return true;
			}
			return false;
		}
		public E next() {
			if (!hasNext()){
				 throw new NoSuchElementException();
			}
			pos = pos.next;
			System.out.println("här");
			return pos.element;
		}
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
