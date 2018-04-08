/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyscaner;

import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class reverse {

    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        
        System.out.println( stringReverseInPlace(s.nextLine().toCharArray()));
    }

    public static char[] stringReverseInPlace(char[] string) {
        for (int i = 0, j = string.length - 1; i < string.length / 2; i++, j--) {
            char c = string[i];
            string[i] = string[j];
            string[j] = c;
        }
        return string;
    }

}
