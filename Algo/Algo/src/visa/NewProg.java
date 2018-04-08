/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visa;

import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class NewProg {

    static int a[][];
    static int val, rows, cols;

    public static void main(String args[]) {
        readInput();
        display(a);
    }

    
    public static void display(int a[][]){
        System.out.println("");
       for (int j = 0; j < rows; j++) {
             for (int i = 0; i < cols; i++) {
                 System.out.print(a[j][i]+" ");
             }
             System.out.println("");
        }
        
    }
    
    public static void readInput() {
        Scanner s = new Scanner(System.in);

        String line = null;
        line = s.nextLine();
        rows = Integer.parseInt(line.split(" ")[0]);
         cols = Integer.parseInt(line.split(" ")[1]);

        a = new int[rows][cols];

        for (int j = 0; j < rows; j++) {

            String[] l = s.nextLine().split(" ");
            for (int i = 0; i < cols; i++) {
                a[j][i] = Integer.parseInt(l[i]);

            }
        }

    }

}
