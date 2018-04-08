
public class CountPairing {

	public static void main(String[] args) {
		System.out.println(countPairs(2));
	}
	
	
	
	static int countPairs(int n){
		
		if(n<=1){
			return 1;
		}
		
		return countPairs(n-1)+(n-1)*countPairs(n-2);
		
	}
	
}
