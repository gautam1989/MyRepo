package com.ques;

import java.util.*;

public class Combination {

	Set<String> set=new HashSet<String>();

	public static void main(String[] args) {

		String a ="abc";
		Combination com =new Combination();
		com.combination("",a );
		System.out.println(com.set);
	}

	public void combination(String prefix,String suffix){
		
		 System.out.println(prefix);
	        for (int i = 0; i < suffix.length(); i++)
	        	combination(prefix + suffix.charAt(i), suffix.substring(i + 1));
		}
	
}
