
public class MaxBendTree {

	
	
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		BinaryTree newTree = tree.getTree();
		
		//findMaxBend(newTree.root, "");
		findSum(newTree.root, 0);
	}
	
	
	public static void findMaxBend(Node root,String path){
		if(root == null){
			System.out.println(path);
			return ;
		}
		
		if(root!=null){
			findMaxBend(root.left, (null==root.left)?path:path+("L"));
			findMaxBend(root.right, (null==root.right)?path:path+"R");
		}
		
		if(root.right!=null){
			
		}
	}
	
	public static void findSum(Node root ,int sum){
		if(root==null){
			return;
		}

		
		if(root.left==null && root.right==null)
				System.out.println(root.data+sum);
		
		findSum(root.left, root.data+sum);
		findSum(root.right, root.data+sum);

	}
	
	
}





