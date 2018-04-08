import java.util.Scanner;

public class InputTest {
public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	String line=null;int sum=0;
	int c=0;
	
	for(int i=0;i<2;i++){
		sum+=Integer.parseInt(s.nextLine());
	}
	
//	while( (line=s.nextLine())!=null || !(line=s.nextLine()).equals("") ){
//		if(c==2)
//			break;
//		sum+=Integer.parseInt(line);
//		c++;
//	}
	
	System.out.println(sum);
	
}
}
