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
public class Ftest {
    static void print (int n)
{
	if (n>0)
	{
		          System.out.println("hello");
		print(n-1);
	}
	System.out.println("world");
}
    public static void main(String []args){
        System.out.println(5 ^ 5 ^3 );
        print(1);
    }
}
