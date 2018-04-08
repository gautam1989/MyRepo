/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class MorganAndString {
    
    
    
    
    
    public static void main(String args[]){
       
        StringBuilder sb=new StringBuilder();
        Scanner s=new Scanner(System.in);
        int c=Integer.parseInt(s.nextLine());
        
        if( !(c>=1 && c<=5)){return;}
        
        for(int i=1;i<=c;i++){
            
            char fi[]=s.nextLine().toCharArray();
            char se[]=s.nextLine().toCharArray();
            
               Deque<Character> stackFi = new ArrayDeque<Character>();
               Deque<Character> stackSe = new ArrayDeque<Character>();
               
              for(int l=fi.length-1;l>=0;l--){
                  stackFi.push(fi[l]);
              }
              
              for(int l=se.length-1;l>=0;l--){
                  stackSe.push(se[l]);
              }
              
              String temp="";
              List<Character>l1=new ArrayList<Character>();
              List<Character>l2=new ArrayList<Character>();
              int flag=0;
              while(!stackFi.isEmpty() && !stackSe.isEmpty()){
                  
                  
                  if(stackFi.peek() == stackSe.peek()){
                       if(stackFi.size()==1){
                           temp+=stackFi.pop();
                           flag=1;  
                       }else{
                           temp+=stackSe.pop();
                           flag=1;
                       }
                       
                      while(!stackFi.isEmpty() && !stackSe.isEmpty() && flag==0)
                      {
                          
                           l1.add(stackFi.pop());
                           l2.add(stackSe.pop());
                           if(stackFi.peek() == stackSe.peek()){
                               continue;
                           }
                           else
                           {
                               if(stackFi.peek() > stackSe.peek()){
                                   for(int i2=0;i2<l1.size();i2++){
                                       temp+=l2.get(i2);
                                       stackFi.push(l1.get(i2));
                                   }
                               }else
                               {
                                   for(int i2=0;i2<l2.size();i2++){
                                       temp+=l1.get(i2);
                                       stackSe.push(l2.get(i2));
                                   }
                               }
                               
                           }
                           l1.clear();;
                           l2.clear();
                           break;
                      }
                      
                      
                      
                      
                  }
                  
                 if(!stackFi.isEmpty() && !stackSe.isEmpty()){ 
                  
                  if( stackFi.peek() > stackSe.peek() )
                  {
                      temp=temp+stackSe.pop();
                  }else
                  {
                      temp=temp+stackFi.pop();
                  }
                 }
                  
              }
              if(!stackFi.isEmpty()){
                  while(!stackFi.isEmpty()){
                      temp+=stackFi.pop();
                  }
              }
              
              if(!stackSe.isEmpty()){
                  while(!stackSe.isEmpty()){
                      temp+=stackSe.pop();
                  }
              }
            //  System.out.println("");
            System.out.println(temp);
         
        }
        
        
    }
    
}
