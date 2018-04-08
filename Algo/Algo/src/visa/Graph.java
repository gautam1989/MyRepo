/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static visa.Solution.inList;

/**
 *
 * @author gautamverma
 */
public class Graph {
    
   static int val=0;
   static int a[][];
   static int b[][];
   static int count=0;
    public static void main(String [] args){
       try {
           readInput();
           
          b=new int[val][val];
           
           for(int i=0;i<a.length;i++){
               for(int j=0;j<a.length;j++){
                   
                   
                   if(checkForAllvalues(i,j)==0){
                       //System.out.println(i+" "+j);
                       b[i][j]=1;
                   }
                   else
                   {
                       b[i][j]=0;
                   }
                   
               }
           }
           
           print(b);
       } catch (Exception ex) {
           ex.printStackTrace();
                 
       }
        
        
    }
    
    static int checkForAllvalues(int i,int j){
         int[]dx={0,0,1,-1};
         int[]dy={1,-1,0,0};
           int big=0;
           for(int t=0;t<4;t++){
               int xx=i+dx[t];
               int yy=j+dy[t];
               if(xx>=0 && yy>=0 && xx<val && yy<val){
               if(a[i][j]<a[xx][yy]){
                   big =1;
                   return big;
               }
               }else
               {
                   return -1;
               }
           }
           return big;
           
    }
    
    
    static void print(int [][]a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }
    }
     static void readInput() throws Exception{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
                line=br.readLine();
                 val=Integer.parseInt(line);
                 if(val <1 || val >100){
                     return;
                 }
                int c=0;
                 a=new int[val][val];
                 while(c<val)
                 {
                     line=br.readLine();
                     for(int j=0;j<val;j++){
                         a[c][j]=Integer.parseInt(line.split("")[j]);
                     }
                     
                     c++;
                 }
	}
     
       static public boolean isLegalString(String pass) {
     if (pass.matches("[a-z]+")) return true;
     else return false;
     
}
    
}
