/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redmart;

/**
 *
 * @author gautamverma
 */
public class Code {

    public static int output1;
    static int testnum, sum, tempnum;

    public static int find(int input1) {
        testnum = input1;
        while (testnum <= 1000) {
            tempnum = testnum;
            sum = 0;
            while (tempnum > 0) {
                sum = sum + (tempnum % 10);
                tempnum = (int) (tempnum / 10);
                if (sum == input1) {
                    output1=testnum;
                    return testnum;
                }
                testnum = testnum + input1;
            }
        }
       return -1;
    }

    public static void FindMeOut(int input1) {
           find(input1);
           System.out.println(output1);
    }

    public static void main(String args[]) {

          FindMeOut(10);
    }

}
