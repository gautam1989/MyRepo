
package visa;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Solution {

     static List<String>inList=new ArrayList<String>();
        static int val=0;
    static Map<Character,Set> map=new HashMap<Character, Set>();
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
           for(int x = 0; x < cArray.length; x++)
            {
                if(characterASCII == (int)cArray[x])
                {
                    characterCount ++;
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
        System.out.println(map);
        findPopular();
        System.out.println(popChar);
    }
    
    
    static void findPopular(){
        Iterator<Character> itr=map.keySet().iterator();
        while(itr.hasNext()){
            Set g=map.get(itr.next());
            if(findInMap(g)){
                popChar+=1;
            }
            
        }
        
    }
    
    static boolean findInMap(Set g){
        
        if(g.size()==val){
            return true;
        }else return false;
        
    }
    
    static void createMap(){
        
        for(int j=0;j<inList.size();j++){
            for(int i=0;i<inList.get(j).length();i++){
                char c=inList.get(j).charAt(i);
                  if(map.get(c)!=null){
                      Set s=map.get(c);
                      s.add(j);
                   map.put(c, s);
               }else
                       {
                        Set s=new HashSet();
                        s.add(j);
                        map.put(c, s);
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
                int i=1;
		while( i<=val  ){
                    line=br.readLine();
		         if(line.equals("") || line.length()>100  || isLegalString(line)){
                             break;
                         }
			inList.add(line);
                        i++;
		}
	}
    
    
   static public boolean isLegalString(String pass) {
     if (pass.matches("[a-z]+")) return true;
     else return false;
     
}
    
}