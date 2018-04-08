
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


class Pos{
	int row;
	int col;
	Pos(int r,int c){
		this.row=r;this.col=c;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
}

public class NewDup {

	
	
	 public static boolean determineKIndices(int[][] matrix, int k){
		 Map<Integer, Set<Pos>> store = new HashMap<Integer, Set<Pos>>();
		  
		 for(int row=0; row<matrix.length; row++){
		  for(int col=0; col<matrix[0].length; col++){
		   int val = matrix[row][col];
		   if(store.containsKey(val)){
		    Set<Pos> set = store.get(val);
		    for(Pos p: set){
		     if(Math.abs(p.getRow() - row) + Math.abs(p.getCol()-col) <=k ){
		      return true;
		     }

		      if(row - p.getRow() >k)
		        set.remove(p);
		    }
		    set.add(new Pos(row, col));
		   }else{
		    Set<Pos> set = new HashSet<Pos>();
		    set.add(new Pos(row, col));
		    store.put(val, set);
		   }
		  }
		 }
		  
		 return false;
		}
	
	
	public static void main(String[] args) {
		 Scanner s=new Scanner(System.in);
	  	   Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
	  	   int row=Integer.valueOf(s.nextLine());
	  	  int m[][]=new int[0][0];
	  	   
	  	   String l="";
	  	   int col=0;
	  	   
	  	   for (int i=0;i<row;i++){
	  		   
	  		   String line=s.nextLine();
	  		   String[] l2=line.split(" ");
	  		   if(i == 0 ){ m=new int[row][l2.length];col=l2.length; }
	  		   int j=0;
	  		   for(String h:l2){
	  			   m[i][j] = Integer.valueOf(h);
	  			   
	  			
	  			   j++;
	  		   }
	  		   j=0;
	  		   
	  	   }
	  	   int k = Integer.parseInt(s.nextLine());
	  	   
	  	 if(determineKIndices(m,k))
		  	   System.out.println("YES");
	            else
	             System.out.println("NO"); 
	}
	
}
