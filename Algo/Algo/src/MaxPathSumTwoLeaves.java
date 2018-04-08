

class Ress{
	int res=Integer.MIN_VALUE;
}
public class MaxPathSumTwoLeaves {

        Node root = null;

    public static void main(String[] args) {
    	
    	MaxPathSumTwoLeaves tree = new MaxPathSumTwoLeaves();
         tree.root = new Node(8);
         tree.root.left = new Node(2);
         tree.root.right = new Node(10);
         tree.root.left.left = new Node(20);
         tree.root.left.right = new Node(1000);
         tree.root.right.right = new Node(25);
         tree.root.right.right.left = new Node(3000);
         tree.root.right.right.right = new Node(4);
         Ress res = new Ress();
         System.out.println("maximum path sum is : " +
                             tree.findMaxSum(tree.root,res));
         
         System.out.println("maximum path sum is : " +Math.max(res.res, tree.findMaxSum(tree.root,res)));

    }

    private int findMaxSum(Node root,Ress res) {

    	if(root==null){
    		return 0;
    	}
    	
    	
    	int l = findMaxSum(root.left,res);
    	int r = findMaxSum(root.right,res);

    	if(root.left!=null && root.right!=null){
    		res.res = Math.max(res.res, l+r+root.data);
    	}
    	
    	
    	return Math.max(l, r)+root.data;

    	
    	
	}
    
    

	

}
