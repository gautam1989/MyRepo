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
public class Dia {
    
    
    public static void main(String []args){
        
        int n=10;
        int sp=n;
        for(int i=0;i<n;i++){
            for(int s=sp;s>0;s--){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            sp=sp-1;
            System.out.println("");
            
        }
        
    }
    
}
