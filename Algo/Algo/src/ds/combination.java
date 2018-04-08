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
public class combination {

    static int a[] = new int[]{1, 2,3,4};
    static List<List> mainList = new ArrayList<List>();
                static List<List> tempmainList = new ArrayList<List>();

    public static void main(String args[]) {

        List<List> temp = new ArrayList<List>();

        if (mainList.isEmpty()) {
            for (int i = 0; i < a.length; i++) {
                List temp2 = new ArrayList();
                temp2.add(a[i]);
                mainList.add(temp2);
            }
            System.out.println(mainList);
        //createCombination(temp,0);

            for(;;){
                int g=0;
                g=mainList.get(0).size();
            for (int i = 0; i < mainList.size(); i++) {
                createCombination(mainList.get(i), i,tempmainList);
                
            }
            
            mainList.clear();
            mainList.addAll(tempmainList);
             tempmainList.clear();
                System.out.println(mainList);
            if(mainList.get(0).size()>2)
                break;
              
            }
        }
    }

    public static void createCombination(List<List> temp, int j,List<List>tempMainList) {
       
        for (int i = j + 1; i < a.length; i++) {
            List temp2 = new ArrayList();
            temp2.addAll(temp);
            temp2.add(a[i]);
            tempMainList.add(temp2);
           // temp.add(temp2);
        }
    //    System.out.println(temp);
    }

}
