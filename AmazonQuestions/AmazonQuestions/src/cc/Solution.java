package cc;


public class Solution {

	static Node root=null;
	
	
	public static int bstDistance(int[] values, int n, int node1, int node2)
	{
		boolean node1e=false;
		boolean node2e=false;
		for(int i=0;i<values.length;i++){
			add(new Node(values[i]));
			if(node1e ==false && node1 ==values[i])node1e=true;
			if(node2e ==false && node2 == values[i])node2e=true;
		}
		if(node1e && node2e){
		return(findDistance(root, node1, node2));
		}else
		return -1;
	}
	
	public static void add(Node node){
	    if(root==null)
	    {
	        root=new Node(node.data);
	        node.left=null;
	        node.right=null;
	        root=node;
	        
	    }
	    else
	    {
	        if(node.data < root.data){
	            addToLeft(node,root);
	        }else
	        {
	            addToRight(node,root);
	        }
	    }
	    
	    
	    
	}

	public static void addToLeft(Node node,Node currNode){
	    
	         if((node.data < currNode.data) && (currNode.left==null))
	         {
	            currNode.left=node;

	         }else if((node.data < currNode.data))
	         {
	              addToLeft(node, currNode.left);
	         }
	         else if((node.data > currNode.data) && (currNode.right==null)){
	             currNode.right=node;
	         }else if(node.data > currNode.data){
	             addToRight(node,currNode.right);
	         }
	                      
	    
	}

	public static void addToRight(Node node,Node currNode ){
	   if((node.data < currNode.data) && (currNode.left==null))
	         {
	             currNode.left=node;

	         }else if((node.data < currNode.data))
	         {
	              addToLeft(node, currNode.left);
	         }
	         else if((node.data > currNode.data) && (currNode.right==null)){
	             currNode.right=node;
	         }else if(node.data > currNode.data){
	             addToRight(node,currNode.right);
	             
	         }
	                      
	}

	
	
	public static int findDistance(Node root, int n1, int n2) {
		int x = Pathlength(root, n1) - 1;
		int y = Pathlength(root, n2) - 1;
		int lcaData = findLCA(root, n1, n2).data;
		int lcaDistance = Pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}
	public static int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}
	public static  Node findLCA(Node root, int n1, int n2) {
		if (root != null) {
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			Node left = findLCA(root.left, n1, n2);
			Node right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}
}


class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
