
public class LCA {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        
        System.out.println(2^2^3);
        //Node lca = tree.findLCA(4, 7);
//        if (lca != null)
//            System.out.println("LCA(4, 5) = " + lca.data);
//        else
//            System.out.println("Keys are not present");
// 
//        lca = tree.findLCA(4, 7);
//        if (lca != null)
//            System.out.println("LCA(4, 10) = " + lca.data);
//        else
//            System.out.println("Keys are not present");

	}
	
	

}
