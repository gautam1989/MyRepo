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
public class COmbi {
    
    static StringBuilder sb=new StringBuilder("wxyz");
    static StringBuilder o=new StringBuilder();
    public static void main(String []args){
        
        
        int start=0;
        int end=sb.length();
        combine(start, end);
      //  System.out.println(o);
    }
    
    
    
    public static void combine(int start,int end){
        
        for(int i=start;i<end;i++){
            o.append(sb.charAt(i));
            System.out.println(o);
            if(i<end){
                combine(i+1, end);      
            }
            o.setLength(o.length()-1);
        }
        
    }
    
}
