
public class Countbit {
	static int countSetBits(int n)
	{
		int count = 0;
		while (true)
		{
			if(n==0)
				return count;
			count += n & 1;
			n >>= 1;
		}
	}
	


	// Function that return count of
	// flipped number
	static int FlippedCount(int a, int b)
	{
		// Return count of set bits in
		// a XOR b
		return countSetBits(a^b);
	}
	public static void main(String[] args) {
		 int a = 0;
		    int b = 15;
		    System.out.println(FlippedCount(a, b));
	}
}
