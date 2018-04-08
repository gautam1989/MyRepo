/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

/**
 *
 * @author gautamverma
 */
class Solution {
    int chg=0;
    String sw;
     public String solution(String S, String T) {
         
         char[] cs=S.toCharArray();
         char[] ct=T.toCharArray();
         
         if(cs.length == ct.length){
             
             
             if(check(cs, ct)){return "NOTHING";}
             if(chg==1){return "SWAP "+sw;}
             
             
               
             
         }else if( (cs.length - ct.length)==1 ||(cs.length - ct.length)==-1){
             
             
             
             int c=0;String v="";
             int b=cs.length > ct.length ? cs.length: ct.length;
              int j=0;
             for(int i=0;i<b;i++){
                
                 if(i <cs.length && i<ct.length){
                 if(cs[i] == ct[j]){
                   j++;
                   
                 }
                 else{
                     c=c+1;
                     i=i-1;
                     v=""+ct[j];
                     j++;
                     
                 }
                 }
                 
             }
             if(c==1){
                 
                 return "INSERT "+v;}else return "IMPOSSIBLE";
             
         }
         else
         {
             return "IMPOSSIBLE";
         }
         
         
     return null ;   
    }

     
     boolean check(char[] cs,char []ct){
         
             for(int i=0;i<cs.length;i++){
                 if(! (cs[i]==ct[i])){
                     
                     char temp=cs[i];
                     cs[i]=cs[i+1];
                     cs[i+1]=temp;
                     sw=temp+" "+cs[i];
                     check(cs,ct);
                     return false;
                     
                 }
             }
             chg=1;
             return true;
     }
    
    
    
    public static void main(String[]args){
        Solution s=new Solution();
        System.out.println( s.solution("form","from"));
    }
}
