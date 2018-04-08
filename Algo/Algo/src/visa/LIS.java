/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gautamverma
 */
public class LIS {
    
    
    public static void main(String args[]){
        
        String s="4236";
        List<String> l=new ArrayList<String>();
        char c[]=s.toCharArray();
        
        String t="";
        for(int i=0;i<c.length-1;i++){
            t=t+c[i];
            if(c[i+1]>c[i]){
                t=t+c[i]+c[i+1];
                l.add(t);
            }else
            {
                t="";
            }
            
            
    }
        System.out.println(l);
        
    }
    
}
