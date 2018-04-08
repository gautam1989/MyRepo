/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

/**
 *
 * @author gautamverma
 */
public class Rational {

    
    static void findFraction(int n1,int n2){
       
       
       int temp1 = n1;
       int temp2 = n2; 

       while (n1 != n2){
         if(n1 > n2)
            n1 = n1 - n2;
         else
            n2 = n2 - n1;
       }      

      int n3 = temp1 / n1 ;
      int n4 = temp2 / n1 ;

      

      System.out.print(n3 + "/" + n4 + "\n" );
    }
    
    public static void main(String[] args){

       
        findFraction(20, 15);
    //    findFraction(12, 15);
      System.exit(0);
    }  
}