import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KSub {
	public static void main(String[] args) {


	System.out.println(function("awaglk",4));

	}

	public static List<String> function(String s,int k){
		List<String> res= new ArrayList<String>();
		if(s==null||s.length()==0||s.length()<k || k==0)
			return res;
		int charCount[]= new int[26];
		int len=s.length();
		int count=0;
		for(int i=0;i<len;i++){
			if(charCount[s.charAt(i)-'a']==0)count++;
			charCount[s.charAt(i)-'a']++;
			if(i>=k-1){
				int startIndex=i-k+1;
				if(count==k-1)
					res.add(s.substring(startIndex,i+1));
				charCount[s.charAt(startIndex)-'a']--;
				if(charCount[s.charAt(startIndex)-'a']==0)
					count--;
			}
		}
		
		Set<String> ss =new HashSet<>();
		ss.addAll(res);
		res.clear();
		res.addAll(ss);
		return res;
		}

	
	
	
}
