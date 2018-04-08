import java.util.Random;

class SkNode{
	int val,height;
	SkNode right,bottom;
	
	public SkNode(int val,int height,SkNode right,SkNode bottom) {
		this.val = val;
		this.height = height;
		this.right = right;
		this.bottom = bottom;
	}
}

public class CustomSkipList {
	
	SkNode head,tail;
	int currentListHeight  = 0;
	
	public void initializeList(){
		tail = new SkNode(1000,0, null, null);
		head = new SkNode(0,0, tail, head);
	}
	
	
	public void insert(int x){
		
		SkNode cur = head;
		if(cur.right == tail && head.height==0){
			cur.right = new SkNode(x, 0, tail, null);
			cur.right.right = tail;
			currentListHeight = 1;
			head = new SkNode(0, currentListHeight, tail, cur);
			return;  //just for the first entry in the list
		}
		
		int r = new Random().nextInt(currentListHeight+1);
		SkNode prevTemp = null ;
		while(cur!=null && cur.height >=0){
			if(cur.height >r){
				cur=cur.bottom;
				continue;
			}
			while(cur !=null && cur.val < x && cur.height <= r){
				if(cur.right.val < x){
					cur=cur.right;
				}else {
					SkNode temp = cur.right;
					SkNode tempForPrevtem = prevTemp;
					prevTemp = new SkNode(x, cur.height, temp, null);
					if(tempForPrevtem!=null){
						tempForPrevtem.bottom = prevTemp;
						tempForPrevtem = prevTemp;
					}
					cur.right = prevTemp;
					cur = cur.bottom;
				}
			}
			
			
		}
		
		if (r == head.height){
			SkNode node = new SkNode(0, head.height+1, tail, head);
			head = node;
			currentListHeight++;
		}
		
		
	}
	
	public boolean search(int x){
		SkNode cur = head;
		while(cur!=null && cur!=tail){
			if(cur.val == x || cur.right.val==x){
				return true;
			}else if( cur.right.val > x){
				cur = cur.bottom;
			}else if(cur.right.val <x){
				cur = cur.right;
			}else{
				cur = cur.bottom;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		CustomSkipList csk = new CustomSkipList();
		csk.initializeList();
		for(int i=1;i<=500;i++)
			csk.insert(i);
		System.out.println(csk.search(4122));
	System.out.println(csk.currentListHeight);
	}

}
