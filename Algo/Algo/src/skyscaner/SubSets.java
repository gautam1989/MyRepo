/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyscaner;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author gautamverma
 */
public class SubSets {  
    
    static Set<Set<Integer>>Mset=null;
    static Set<Set<Integer>>Mainset=null;
    static int till=0;
    static int val=0;
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        String []values=s.nextLine().split(" ");
         till=Integer.parseInt(values[0]);
         val=Integer.parseInt(values[1]);
        Rrun();
        int sizeOfList=0;
        for(Set l:Mainset){
            if(l.size()==val){
                sizeOfList+=1;
            }}
        System.out.println(sizeOfList);
        for(Set l:Mainset){
            if(l.size()==val){
                
            Iterator itr=l.iterator();
            while(itr.hasNext()){
                System.out.print(itr.next()+" ");
            }
            System.out.println("");
        }}
    }
    
   public static void Rrun()
    {
         List<Integer>l=new ArrayList<Integer>();
        for(int i=1;i<=till;i++){
            l.add(i);
        }
         Mset=new HashSet<>();Mainset=new HashSet<>();
       int k=9;
        for(int i=1;i<=k;i++){
            
            findAllSets(l,i);
        
        }
        
        
    }
    
    static Set<Integer> findAllSets(List l,int k){
        Set<Integer> sn=new HashSet<Integer>();
       if(Mset.isEmpty()){
           for(int i=0;i<l.size();i++){
               Set<Integer>s=new HashSet<Integer>();
               s.add((int)l.get(i));
            //   System.out.println("s:"+s);
               Mset.add(s); 
           }
           
       }
       else
       {
           Iterator<Set<Integer>> i=Mset.iterator();
           
           while(i.hasNext()){
               
               Set<Integer> s=(Set<Integer>)i.next();
              if(s.size()<=k){
               for(int j=0;j<l.size();j++){
                  sn=new HashSet<Integer>();
                   sn.addAll(s);
                   sn.add((int)l.get(j));
               
              
                   Mainset.add(sn);
                   
                  
               }
              }else
              {
                  
              }
           } Mset.clear();
           Mset.addAll(Mainset);
       }
        return sn;
    }
        
}
	