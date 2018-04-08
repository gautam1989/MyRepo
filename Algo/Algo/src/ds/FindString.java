/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author gautamverma
 */
public class FindString {

    int c=0;
 int[]x={0,0,-1,-1,-1,1,1,1,1};
 int[]y={-1,1,-1,0,1,-1,0,1};
      int valTrack=1;int xn,yn=0;
      String found="";
      String searchSt="MICROSOFT";
    static  String ha="";
      List<String> li=new ArrayList<String>(); int totalPoints;
      String search[]=null;
    void start() {
        String arr = "A-C-P-R-C-X-S-O-P-C-V-O-V-N-I-W-G-F-M-N-Q-A-T-I-T";
        String br[] = arr.split("-");
        String a[][] = new String[5][5];
       
        int h = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = br[h];
                h += 1;
            }
        }
   totalPoints=h*2;
        //display
        for (int i = 0; i < 5; i++) {
          // System.out.println();
            for (int j = 0; j < 5; j++) {
            //    System.out.print(a[i][j]);
            }
        }
        //display

        
        
         search=searchSt.split("");
        
        int f=0;
        found+="M";
        ha=search[1];
        searchString(a, 3, 3);
        
    }
        
    
    
    
    public void searchString(String a[][],int xx,int yy){
       
      //  System.out.println("SV: "+c++ +ha + xx+ " "+yy);
        
        if(li.size()<=totalPoints && !found.equals(searchSt)){ 
            
            
        for(int i=0;i<8;i++){
                xn=xx+x[i];
                yn=yy+y[i];
                
                li.add(xn+" "+yn);  
              //  System.out.println(xn+ "and "+yn);
                if( (xn>=0 && yn >=0 && xn <=4 && yn <=4)   && (a[xn][yn].equals(ha)) ){
                  //  System.out.println("SS: "+xn+ " "+yn);
                  found=found+ha; 
                    System.out.println("Found String:"+found);
                    valTrack+=1;
                   ha=search[valTrack];
                    
                    searchString( a, xn, yn);
                }else if((xn>=0 && yn >=0 && xn <=4 && yn <=4) && (a[xn][yn].equals(search[valTrack-1])))
                {
                     searchString( a, xn, yn);
                }
            }

    }}
    
      
    public static void main(String args[]) {

        FindString fs = new FindString();
        fs.start();
    }

}
