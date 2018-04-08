import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

	static PriorityQueue<Integer> lo = new PriorityQueue<>(10, Collections.reverseOrder()); //max heap
	static PriorityQueue<Integer> high = new PriorityQueue<>(10); //min heap
	
	public static void main(String[] args) throws InterruptedException {
		
		for(int i=1;i<=10;i++){
			
			//Thread.sleep(2000);
			
			if(high.size()<1 && lo.size()<1){
				high.add(i);
				findMedian();
				continue;
			}
			
			if(high.size() == lo.size()){
				
				if(i > high.peek()){
					high.add(i);
					findMedian();continue;
				}
				
				if(i< high.peek()){
					lo.add(i);
					findMedian();continue;
				}
				
			}if(high.size() > lo.size()){
				
				if(i> high.peek()){
					lo.add(high.poll());
					high.add(i);findMedian();continue;
				}else{
					lo.add(i);
					findMedian();continue;
				}
				
			}else{
				
				if(i < high.peek()){
					high.add(lo.poll());
					lo.add(i);findMedian();continue;
				}else{
					high.add(i);
					findMedian();continue;
				}
				
			}
			
		}
		
		
	}

	private static void findMedian() {
		if(high.size() == lo.size()){
			System.out.println(  ((high.peek()+lo.peek())/2.0) );
		}else if(high.size() > lo.size()){
			System.out.println(high.peek());
		}else{
			System.out.println(lo.peek());
		}
	}
	
}
