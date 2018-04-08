/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.worksap.global;

/**
 *
 * @author gautamverma
 */
public class Irreduce {
 
    
    public static void main(String []args){
        
        int a=12;
        
        
        for(int i=1;i<=12;i++){
            System.out.println(i+"/"+a);
                 
            if(findGCD(i, a)==1)
                System.out.println("Irreducible");
            else
                System.out.println("reducible"+findGCD(i, a));
        
        }
    }
    
    
    private static int findGCD(int number1, int number2) {
        //base case
        if(number2 == 0){
            return number1;
        }
        return findGCD(number2, number1%number2);
    }
    
}
