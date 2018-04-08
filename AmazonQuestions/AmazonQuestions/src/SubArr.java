import java.util.Arrays;
import java.util.Collection;

public class SubArr {
public static void main(String[] args) {
	
	
	
	int a[]={1,2,3};
	String b="123";
	findMagic(b,b,b, 0,1);
	 
	
	
}


 public static void findAllSubs(int []a,int start,int end){
	 if(start==a.length)return;
	 for(int i=start;i<end;i++){
		 System.out.print(a[i]+"");
	 }
	 System.out.println();
	 findAllSubs(a, start+1, end);
 }
 
 
 public static void findMagic(String a, String pre,String post,int c,int p){
	
	 
	 if(c>a.length()-1 || p >a.length())
		 return;
	 String pr = a.substring(c, p);
	 System.out.println(pr);
	 
	 if(p >= a.length() ){
		 findMagic(a, pre, post, c+1, c+2);
	 }else{
	 findMagic(a, pre, post, c,p+1);
	 }	 
 }
}
