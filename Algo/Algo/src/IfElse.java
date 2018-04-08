

class IfNode{
	char data;
	IfNode right,left;
	
	
	public IfNode(char data) {
		this.data = data;
	}
}

public class IfElse {
	
	static IfNode rootNode ;
	public static void main(String[] args) {
		
		String s="a?b?c:d:e";
		evaluateExp(s, 0, rootNode, -1);;
		printTree( eval(s,0));
		System.out.println();
		printTree(rootNode);
		
	}

	public static void evaluateExp(String exp,int pos,IfNode node,int side){ //0 1 -1
		IfNode cnode = null ;
	
		if(pos >= exp.length())
			return ;
		
		if(rootNode == null){
			rootNode = new IfNode(exp.charAt(pos));
			 evaluateExp(exp, pos+1, rootNode,-1);
		}
		
		if(exp.charAt(pos) == '?'){
			 evaluateExp(exp, pos+1, node, 0);
			
		}else if(exp.charAt(pos) == ':'){
			 evaluateExp(exp, pos+1, node, 1);
		}
		
		if(side == -1){
			cnode = new IfNode(exp.charAt(pos));
			 evaluateExp(exp, pos+1, cnode,-1);
		}else if(side ==0){
			cnode = new IfNode(exp.charAt(pos));
			node.left = cnode;
			 evaluateExp(exp, pos+1, cnode,-1);
		}
		else if(side ==1){
			cnode = new IfNode(exp.charAt(pos));
			node.right = cnode;
			 evaluateExp(exp, pos+1, cnode,-1);
		}
		
	}
	
	
	public static IfNode eval(String exp,int pos){
		
		if(pos >= exp.length())
			return  null;
		
		IfNode node = new IfNode(exp.charAt(pos));
		
		if(pos+1< exp.length() && exp.charAt(pos+1)=='?'){
			node.left = eval(exp,pos+2);
		}else{
			node.right = eval(exp,pos+2);
		}
		
		return node;
		
		
		
	}
	
	 public static void printTree( IfNode root)
	    {
	        if (root == null)
	            return;
	                 
	        System.out.print(root.data +" ");
	        printTree(root.left);
	        printTree(root.right);
	    }
	
}
