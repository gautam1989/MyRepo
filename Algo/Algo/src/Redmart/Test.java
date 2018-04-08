/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Redmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test {
 
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String x = null;
        while( (x = input.readLine()) != null ) {
            System.out.println(x);
        }
    }
}
