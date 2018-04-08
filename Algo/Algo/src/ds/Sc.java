/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gautamverma
 */
public class Sc implements Cloneable{
    
    int j;
    public static void main(String[] args)  {
        
        try {
            Sc s1=new Sc();
            s1.j=10;
            Sc s2=(Sc)s1.clone();s2.j=11;
            System.out.println(s1.j);
            s2.addcl();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Sc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addcl() throws CloneNotSupportedException
    {
        Sc s3=new Sc();
        s3=(Sc)this.clone();
      //  s3.j=9;
        System.out.println(s3.j);
        
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
