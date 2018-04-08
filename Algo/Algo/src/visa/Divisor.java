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
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Divisor {

    
    public static void findDivisor(int a[]){
        
        for(int i=0;i<a.length;i++){
            int c=0;
            
              for(int j=a[i];j>0;j--){
                  if(a[i]%j==0){
                      if(j%2==0){
                        c+=1; 
                          
                      }
                  }
              }
            System.out.println("Number of divisorr for "+a[i]+" are "+c);
            
        }
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        
        for(int i=1;i<=_a_size;i++){
            _a[i-1]=in.nextInt();
        }
        
        findDivisor(_a);
        
    }
}