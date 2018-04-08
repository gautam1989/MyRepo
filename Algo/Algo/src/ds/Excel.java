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
public class Excel {
    
	public static String getColumnName(int num){
		if(num<=26)
			return "" + num;
		int offset = 26;
		int numDigits = 1;
		while(true) {
			num -= offset;
			numDigits++;
			offset *= 26;
			if(num - 1 < offset) {
				return helper(num-1, numDigits);
			}
		}
	}

	public static String helper(int num, int numDigits) {
		if(numDigits == 0)
			return "";
		int digit = num%26;
		return helper(num/26, numDigits-1) + (char)(digit + 'A');
	}


	public static void main(String[] args) {
		System.out.println(getColumnName(27));
	}
    
}
