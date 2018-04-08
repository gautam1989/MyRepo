/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.math.BigInteger;

/**
 *
 * @author gautamverma
 */
public class Shift {
    
    
    public static void main(String args[]){
        
        System.out.println(Integer.toBinaryString(6<<1));
       int foo = Integer.parseInt(Integer.toBinaryString(2<<36), 2);
        //BigInteger bi=Math.pow(2, );
        System.out.println(Math.pow(2, 100));
       
        int a='a';
        System.out.println(a);
        System.out.println(Integer.toBinaryString(97));
        int b='b';
        System.out.println(b);
        System.out.println(Integer.toBinaryString(98));
        System.out.println("ab".getBytes());
        System.out.println("ab".getBytes());
   
    }
    
}
