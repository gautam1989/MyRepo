/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.worksap.global;

/**
 *
 * @author gautamverma
 */
 public class Knp {
  
     static char find[]="am".toCharArray();
     static char MainString[]="gauasdgautam".toCharArray();
     
     static int v=-1;
     public static void main(String args[]){
     
         if(find.length <=MainString.length)
         System.out.println(findtxt());
         else
             System.out.println("No match");
         
     }
     
     static boolean findtxt(){
          
         for(int m=0;m<MainString.length;m++){
             
             for(int i=0;i<find.length;i++){
                 if(m+i >MainString.length-1)return false;
                 if(find[i]==MainString[m+i]){
                     if(v==-1 && i>0 && find[i]==find[0])v=m;
                     if(i==find.length-1)
                         return true;
                 }
                 
                 
             }
            //if(m==MainString.length-1)return false;
            if(v==-1 && m==MainString.length-1)return false;
            if(v!=-1)
                m=v;
            v=-1;
             
         }
         return false;
         
     }
 }