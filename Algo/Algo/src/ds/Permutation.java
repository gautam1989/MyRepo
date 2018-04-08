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
public class Permutation {

    String s="AABC";
    List<List> mList=new ArrayList<List>();
    
    
    
     void permutate(String s,int pos,List<Character>tl){
        
         if(tl.isEmpty()){
             tl=new ArrayList<>();
             tl.add(s.charAt(pos));
             permutate(s, pos, tl);
         }else
         {
             for(int i=0;i<s.length();i++){
                 if(!tl.contains(s.charAt(i))){
                     List<Character> temp=new ArrayList<>();
                     temp.addAll(tl);
                     temp.add(s.charAt(i));
                     if(temp.size()==3)
                     mList.add(temp);
                     permutate(s, pos, temp);
                 }
             }
         }
         
    }
    
    void start()
    {
        for(int i=0;i<s.length();i++)
        permutate(s,i,new ArrayList<Character>());
        
        System.out.print(mList);
    }
    
    public static void main(String args[]){
        
        Permutation p3=new Permutation();
        p3.start();;
        
        
        
        
    }
    
}
