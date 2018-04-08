import java.util.Scanner;

public class INput {
public static void main(String[] args) {
	Scanner s= new Scanner(System.in);

	//int r=Integer.parseInt(s.next());
	//int c=Integer.parseInt(s.next());
	int r=0;
	int c=0;
	String l[]=null;
	for(int i=0;i<1;i++){
		r=s.nextInt();
		c=s.nextInt();
	}
	int a[][]=new int[r][c];
s.nextLine();
	for(int i=0;i<3;i++){
		l=s.nextLine().split(" ");
		for(int j=0;j<3;j++){
			
			a[i][j]=Integer.parseInt(l[j]);
		}
	}
	
	
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			System.out.print(a[i][j]+" ");
		}
		System.out.println();
	}
}
}
