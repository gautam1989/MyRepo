/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyscaner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class NewSub {

    static int till = 0;
    static int val = 0;

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        String[] values = s.nextLine().split(" ");
        till = Integer.parseInt(values[0]);
        val = Integer.parseInt(values[1]);

        int[] S = new int[till];
        for (int i = 1; i <= till; i++) {
            S[i - 1] = i;
        }
        int sizeOfList = 0;
        for (List l : subsets(S)) {
            if (l.size() == val) {
                sizeOfList += 1;
            }
        }
        System.out.println(sizeOfList);
        for (List<Integer> l : subsets(S)) {
            if (l.size() == val) {
                for (int k : l) {
                    System.out.print(k + " ");
                }
                System.out.println("");
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        ans.add(new ArrayList<Integer>());

        Arrays.sort(S);

        for (int i = 0; i < S.length; i++) {

            int curSize = ans.size();

            for (int j = 0; j < curSize; j++) {

                ArrayList<Integer> cur = new ArrayList<Integer>(ans.get(j));

                cur.add(S[i]);
              
               // if(cur.size()>val)return ans;
                ans.add(cur);
               // System.out.println(ans);
            }

        }
       
        return ans;

    }
}
