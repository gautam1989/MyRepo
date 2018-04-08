/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gautamverma
 */

class Test{
 
 public int countDup(){   
int a[]=new int[]{1,6,4,8,7,4,4,7,2,1,5};
int dupCount=0;
Set<Integer>s=new HashSet<Integer>();    //a set is created to store the alredy found duplicate value ,so that we dount count it again
for(int i=0;i<a.length;i++){
    
    for(int j=i+1;j<a.length;j++){
        
      if(a[i]==a[j] && !s.contains(a[i])){   //if the set does not contain the value and it is a duplicate then the duplicate count is increased.
          dupCount+=1;
          s.add(a[i]);
      }    
        
    }
    
}
return dupCount;
}

public static void main(String []args){
    Test t=new Test();
    System.out.println(t.countDup()); //will print the dupCount number
}

}