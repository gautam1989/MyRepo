import java.util.HashMap;
import java.util.Map;

public class LCS {
	static Map<String,Integer> foundlcs =new HashMap<>();
	public static void main(String[] args) {
		char []X="AGGTAB".toCharArray();
		char []Y="GXTXAYB".toCharArray();
		System.out.println(lcsR(X,Y,X.length,Y.length));	
		System.out.println(lcs(X,Y,X.length,Y.length));
	}
	
	private static int lcsR(char[] X, char[] Y, int m, int n){
	
		if(m == 0 || n ==0)
			return 0;
		else if(X[m-1] == Y[n-1]){
			return 1 + lcsR(X,Y,m-1,n-1);
		}
		else 
			return Math.max(lcsR(X,Y,m-1,n),lcsR(X,Y,m,n-1));
			
	}
	
	
	private static int lcs(char[] X, char[] Y, int m, int n){
		int[][] L = new int[m+1][n+1];
		int i,j;
		 for (i=0; i<=m; i++)
		   {
		     for (j=0; j<=n; j++)
		     {
		       if (i == 0 || j == 0)
		         L[i][j] = 0;
		  
		       else if (X[i-1] == Y[j-1])
		         L[i][j] = L[i-1][j-1] + 1;
		  
		       else
		         L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
		     }
		   }
		 
		 
		 for (i=0; i<=m; i++)
		   {
		     for (j=0; j<=n; j++)
		     {
		    	System.out.print(L[i][j]); 
		     }
		     System.out.println();
		   }
		 
		 //print lcs
		 int i2=m,j2=n;
		 StringBuilder sb =new StringBuilder();
		 while(i2 > 0 && j2 >0){
			 
			 if(X[i2-1] == Y[j2-1]){
				 sb.append(X[i2-1]);
				 i2--;j2--;
			 }else if(X[i2-1] > Y [j2-1]){
				 i2--;
			 }else
				 j2--;
			 
		 }
		 System.out.println(sb.reverse().toString());
		
		return L[m][n];
	}
	
}
