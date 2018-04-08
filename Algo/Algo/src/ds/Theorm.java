/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author gautamverma
 */
public class Theorm {
    
    static int a=0,b=0,c=0;
     static Set<Set<Integer>>Mset=null;
    static Set<Set<Integer>>Mainset=null;
    static String[]val=null;
    public static void main(String args[]){
        
        
                 Mset=new HashSet<>();Mainset=new HashSet<>();
List<Integer>l=new ArrayList<Integer>();
        for(int i=1;i<=1260;i++)l.add(i);
         Mset=new HashSet<>();Mainset=new HashSet<>();
       int k=9;
        for(int i=1;i<=k;i++){
            
            findAllSets(l,i);
          //   System.out.println("Subset with" + i +":"+Mset);
        }
        if(val!=null){
        System.out.println("a: "+val[0]);
        System.out.println("b: "+val[1]);
        System.out.println("c: "+val[2]);
        }else {System.out.println("cannot find");}
        
    }
 
     static Set<Integer> findAllSets(List l,int k){
        Set<Integer> sn=new HashSet<Integer>();
       if(Mset.isEmpty()){
           for(int i=0;i<l.size();i++){
               Set<Integer>s=new HashSet<Integer>();
               s.add((int)l.get(i));
              // System.out.println("s:"+s);
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
                    // Mset.add(s);
                   if(sn.size()==3){
                  // System.out.println("sn:"+sn);
                   if( chkForValidity(sn)!=null){
                      val= chkForValidity(sn);
                      return null;
                   };
                   }
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
    
     static String[] chkForValidity(Set sn){
         Iterator itr=sn.iterator();
         while(itr.hasNext()){
             int a=(int)itr.next();
             int b=(int)itr.next();
             int c=(int)itr.next();
             if((a<b && b<c) && (a+b+c==1260)){

                if(a*a + b*b == c*c){
                 
                    String val[]={a+"",b+"",c+""};
                   return val;
                }
             }
         }
         return null;
     }
     
}
