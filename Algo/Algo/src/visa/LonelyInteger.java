/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {
   static int lonelyinteger(int[] a) {
       Map<Integer,Integer>map=new HashMap<Integer,Integer>();
        for(int i=0;i<a.length;i++){
            int c=0;
            if(map.get(a[i])!=null){
                c=map.get(a[i])+1;
                map.put(a[i], c);
            }else
            {
                map.put(a[i], 1);
            }
        }
        System.out.println(map);
        for(Integer i:map.keySet()){
            if(map.get(i)==1)return (i);
        }
        
        
        return 0;
    }
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = lonelyinteger(_a);
        System.out.println(res);
        
    }
    
     
}

