
package visa;
        
import java.util.*;
import java.util.logging.*;

public class PC2
{
    public static void main(String args[])
    {
            ArrayList<Integer> queue = new ArrayList<Integer>();

            int size = Integer.parseInt("10");
            Thread[] prod = new Thread[2];
            Thread[] cons = new Thread[2];

            for(int i=0; i<prod.length; i++)
            {
                    prod[i] = new Thread(new Producer(queue, size));
                    prod[i].start();
            }

            for(int i=0; i<cons.length; i++)
            {
                    cons[i] = new Thread(new Consumer(queue, size));
                    cons[i].start();
                }

    }
}

class Producer extends Thread
{
    private final ArrayList<Integer> queue;
    private final int size;

    public Producer(ArrayList<Integer> queue, int size)
    {
            this.queue = queue;
            this.size = size;
    }

    public void run()
    {
            while(true){
            for(int i=0; i<size; i++)
            {
                    System.out.println("Produced: "+i+" by id " +Thread.currentThread().getId());
try
                    {
                            produce(i);
                            Thread.sleep(3000);
                    }
                    catch(Exception e)
                    {
                            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
                    }
            }}
    }


    public void produce(int i) throws InterruptedException
    {
            while(queue.size() == size)
            {
                    synchronized(queue)
                    {
                            System.out.println("Queue is full "+Thread.currentThread().getId()+" is waiting, size: "+queue.size());
                            queue.wait();
                       }
            }
            synchronized(queue)
            {
                    queue.add(i);
                    queue.notifyAll();
            }
    }
}

class Consumer extends Thread
{
    private final ArrayList<Integer> queue;
    private final int size;

    public Consumer(ArrayList<Integer> queue, int size)
    {
            this.queue = queue;
            this.size = size;
    }

    public void run()
    {
            while(true)
            {
                    try
                    {       System.out.println("Consumed: "+consume());
                            Thread.sleep(1000);
                    }
                    catch(Exception e)
                    {
                            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
                    }
            }
    }

    public int consume() throws InterruptedException
    {
            while(queue.isEmpty())
            {
                    synchronized(queue)
                    {
                            System.out.println("Queue is empty "+Thread.currentThread().getId()+" is waiting, size: "+queue.size());
                            queue.wait();
                        }
            }

            synchronized (queue)
            {
                    queue.notifyAll();
                    System.out.println("Consumed by id "+Thread.currentThread().getId());
                    return (Integer) queue.remove(0);

            }
    }
}