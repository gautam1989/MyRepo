/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gautamverma
 */
public class LoveLetter {

    
    StringBuffer input=new StringBuffer("cba");
    List<String> l=new ArrayList<String>();
    int c=0;
    public void start()
    {
        
        StringBuffer inputm=new StringBuffer("cba");
        int l=input.length()-1;
        int s=0;
        
        find(inputm,0,inputm.length()-1);
        System.out.println("c:"+c);
        
        
    }
    
    
      void find(StringBuffer s,int start,int end)
      {
          
           
            
            char f=s.charAt(start);
            char la=s.charAt(end);
            if(  f!=la && ((int)f < (int)la)    ){
               char n=(char) ((int)la -1);
                
                 
                s.setCharAt(end, n);
                c=c+1;
                System.out.println(s);
                find(s, start, end);
                
        }
            if(f!=la && ((int)f > (int)la)   ){
                char n=(char) ((int)la +1);
                
                 
                s.setCharAt(end, n);
                c=c+1;
                System.out.println(s);
                find(s, start, end);
            }
            else if(f==la)
            {
                if(start<end)
                find(s, start+1, end-1);
            }
            else if(findPalindromes(s))
            {
              //  System.out.println("FOUND"+c);
                
                return;
            }
      }
    
      boolean findPalindromes(StringBuffer f){
           int j=f.length()-1;
           boolean v=true;
          for(int i=0;i<f.length()-1;i++){
              if(i<=j){
             if(!(f.charAt(i)==f.charAt(j))){
                      v=false;
             }
             j=j-1;
              }
          }
          return v;
      }
      
    
    public static void main(String args[]){
        
        LoveLetter l=new LoveLetter();  l.start();
        
        
        
        
        
    }
    
}


//if(s.equals(input)){
//                    return;
//                }else
//                {
//                    if()
//                }
//                