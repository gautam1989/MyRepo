import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DynamicCoinss {

	
	public static void main(String[] args) {
		
		int g =reductionCost(new int[]{3,2,10,1});
		System.out.println(g);
		
		
		
	}

	
	
	  public static  int reductionCost(int[] num) {
		  	List<Integer> tlist = new ArrayList<Integer>();
		  for(int h: num){
			  Integer intObj = new Integer(h);
			  tlist.add(intObj);
		  }
	        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((tlist));
	        int sum = priorityQueue.poll();
	        int cost = 0;
	        while (!priorityQueue.isEmpty()) {
	            int currentElement = priorityQueue.poll();
	            if (currentElement < sum) {
	                priorityQueue.add(sum);
	                sum = currentElement;
	            } else {
	                sum += currentElement;
	                cost += sum;
	                continue;
	            }

	            sum += priorityQueue.poll();
	            cost += sum;
	        }

	        return cost;
	    }
}
