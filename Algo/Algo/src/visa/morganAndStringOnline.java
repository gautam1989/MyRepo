/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class morganAndStringOnline {
    
    
    static void test(){
        Scanner s=new Scanner(System.in);
        int T=Integer.parseInt(s.nextLine());
        while(T>0){
        String result="";
        int i=0,j=0;
        char a[]=s.nextLine().toCharArray();
        char b[]=s.nextLine().toCharArray();
        int len1=a.length;
        int len2=b.length;
            while( i<len1 && j<len2 ){
            if( a[i]==b[j] )
            {   
                int x=i,y=j,flag=1;
                while( x<len1 && y<len2 && flag==1)
                    {
                         if( a[x]<b[y] )
                         {   result+=(a[i]);
                             i++;
                             flag=0;
                         } 
                         if( a[x]>b[y])
                         {  result+=(b[j]);
                             j++;
                             flag=0;
                         }
                        x++;y++;
                    }
                if( flag == 1)
                 {
                    result+=(a[i]);
                    i++;
                }
                      
            }
            if(i< a.length && j<b.length){    
            if( a[i]<b[j] )
            {   result+=(a[i]);
                i++;
            } 
            if( a[i]>b[j])
             {  result+=(b[j]);
                j++;
             }
            }
        }
        
        
            while(i<len1)
            {
                result+=(a[i]);
                i++;
            }
            while(j<len2)
            {
                result+=(b[j]);
                j++;
            } 
            
            System.out.println(result);
    }
        T--;
    
}
        
    
    
    public static void main(String []args){
        
        
        test();
    }
    
}
