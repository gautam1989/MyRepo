import java.util.Stack;

public class BalP {

	public static void main(String[] args) {
		 System.out.println(balancedParenthensies("()()"));
	}
	
	 public static int balancedParenthensies(String str) {
	        Stack<Character> stack  = new Stack<Character>();
	        for(int i = 0; i < str.length(); i++) {
	            char c = str.charAt(i);
	            if(c == '[' || c == '(' || c == '{' || c =='<' ) {

	                stack.push(c);

	            }else if(c == ']') {
	                if(stack.isEmpty()) return 0;
	                if(stack.pop() != '[') return 0;

	            }else if(c == ')') {
	                if(stack.isEmpty()) return 0;
	                if(stack.pop() != '(') return 0;

	            }else if(c == '}') {
	                if(stack.isEmpty()) return 0;
	                if(stack.pop() != '{') return 0;
	            }else if(c == '>'){
	                if(stack.isEmpty()) return 0;
	                if(stack.pop() != '<') return 0;
	            	
	            }

	        }
	        if(stack.isEmpty())
	        	return 1;
	        return 0;
	    }
	
}
