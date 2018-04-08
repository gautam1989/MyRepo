/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gautamverma
 */
public class Solutions {

     static List<String>inList=new ArrayList<String>();
        static int val=0;
    static Map<Character,String> map=new HashMap<Character, String>();
        static int popChar=0;
        
   static public char getMax(String word)
    {
        int characterCount = 0;
        int maxCharacter = 0;
        char maxCharacterChar = '.';
        

        char[] cArray = word.toCharArray();

        for(int i =0; i < cArray.length; i++)
        {
            int characterASCII = (int)cArray[i];
            characterCount = 0;

            //System.out.print("Chracter ASCII: " + characterASCII + "\n");
            for(int x = 0; x < cArray.length; x++)
            {
                if(characterASCII == (int)cArray[x])
                {
                    characterCount ++;
                    //System.out.print("Character Count for " + characterASCII + " " +  characterCount  + "\n");
                    if(characterCount > maxCharacter)
                    {
                        maxCharacter = characterCount;
                        maxCharacterChar = cArray[i];
                    }
                }
            }
        }
        return maxCharacterChar;
    }
    
    public static void main(String []args) throws Exception{
        
        
    
        readInput();
        
        createMap();
      
        findPopular();
        System.out.println(popChar);
    }
    
    
    static void findPopular(){
        
        Iterator<Character> itr=map.keySet().iterator();
       
        while(itr.hasNext()){
            String g=map.get(itr.next());
              
            
            
            
            
            if(findInMap(g)){
                popChar+=1;
            }
            
        }
        
    }
    
    static boolean findInMap(String g){
          String temp="";
        for(int i=0;i<val;i++){
            temp=temp+i;
        }
        
        if(g.contains(temp))
        return true;
        else
            return false;
    }
    
    static void createMap(){
        
        for(int j=0;j<inList.size();j++){
            
            for(int i=0;i<inList.get(j).length();i++){
                
                
                char c=inList.get(j).charAt(i);
               if(map.get(c)!=null){
                   
                   String v=map.get(c);
                   v=v+j;
                   map.put(c, v);
                   
               }else
                       {
                         map.put(c, j+"");
                       }
                
                
                
                
            }
            
            
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
                 
                
		while( (line=br.readLine())!=null  ){
		         if(line.equals("") || line.length()>100  || isLegalString(line)){
                             break;
                         }
			inList.add(line);
                        
		}
                
		
	}
    
    
   static public boolean isLegalString(String pass) {

    

     if (!pass.matches("[a-z]+")) return true;


     return false;
}
    
}