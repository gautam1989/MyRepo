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
public class N {
    
    
    
    public static void main(String args[]){
        
        
        
         int n1 = Integer.parseInt("825");
       int n2 = Integer.parseInt("1161"); 
       int temp1 = n1;
       int temp2 = n2; 

       while (n1 != n2){
         if(n1 > n2)
            n1 = n1 - n2;
         else
            n2 = n2 - n1;
       }      

      int n3 = temp1 / n1 ;
      int n4 = temp2 / n1 ;

      System.out.print("\n Output :\n");

      System.out.print(n3 + "/" + n4 + "\n\n" );
      System.exit(0);
    }  
     
//        int f=825,l=1161;
//        
//        int g=0;
//        
//        process(f,l);
//        
        
    }
    
    
//    static void process(int a,int b){
//        
//        if(a>b){
//            return;
//        }else
//        {
//            int temp=b;
//            b=a;
//            
//            int vt=temp/a;
//            a=temp%a;
//            
//            
//            if(a==0){
//                 System.out.println("a:"+vt+"b:"+b); 
//                return;
//            }
//          
//        }
//        System.out.println("a:"+a+"b:"+b);
//        process(a, b);
//    }
    

