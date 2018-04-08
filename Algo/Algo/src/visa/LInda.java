/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class LInda {
 
    static List<String []> l;
    static List<String> ll=new ArrayList<String>();
    
  
    
    public static void findMod(List<String[]>a){
        
        for(int i=0;i<a.size();i++){
            
            String t[]=a.get(i);
            BigInteger A1=new BigInteger(t[0]);
            BigInteger A2=new BigInteger(t[1]);
            BigInteger A3=new BigInteger(t[2]);
            if(A2.intValue() < 0){
             
                
             double d=Math.pow(A1.doubleValue(), -1);
                
                System.out.println((int)Math.pow(d, A2.doubleValue()));
              
                
            }else
            {
               BigInteger p=A1.pow(A2.intValue());
                ll.add(p.mod(A3).toString());
            }
            
            
            
        }
        
        System.out.println(ll);
    }
    
    
    public static void main(String args[]){
         Scanner in = new Scanner(System.in);
         l=new ArrayList<String[]>();
        
        int c=Integer.parseInt(in.nextLine());
        
        
        for(int i=0;i<c;i++){
            String a[]=new String[3];
            String line=in.nextLine();
            for(int j=0;j<3;j++){
                a[j]=(line.split(" ")[j]);
            }
            l.add(a);
        }
        
        
        
        findMod(l);
        
        
        
        
        
        
    
       
    }
    
}
