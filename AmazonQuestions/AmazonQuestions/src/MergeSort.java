/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//import java.util.HashSet;
//import java.util.Set;

/**
 *
 * @author gautamverma
 */
public class MergeSort {
  
    int a[]=new int[]{5,200,4,10,9,8,100};
    
    void start(int a[]){
        
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

    
    void disp(int a[])
    {
        System.out.println();
        for(int d:a){
            System.out.print(d+" ");
        }
        System.out.println();
    }
    
     void mergeSort(int a[],int[]l,int r[]) {
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
    
    
    
    public static void main(String args[]){
        
        MergeSort ms=new MergeSort();
        ms.start(ms.a);
        ms.disp(ms.a);
     
      
        
    }
    
}
