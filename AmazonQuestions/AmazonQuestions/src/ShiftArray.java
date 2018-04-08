import java.util.Scanner;

public class ShiftArray {
    static void shiftArray(int[][]a, int index, int n) {
       if ((n%2 == 0) && (index >= n/2))
           return;
       if ((n%2 != 0) && (index > n/2))
           return;

       int tempRowTopLast = a[index][n-1-index]; 
       int tempColRightLast = a[n-1-index][n-1-index];
       int tempRowBottomLast = a[n-1-index][index]; 
       int tempColLeftLast = a[index][index];

       int temp, temp2;

       temp = tempColLeftLast; 

       for (int k = index + 1; k < n-index; k++) {
           temp2 = a[index][k];
           a[index][k] = temp;
           temp = temp2;
       }

       temp = tempRowTopLast; 
       for (int k = index + 1; k < n-index; k++) {
           temp2 = a[k][n-1-index];
           a[k][n-1-index] = temp; 
           temp = temp2; 
       }

       temp = tempColRightLast; 
       for (int k = n-2-index; k >=index; k--) {
           temp2 = a[n-1-index][k];
           a[n-1-index][k] = temp; 
           temp = temp2; 
       }

       temp = tempRowBottomLast;
       for (int k = n-2-index; k >=index; k--) {
           temp2 = a[k][index];
           a[k][index] = temp;
           temp = temp2;
       } 

       shiftArray(a, index+1, n);

    }

    public static void main(String[] args) {
       // int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    	
    	Scanner s=new Scanner(System.in);
   	 int m[][]=new int[0][0];
   	   int row=Integer.valueOf(s.nextLine());
   int col=0;
   	 for (int i=0;i<row;i++){
   		   
   		   String line=s.nextLine();
   		   String[] l2=line.split(" ");
   		   if(i == 0 ){ m=new int[row][l2.length];col=l2.length; }
   		   int j=0;
   		   if(l2.length != row){
   			   System.out.println();
   			   System.out.println("ERROR");
   			   return;
   		   }
   		   for(String h:l2){
   			   m[i][j] = Integer.valueOf(h);
   			   
   			
   			   j++;
   		   }
   		   j=0;
   		   
   	   }

        shiftArray(m, 0, row);
        

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
       }
    }
}