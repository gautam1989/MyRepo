/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author gautamverma
 */
public class Ap {
     static int val=0;
   static int a[];
  
    public static void main(String []args) throws Exception{
        readInput();
       Arrays.sort(a);
       int difference[]=new int[a.length-1];
    int missingTerm;

    for(int i=1;i<a.length;i++){
        difference[i-1] = a[i]-a[i-1];  
    }




    for(int j =0;j<a.length-1;j++){

        if(difference[j]!=difference[j+1]){
            missingTerm = a[j]+difference[j+1];
            System.out.println("The missing term is: " + missingTerm );

        break;


}}}
       
       
             
    
    
    static void readInput() throws Exception{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
                line=br.readLine();
                 val=Integer.parseInt(line);
                 if(val <1 || val >100){
                     return;
                 }
                int c=0;
                 a=new int[val];
                 
                 
                     line=br.readLine();
                     for(int j=0;j<val;j++){
                         
                         a[j]=Integer.parseInt(line.split(" ")[j]);
                     }
                     
                 
                 
	}
}
