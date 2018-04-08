    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gautamverma
 */
 class BNode{
        int value;
        BNode right;
        BNode left;
        BNode(int value){this.value=value;}
        public void addLeft(BNode node){
            this.left=node;
        };
        public void addRight(BNode node){
             this.right=node;
        };
    }

public class Btree {
    static BNode root=null;
    
    public static void main(String[] args) throws IOException {
        
        
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BNode Ten=new BNode(10);
        BNode One=new BNode(1);BNode Two=new BNode(2);
        BNode Three=new BNode(3);BNode Four=new BNode(4);BNode fifteen=new BNode(15);
        BNode eleven=new BNode(11);
        BNode sixteen=new BNode(16);BNode fourteen=new BNode(14);
        add(Ten);
        add(One);
        add(Three);add(Four);add(Two);
        add(fifteen);add(eleven);add(sixteen);add(fourteen);
        display(root);
        
        System.out.println("SORT: ");
       
      //  Hsort(root);
     //   mySort(root);
        displayinSorted(root);
        find(111,root);
     }
    
    
    public static void find(int find,BNode root){
        
        if(root.value==find){
            System.out.println("found");
            return;
        }
        if(root.left==null && root.right==null)return;
        if(root.value > find)
            find(find,root.left);
        else
            find(find,root.right);
        
    }
    public static void displayinSorted(BNode root){
    
     
        if(root==null)return;
        
        displayinSorted(root.left);
        System.out.println(root.value);
          displayinSorted(root.right);
        
}
    
    
    public static void add(BNode node){
        if(root==null)
        {
            root=new BNode(node.value);
            node.left=null;
            node.right=null;
            root=node;
            
        }
        else
        {
            if(node.value < root.value){
                addToLeft(node,root);
            }else
            {
                addToRight(node,root);
            }
        }
        
        
        
    }
    
    public static void addToLeft(BNode node,BNode currNode){
        
             if((node.value < currNode.value) && (currNode.left==null))
             {
                currNode.left=node;

             }else if((node.value < currNode.value))
             {
                  addToLeft(node, currNode.left);
             }
             else if((node.value > currNode.value) && (currNode.right==null)){
                 currNode.right=node;
             }else if(node.value > currNode.value){
                 addToRight(node,currNode.right);
             }
                          
        
    }
    
    public static void addToRight(BNode node,BNode currNode ){
       if((node.value < currNode.value) && (currNode.left==null))
             {
                 currNode.left=node;

             }else if((node.value < currNode.value))
             {
                  addToLeft(node, currNode.left);
             }
             else if((node.value > currNode.value) && (currNode.right==null)){
                 currNode.right=node;
             }else if(node.value > currNode.value){
                 addToRight(node,currNode.right);
                 
             }
                          
    }
    
    
    public static void display(BNode node)
    {
//        System.out.println(root.value);
//        if(root.left!=null)
//        dispLeft(root.left);
//        
//        if(root.right!=null)
//        dispRight(root.right);
        
        
        //System.out.println(node.value);
        dispLeft(node);
        dispRight(node);
        
    }
    
    public static void dispLeft(BNode node)
    {
        if(node!=null){
        System.out.println(node.value);
        if(node.left!=null)
        {
            display(node.left);
        }}
    }
    
    
    public static void dispRight(BNode node){
   //     System.out.println(node.value);

        if(node.right!=null)
        {
            display(node.right);
        }
    
    }
   
    
    
    public  static void Hsort(BNode node){
        sortLeftD(node);
          if(node.right!=null)
        sortRightD(node);
    }
    
    public static void sortLeftD(BNode node){
        if(node!=null){
            
            if(node.left==null){System.out.println(node.value);}
            else
            {
                Hsort(node.left);
                System.out.println(node.value);
            }
        }
    }
    public static void sortRightD(BNode node){
        if(node.right==null){System.out.println(node.value);}
        else
        {
            Hsort(node.right);
        }
    }
    
    
    
    public static int mySort(BNode node)
    {
        
        if(node.left!=null){
            mySort(node.left);
            
        }else if(node.left==null && node.right==null){
            System.out.println(node.value);
            return 0;
        }else if(node.left==null && node.right!=null){
            System.out.println(node.value);
            mySort(node.right);
            return 0;
        }
        System.out.println(node.value);
        if(node.right!=null){
            mySort(node.right);
        }
        else if(node.right==null){
               return 0;
        }
        return 0;
    }
    
}
