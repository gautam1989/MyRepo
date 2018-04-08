/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gautamverma
 */
public class BracketTest {
 
    
      static Deque<String> stack = new ArrayDeque<String>();
      static String a="[](){}<>";
     
      static Map map=new HashMap<String, Integer>();
    
      
      public static void main(String args[]){
          String sp[]=a.split("");
          for(int i=0;i<a.split("").length;i++){
              
              if(stack.isEmpty()){
                  stack.push(sp[i]);
              }else
              {
                  checkForbaracket(stack.peek(),sp[i]);
              }
              
              
          }
          if(stack.isEmpty()){
              System.out.println("valid list");
          }else System.out.println("Invalid list");
                  
      }
      
      
      static void checkForbaracket(String inStack,String nextVal){
          
          switch (inStack){
              case "(":
                 
                  if(nextVal.equals(")")){
                      stack.pop();}
                  else{
                      stack.push(nextVal);}
                  break;
                  
              case ")":
                  if(nextVal.equals("("))
                      stack.pop();
                  else
                      stack.push(nextVal);
                  break;
              case "[":
                  if(nextVal.equals("]"))
                      stack.pop();
                  else
                      stack.push(nextVal);
                  break;
                  
              case "]":
                  if(nextVal.equals("["))
                      stack.pop();
                  else
                      stack.push(nextVal);
                  break; 
                  
               case "{":
                  if(nextVal.equals("}"))
                      stack.pop();
                  else
                      stack.push(nextVal);
                  break;
               case "}":
                  if(nextVal.equals("{"))
                      stack.pop();
                  else
                      stack.push(nextVal);
                  break;
          }
                  
      }
    
}
