/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author gautamverma
 */


class Per implements Comparator<Per>{

    public int age;
    @Override
    public int compare(Per o1, Per o2) {
        if(o1.age > o2.age){
            return 1;
        }else if(o1.age < o2.age){
            return -1;
        }else{
            return 0;
        }
    }

   
    
}
public class Compare {
 
    public static void main(String []args){
        Per per1=new Per();
    per1.age=100;
    
    Per per2=new Per();
    per2.age=220;
    
    List<Per>l=new ArrayList<Per>();
    l.add(per2);l.add(per1);
       for(Per f:l){
           System.out.println(f.age);
       }
        System.out.println("");
    
    Collections.sort(l,new Per());
       for(Per f:l){
           System.out.println(f.age);
       }
    }
    
    
    
}
