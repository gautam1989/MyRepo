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


public class BfsGifts {

	static int a[][]=new int[4][4];
	static Queue<Integer> queue=new LinkedList<Integer>();
	static List<String> ll=new ArrayList<String>();
        static int b[][]=new int[4][4];
	static int x[]={1,0};
	static int y[]={0,1};
	public static void main(String[] args) throws Exception{
		
		
		readInput();
		
		String addCoor=0+" "+0;
		queue.add(0);
		queue.add(0);
		ll.add(addCoor);
                b[0][0]=a[0][0];
		while(queue.size()>0){
	
                    
			int cx=queue.poll();
			int cy=queue.poll();
			                
		for(int i=0;i<2;i++){
			
			int xx=cx+x[i];
			int yy=cy+y[i];
			
			
			 if( ((xx>=0 && yy>=0) &&(xx<=3 && yy <=3)) && ll.contains(xx+" "+yy)==false){
				// display();System.out.println("");
//                               
                                    
				
				 queue.add(xx);
				 queue.add(yy);
				 if (ll.contains(xx+" "+yy)==false){
					 ll.add(xx+" "+yy); 
				
				 }
			 }
                         
                         if ((xx>=0 && yy>=0) &&(xx<=3 && yy <=3)){
                         if(a[xx][yy]+b[cx][cy] > b[xx][yy])
                                 b[xx][yy]=a[xx][yy]+b[cx][cy];
			
		}}
		
		}
	display();
	}
	
	
	static void readInput() throws Exception{
		BufferedReader b=new BufferedReader(new FileReader(new File("/Users/gautamverma/Documents/workspaceL/Tre/gift.txt")));
		String line=null;int j=0;
		while( (line=b.readLine())!=null  ){
		//	System.out.println(line);
			String[] l=line.split(" ");
			for(int i=0;i<l.length;i++)
				a[j][i]=Integer.parseInt(l[i]);
			j=j+1;
		}
		
	}
	
	
	static void display(){
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b.length;j++){
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
