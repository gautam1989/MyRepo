/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobilewalla;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author gautamverma
 */
public class duplicate {
    static int a[] = {1,1,2,3,4,5};
    static ArrayList<Integer> res= new ArrayList<Integer>();
    static int res1[] = new int[11];
    public static ArrayList<Integer> findDuplicates(int a[]){
        
        HashSet set = new HashSet();
        int i=0;
        for(int val:a){
            if(!set.add(val)){
                res.add(val);
                res1[i] = val;
                //System.out.println(val);+
                i++;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println("Duplicate elements are");
        for(int val:findDuplicates(a)){
            if(val!=0){
                System.out.println(val);
            }
        }
    }
}