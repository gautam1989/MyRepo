/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class CommonChild {

   List<String> l=new ArrayList<String>();
   static List<String> l2=new ArrayList<String>();
    
    public static void findTheCommon(String first,String second){
         List<Integer>il=new ArrayList<Integer>();
        int i=0;
        int j=0;
        String []f=first.split("");
        String []s=second.split("");
        String temp="";
        int it=0;
        while(it<first.length())
        {
            
            while(j<second.length()){
                
                
                 if(i >=first.length() || j>=first.length())break;
                if(f[i].equals(s[j])){
                
                temp+=f[i];
              //  System.out.println(temp);
                i++;j++;
                        }else
                {
                    j++;
                }
                
            }
            
            if(i < first.length()){i++;j=0; continue;}else
            {
        //    l2.add(temp);
            temp="";
            it++;
            i++;
           j=0;
            }
        }
        
      //  System.out.println("temp "+l2);
    }
    
    public static void main(String[]args){
        
                 Scanner in = new Scanner(System.in);

                 String first=in.nextLine();
                 String second=in.nextLine();
                 findTheCommon(first,second);
                
                // findTheCommon(second,first);
        
    }
    
}
