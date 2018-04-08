/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Redmart;

/**
 *
 * @author gautamverma
 */
public class FindME {
    
    
    public static int output1;
	    
	static boolean countNum(int input,int i){
            
             int sum = 0;
                   while (i != 0) {

                        sum += i % 10;
                        i /= 10;

                  }
                 
                 
                  if(sum==input)
            return true;
                  else
                      return false;
        }	
    public static void FindMeOut(int input1){
        int i=0;
        for(;;){
            i=i+input1;
            
            if(String.valueOf(input1).length()>input1){
                output1=-1;
                break;
            }
            
            
            if((i % input1)==0 && input1!=i){
                
                if(countNum(input1,i)){
                    output1=i;
                    break;
                }else{output1=-1;}
                
            }
        }
       
        
    }	
    
    public static void main(String []args){
        FindMeOut(-10);
        System.out.println(output1);
    }
    
}
