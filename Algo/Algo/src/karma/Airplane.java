/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package karma;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gautamverma
 */

class seat{
   int passengerNo; 
}
public class Airplane {

    static List<seat> aile=new ArrayList<seat>();
    static List<seat> window=new ArrayList<seat>();
    static List<seat> centre=new ArrayList<seat>();
    List<seat[][]> totalSeats=new ArrayList<seat[][]>();
    
    public static void main(String args[]){
      
    
        readInput();
       int a[]=new int[]{3,2,4,3,2,3,3,4};
       
       int s=a.length/2;
       
       int cur=0;
       for(int k=1;k<=s;k++){
           
           if(k==1){
           
               int r=a[cur];
               int c=a[cur+1];
               for(int i=0;i<r;i++){
          
              
              if(i==0){
                  for(int g=0;g<c;g++){
                  seat sc=new seat();
                  window.add(sc);
                  }
              }
              else if((r-1)>1 && i<r-1){
                     for(int g=0;g<c;g++){
                  seat sc=new seat();
                  centre.add(sc);
                  }
              }
              else {
                      for(int g=0;g<c;g++){
                  seat sc=new seat();
                  aile.add(sc);
                  }
              }
              
          
      }
                 
                
               cur=cur+2;
           }else if(k==s){
              int r=a[cur];
               int c=a[cur+1];
               for(int i=0;i<r;i++){
         
              
              if(i==0){
                 
                  for(int g=0;g<c;g++){
                  seat sc=new seat();
                  aile.add(sc);
                  }
              }
              else if((r-1)>1 && i<r-1){
                     for(int g=0;g<c;g++){
                  seat sc=new seat();
                  centre.add(sc);
                  }
              }
              else {
                      for(int g=0;g<c;g++){
                  seat sc=new seat();
                  window.add(sc);
                  }
              }
              
          
      }cur=cur+2;
           }else{
               
              int r=a[cur];
               int c=a[cur+1];
                 for(int i=0;i<r;i++){
          
              
              if(i==0){
                  for(int g=0;g<c;g++){
                  seat sc=new seat();
                  aile.add(sc);
                  }
              }
              else if((r-1)>1 && i<r-1){
                      for(int g=0;g<c;g++){
                  seat sc=new seat();
                  centre.add(sc);
                  }
              }
              else {
                     for(int g=0;g<c;g++){
                  seat sc=new seat();
                  aile.add(sc);
                  }
              }
              
          
      }
               cur=cur+2;
           }
               
           
       }
      
        System.out.println(aile.size());
        System.out.println(window.size());
         System.out.println(centre.size());

        int passenger=36;
        int curP=0;
        System.out.println("AILE passengers");
        for(int i=0;i<aile.size();i++){
            
            if(curP<=passenger){
            aile.get(i).passengerNo=curP+1;
                System.out.print(aile.get(i).passengerNo+" ");
            curP+=1;
            }
        }
        System.out.println("");
        System.out.println("Window passengers");
            for(int i=0;i<window.size();i++){
            if(curP<passenger){
            window.get(i).passengerNo=curP+1;
            System.out.print(window.get(i).passengerNo+" ");
            curP+=1;
            }
        }
        System.out.println("");
        System.out.println("centre passengers");
            for(int i=0;i<centre.size();i++){
            if(curP<passenger){
            centre.get(i).passengerNo=curP+1;
            System.out.print(centre.get(i).passengerNo+" ");
            curP+=1;
            }
        }
            System.out.println("");System.out.println("");
        
            
        int curaile=0;int curcentre=0;int curwin=0;    
      
        //to print
       
        cur=0;
         for(int k=1;k<=s;k++){
             
            if(k==1){
                System.out.println("BLOCK 1:");
               int r=a[cur];
               int c=a[cur+1];
               for(int i=0;i<r;i++){
          
               for(int g=0;g<c;g++){
              if(i==0){
                 
              
                System.out.print("W:"+ window.get(curwin).passengerNo +" ");
                    curwin+=1;
                  }
              
             else if((r-1)>1 && i<r-1){
                    
                  System.out.print("C:"+centre.get(curcentre).passengerNo+" ");
                    curcentre+=1;
                  
              }
              else {
                  
                 System.out.print("A:"+aile.get(curaile).passengerNo+" ");
                    curaile+=1;
                  
              }
               }
                   System.out.println("");
      }
      
               cur=cur+2;
           }else if(k==s){
               System.out.println("BLOCK next:");
               int r=a[cur];
               int c=a[cur+1];
                 for(int i=0;i<r;i++){
         
              
              if(i==0){
                 
                  for(int g=0;g<c;g++){
                  System.out.print("A: "+aile.get(curaile).passengerNo+" ");
                    curaile+=1;
                  }
              }
               else if((r-1)>1 && i<r-1){
                     for(int g=0;g<c;g++){
                  System.out.print("C: "+centre.get(curcentre).passengerNo+" ");
                    curcentre+=1;
                  }
              }
              else {
                      for(int g=0;g<c;g++){
                  System.out.print("W: "+window.get(curwin).passengerNo+" ");
                    curwin+=1;
                  }
              }
              
          System.out.println("");
      }cur=cur+2;
           }else{
               System.out.println("BLOCK next:");
               
               int r=a[cur];
               int c=a[cur+1];
                 for(int i=0;i<r;i++){
          
              
              if(i==0){
                  for(int g=0;g<c;g++){
                  System.out.print("A: "+aile.get(curaile).passengerNo+" ");
                    curaile+=1;
                  }
              }
              else if((r-1)>1 && i<r-1){
                      for(int g=0;g<c;g++){
                 System.out.print("C: "+centre.get(curcentre).passengerNo+" ");
                    curcentre+=1;
                  }
              }
              else {
                     for(int g=0;g<c;g++){
                  System.out.print("A: "+aile.get(curaile).passengerNo+" ");
                    curaile+=1;
                  }
              }
              System.out.println("");
          
      }
               cur=cur+2;
           }
              
             
         }
        
    }
    
    
    static void readInput(){
            
        
        
    }
    
    
        
}
