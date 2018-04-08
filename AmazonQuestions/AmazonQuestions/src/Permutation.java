
public class Permutation {

	
	
	public static void main(String[] args) throws InterruptedException {
		  permuteString("", "abc");
	}
	
	 public static void permuteString(String beginningString, String endingString) throws InterruptedException {
		    if (endingString.length() <= 1)
		      System.out.println(beginningString + endingString);
		    else
		      for (int i = 0; i < endingString.length(); i++) {
		        try {
		          String newString = endingString.substring(0, i) + endingString.substring(i + 1);
		         // Thread.sleep(1000L);
		          permuteString(beginningString + endingString.charAt(i), newString);
		        } catch (StringIndexOutOfBoundsException exception) {
		          exception.printStackTrace();
		        }
		      }
		    
		  }
	
}
