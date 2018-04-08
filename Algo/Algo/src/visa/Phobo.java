/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

/**
 *
 * @author gautamverma
 */
public class Phobo {
    public static void main(String args[]){
        int x=-1;
        int y=1;
        int z=0;
        for(int i=0;i<10;i++){
            z=x+y;
            System.out.println(z);
            x=y;
            y=z;
        }
    }
}
