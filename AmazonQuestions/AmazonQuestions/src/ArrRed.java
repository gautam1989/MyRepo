import java.util.Arrays;

public class ArrRed {
public static void main(String[] args) {
	
	System.out.println(reduce(new int[]{1,2,3,4,5}));
	
}

static int reduce(int [] num){
	
	Arrays.sort(num);
	int j=0;
	int currentcount =0;
	int totalcount =0;
	
	for(int i=0;i<num.length;i++){
		j=i+1;
		if(j == num.length){
			return totalcount;
		}
		int f = num[i];
		int s = num[j];
		currentcount = f+s;
		totalcount += currentcount;
		num[j]=currentcount;
		Arrays.sort(num);
		
		
	}
	
	return totalcount;
	
}

}
