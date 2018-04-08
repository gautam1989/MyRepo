
// Java program to turn off a particular bit in a number
import java.io.*;
 
class TurnOff 
{
    // Function to returns a number that has all bits same as n
    // except the k'th bit which is made 0
    static int turnOffK(int n, int k)
    {
        // k must be greater than 0
        if (k <= 0) 
            return n;
  
        // Do & of n with a number with all set bits except
        // the k'th bit
        return (n & ~(1 << (k - 1)));
    }
     
    // Driver program
    public static void main (String[] args) 
    {
        int n = 14;
        int k = 4;
        System.out.println(turnOffK(n, k));
    }
}