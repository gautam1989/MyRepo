
package ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    
    static Map<Integer,Queue>queueMap=new HashMap<Integer, Queue>();
   static  Map<Integer,Deque>stackMap=new HashMap<Integer, Deque>();
    
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String line="";
       
        
        while( !(line=s.nextLine()).equals("")){
                String l[]=null;
                l=line.split(" ");
                
                
                String val=l[0];
                if(val.equals("new_s")){
                    Deque<Integer> stack = new ArrayDeque<Integer>();
                       stackMap.put(Integer.parseInt(l[1]),stack);
                }
                else if(val.equals("push")){ 
                    if(stackMap.get(Integer.parseInt(l[1])).size()==10)System.out.println("error: stack is full");
                        else
                       stackMap.get(Integer.parseInt(l[1])).push(Integer.parseInt(l[2]));
                }
                else if(val.equals("pop")){ 
                    if(stackMap.get(Integer.parseInt(l[1])).size()==0)System.out.println("error: stack is empty");
                         else
                        stackMap.get(Integer.parseInt(l[1])).pop();
                }
                else if(val.equals("delete_s")){
                    Deque<Integer>st=stackMap.get(Integer.parseInt(l[1]));st.clear();
                }
                else if(val.equals("print_s")){
                    printStack(stackMap.get(Integer.parseInt(l[1])));
                }
                else if(val.equals("new_q")){
                    Queue<Integer> q = new LinkedList();
                        queueMap.put(Integer.parseInt(l[1]), q);
                }
                else if(val.equals("enqueue")){
                    if(queueMap.get(Integer.parseInt(l[1])).size()==10)System.out.println("error: queue is full");
                        else
                            queueMap.get(Integer.parseInt(l[1])).add(Integer.parseInt(l[2]));
                }
                else if(val.equals("dequeue")){
                    if(queueMap.get(Integer.parseInt(l[1])).size()==0)System.out.println("error: queue is empty");
                        else
                         queueMap.get(Integer.parseInt(l[1])).remove();
                }
                else if(val.equals("delete_q")){
                    Queue<Integer> q2= queueMap.get(Integer.parseInt(l[1]));q2.clear();
                }
                else if(val.equals("print_q")){ 
                    printQueue(queueMap.get(Integer.parseInt(l[1])));
                }
                else if(val.equals("stack->stack")){
                    moveElementFromStackToStack(stackMap.get(Integer.parseInt(l[1])),stackMap.get(Integer.parseInt(l[2])));
                }
                else if(val.equals("stack->queue")){
                    moveElementFromStackToQueue(stackMap.get(Integer.parseInt(l[1])),queueMap.get(Integer.parseInt(l[2])));
                }
                else if(val.equals("queue->queue")){
                    moveElementFromQueueToQueue(queueMap.get(Integer.parseInt(l[1])),queueMap.get(Integer.parseInt(l[2])));
                }
                else if(val.equals("queue->stack")){
                    moveElementFromQueueToStack(queueMap.get(Integer.parseInt(l[1])),stackMap.get(Integer.parseInt(l[2])));
                }
                
                
                
                
                
            }
            
            
            
            
        }
        
        
        
    
    
    
     public static void moveElementFromQueueToStack(Queue<Integer>from,Deque<Integer>to){
        if(from.size()>0 && to.size()<10){
         int e=from.remove();
         to.push(e);
        }else
        {
            System.out.println("error: wrong command");
        }
        
    }
    
     public static void moveElementFromQueueToQueue(Queue<Integer>from,Queue<Integer>to){
        if(from.size()>0 && to.size()<10){
         int e=from.remove();
        to.add(e);
        }else
        {
            System.out.println("error: wrong command");
        }
    }
    
    public static void moveElementFromStackToQueue(Deque<Integer>from,Queue<Integer>to){
       if(from.size()>0 && to.size()<10){
        int e=from.pop();
        to.add(e);
       }else
        {
            System.out.println("error: wrong command");
        }
    }
    
    public static void moveElementFromStackToStack(Deque<Integer>from,Deque<Integer>to){
         if(from.size()>0 && to.size()<10){
        int e=from.pop();
        to.push(e);
         }else
        {
            System.out.println("error: wrong command");
        }
         
    }
    
    public static void printStack(Deque<Integer>st){
        if(st.size()==0){
            System.out.println("empty");
        }else
        {
            Iterator<Integer> t=st.iterator();
            List<Integer> l=new ArrayList<Integer>();
            while(t.hasNext()){
                l.add(t.next());
            }
            for(int i=l.size()-1;i>=0;i--){
                if(i==0)
                    System.out.print(l.get(i));
                else
                System.out.print(l.get(i)+" ");
            }
            System.out.println("");
        }
        
    }
    
    
    public static void printQueue(Queue<Integer>q){
        if(q.size()==0){
            System.out.println("empty");
        }else
        {
            Iterator<Integer>t=q.iterator();
                        List<Integer> l=new ArrayList<Integer>();

             while(t.hasNext()){
                l.add(t.next());
            }
             for(int i=l.size()-1;i>=0;i--){
                 if(i==0)
                     System.out.print(l.get(i));
                 else
                System.out.print(l.get(i)+" ");
            }
                 System.out.println("");
        }
     
    }
}
