/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

/**
 *
 * @author gautamverma
 */
public class recur {
    
    int fact=1;
    int fact(int n){
        if(n==1 || n==0){
            return fact;
        }else
        {
            fact=fact*n;
            fact(n-1);
        }
        return fact;
    }
    
    
    public static void main(String[] args) {
        
        recur r=new recur();
        System.out.println(r.fact(5));
                
        
    }
    
}
