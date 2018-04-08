
package jp.co.worksap.global;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects.
 * 
 * @param <E>
 */
public class ImmutableQueue<E> {



	private List<E> queue = new ArrayList<E>();

	int end = -1;
	int start = -1;

	/**
	 * requires default constructor.
	 */
	public ImmutableQueue() {
			queue.clear();
		end = -1;
		start = -1;
		
	}



	private ImmutableQueue(List<E> queue,  int start, int end) {
		this.queue = queue;
		this.start = start;
		this.end = end;
	}

	/**
	 * Returns the queue that adds an item into the tail of this queue without
	 * modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
	 * this method returns a new queue (2, 1, 2, 2, 6, 4)
	 * and this object still represents the queue (2, 1, 2, 2, 6) .
	 * </pre>
	 * 
	 * If the element e is null, throws IllegalArgumentException.
	 * 
	 * @param e
	 * @return
	 * @throws IllegalArgumentException
	 */
	public ImmutableQueue<E> enqueue(E e) {
		if (e == null)
			throw new IllegalArgumentException();

		queue.add(e);
		int indexEnd = end + 1;
		int indexStart = 0;
		if (start == -1)
			indexStart = start + 1;
		else
			indexStart = start;

		return new ImmutableQueue<E>(queue,indexStart,
				indexEnd);
	}

	/**
	 * Returns the queue that removes the object at the head of this queue
	 * without modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
	 * this method returns a new queue (1, 3, 3, 5, 1)
	 * and this object still represents the queue (7, 1, 3, 3, 5, 1) .
	 * </pre>
	 * 
	 * If this queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public ImmutableQueue<E> dequeue() throws NoSuchElementException {

		if (start == -1 || end == -1 || queue.isEmpty() 
				|| start > end)
			throw new NoSuchElementException();

		// deqList.add(enqList.removeFirst());
		int indexStart = start + 1;
		return new ImmutableQueue<>(queue, indexStart, end);
	}

	/**
	 * Looks at the object which is the head of this queue without removing it
	 * from the queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1),
	 * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
	 * </pre>
	 * 
	 * If the queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public E peek() {
		if (start == -1 || end == -1 || queue.isEmpty()
				|| start > end)
			throw new NoSuchElementException();
		return queue.get(start);
	}

	/**
	 * Returns the number of objects in this queue.
	 * 
	 * @return
	 */
	public int size() {
		if (start == -1 || end == -1 || queue.isEmpty() 
				|| start > end)
			return 0;
		return end - start + 1;
	}

	public void printQueue() {
            System.out.println("");
		if (start == -1 || end == -1 || queue.isEmpty() 
				|| start > end) {
			System.out.println("Queue Empty, size:" + size());
			return;
		}
		System.out.println(" size of the Queue = " + size());
		for (int i = start; i <= end; i++) {
			System.out.print(queue.get(i) + ",");
		}
                System.out.println("");
	}
}
