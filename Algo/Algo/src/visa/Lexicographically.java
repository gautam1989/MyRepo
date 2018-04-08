/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author gautamverma
 */
public class Lexicographically {
    
    public static int find(char[]W ,int i){
        int s=0;
        int val=0;
        for(int j=i+1;j<W.length;j++){
         
                   if(W[i]-W[j]<0){
                       if(val==0){val=W[i]-W[j];s=j;}
            if(W[i]-W[j] > val){
                s=j;
            }
        }}
        return s;
        
    }
    
    public static void main(String []args) throws IOException{
         final StringBuffer sb = new StringBuffer();
        
        //INPUT
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
         for(int T = Integer.parseInt(br.readLine()); T > 0; --T){
            final char[] W = br.readLine().toCharArray();
            final int N = W.length;
             
             int brvalue=0;
             int k=0;
             for(int i=N-2;i>=0;i--){
                 
                 if(W[i]<W[i+1]){
                     int f=find(W, i);
                     
                     char t=W[f];
                     W[f]=W[i];
                     W[i]=t;
                     
                     brvalue=i+1;
                     break;
                     
                     
                 }else
                 {
                     
                     if(i==0 || N==1){
                         sb.append("no answer").append("\n");
                         k=1;
                     break;
                     }
                     
                 }
             }
             
             if(N==1){
                   sb.append("no answer").append("\n");
                   
             }
             else if(k!=1){
             Arrays.sort(W, brvalue, W.length);
             sb.append(W).append("\n");
              //System.out.println(sb);
             }
             
             
        }
         System.out.println("");
        System.out.println(sb);
    }
    
}
