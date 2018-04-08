/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class CommonChildNew {

    static List<String> list = new ArrayList<String>();
    static Map<String,String> m=new HashMap<String, String>();
    
    public static void main(String args[]) {

        readInput();
        dispMap();
        findtheCommon();
        
        String h="asdasd";
//        char d[]=h.toCharArray();
//        int g=d[0];
//        System.out.println(g);
        
        
    }
    
    static void findtheCommon(){
        
        Iterator<String>itr=m.keySet().iterator();
        int c=0;String max="";int values=0;
        while( itr.hasNext() )
        {
            String n=itr.next();
            if(m.get(n).length()==list.size()){
                values+=1;
                System.out.println(n);
            }
        }
       
       
        System.out.println(values);
        
        
    }
    static void dispMap(){
        System.out.println(m);
    }
    
    static void checkForval(int h){
        
        String l[]=list.get(list.size()-1).split("");
        for(String k:l){
            if(m.get(k)!=null){
                String j[]=m.get(k).split("");
                if( !j[j.length-1].equals(h+"") ){
                m.put(k,m.get(k)+h);
                }
            }else
            {
                m.put(k,h+"");
            }
                    
        }
        
    }

    static void readInput() {

        Scanner s=new Scanner(System.in);
        String line;int h=0;
        while( !(line=s.nextLine()).equals("") ){
        list.add(line);
        checkForval(h);
        h++;
        }
        
    }

}
