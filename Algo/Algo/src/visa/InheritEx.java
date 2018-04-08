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
interface i1{
    
}
interface i2{
    
}
interface testIN extends i1,i2 {
    public final int i=0;
    public abstract void me();
}
class Person{
    public String name;
    
    public void disp(){
        System.out.println("Person Disp");
    }
}

class Emp extends Person{
    public int empID;
    public void disp(){
        System.out.println("emp Disp");
    }
    public void EmpMet(){
        
    }
}


public class InheritEx implements testIN{
    
    
 
   public void de(){
       
   }
    
    public static void main(String []args)
    {
        char[]s="gauuag".toCharArray();
          int st=0;
          int e=s.length-1;
        while(st<=e || e>=st){
            if(s[st]!=s[e]){
                System.out.println("Not");
                break;
            }
            st=st+1;e=e-1;
            
        }
           Emp emp1=new Emp();
           emp1.name="Gautam";
           emp1.empID=1;
           
           Emp emp2=new Emp();
           emp2.name="neha";
           emp2.empID=2;
           
           emp1.disp();
           
           Person p=new Person();
           p.name="s";
           p.disp();
           
           Person p2=new Emp();
           p.name="s";
           p.disp();
           
           
           
           final int i=0;
           
           testIN ci=new InheritEx();
           ci.me();
           
           
           
           
     }

    @Override
    public void me() {
        System.out.println("Me");
    }
    
}
