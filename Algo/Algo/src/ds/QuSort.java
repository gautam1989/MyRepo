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
public class QuSort {
    
    
    public static void main(String[] args) {
        int a[]={7,2,1,6,8,5,3,4};
        
        int pivot=a.length-1;
        int pindex=0;
         for(int i=0;i<a.length;i++)
         {
             
             if(a[pivot] >a[i]){
                 int t=a[i];
                 a[i]=a[pindex];
                 a[pindex]=t;
                 pindex=pindex+1;
             }
             
            
         }
         
         int t=a[pivot];
         a[pivot]=a[pindex];
         a[pindex]=t;
         for(int h:a)
         {
             System.out.println(h+" ");
         }
    
    }
    
}
