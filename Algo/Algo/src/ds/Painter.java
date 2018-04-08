/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gautamverma
 */
public class Painter {
    
    int a[]=new int[]{10,20,30,40};
    int k=2;
    List<List<Integer>> Mlist=new ArrayList<List<Integer>>();
        List<Integer> tlist;

    void create(int index){
        List<Integer>l=new ArrayList<>();
        for(int i=index;i<a.length;i++){
            l.add(a[i]);
         //   System.out.println(l);
            tlist=new ArrayList<Integer>();
            tlist.addAll(l);
             Mlist.add(tlist);
            

        }
        index+=1;
        if(index<a.length)
        create(index);
    }
    
    void findNow(List<List<Integer>> Mlist,int index){
        
        for(int i=index;i<Mlist.size();i++){
            int t=1;
                 System.out.println("i:"+Mlist.get(i));
                for(int j=i+1;j<Mlist.size();j++){
                if(t<k){
                System.out.println(Mlist.get(j));
                t++;
                }
                else{
                    System.out.println("-----");
                
                t=1;
                j=j-1;
                }
                }
                
            
        }
        
    }
    
    void start()
    {
        
            for(int i=0;i<1;i++){
                create(i);
            }
        findNow(Mlist,0);
    }
    
    public static void main(String []args){
        
        Painter p=new Painter();
        p.start();
       //System.out.println(p.Mlist);
        
    }
}
