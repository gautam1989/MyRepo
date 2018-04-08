

class Node {
 
    int data;
    Node left, right;
    int max;
    public Node(int item) {
        data = item;
        left = right = null;
        max =  item;
    }
}
public class MaxPathSum {
	
	Node root;
	int maxt=Integer.MIN_VALUE;
	
	public void findMaxSum(Node node,int max){
		
		
		if(node == null)
			return ;
		
	
		
		findMaxSum(node.left,node.max);
		findMaxSum(node.right,node.max);
		int l = (node.left!=null)?node.left.max:0;
		int r = (node.right!=null)?node.right.max:0;
		
		
		node.max = Math.max(node.data, Math.max(l, r)+node.data);
		maxt = Math.max(node.max, Math.max(node.data+l+r,maxt));

		//node.max = Math.max(node.max,Math.max(node.max+ ((node.left==null)?0:node.left.max), node.max+  ((node.right==null)?0:node.right.max)));
		//node.max = Math.max(node.max, Math.max(node.max+((node.left==null)?0:node.left.max), node.max+((node.right==null)?0:node.right.max)));
		
		System.out.println(maxt);
		
		
	}
	
	public static void main(String[] args) {
			MaxPathSum tree = new MaxPathSum();
	        tree.root = new Node(10);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(10);
	        tree.root.left.left = new Node(20);
	        tree.root.left.right = new Node(1);
	        tree.root.right.right = new Node(25);
	        tree.root.right.right.left = new Node(3);
	        tree.root.right.right.right = new Node(4);
	        tree.findMaxSum(tree.root,tree.root.max);
	        System.out.println(tree.maxt);
	}
}
