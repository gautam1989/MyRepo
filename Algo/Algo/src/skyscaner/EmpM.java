/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyscaner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gautamverma
 */



public class EmpM {
    static HashSet<String>set;
    static HashMap<String, List>map;
    static List<String>tempL;
    static int c=0;
    static int number=0;
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
    map=new HashMap<String,List>();
    
    
    number=Integer.parseInt(in.nextLine());
          String line="";
          int i=0;String root="";
          while(!(line=in.nextLine()).equals("")){
              
                  

              String names[]=line.split(" ");
              if(i==0)
                  root=names[0];
              if( map.get(names[0])!=null ){
                  List<String>temp=new ArrayList<String>();
                  temp.addAll(map.get(names[0]));
                  temp.add(names[1]);
                  map.put(names[0], temp);
              }else{
                  List<String>temp=new ArrayList<String>();
                  temp.add(names[1]);
                  map.put(names[0],temp);
              }
            i++;
          }
       
          
          set=new HashSet<String>();
          
          System.out.println(root);c++;
          set.add(root);
          tempL=new ArrayList<String>();
         // print(root);
          List<String>sd=new ArrayList<>();sd.add(root);
          
          prints(sd);
          
    }
    
    
    static void print(String root){
     //   System.out.println(root);
        tempL.remove(root);
       List<String>l=map.get(root);
       if(l!=null){
       for(String h:l){
           System.out.print(h+" ");
           
           tempL.add(h);
           
       }System.out.println("");}
       while(!tempL.isEmpty())
       {
         
           set.add(tempL.get(0));
           print(tempL.get(0));
       }
         
    }
    
    
    static void prints(List<String> root){
        List<String>p=root;
        List<String>t=new ArrayList<String>();
        for(String j:p){
            List<String>l=map.get(j);
            if(l!=null){
            if(l.size()>0){
            for(String h:l){
                c++;
                System.out.print(h+" ");
                t.add(h);
            }
            }}
        }
        System.out.println("");
        if(c>=number)return;
        else
        prints(t);
        
    }
}
