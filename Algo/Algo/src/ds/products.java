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
public class products {
 
    
    static int [] product (int [] input) {
	int [] front = new int[input.length];
	int [] rear = new int[input.length];
	int [] output = new int[input.length];
	front[0] = 1;
	rear[input.length-1] =1;
	for(int i = 1; i < input.length; i++)
        	front[i] = front[i-1]*input[i-1];
        disp(front);
        
	for(int i = input.length-2; i >=0; i--)
		rear[i] = rear[i+1]*input[i+1];
	        disp(rear);

        
        for(int i = 0;i<input.length;i++)
		output[i] = front[i]*rear[i];
	
        
        
        return output;
}
    
    public static void main(String []args){
        
       int[] a= product(new int[]{2,3,1,4});
        for (int i : a) {
            System.out.println(i);
        }
        
    }
    
    static void disp(int a[]){
        for (int i : a) {
            System.out.println(i);
        }
    }
    
}
