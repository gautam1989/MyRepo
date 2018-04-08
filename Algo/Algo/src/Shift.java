import java.util.BitSet;

public class Shift {
	public static void main(String[] args) {

		int a=2;
		int pow=2;
		System.out.println(a<<1);
		System.out.println(a<<2);
		System.out.println(a<<10);
		
		System.out.println(a>>1);
		System.out.println(a>>2);
		System.out.println(a>>3);
		
		
		BitSet bs = new BitSet();
		bs.set(100,true);
		bs.set(1,false);
		System.out.println(bs);

	}
}
