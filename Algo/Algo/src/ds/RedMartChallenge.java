/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gautamverma
 */


class MartNode{
    MartNode Leftnode;
    MartNode Rightnode;
    MartNode upnode;
    MartNode bottomnode;    
    int val;
    int c=1;
}
public class RedMartChallenge {
    
    
	static int a[][];
        static int mr,mc;
	
        static MartNode b[][];
	static int x[]={0,0,1,-1};
	static int y[]={1,-1,0,0};
        static int c=1;
    static int maxC =0;
    static MartNode nodeStart;
    static MartNode nodeEnd;
    static int f=0;
    static int valuesfound=1;
    static int theFinalmax=0;
    static int length=0,drop=0,maxForCurrent=0;
    static Map<Integer,Integer>ldrop=new HashMap<Integer, Integer>();
    static List<MartNode>maxNodeVal=new ArrayList<MartNode>();
    public static void main(String args[])
    {
         try {
             readInput();
             
             doMagic();
            

             
             for(int i=0;i<a.length;i++){
                
                for(int j=0;j<a.length;j++){
              
                    
                    printTree(b[i][j],new ArrayList<MartNode>()); 
                   // findallNodeformax();
                    
                    if(maxC < f){
                        
                        maxC=f;
                        
                    }
                        nodeStart=b[i][j];
                        
                        if(nodeStart.c ==1 && nodeEnd.c==maxC){

                            try{
                                
                                
                             //  for(MartNode md:maxNodeVal){
                            find(nodeStart,nodeEnd);
                                
                                 
                                if(theFinalmax <= length){
                                    
                                    theFinalmax=length;
                                    
                                    
                                  
                                        drop=nodeStart.val -nodeEnd.val;
                                        if(ldrop.get(length)!=null){
                                         
                                            if(ldrop.get(length) < drop)
                                                ldrop.put(length, drop);
                                            
                                        }else
                                        {
                                            ldrop.put(length,drop);
                                        }
                                        
                                        
                                    
                                     
                                }
                                
                        //        }
                        }catch(Exception e){
                                 
                           
                            }finally{
                                valuesfound=1;
                            }
                            
                           
                        }
                    f=0;
                }
             }
        //     System.out.println("l:"+ldrop);
             
             findallNodeformax();ldrop.clear();
           //  listP(maxNodeVal);
               for(int i=0;i<a.length;i++){
                
                for(int j=0;j<a.length;j++){
                    nodeStart=b[i][j];
                     if(nodeStart.c ==1){
                     for(MartNode md:maxNodeVal){
                          if(nodeStart.c==1){
                              maxForCurrent=0;
                            find(nodeStart,md);
                               // System.out.println(">>>>");
                                 //System.out.println("maxc:"+maxForCurrent);
                                if( !(maxForCurrent < length)){
                                    
                                    //theFinalmax=length;
                                    
                                    
                             //          System.out.println("KL:"+nodeStart.val+"  "+md.val);
                                        drop=nodeStart.val -md.val;
                                        if(ldrop.get(length)!=null){
                                         
                                            if(ldrop.get(length) < drop)
                                                ldrop.put(length, drop);
                                            
                                        }else
                                        {
                                            ldrop.put(length,drop);
                                        }
                                        
                                        
                            //        System.out.println(ldrop);
                                     
                                }
                                
                                }
                     }
                     }
                }
               }
             
            
            // System.out.println(ldrop);
             int h=0;
             Set m=ldrop.keySet();
             Iterator<Integer> t=m.iterator();
             while(t.hasNext())
             {
                 int j=t.next();
                 if(j>h)
                     h=j;
             }
              System.out.println("Length= "+h);
             System.out.println("drop= "+ldrop.get(h));
        //     System.out.println(ldrop);
             
           //  for(MartNode md:maxNodeVal)System.out.println(md.val);
             
         } catch (Exception ex) {
             Logger.getLogger(RedMartChallenge.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    static void findallNodeformax(){
      //  System.out.println(f);
        maxNodeVal.clear();
        for(int i=0;i<a.length;i++){
                
                for(int j=0;j<a.length;j++){
                    if(b[i][j].c == length)maxNodeVal.add(b[i][j]);
                    
                }
        }
    }
    
    static void find(MartNode nodeStart,MartNode nodeEnd) throws Exception{
        
       // System.out.println(nodeStart.val);
        //System.out.println(nodeEnd.val);
        
        if(nodeStart==nodeEnd)
        {
         
             if(maxForCurrent < valuesfound){
                 maxForCurrent=valuesfound;
                 length=maxForCurrent;
                 
             }
             
            return ;
           
        }
        if(nodeStart.Leftnode!=null){
            valuesfound+=1;
            find(nodeStart.Leftnode,nodeEnd);
            valuesfound-=1;
        }
         if(nodeStart.Rightnode!=null){
            valuesfound+=1;
            find(nodeStart.Rightnode,nodeEnd);
            valuesfound-=1;
        }
          if(nodeStart.bottomnode!=null){
            valuesfound+=1;
            find(nodeStart.bottomnode,nodeEnd);
            valuesfound-=1;
        }
           if(nodeStart.upnode!=null){
            valuesfound+=1;
            find(nodeStart.upnode,nodeEnd);
            valuesfound-=1;
        }
        
    }
    
    
    static void printTree(MartNode node,List<MartNode>l){
        l.add(node);
        
        if(f < node.c)
        {f=node.c;
        nodeEnd=node;
        }
        
    
        if(node.Leftnode!=null){
            if(node.Leftnode.c <= node.c)
            node.Leftnode.c=node.c+1;
            printTree(node.Leftnode,l);
            l.clear();
        }
        if(node.Rightnode!=null){
            if(node.Rightnode.c <= node.c)
            node.Rightnode.c=node.c+1;
            printTree(node.Rightnode,l);
            l.clear();
        }
        if(node.bottomnode!=null){
            if(node.bottomnode.c <= node.c)
            node.bottomnode.c=node.c+1;
            printTree(node.bottomnode,l);
            l.clear();
        }
        if(node.upnode!=null){
            if(node.upnode.c <= node.c)
            node.upnode.c=node.c+1;
            printTree(node.upnode,l);
            l.clear();
        }
         
        
    }
    
    static void listP(List<MartNode>l){
        for(MartNode m:l){
            System.out.print(m.val+" ");
        }
        System.out.println("");
    }
    static void printAll(MartNode mNode,List<MartNode>l){
       
        l.add(mNode);
      //  listP(l);
        
        if(mNode.Rightnode !=null){
           
            printAll(mNode.Rightnode, l);
            l=new ArrayList<MartNode>();
            l.add(mNode);
        }
        if(mNode.Leftnode !=null){
        
            printAll(mNode.Leftnode, l);
             l=new ArrayList<MartNode>();
            l.add(mNode);
        }
        if(mNode.upnode !=null){
          
            printAll(mNode.upnode, l);
             l=new ArrayList<MartNode>();
            l.add(mNode);
        }
        if(mNode.bottomnode !=null){
            
            printAll(mNode.bottomnode, l);
             l=new ArrayList<MartNode>();
         l.add(mNode);   
        }
        
        
        
    }
    
    static void readInput() throws Exception{
	URL file = new URL("http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt");	
            

      // BufferedReader br=new BufferedReader(new FileReader(new File("/Users/gautamverma/Documents/workspaceL/Tre/giftec.txt")));
       BufferedReader br = new BufferedReader(new InputStreamReader(file.openStream()));  
		String line=null;int j=0;
                line=br.readLine();
                 int row=Integer.parseInt(line.split(" ")[0]);
                 int col=Integer.parseInt(line.split(" ")[1]);
                 mr=row;
                 mc=col;
                 a=new int[row][col];
                 b=new MartNode[row][col];
		while( (line=br.readLine())!=null  ){
		
			String[] l=line.split(" ");
			for(int i=0;i<l.length;i++){
				a[j][i]=Integer.parseInt(l[i]);
                                MartNode ml=new MartNode();
                                ml.val=a[j][i];
                                b[j][i]=ml;
                        }
			j=j+1;
		}
                
	       
	}
    
           
        static void doMagic()
        {
            
            for(int i=0;i<a.length;i++){
                
                for(int j=0;j<a.length;j++){
                     
                    MartNode node=b[i][j];
                    int h=1;
                    for (int k = 0; k < 4; k++) {

            int xx = i + x[k];
            int yy = j + y[k];
               
            if (((xx >= 0 && yy >= 0) && (xx < mr && yy < mc))) {
                     if(h==1){
                         if(b[i][j].val>b[xx][yy].val)
                         node.Rightnode=b[xx][yy];
                     }
                     else if(h==2){
                         if(b[i][j].val>b[xx][yy].val)
                         node.Leftnode=b[xx][yy];
                     }
                     else if(h==3){
                         if(b[i][j].val>b[xx][yy].val)
                         node.bottomnode=b[xx][yy];
                     }
                     else if(h==4){
                         if(b[i][j].val>b[xx][yy].val)
                         node.upnode=b[xx][yy];
                     }
                     
            }
            h+=1;
                  
                    
                }h=1;  
                
            }
            
        }
        }
        
        
        
        
}
