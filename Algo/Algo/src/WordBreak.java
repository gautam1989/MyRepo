
import java.util.Arrays;
import java.util.stream.*;

public class WordBreak {

	static String dictionary[] = {"cat", "cats", "and", "sand", "dog"};
	
	
	public static void main(String[] args) {
		dictionatyContains("catsanddog","");
	}
	
	
	static void dictionatyContains(String word,String tillNow){
		System.out.println(tillNow);

		for(int i=1;i<=word.length();i++){
			String prefix = word.substring(0, i);
			if(findInDict(prefix)>0){
				dictionatyContains(word.substring(i),tillNow+prefix+" ");
			}else{
				continue;
			}
			
			
		
			
		}
	}
	
	static long findInDict(String word){
		return Arrays.stream(dictionary).filter(f-> f.equals(word)).count();
	}
	
	
}
