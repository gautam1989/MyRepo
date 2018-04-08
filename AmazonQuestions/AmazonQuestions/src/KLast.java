
class KNode{
	int val;
	KNode next;
}

public class KLast {

	
	public static void main(String[] args) {
		
		KNode k1 =new KNode();
		k1.val = 1;
	
		KNode k2 =new KNode();
		k2.val = 2;
		
		KNode k3 =new KNode();
		k3.val = 3;
		
		KNode k4 =new KNode();
		k4.val = 4;
		
		KNode k5 =new KNode();
		k5.val = 5;
		
		k1.next  =k2;
		k2.next  =k3;
		k3.next  =k4;
		k5.next  =k5;
		
		
		

	}
	
	
	static KNode findKlast(KNode head, int k){
		
		if(head == null || k ==0){
			return head;
		}
		findKlast(head.next, k);
		k --;
		return head;
	}
	
}
