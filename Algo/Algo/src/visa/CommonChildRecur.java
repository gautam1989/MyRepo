/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gautamverma
 */
public class CommonChildRecur {

    List<String> l = new ArrayList<String>();
    static int tempC=0;

    public static int findTheCommon(String first, String second) {
        int i = 0;
        int j = 0;
        String f[] = first.split("");
        String s[] = second.split("");
        while (i < first.length()) {

            while (j < second.length()) {
                if(f[i].equals(s[i])){
                    String ff=createString(first,i+1);
                    String ss=createString(second,j+1);
                    tempC= 1+ findTheCommon(ff, ss);
                }
                j++;
            }
           i++;
           j=0;
            System.out.println(tempC);
        }
     return tempC;
    }

    public static String createString(String s,int i){
        String temp="";
        String t[]=s.split("");
        for(int j=i;j<s.length();j++){
            temp+=t[j];
        }
        return temp;
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String first = in.nextLine();
        String second = in.nextLine();
        findTheCommon(first, second);

    }

}
