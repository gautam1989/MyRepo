/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author gautamverma
 */
class SumSet {
    
    
    Integer[]numbers;
    int target;
   static ArrayList<ArrayList<Integer>>ret=new ArrayList<ArrayList<Integer>>();
    public int[] solution(int N) {
        Integer[] numbers = {1,3,4,5,6,7,8,9,10,11};
        int target = N;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
      
        int re[]=new int[ret.get(0).size()];
        for(int i=0;i<ret.get(0).size();i++){
            re[i]=ret.get(0).get(i);
        }
       return re;
    }


    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
       int s = 0;
       for (int x: partial) s += x;
       if (s == target){
           int v=0;
         
            for(int i=0;i<partial.size();i++){
                if((partial.get(i)%2)==0){
                   v=1; 
                }
            }
            if(v==1){
                v=0;
            }else
            {
                ret.add(partial);
            }
       }
       if (s >= target)
            return;
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    public static void main(String args[]) {
        SumSet s=new SumSet();
        System.out.println(s.solution(8)[2]);
    }
}
