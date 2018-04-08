/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

/**
 *
 * @author gautamverma
 */
public class Ds {
     static Node head;
    /**
     * @param args the command line arguments
     */
    
   void add(int value){
       if(head!=null){
        Node st=head;
        for(;;){
          if(st.next==null){
              break;
          }else
          {
              st=st.next;
          }
        }
         Node n2=new Node(value, null);
        n2.value=value;
        n2.next=null;
        st.next=n2;
       }
       else
       {
           Node st=new Node(value, null);
        st.value=value;
        st.next=null; 
        head=st;
       }
    }
    
    static void display()
    {
        
            Node n=head;
            while(n!=null){
                System.out.println(n.value);
                
                n=n.next;
            }
        
    }
    public static void main(String[] args) {
     Ds d=new Ds();
     d.add(1);
     d.add(2);
     d.add(3);
     display();
     
    }
    
}


 class Node
{
    Node next;
   
    Integer value;
    Node(int value,Node next){
        this.value=value;
        this.next=next;
    }
    
}
