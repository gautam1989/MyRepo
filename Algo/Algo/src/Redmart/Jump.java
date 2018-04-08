/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Redmart;

import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class Jump {
  
    
    static int climbUp=5;
    static int climbDown=1;
    static int noOfWalls=2;
    static int[]wallHeights=new int[]{9,10};
    
    
    public static void main(String []args){
        
        int curDistance=0;
        int jump=0;
        int count=0;
        for(int h:wallHeights){
            
        int distancetocover=h;
        while(jump<=h){
            count+=1;
        jump=jump+climbUp;
        if(jump>=h){
            break;
        }else if(jump<h){
            jump=jump-climbDown;
        }
            
        }
        jump=0;
        }
        
        System.out.println(count);
        
    }
    
    
    
    public static void readinput(){
        
        
    }
}


