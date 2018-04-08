/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gautamverma
 */
public class Pattern {

    String a[] = new String[]{"a", "b", "c"};
    int n = 2;
    List<List<List<String>>> ml = new ArrayList<List<List<String>>>();
    List tmp;

    void match(List<List<String>> l) {

        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < 3; j++) {
                List<List<String>> tl = new ArrayList<List<String>>();

                //    tl.addAll(l.get(i));
                List<String> ltemp = new ArrayList<String>();
                ltemp.addAll(l.get(i));
                ltemp.add(a[j]);

                if (ltemp.size() <= n) {
                    int v=verify(ltemp);
                     if(v==1)
                    tl.add(ltemp);
                    if (ltemp.size() == n) {
                        ml.add(tl);
                    }
                  //  System.out.println(tl);

                    match(tl);
                }
            }
        }

    }

    int verify(List<String> test) {
        int ret=0;
       System.out.println(test);int c=1;
       int b=0;
       //test for b//
       for(String s:test){
           if(s=="b")
           {
               b=b+1;
           }
       }
       
       if(test.lastIndexOf("c") - test.indexOf("c") == 1){
          c=1;
          
       }
       
       
       if(b>1 ){return 0;}
       else if(c==1){
        return 1;}
       else
       {
           return 1;
       }
    }

    void start() {
        List<List<String>> y = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            //if(tmp==null)tmp=new ArrayList();
            List<String> tmp = new ArrayList<String>();
            tmp.add(a[i]);
            y.add(tmp);
        }

        match(y);
          System.out.println("ml:"+ml);
    }

    public static void main(String[] args) {

        Pattern p = new Pattern();
        p.start();

    }

}
