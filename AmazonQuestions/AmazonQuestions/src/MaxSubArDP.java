
public class MaxSubArDP {
	public static void main(String[] args) {
		int a[]={1,0,3,9,2,10};
		System.out.println(maxSubSum(a, a.length-1));
	}
	
	
	private static int maxSubSum(int a[],int i){
		
		if(i ==0)
			return a[0];
		if(i == 1)
			return Math.max(a[0],a[1]);
		
		return Math.max(a[i]+maxSubSum(a, i-2), maxSubSum(a, i-1));
		
	}
	
	
}
