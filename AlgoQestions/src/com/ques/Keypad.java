package com.ques;

public class Keypad {
	
	String[] keys =new String[]{"","","abc","def","ghi","jkl","mno",
					"pqrs","tuv","xyz"};
	
	char []output=new char[4];
	public static void main(String[] args) throws InterruptedException {
		
		int number[]=new int[]{2,3,4};	
		Keypad k = new Keypad();
		//k.printNumbersPerm(number, k.output, 0, number.length);
		
		int []number2 = new int[]{0,1,2,3,4,5,6,7,8,9};
		int output2[]=new int[8];
		k.printNumberPerm2(number2, output2, 0, 8);
	}
	
	
	
	public void printNumbersPerm(int number[],char output[],int curr,int n){
		
		if(curr == n){
			print(output);
			return;
		}
		
		for(int i=0;i<keys[number[curr]].length();i++){
			
			output[curr] = keys[number[curr]].charAt(i);
			printNumbersPerm(number,output,curr+1,n);
			if(number[curr]==0 && number[curr]==1)
				return;
		}
		
		
		
		
	}
	
	public void print(char output[]){
		for(char c:output)
			System.out.print(c);
		System.out.println();
	}
	
	
	public void print(int output[]){
		for(int c:output)
			System.out.print(c);
		System.out.println();
	}
	
	
	public void printNumberPerm2(int number[],int output[],int curr,int n) throws InterruptedException{
		
		if(curr == n){
			print(output);
			//Thread.sleep(100);
			return;
		}
		
		for(int i=0;i<n;i++){
			
			output[curr] =number[i];
			printNumberPerm2(number,output,curr+1,n);
			
		}
		
		
	}
}
