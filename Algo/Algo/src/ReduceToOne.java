
public class ReduceToOne {
	
	static int minn = Integer.MAX_VALUE;
	static void reduceToOne(int num,int m){
		minn = m;
		if(num ==1)
			return ;
		if(num%3==0){
			m++;
			reduceToOne(num/3, m);
		}else if(num%2==0){
			m++;
			reduceToOne(num/2, m);
		}else{
			m++;
			reduceToOne(num-1, m);
		}
		
	}
	
	static int reduce(int num)
	{
	    int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE;
	    if(num==1)
	        return 0;
	    else if(num%3==0)
	        a=1+reduce(num/3);
	    else if(num%2==0)
	        b=1+reduce(num/2);
	    else
	        c=1+reduce(num-1);
	    return Math.min(a,Math.min(b,c));
	}
	
	public static void main(String[] args) {
		 System.out.println(reduce(3));
		 reduceToOne(3, 0);
		 System.out.println(minn);
	}
}
