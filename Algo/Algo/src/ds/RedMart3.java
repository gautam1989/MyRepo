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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class RedMart3 {
        static List<List<String>> mainList=new ArrayList<List<String>>();
        static List<Integer>possibleList=new ArrayList<Integer>();
        static List<List<Integer>>FpossibleList=new ArrayList<List<Integer>>();
	static int a[][];
        static int mr,mc;
	static Queue<Integer> queue=new LinkedList<Integer>();
	static List<String> ll=new ArrayList<String>();
        static Map<String,List<String>>map=new HashMap<String, List<String>>();
        static int b[][];
	static int x[]={0,0,1,-1};
	static int y[]={1,-1,0,0};
        static int c=0;
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
			
                        List<String> l=new  ArrayList<String>();
                        
		for(int i=0;i<4;i++){
			
			int xx=cx+x[i];
			int yy=cy+y[i];
			
                        if(((xx>=0 && yy>=0) &&(xx<mr && yy <mc))){
                            l.add(xx+" "+yy);
                            map.put(cx+" "+cy, l);
                        }
			
                        
			 if( ((xx>=0 && yy>=0) &&(xx<mr && yy <mc)) && ll.contains(xx+" "+yy)==false){
				// display();System.out.println("");
//                               
                               
				
				 queue.add(xx);
				 queue.add(yy);
				 if (ll.contains(xx+" "+yy)==false){
					 ll.add(xx+" "+yy); 
				
				 }
			 }
                         
//                         if ((xx>=0 && yy>=0) &&(xx<mr && yy <mc)){
//                         if(a[xx][yy]+b[cx][cy] > b[xx][yy])
//                                 b[xx][yy]=a[xx][yy]+b[cx][cy];
//			
//		}
                 
                   
                }
		// writeToFile();
		}
                
               
                
	//display();
         //   System.out.println("MAP:");
         //  dispMap();
         //  System.out.println("MAGIC:");
            createMagic(0+" "+0, new ArrayList<String>());
           // System.out.println(mainList.size());
           dispMain();
             dispNow();;
	}
	
        static void writeToFile(){
            PrintWriter pw=null;
           try{
            //BufferedWriter bufw=new BufferedWriter(new FileWriter(new File("/Users/gautamverma/Documents/workspaceL/Tre/giftmap.txt")));
           // pw=new PrintWriter(new File("/Users/gautamverma/Documents/workspaceL/Tre/giftmap.txt"));
            Set s=map.keySet();
            Iterator e=s.iterator();
            
            while(e.hasNext()){
                c++;
              //  Files.write(Paths.get("/Users/gautamverma/Documents/workspaceL/Tre/giftmap.txt"), map.get(e.next()), StandardCharsets.UTF_8);
         //       pw.println(c);
            }
           }catch(Exception e){}
           //finally{pw.close();}
        }
        
        static void dispNow(){
          //  System.out.print(FpossibleList);
            int size=0;
            for(List<Integer>l:FpossibleList){
                 if(l.size()>=size)size=l.size();
            }
            int drop=0;
            for(List<Integer>l:FpossibleList){
                if(l.size()==size){
                     if(drop<l.get(0) - l.get(l.size()-1)){
                         drop=l.get(0) - l.get(l.size()-1);
                         System.out.println(drop);
                     }
                    
                    
                }
               // System.out.println(l);
            }
        }
        
        
        static void dispMain(){
            for(List<String> l: mainList){
                 List<Integer>tempList=new ArrayList<Integer>();
                
                   //  System.out.println("");
                for(String m:l){
                    int r=Integer.parseInt(m.split(" ")[0]);
                    int c=Integer.parseInt(m.split(" ")[1]);
                    tempList.add(a[r][c]);
                  //  System.out.print(" "+a[r][c]);
                    
                }searchList(tempList);
            }
        }
	
        static void searchList(List<Integer>tempList){
             int start =0,end=0;
             for(int i=0;i<tempList.size();i++){
                 if(i>0){
                    if(tempList.get(i)< tempList.get(i-1)){
                        end=end+1;
                        possibleList=addAll(tempList,start,end);
                       // System.out.println("PO:"+possibleList);
                        FpossibleList.add(possibleList);
                    }else
                    {
                        start=i;end=i;
                    }
                 }
             }   
        }
	
        static List<Integer> addAll(List<Integer>temp,int s,int e){
            List<Integer>n=new ArrayList<Integer>();
            for(int i=s;i<=e;i++){
              n.add(temp.get(i));
            }
            return n;
        }
        
	static void readInput() throws Exception{
	URL file = new URL("http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt");	
            
       //   BufferedReader br=new BufferedReader(new FileReader(new File("/Users/gautamverma/Documents/workspaceL/Tre/giftec.txt")));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(file.openStream()));  
		String line=null;int j=0;
                line=br.readLine();
                 int row=Integer.parseInt(line.split(" ")[0]);
                 int col=Integer.parseInt(line.split(" ")[1]);
                 mr=row;
                 mc=col;
                 a=new int[row][col];
                 b=new int[row][col];
		while( (line=br.readLine())!=null  ){
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
			//	System.out.print(a[i][j]+" ");
			}
			//System.out.println();
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
        
        static void dispMap(){
            Set i=map.keySet();
            Iterator itr=i.iterator();
            while(itr.hasNext()){
                String s=itr.next().toString();
                System.out.println(s);
                System.out.println(map.get(s));
            }
            
            
            
           System.out.println(map);
        }
        
        static int getVal(String cur){
            int r=Integer.parseInt(cur.split(" ")[0]);
            int c=Integer.parseInt(cur.split(" ")[1]);
            return a[r][c];
        }
        
        
        static void checkMainList(){
            
        }
        
        static void createMagic(String cur,List<String> cl){
      
             
            cl.add(cur);
              
           
               mainList.add(cl);
               checkMainList();
            for(int i=0;i<map.get(cur).size();i++){
                  
                  if(i>0){
                      
                 if(!cl.contains(map.get(cur).get(i))){
                     List<String>nl=new ArrayList<String>();
                     nl.addAll(cl);
                   
                    // nl.add(cur);
      
                createMagic(map.get(cur).get(i),nl);
                 }
                  }else
                  {
                      if(!cl.contains(map.get(cur).get(i))){
                       //   System.out.println("crate called with:"+map.get(cur).get(i));
                          List<String>l=new ArrayList<String>();
                          l.addAll(cl);
                       createMagic(map.get(cur).get(i),l);
                  }}
                
            }
            
            
            
            
        }
        
}
