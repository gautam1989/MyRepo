/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redmart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gautamverma
 */

class Spread{
    
    float val;
    String txt;
    
}
public class Spreadsheet {

    static Spread a[][];
    static int row, col;
    static Queue<String>lines=new  LinkedList<String>();
    public static void main(String args[]) {
       runFirst();
        runSecond();
        display();
    }

    static String getTheNumberForChar(String a) {
        int A = 65;
        char f = a.toCharArray()[0];
        int ret = f - A;

        return ret + 1 + " " + Character.toString(a.toCharArray()[1]);
    }

    public static float evalRPN(String[] tokens) {
        float returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                float a = Float.valueOf(stack.pop());
                float b = Float.valueOf(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Float.valueOf(stack.pop());

        return returnValue;
    }

    
    static void runFirst(){
        
        

        File f = new File("/Users/gautamverma/Desktop/spreadsheet.txt");
        String operators = "+-*/";
        String pattern = "[A-Z]+";
        Pattern r = Pattern.compile(pattern);
        try {
            Scanner s = new Scanner(f);
            String line = s.nextLine();
            lines.add(line);
            col = Integer.parseInt(line.split(" ")[0]);
            row = Integer.parseInt(line.split(" ")[1]);
            a = new Spread[row + 1][col + 1];

            for (int i = 1; i <= row; i++) {
                
                for (int j = 1; j <= col; j++) {
                   
                    String in = s.nextLine(); lines.add(in);
                    Matcher m = r.matcher(in);
                    if (in.split(" ").length == 1 && m.find()) {
                        int row = Integer.parseInt(getTheNumberForChar(in).split(" ")[0]);
                        int col = Integer.parseInt(getTheNumberForChar(in).split(" ")[1]);
                        
                        if(a[row][col]==null){ 
                            Spread sp=new Spread();
                            a[row][col]=sp;
                        a[i][j]= a[row][col];
                        }else
                        {
                             a[i][j]=new Spread();
                            a[i][j] = a[row][col];
                        }
                        
                    } else if( in.split(" ").length==1 ){
                         a[i][j]=new Spread();
                        a[i][j].val=Integer.parseInt(in);
                    }else {
                        List<String> list = new ArrayList<String>();
                        String[] S = in.split(" ");

                        for (int n = 0; n < S.length; n++) {
                             m = r.matcher(S[n]);
                            if (m.find()) {
                                int row = Integer.parseInt(getTheNumberForChar(S[n]).split(" ")[0]);
                                int col = Integer.parseInt(getTheNumberForChar(S[n]).split(" ")[1]);
                                if(a[row][col]==null){
                                 a[row][col]=new Spread();
                                 list.add(String.valueOf(a[row][col].val));
                                }else
                                {
                                list.add(String.valueOf(a[row][col].val));
                                }
                            } else {
                               list.add(S[n]);
                            }
                        }
                        
                        String crString[]=createString(list);
                        a[i][j]=new Spread();
                      
                    }
                }

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
    static void runSecond() {

       
        String operators = "+-*/";
        String pattern = "[A-Z]+";
        Pattern r = Pattern.compile(pattern);
        try {
            
            String line = lines.poll();
            for (int i = 1; i <= row; i++) {
                
                for (int j = 1; j <= col; j++) {
                   
                    String in = lines.poll();
                    Matcher m = r.matcher(in);
                    if (in.split(" ").length == 1 && m.find()) {
                        int row = Integer.parseInt(getTheNumberForChar(in).split(" ")[0]);
                        int col = Integer.parseInt(getTheNumberForChar(in).split(" ")[1]);
                        
                        if(a[row][col]==null){ 
                            Spread sp=new Spread();
                            a[row][col]=sp;
                        a[i][j]= a[row][col];
                        }else
                        {
                             a[i][j]=new Spread();
                            a[i][j] = a[row][col];
                        }
                        
                    } else if( in.split(" ").length==1 ){
                    }else {
                        List<String> list = new ArrayList<String>();
                        String[] S = in.split(" ");

                        for (int n = 0; n < S.length; n++) {
                             m = r.matcher(S[n]);
                            if (m.find()) {
                                int row = Integer.parseInt(getTheNumberForChar(S[n]).split(" ")[0]);
                                int col = Integer.parseInt(getTheNumberForChar(S[n]).split(" ")[1]);
                                if(a[row][col]==null){
                                 a[row][col]=new Spread();
                                 list.add(String.valueOf(a[row][col].val));
                                }else
                                {
                                list.add(String.valueOf(a[row][col].val));
                                }
                            } else {
                               list.add(S[n]);
                            }
                        }
                        
                        String crString[]=createString(list);
                        a[i][j].val=evalRPN(crString);
                    }
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    
    public static String[] createString(List<String>list){
        
        String l[]=new String[list.size()];
        int i=0;
        for(String k:list){
            l[i++]=k;
        }
        return l;
    }
    
    
    public static void display(){
        
        System.out.println(col+" "+row);
         for (int i = 1; i <= row; i++) {
                
                for (int j = 1; j <= col; j++) {
                    System.out.println(String.format("%.5f", a[i][j].val));          
                }
         }
        
    }
    
}
