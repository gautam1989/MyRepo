package com.ques;

public class BinarySearchOnArray {
	static int k=2;
	public static void main(String[] args) {


		int a[]={1,2,3,4,6,7,8,9};
		binSearch(a, 0, a.length-1);

	}

	static void binSearch(int[] a, int start ,int end){
		 if(start > end){
			 System.out.println("not found");
			 return; 
		 }
			 
					 
		int mid = (start+end)/2;
		if(k == a[mid])
			{
			System.out.println("FOUND");
			return;
			}
		if(k > a[mid]){
			binSearch(a, mid+1, end);
		}else{
			binSearch(a, start, mid-1);
		}
	}
}
