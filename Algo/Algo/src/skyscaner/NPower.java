/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyscaner;

/**
 *
 * @author gautamverma
 */
public class NPower {
    
    
    public static void main(String args[]){
      
        //System.out.println( power(4));
        power(4);
        
    }
    
    
    
    
    
    public static void power(int n){
		
		long x = 1;
		long y = 0;
		for (int i = 0; i < n; i++) {
			//bit shift 
			x = x<<1;
			y += x;
			                 
		}
		
		if( n == 0) System.out.println(1); 
		else { System.out.println(y);}
			
	}
    
    
    public static int powerOf2(int number) {
    if (number == 0) {
        return 1;
    } else {
        return 2 * powerOf2(number - 1);
    }
}
    
    
    public static int pow (int base, int ex) {
    if (ex == 0) {
        return 1;
    } else if (ex == 1) {
        return base;
    } else if(ex > 1) {
        return (pow(base, ex - 1) * base);
    } else {
        return pow(base, ex + 1) / base;
    }
}
    
    
}
