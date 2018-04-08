
public class Keypad {

	String char_on_pad[] ={"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};
	int numberpad[] ={1,2,3,4,5,6,7,8,9,0};
	
	char[] c = new char[4];
	
	public void printWordUtils(int []number, int cdigit, char[]out,int n){
		
		if(cdigit == n){
			System.out.print(out);
			System.out.print(" ");
			return;
		}
		
		for(int i=0;i < char_on_pad[number[cdigit]].length();i++){
			out[cdigit] = char_on_pad[number[cdigit]].charAt(i);
			printWordUtils(number, cdigit+1, out, n);
			if(number[cdigit] == 0 || number[cdigit]==1)
				return;
		}
	}
	
	
	public void printAllPossibleSixDigitNumbers(int[] output,int currdigit,int n) throws InterruptedException{
			if(currdigit == 6){
				print(output);
				System.out.println();
				Thread.sleep(1000);
				return;
			}
			for(int i=0;i<n;i++){
				output[currdigit]=numberpad[i];
				printAllPossibleSixDigitNumbers(output, currdigit+1, n);
			}
	}
	
	public void printWords(int[] number){
		printWordUtils(number, 0, new char[number.length], number.length);
	}
	
	public void printAllDigits(int n) throws InterruptedException{
		printAllPossibleSixDigitNumbers(new int[6],0,n);
	}

	public void print(int a[]){
		for(int g:a)
			System.out.print(g);
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Keypad k = new Keypad();
		int number[]={2,3,4};
		k.printWords(number);
		//k.printAllDigits(9);
	}
	
}
