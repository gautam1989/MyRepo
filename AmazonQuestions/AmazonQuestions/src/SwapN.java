import java.util.Arrays;
import java.util.Collections;

public class SwapN {
public static void main(String[] args) {
	
	int n=2;
	int c=0;
	int a[]=new int[]{1,2,9,8,1};
	//int w[]=Arrays.copyOf(a, a.length);
	int currentL = convert(a);
	for(int i=0;i<a.length-1;i=i+1){
		int w[]=Arrays.copyOf(a, a.length);;
		for(int j=i;j<w.length-1;j=j+1){
		if( j>=0 && w[j+1] > w[j]){
			swap(w,j);
			c++;
			j=j-2;
			if(convert(w) > currentL){
				currentL = convert(w);
				System.out.println(currentL);
			}
		}
		if(c==n){
			c=0;
			break;
		}
		}
	}
	
	
}

static void swap(int []a,int i){
	int t=a[i];
	a[i]=a[i+1];
	a[i+1]=t;
	System.out.println("s:"+convert(a));
}
 static int convert(int []a){
	String total="";
	 for(int b:a){
		total+=b;
	}
	 return Integer.parseInt(total);
 }

}
