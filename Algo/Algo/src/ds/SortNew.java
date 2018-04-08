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
public class SortNew {
    
    
    static int []a=new int[]{8,8,8,9,9,11,15,16,16,16};
    static int c=0;
    static int tot=0;
    
    static int sort(int []a,int st,int end,int c){
       // System.out.println("s: ");
       // disp(a,st,end);
        if(a[st]==c && a[end]==c)
        {
            tot=(end-st)+1;
            System.out.println(tot +" for "+c);
            if(a[end+1]==c){
                sort(a, st, end+1, c);
            }else 
            {
                
                sort(a, end+1, a.length-1, a[end+1]);
            }
            //disp(a,st,end);
           
            return 0;
        }else
        {
       //   System.out.print("st:"+st+"  ");
         //   System.out.println((st+end)/2);
            sort(a, st, ((st+end)/2),c);
            
        }
        return 0;
        
    }
    
    static void disp(int []a,int st,int end){
        for(int i=st;i<=end;i++)
        {
            System.out.println(a[i]);
        }
        
    }
    
    public static void main(String args[])
    {
        
        sort(a, 0, a.length-1,a[0]);
        
        
        
    }
}
