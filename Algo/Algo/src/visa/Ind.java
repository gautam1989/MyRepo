package visa;

import java.util.HashSet;
import java.util.Scanner;


public class Ind			
{
   public static void main(String[] args) {
	
	   Scanner s=new Scanner(System.in);
	   
	   int row=Integer.valueOf(s.nextLine());
	   int m[][]=new int[row][row];
	   
	   String l="";
	   
	   for (int i=0;i<row;i++){
		   
		   String line=s.nextLine();
		   String[] l2=line.split(" ");
		   int j=0;
		   for(String h:l2){
			   m[i][j] = Integer.valueOf(h);
			   j++;
		   }
		   j=0;
		   
	   }
	   int k = Integer.parseInt(s.nextLine());
	   
	   System.out.println("");
	   
}
}