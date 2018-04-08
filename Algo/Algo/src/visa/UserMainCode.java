/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

/**
 *
 * @author gautamverma
 */
public class UserMainCode {

    
    public static int output1;
	static int first=-1,last=-1,count=-1;    
				
    public static void SearchLetter(String input1,String input2){
        input1=input1.replaceAll("\\s+","");
        char[]in1=input1.toCharArray();
        char t=input2.charAt(0);
        for(int i=0;i<in1.length;i++){
                if(in1[i]==t){
                    
                    if(first==-1){
                        first=i;
                    }
                    else{
                        last=i;
                        count++;
                    }
                    
                }
        }
        
        if(first==-1 || last==-1)output1=-1;
        else
        output1=(((last-first)-1)-count);
        
        System.out.println(output1);
    }	
    
    public static void main(String []args){
        SearchLetter("sdsadaa aaaaada", "a");
        
        
        
    }
    
}
