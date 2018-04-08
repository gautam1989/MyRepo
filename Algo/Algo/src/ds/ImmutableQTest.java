/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;



public class ImmutableQTest {

	public static void main(String[] args) {

		ImmutableQueue<Integer> iq = new ImmutableQueue<>();
		ImmutableQueue<Integer> iq1 = iq.enqueue(55);
		// System.out.println(iq.peek());
                
		iq.printQueue();
		iq1.printQueue();
                iq.printQueue();
		System.out.println("peek" + iq1.peek());
		ImmutableQueue<Integer> iq2 = iq1.dequeue();
		iq1.printQueue();
		iq2.printQueue();
		ImmutableQueue<Integer> iq3 = iq2.enqueue(56);
		iq3 = iq3.enqueue(57);
		iq2.printQueue();
		iq3.printQueue();
		iq3.printQueue();
		iq3 = iq3.enqueue(58);
		iq3 = iq3.enqueue(59);
		iq3 = iq3.enqueue(60);
		iq3.printQueue();
		ImmutableQueue<Integer> iq4 = iq3.dequeue();
		iq3.printQueue();
		iq4.printQueue();
		System.out.println("peek" + iq4.peek());
		iq4 = iq4.dequeue();
		iq4 = iq4.dequeue();
		iq4 = iq4.dequeue();
		iq4 = iq4.dequeue();
		iq4.printQueue();
		iq4 = iq4.dequeue();
		iq4 = iq4.dequeue();
		iq4.printQueue();
		System.out.println(iq4.peek());
	}
}
