package com.ques;

import java.util.BitSet;

public class BitArrayTest {
public static void main(String[] args) {
	
	BitSet bs =new BitSet();
	bs.set(1000000, true);
	bs.set(1, true);
	bs.set(133, true);
	bs.set(1213123, true);
	
	System.out.println(bs);
	
	System.out.println(Integer.toBinaryString(2));
	System.out.println(Integer.toBinaryString(124 & 24));
	
}
}
