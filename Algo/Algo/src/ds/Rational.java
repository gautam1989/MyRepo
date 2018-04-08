package ds;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Rational {
static List<String>inList=new ArrayList<String>();
        static int val=0;
        
        
    public static void main(String[] args) throws Exception{

        readInput();
        
        for(String l:inList){
            int a=Integer.parseInt(l.split("/")[0]);
             int b=Integer.parseInt(l.split("/")[1]);
                findFraction(a, b);
        }
        
      
    }  
    
    
    
    
    static void readInput() throws Exception{
	
            
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
               
		String line=null;
                line=br.readLine();
                 
                 val=Integer.parseInt(line);
                 if(val <1 || val >500){
                     return;
                 }
                 
                
		while( (line=br.readLine())!=null  ){
		         if(line.equals("")){
                             break;
                         }
                         
                         int a=Integer.parseInt(line.split("/")[0]);
                         int b=Integer.parseInt(line.split("/")[1]);
                         
                         if(a < 1||b >2000)break;
                         
			inList.add(line);
                        
		}
                
		
	}
    
    
    
    static void findFraction(int n1,int n2){
         
       int temp1 = n1;
       int temp2 = n2; 

       while (n1 != n2){
         if(n1 > n2)
            n1 = n1 - n2;
         else
            n2 = n2 - n1;
       }      

      int n3 = temp1 / n1 ;
      int n4 = temp2 / n1 ;

      

      System.out.print(n3 + "/" + n4 + "\n" );
      
    }
}