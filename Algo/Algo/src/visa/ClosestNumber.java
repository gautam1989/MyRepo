/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class ClosestNumber {
    
    
      static void start(int a[]){
        
        if(a.length>1){
        int brindex=a.length/2;
        
        int l[]=new int[brindex];
        for(int i=0;i<brindex;i++){
            l[i]=a[i];
           
        }
        
        int r[]=new int[a.length-brindex];
        int j=brindex;
        for(int i=0;i<a.length-brindex;i++){
            //System.out.println(brindex++);
            
            r[i]=a[j++];
        }
        
        start(l);
        start(r);
        
        mergeSort(a,l,r);
        }
        
        
        
    }
      
      
      static void mergeSort(int a[],int[]l,int r[]) {
         int k=0;
         int lp=0,rp=0;
         while(k<a.length){
             
             if(lp < l.length && rp < r.length){
                 if( l[lp] >= r[rp] ){
                     a[k]=r[rp];
                     rp=rp+1;
                 }else
                 {
                     a[k]=l[lp];
                     lp=lp+1;
                 }
                 k=k+1;
             }else
             {
                 if(lp<l.length){
                     while(lp<l.length)
                     {
                         a[k]=l[lp];
                         lp=lp+1;
                         k=k+1;
                     }
                 }else if(rp<r.length)
                 {
                     a[k]=r[rp];
                         rp=rp+1;
                         k=k+1;
                 }
             }
             
             
             
         }
         
    }
    static void disp(int a[])
    {
        System.out.println();
        for(int d:a){
            System.out.print(d+" ");
        }
        System.out.println();
    }
    
    public static void main(String []args){
        
        Scanner s=new Scanner(System.in);
        int c=Integer.parseInt(s.nextLine());
        
        int a[]=new int[c];
        for(int i=0;i<c;i++){
            a[i]=s.nextInt();
        }
       
        start(a);
        
       List<Integer>l=new ArrayList<Integer>();
       int currentsmal=0;
       
       for(int i=0;i<a.length-1;i++){
           
               if(i==0){currentsmal=a[i+1]-a[i];l.clear();
                   l.add(a[i]);l.add(a[i+1]); continue;}
               if(a[i+1]-a[i]<currentsmal)
               {
                   currentsmal=a[i+1]-a[i];
                   l.clear();
                   l.add(a[i]);l.add(a[i+1]);
               }else if(a[i+1]-a[i]==currentsmal){
                   l.add(a[i]);l.add(a[i+1]);
               }
           
       }
        for(Integer i:l)System.out.print(i+" ");
        
    }
    
}
