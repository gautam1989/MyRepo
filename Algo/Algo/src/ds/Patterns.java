/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author gautamverma
 */
public class Patterns {

    static int n = 5;
    static String p = null;
    static int i = 0;

    static void rep(String result) {
        System.out.println(result);
        i++;
        if (i <= n) {

            char c[] = result.toCharArray();
            
            Deque<Character> stack = new ArrayDeque<Character>();
            int tempcount = 0;
            String nres="";
            for (int i = 0; i < c.length; i++) {
                if(result.length()==1)
                {
                    stack.push(c[i]);
                    rep("1"+c[i]);
                }
                else
                {

                    if(stack.isEmpty()==false){
                      if(stack.peek()==c[i]){
                          tempcount+=1;
                          stack.push(c[i]);
                          if(c.length-i==1){
                              nres=nres+""+tempcount+""+c[i];
                          }
                      }
                      else
                      {
                          nres=nres+""+tempcount+""+c[i-1];
                          tempcount=1;
                          stack.push(c[i]);
                            if(c.length-i==1){
                              nres=nres+""+tempcount+""+c[i];
                          }
                      }
     
                    }
                    else
                    {
                        stack.push(c[i]);
                        tempcount+=1;
                    }
                    
                }
            }
            rep(nres);
            
        }

    }


    public static void main(String args[]) {

        rep("1");
        

    }
    

}

//for(int i=1;i<=4;i++){
//            
//            if(p==null){
//                System.out.println(i);
//                p=i+"";
//                break;
//            }
//            
//            char []c=p.toCharArray();
//            
//            for(int i=0;i<c.length;i++){
//                
//            }
