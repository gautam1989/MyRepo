package ww;

public class Sol {

	
	public static void main(String[] args) {
		int[] a={5,6,3,1,2,4};
		bstDistance(a, 6, 2, 4);
	}
	
	
	public static int bstDistance(int[] values, int n, int node1, int node2) {
		Node root = arrayToTree(values);
		System.out.println(findLCA(root, node1, node2));
		return node2;
		
	}
	
	static Node findLCA(Node node, int n1, int n2)
	    {
	        // Base case
	        if (node == null)
	            return null;
	 
	        // If either n1 or n2 matches with root's key, report
	        // the presence by returning root (Note that if a key is
	        // ancestor of other, then the ancestor key becomes LCA
	        if (node.data == n1 || node.data == n2)
	            return node;
	 
	        // Look for keys in left and right subtrees
	        Node left_lca = findLCA(node.left, n1, n2);
	        Node right_lca = findLCA(node.right, n1, n2);
	 
	        // If both of the above calls return Non-NULL, then one key
	        // is present in once subtree and other is present in other,
	        // So this node is the LCA
	        if (left_lca!=null && right_lca!=null)
	            return node;
	 
	        // Otherwise check if left subtree or right subtree is LCA
	        return (left_lca != null) ? left_lca : right_lca;
	    }
	 
	
	public static Node arrayToTree(int[] input){
		Node root = createTreeNode(input,1);
	    return root;
	}

	private static Node createTreeNode(int[] input, int index){
	    if(index<=input.length){
	        Integer value = input[index-1];
	        if(value!=null){
	        	Node t = new Node(value);
	            t.left = createTreeNode(input, index*2);
	            t.right = createTreeNode(input, index*2+1);
	            return t;
	        }
	    }
	    return null;
	}
	
}

class Node {
    public Node left, right;
    public int data;

    public Node(int data) {
        this.data = data;
    }
}

