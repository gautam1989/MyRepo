/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gautamverma
 */
public class Equilibrium {
    
  static   List<Integer> l=new ArrayList<Integer>();
 
public static int equilibrium(int arr[], int n)
{
   int sum = 0;      // initialize sum of whole array
   int leftsum = 0; // initialize leftsum
   int i;
 
   /* Find sum of the whole array */
   for (i = 0; i < n; ++i)
        sum += arr[i];
 
   for( i = 0; i < n; ++i)
   {
      sum -= arr[i]; // sum is now right sum for index i
 
      if(leftsum == sum)
      {// return i;
          l.add(i);
      }
 
      leftsum += arr[i];
   }
 
    /* If no equilibrium index found, then return 0 */
    return -1;
}
 
public static void main(String args[])
{
  int arr[] = {-7, 1, 5, 2, -4, 3, 0};
  
   equilibrium(arr, arr.length);
    System.out.println(l);
  
  
}
    
    
    
}
