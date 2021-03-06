
public class PrintSubSets {

	
	public static void main(String[] args) {
		char []S = {'a','b'};
		printSubsets(S);
		
		
		System.out.println(Integer.toBinaryString(1<<1));
		System.out.println((1<<1));
		System.out.println(Integer.toBinaryString(1<<2));
		System.out.println((1<<2));
		System.out.println(Integer.toBinaryString(1<<3));
		System.out.println((1<<3));
		System.out.println(Integer.toBinaryString(1<<4));
		System.out.println((1<<4));
		
	}
	
	
	static void printSubsets(char set[])
    {
        int n = set.length;
 
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");
 
            // Print current subset
            for (int j = 0; j < n; j++)
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
 
            System.out.println("}");
        }
    }
	
}
