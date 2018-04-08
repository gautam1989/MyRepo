import java.util.Arrays;

public class LPSManacher {


	int max;
	static int R;
	static int L;
	static int C;

	public static void main(String[] args) {
   findpalindrome("abcbabc".toCharArray());

	}


	static int findpalindrome(char[] arr){
		int T[] = new int[arr.length];
		Arrays.fill(T, 0);T[0]=0;
		C=0;L=0;R=0;
		for(int i=0;i<arr.length;i++){

			expand(arr,i,T);

		}
		return C;

	}


	private static void expand(char[] arr, int i, int[] T) {

		int r=i,l=i;
		
		if(i>=R){
			C=r;L=C-1;R=C+1;
		}
		
		if(i<R && i>L &&C!=i){
			T[i]=2*C-i;
		}
		while(r>=0 && l<arr.length-1 && l>=0 &&r<arr.length-1 && arr[l]==arr[r] ){		

			
		
			if(C!=i && i<R){
				T[i]=2*C-i;
				l=i+T[i];
				r=i+T[i];
				i=i+T[i];
				continue;
			}
			
			
			if(C!=i){
				r++;l--;
				if(r<=R && l>=L){
					T[i]+=2;
				}else if(r>R || l<L){
					break;
				}else if(r==R){
					C=r+1;
					L=C-1;R=C+1;
					break;
				}
			}else{
				
				T[i]+=(r==l)?1:2;
				L=l;R=r;
				r++;l--;
				
			}
			

		}

//		if(C==i &&r+1>R){
//			C=r;L=C-1;R=C+1;
//		}
//		else if(r==R){
//			C=r;L=C-1;R=C+1;
//		}else if(r>R){
//			C=r;L=C-1;R=C+1;
//			
//		}

		
		System.out.println(Arrays.toString(T));






	}

}
