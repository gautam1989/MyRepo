/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;


/**
 *
 * @author gautamverma
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class WorksAppTrack {
        static int row,col,startr,startc;
        static List<Integer> checkPoints=new ArrayList<Integer>();
	static String a[][]=null;
	static Queue<Integer> queue=new LinkedList<Integer>();
	static List<String> ll=new ArrayList<String>();
        static int b[][]=null;
	static int x[]={0,0,1,-1};
	static int y[]={1,-1,0,0};
        static int start=0;
        static int maincount=0,mc=0;
        static List<String> checkPointsfound=new ArrayList<String>();
	public static void main(String[] args) throws Exception{
		
		
		readInput();
		findStart();
		String addCoor=startr+" "+startc;
	
                for(int i=0;i<checkPoints.size();i++)
                findNearestCheckPoint(startr,startc);

                
                System.out.println("mc:"+mc);
                {
             int   a=1;
		int   b=1;
		 int  c=a+b;
		                  System.out.print(c);
		   a=b;
		   b=c;
		   c=a+b;
		                  System.out.print(c);
                }
                {
                    bitwiseMultiply(2);
                    
                }
	}
        
         public static void bitwiseMultiply(int n1) {
        int a = n1, b = 15, result=0;
        while (b != 0) // Iterate the loop till b==0
        {
            if ((b & 01) != 0) // Logical ANDing of the value of b with 01
            {
                result = result + a; // Update the result with the new value of a.
            }
            a <<= 1;              // Left shifting the value contained in 'a' by 1.
            b >>= 1;             // Right shifting the value contained in 'b' by 1.
        }
        System.out.println(result);
    }


        static void findNearestCheckPoint(int rows,int cols){
            
            {
            int g;
        }
        {
            int g=10;
        }
            
                String addCoor=rows+" "+cols;
		queue.add(rows);
		queue.add(cols);
		ll.add(addCoor);
                {
                    int g=0;
                }
                
		while(queue.size()>0){
			int cr=queue.poll();
			int cc=queue.poll();
		for(int i=0;i<4;i++){
			
			int r=cr+x[i];
			int c=cc+y[i];
			              //   System.out.println("x:"+c +" y:"+r);
			
			 if( ((r>=0 && c>=0) &&(c<col && r <row)) && ll.contains(r+" "+c)==false){
			
                             if(a[r][c].equalsIgnoreCase(".") || a[r][c].equalsIgnoreCase("@")){
                                 
                         //    display();
                         //    System.out.println(r+ " "+c);
				 queue.add(r);
				 queue.add(c);
				 if (ll.contains(r+" "+c)==false){
					 ll.add(r+" "+c); 
				
				 }
                                 
                                 b[r][c]=b[cr][cc]+1;             	
		        }
                         }
                         if ((r>=0 && c>=0) &&(r<row && c <col)){
                         if(1+b[cr][cc] < b[r][c])
                                 b[r][c]=1+b[r][c];
                         }
                        if((r>=0 && c>=0) &&(r<row && c <col)){
                         if(a[r][c].equalsIgnoreCase("@")){
                             
                             if(!checkPointsfound.contains(r+" "+c)){
                             checkPointsfound.add(r+" "+c);
                             System.out.println("Chekpoint found at:"+r +" "+ c);
                                 maincount+=b[r][c];
                                 System.out.println("M:"+maincount);
                                 if(checkPointsfound.size()<=checkPoints.size())
                                 findNearestCheckPoint(r, c);else return;
                             }
                              System.out.println("called:"+r+" ");
                              findEndPoint(r, c);
                             return;
                         }}
                         
                         
                }
		
		}
	display();
        }
	
        
        static void findEndPoint(int rows,int cols){
            queue.clear();
            ll.clear();
            b=new int[row][col];
            String addCoor=rows+" "+cols;
		queue.add(rows);
		queue.add(cols);
		ll.add(addCoor);
                
		while(queue.size()>0){
			int cr=queue.poll();
			int cc=queue.poll();
		for(int i=0;i<4;i++){
			
			int r=cr+x[i];
			int c=cc+y[i];
			              //   System.out.println("x:"+c +" y:"+r);
			
			 if( ((r>=0 && c>=0) &&(c<col && r <row)) && ll.contains(r+" "+c)==false){
			
                             if(a[r][c].equalsIgnoreCase(".") || a[r][c].equalsIgnoreCase("g")){
                                 
                         //    display();
                         //    System.out.println(r+ " "+c);
				 queue.add(r);
				 queue.add(c);
				 if (ll.contains(r+" "+c)==false){
					 ll.add(r+" "+c); 
				
				 }
                                 
                                 b[r][c]=b[cr][cc]+1;             	
		        }
                         }
                         if ((r>=0 && c>=0) &&(r<row && c <col)){
                         if(1+b[cr][cc] < b[r][c])
                                 b[r][c]=1+b[r][c];
                         }
                         if ((r>=0 && c>=0) &&(r<row && c <col)){
                         if( a[r][c].equalsIgnoreCase("g")){
                              maincount+=b[r][c];
                               System.out.println("MAINCOUNT:"+maincount);
                               if(mc==0)
                               mc=maincount;
                              System.out.println("asas"+r+" "+c);
                              display();
                             return;
                         }
                         }
                         
                }
		
		}
	display();
        }
        
	static void findStart(){
            
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(a[i][j].equalsIgnoreCase("s"))
                    {
                        startr=i;startc=j;
                        System.out.println(startr +" "+startc);
                        
                    }else if(a[i][j].equalsIgnoreCase("@")){
                        int r=i;int c=j;
                        checkPoints.add(r);
                        checkPoints.add(c);
                       
                    }
                }
            }
            
        }
	static void readInput() throws Exception{
		BufferedReader br=new BufferedReader(new FileReader(new File("/Users/gautamverma/NetBeansProjects/ds/example1.txt")));
		String line=null;int j=0;
                String sp[]=br.readLine().split(" ");
                col=Integer.parseInt(sp[0]);
                row=Integer.parseInt(sp[1]);
                System.out.println("row:"+row+" col:"+col);
                a=new String[row][col];
                b=new int[row][col];
		while( (line=br.readLine())!=null  ){
                      
			System.out.println(line);
			String[] l=line.split("");
			for(int i=0;i<col;i++)
				a[j][i]=l[i];
			j=j+1;
		}
		
	}
	
	
	static void display(){
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
        
        static void queueElent(){
            
            Iterator<Integer> q=queue.iterator();
            while(q.hasNext()){
                int x=q.next();
                int y=q.next();
                System.out.println(a[x][y]+" ");
            }
            
        }
}
