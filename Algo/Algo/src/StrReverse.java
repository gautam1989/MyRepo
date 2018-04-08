
public class StrReverse {

	public static void main(String[] args) {
		
		
		System.out.println(strrev("123456789","123456789".length()));
		
		
	}
	
	
	
	public static String strrev(String s,int n){
		
		if(s.length()<=1)
			return s;
		
		return s.substring(n-1)+strrev(s.substring(0, n-1), n-1);
		
	}
	
}
