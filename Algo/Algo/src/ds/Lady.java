/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SizeRequirements;

/**
 *
 * @author gautamverma
 */
public class Lady {

    String s="10,10,12,15,16,20,45,65,120,140,150,178,198,200,210,233,298,306,307,310,375,400,420,411,501,550,662,690,720,731,780,790";
  
    List<List> mList=new ArrayList<List>();
    String chk[]=s.split(",");
    
    
     void permutate(String []chk,int pos,List<String>tl){
        
         if(tl.isEmpty()){
             tl=new ArrayList<>();
             tl.add(chk[pos]);
             permutate(chk, pos, tl);
         }else
         {
             for(int i=0;i<chk.length;i++){
                 if(!tl.contains(chk[i])){
                     List<String> temp=new ArrayList<>();
                     temp.addAll(tl);
                     temp.add(chk[i]);
                   //  if(temp.size()==3)
                     
                     chkForSum(temp);
                     
                     
                     permutate(chk, pos, temp);
                 }
             }
         }
         
    }
    
      void chkForSum(List<String> t){
          int sum=0;
         for(int i=0;i<t.size();i++){
             sum=sum+Integer.parseInt(t.get(i));
             if(sum >3000){
                 t.remove(t.size()-1);
                 mList.add(t);
                 return;
             }
         }
     }
     
    void start()
    {
        for(int i=0;i<chk.length;i++)
        permutate(chk,i,new ArrayList<String>());
        
        System.out.println("Possible ways are:"+mList);

    }
    
    static int calculate(List<String> st)
    {
        int sum=0;
        for(int i=0;i<st.size();i++){
            sum=sum+Integer.parseInt(st.get(i));
        }
        System.out.println("SUM:"+sum);
        return sum;
    }
    public static void main(String args[]){
        
        Lady p3=new Lady();
        p3.start();;
        
        
        
        
    }
    
}
