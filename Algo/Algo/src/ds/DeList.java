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
public class DeList {
     static Node2 head;
    /**
     * @param args the command line arguments
     */
    
   void add(int value){
       if(head!=null){
        Node2 st=head;
        for(;;){
          if(st.next==null){
              break;
          }else
          {
              st=st.next;
          }
        }
         Node2 n2=new Node2(value, null,st);
        n2.value=value;
        st.next=n2;
       }
       else
       {
           Node2 st=new Node2(value, null,null);
        st.value=value;
        head=st;
       }
    }
    
    static void display()
    {
        
            Node2 n=head;
            while(n!=null){
                System.out.println(n.value);
                
                n=n.next;
            }
        
    }
    public static void main(String[] args) {
        DeList d=new DeList();
     d.add(1);
     d.add(2);
     d.add(3);
     display();
     int[] a=new int[2];
        System.out.println(a.length);
     
    }
    
}


class Node2{
     Node2 next,prev;
   
    Integer value;
    Node2(int value,Node2 next,Node2 prev){
        this.value=value;
        this.next=next;
        this.prev=prev;
    }
}


