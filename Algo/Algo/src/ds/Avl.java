/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import static ds.Btree.dispLeft;
import static ds.Btree.dispRight;
import static ds.Btree.display;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gautamverma
 */

class ANode{
        int value;
        ANode right;
        ANode left;
        ANode prev;
        ANode(int value){
            this.value=value;
            this.height=0;
        }
        public void addLeft(ANode node){
            this.left=node;
        };
        public void addRight(ANode node){
             this.right=node;
        };
        int height;
    }

public class Avl {
    static ANode root;
    static int t=0;
    public static void main(String[] args) throws IOException {
        int read=0;
       do{
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           read=Integer.parseInt(br.readLine());
           ANode nodeval=new ANode(read);
            if(nodeval.value!=1)
           insert(nodeval);
           if( nodeval.value!=1){
           if(root.left!=null || root.right!=null )
           setHeight(nodeval);
           }
          
       }while(read!=1);
        //display(root);
        System.out.println(">>>>");
        System.out.println(root.height);
        System.out.println(root.left.height);
        System.out.println(root.left.left.height);
        //System.out.println(root.left.left.left.prev.value);
    }
    
    static void insert(ANode read)
    {
        if(root==null){
            root=read;
            root.height=0;
        }else
        {
            if(read.value<root.value && root.left!=null){
                searchInLeft(read,root.left);
            }else if(read.value >root.value && root.right!=null)
            {
                searchInLeft(read,root.right);
            }
            else if(read.value <root.value && root.left==null){root.left=read;read.prev=root;}
            else if(read.value >root.value && root.right==null){root.right=read;read.prev=root;}
                
        }
    }
    
    static void searchInLeft(ANode read,ANode root){
         if(read.value<root.value && root.left==null)
         {
             root.left=read;read.prev=root;
         }else if(read.value >root.value &&root.right==null){
             root.right=read;read.prev=root;
         }else if(read.value <root.value && root.left!=null){
             searchInLeft(read, root.left);
         }else if(read.value >root.value && root.right!=null){
             searchInLeft(read, root.right);
         }
    }
     static void searchInRight(ANode read,ANode root){
        
    }
     static void display(ANode root){
          dispLeft(root);
        dispRight(root);
     }
     public static void dispLeft(ANode node)
    {
        if(node!=null){
        System.out.println(node.value);
        if(node.left!=null)
        {
            display(node.left);
        }}
    }
    
    
    public static void dispRight(ANode node){
   //     System.out.println(node.value);

        if(node.right!=null)
        {
            display(node.right);
        }
    
    }
    
    static void setHeight(ANode read){
      
          
       
            
            if(read.prev==null){ 
            
            }
            else if(read.prev.left==read && read.prev.right==null){
                t=+1;
                read.prev.height=read.height+1;setHeight(read.prev);
            }else if((read.prev.left==read) && (read.prev.right!=null) ){
                read.prev.height=read.prev.right.height+1;
                t=+1;setHeight(read.prev);
            }else if(read.prev.right==read && read.prev.left==null){
                t=+1;setHeight(read.prev);
                read.prev.height=read.prev.height+1;
            }else if((read.prev.right==read) && (read.prev.left!=null) ){
                read.prev.height=read.prev.left.height+1;
                t=+1;setHeight(read.prev);
            }
           

          
        
        
    }
    
}
