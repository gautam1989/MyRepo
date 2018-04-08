/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gautamverma
 */
public class PermSwap {

    StringBuffer str=new StringBuffer("123");
    String m=str.toString();
  //  Set<String> s=new HashSet<String>();
    void doPerm(StringBuffer str,int index){
      
       // s.add(str.toString());
        System.out.println(str);
        System.out.println(index);
            
            for(int i=0;i<str.length()-1;i++){
            
                if(i==str.length()-2){
//                char temp2=str.charAt(i);
//                str.setCharAt(i, str.charAt(0));
//                str.setCharAt(0, temp2);
                char temp=str.charAt(index);
                str.setCharAt(index, str.charAt(index+1));
                str.setCharAt(index+1, temp);
                    System.out.println("s:"+str);
                    doPerm(str, index);
                    
//                      
                }else
                {
                char tm=str.charAt(index);
                str.setCharAt(index, str.charAt(0));
                str.setCharAt(0, tm);
                
                char temp=str.charAt(i+1);
                str.setCharAt(i+1, str.charAt(i+2));
                str.setCharAt(i+2, temp);
               // System.out.println(str);
                doPerm(str, index+1);
                }
                
                
        }
        
        
        
        
    }
    
    void start()
    {
        
        doPerm(str, 0);
        //System.out.println(s);
    }
    
    public static void main(String args[]){
        
        
        PermSwap ps=new PermSwap();
        ps.start();
    }
    
}
