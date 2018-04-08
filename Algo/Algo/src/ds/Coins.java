/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gautamverma
 */
public class Coins {
    
    List<Integer> c=new ArrayList<Integer>();
    
    Map<Integer,Integer>m=new HashMap<Integer, Integer>();
    int sum=11;
    
    void calcSum(int i){
        if(c.contains(i)){
            m.put(i, 1);
        }else
        {
            int numberpresent=m.get(i-1);
            int toget=i-(i-1);
            int numberneeded=m.get(toget);
            System.out.println(i+" "+numberpresent+" "+toget+" "+numberneeded);
            m.put(i, numberneeded+numberpresent);
        }
    }
    
    void start()
    {
    c.add(1);c.add(3);c.add(5);
    for(int i=1;i<=sum;i++){
        calcSum(i);
    }    
        
    }
    
    public static void main(String args[]){
        Coins c=new Coins();
        c.start();
        System.out.println(c.m);
    }
    
}
