/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

/**
 *
 * @author gautamverma
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedMart2 {

    static List<List<String>> mainList = new ArrayList<List<String>>();
    static List<Integer> possibleList = new ArrayList<Integer>();
    static Set<List<Integer>> FpossibleList = new HashSet<List<Integer>>();
    static int a[][];
    static int mr, mc;
    static Queue<Integer> queue = new LinkedList<Integer>();
    static List<String> ll = new ArrayList<String>();
    static Map<String, List<String>> map = new HashMap<String, List<String>>();
    static int b[][];
    static int x[] = {0, 0, 1, -1};
    static int y[] = {1, -1, 0, 0};
    static int c = 0;
    static int max = 0;
    static List<String> cl;
    static int rs = 0;
    static int cs = 0;
    static List<Integer> newPossibleList = new ArrayList<Integer>();
    static String lk;

    public static void main(String[] args) {

        try {
            readInput();
            cl = new ArrayList<String>();

            createMagic(0 + " " + 0, cl);
        } catch (Exception e) {

            // e.printStackTrace();
            
        } finally {
            System.out.println("FP size:" + FpossibleList);
System.out.println(lk);
        }
        //   dispMain();
        System.out.println("FP size:" + FpossibleList.size());
        dispNow();

        System.out.println(FpossibleList);

    }

    static void dispNow() {

        int size = 0;
        for (List<Integer> l : FpossibleList) {
            if (l.size() >= size) {
                size = l.size();
            }
        }
        int drop = 0;
        for (List<Integer> l : FpossibleList) {
            if (l.size() == size) {
                if (drop < l.get(0) - l.get(l.size() - 1)) {
                    drop = l.get(0) - l.get(l.size() - 1);

                }

            }

        }
        System.out.println(drop);
    }

    static void dispMain() {
        for (List<String> l : mainList) {
            List<Integer> tempList = new ArrayList<Integer>();

            for (String m : l) {
                int r = Integer.parseInt(m.split(" ")[0]);
                int c = Integer.parseInt(m.split(" ")[1]);
                tempList.add(a[r][c]);

            }
            searchList(tempList);
        }
    }

    static void searchList(List<Integer> tempList) {
        int start = 0, end = 0;
        for (int i = 0; i < tempList.size(); i++) {
            if (i > 0) {
                if (tempList.get(i) < tempList.get(i - 1)) {
                    end = end + 1;
                    possibleList = addAll(tempList, start, end);

                    if (possibleList.size() >= max) {
                        max = possibleList.size();
                        System.out.println(max);
                        FpossibleList.add(possibleList);
                    } else {
                        possibleList = null;
                    }

                } else {
                    start = i;
                    end = i;
                }
            }
        }
    }

    static List<Integer> addAll(List<Integer> temp, int s, int e) {
        List<Integer> n = new ArrayList<Integer>();
        for (int i = s; i <= e; i++) {
            n.add(temp.get(i));
        }
        return n;
    }

    static void readInput() throws Exception {
        URL file = new URL("http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt");

       //   BufferedReader br=new BufferedReader(new FileReader(new File("/Users/gautamverma/Documents/workspaceL/Tre/giftec.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(file.openStream()));
        String line = null;
        int j = 0;
        line = br.readLine();
        int row = Integer.parseInt(line.split(" ")[0]);
        int col = Integer.parseInt(line.split(" ")[1]);
        mr = row;
        mc = col;
        a = new int[row][col];
        b = new int[row][col];
        while ((line = br.readLine()) != null) {
            //	System.out.println(line);
            String[] l = line.split(" ");
            for (int i = 0; i < l.length; i++) {
                a[j][i] = Integer.parseInt(l[i]);
            }
            j = j + 1;
        }

    }

//        
//        static void dispMap(){
//            Set i=map.keySet();
//            Iterator itr=i.iterator();
//            while(itr.hasNext()){
//                String s=itr.next().toString();
//              //  System.out.println(s);
//               // System.out.println(map.get(s));
//            }
//            
//            
//            
//           System.out.println(map);
//        }
//        
    static int getVal(String cur) {
        int r = Integer.parseInt(cur.split(" ")[0]);
        int c = Integer.parseInt(cur.split(" ")[1]);
        return a[r][c];
    }

    static void displayListVal(List<String> cl) {
        System.out.println("");
        for (String s : cl) {
            System.out.print(a[Integer.parseInt(s.split(" ")[0])][Integer.parseInt(s.split(" ")[1])]);

        }

    }

    static void checkList(List<String> cl) {

        if (cl.isEmpty()) {
            return;
        }
        List<Integer> cl2 = new ArrayList<Integer>();

        for (String m : cl) {
            //  System.out.println(m);
          

             lk=m;
            rs = Integer.parseInt(m.split(" ")[0]);

            cs = Integer.parseInt(m.split(" ")[1]);
            cl2.add(a[rs][cs]);

        }
        int start = 0, end = 0;
        for (int i = 0; i < cl2.size(); i++) {
            if (i > 0) {
                if (cl2.get(i) < cl2.get(i - 1)) {
                    end = end + 1;
                    possibleList = addAll(cl2, start, end);

                    if (max < possibleList.size()) {
                        max = possibleList.size();
                        FpossibleList.add(possibleList);

                    } //                         if(possibleList.size() >=max){
                    //                            //max=possibleList.size();
                    //                             
                    //                            //FpossibleList.add(possibleList);
                    //                            
                    //                             
                    //                            
                    //                        }
                    else {
                        //FpossibleList.clear();
                        possibleList.clear();

                    }
                } else {
                    start = i;
                    end = i;

                }
            }
        }
    }

    static void createMagic(String cur, List<String> cl) {

        cl.add(cur);

        checkList(cl);
          //  displayListVal(cl);

        //new for logic
        int cx = Integer.parseInt(cur.split(" ")[0]);
        int cy = Integer.parseInt(cur.split(" ")[1]);
        for (int i = 0; i < 4; i++) {

            int xx = cx + x[i];
            int yy = cy + y[i];

            if (((xx >= 0 && yy >= 0) && (xx < mr && yy < mc))) {
                if (i > 0) {

                    if (!cl.contains(xx + " " + yy)) {
                        List<String> nl = new ArrayList<String>();
                        nl.addAll(cl);
                    // cl=new ArrayList<String>();
                        // nl.add(cur);
                       cl.clear();;
                        createMagic(xx + " " + yy, nl);
                    }
                } else {
                    if (!cl.contains(xx + " " + yy)) {
                        //   System.out.println("crate called with:"+map.get(cur).get(i));
                        List<String> l = new ArrayList<String>();
                        l.addAll(cl);
                        cl.clear();
                        createMagic(xx + " " + yy, l);
                    }
                }
            }

        }
            //
     
    }

}
