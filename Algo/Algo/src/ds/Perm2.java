/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author gautamverma
 */
public class Perm2 {

    String a = "1234";
    List<Character> qc = new LinkedList<Character>();

    void addTOQueue(List<Character> qc,List<Character> qn, char c) {
        if (qn.isEmpty()) {
            qn.add(c);
            System.out.println("o"+qn);
            addTOQueue(qc, qn, c);
        }else
        {
               for(int i=0;i<a.length();i++){
                   List<Character> cl=new LinkedList<>();
                   cl.addAll(qn);
                    cl.remove(qn.size()-1);
                if(!cl.contains(a.charAt(i))){
                    
                    
                   cl.add(a.charAt(i));
                   System.out.print(cl);
                    
                }
                   System.out.println();
            }
               addTOQueue(qc, qn,c);
        }
    }

    void start() {

        for (int i = 0; i < a.length(); i++) {
            List<Character> qn = new LinkedList<Character>();

            addTOQueue(qc,qn, a.charAt(i));
        }

    }

    public static void main(String args[]) {

   Perm2 p=new Perm2();        p.start();

    }

}
