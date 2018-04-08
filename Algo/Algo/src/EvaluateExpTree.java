
class ExpTree{
	ExpTree left,right;
	char opr;
	int val;
	public ExpTree(ExpTree left, ExpTree right, char opr, int val) {
		super();
		this.left = left;
		this.right = right;
		this.opr = opr;
		this.val = val;
	}
	
	
}

public class EvaluateExpTree {
	
		ExpTree root;
		private static int eval(ExpTree node){
				
			if(node == null){
				return 0;
			}
			
			if(node.opr!='$'){
				if(node.opr == '*')
				 return node.val = eval(node.left)*eval(node.right);
				
				if(node.opr == '+')
					return node.val = eval(node.left)+eval(node.right);
				
				if(node.opr == '-')
					return node.val = eval(node.left)-eval(node.right);
				
				if(node.opr == '/')
					return node.val = eval(node.left)/eval(node.right);
			}
			return node.val;
		}
	
	
	public static void main(String[] args) {
		ExpTree two =new ExpTree(null, null,'$',2);

		ExpTree five =new ExpTree(null, null,'$', 5);
		ExpTree four =new ExpTree(null, null,'$', 4);
		ExpTree hunder =new ExpTree(null, null,'$', 100);
		ExpTree twenty =new ExpTree(null, null,'$',20);
		ExpTree divide =new ExpTree(twenty, two,'/',1);
		ExpTree mulone = new ExpTree(five, four, '*', 1);
		ExpTree minusone =new ExpTree(hunder, divide,'-', 0);
		ExpTree root = new ExpTree(mulone, minusone, '+', 0);
		System.out.println(eval(root));
	}
}
