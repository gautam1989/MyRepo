
package visa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by dhiraj on 26/12/14.
 */
public class NAP {

    static Set<Integer>s=new HashSet<Integer>();
    public static void main(String[] str){
        printMissingElement();
    }

    static void printMissingElement(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] intArray = new int[n];
        long sum = 0;
        for(int t = 0; t < n; t++) {
            intArray[t] = sc.nextInt();
            sum += intArray[t];
        }
       Arrays.sort(intArray);
      int d=0;
       
        for(int i=0;i<n-1;i++){
          int add=intArray[i+1]-intArray[i];
            
          if(!s.add(add)){
              d=add;
          }
        }
        
        for(int i=0;i<n-1;i++){
        int add=intArray[i+1]-intArray[i];
        if(add!=d){
            System.out.println("Missing element ->"+(intArray[i]+d));
            return;
        }
        }
        
    }
}
