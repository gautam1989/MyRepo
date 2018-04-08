/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gautamverma
 */
public class Solution {

    
   static int a[][];
    
    public static void main(String args[]) throws IOException{
        
        
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        int i=0,arrLine=0,row=0;
        while( (line=buf.readLine())!=null && arrLine<=row){
          
           i++;
           if(i==1){
               a=new int[Integer.parseInt(line)][Integer.parseInt(line)];
               row=Integer.parseInt(line);
           }else
           {
               
               String l[]=line.split("");
               for(int j=0;j<l.length;j++){
                   a[arrLine][j]=Integer.parseInt(l[j]);
               }
               arrLine++;
//              for(int i2=0;i<row;i++){
//            for(int j=0;j<row;j++){
//                System.out.println("a:"+a[i2][j]);
//            }
//        }
        
               
           }
           
        }
        
        
        
        
        
    }
    
}
