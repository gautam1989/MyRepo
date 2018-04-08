/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Redmart;

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

public class MyTree {

    static BNode root;
    
public static void main(String []args){
        BNode Ten=new BNode(10);
        BNode One=new BNode(1);BNode Two=new BNode(2);
        BNode Three=new BNode(3);BNode Four=new BNode(4);BNode fifteen=new BNode(15);
        BNode eleven=new BNode(11);
        BNode sixteen=new BNode(16);BNode fourteen=new BNode(14);
//        add(Ten,root);
//        add(One,root);
//        add(Three,root);add(Four,root);add(Two,root);
//        add(fifteen,root);add(eleven,root);add(sixteen,root);add(fourteen,root);
        
        add(10,root);
        add(5,root);
        add(13,root);
        add(14,root);
      displayinSorted(root);
    
}

public static int height(BNode root){
    if(root==null)
        return -1;
                else
        return 1+Math.max(height(root.left), height(root.right));
        
}
  public static void displayinSorted(BNode root){
    
     
        if(root==null)return;
        
        displayinSorted(root.left);
        System.out.println(root.value);
          displayinSorted(root.right);
        
}
public static void add(int n,BNode ro){
    
   
    if(root==null){
        root=new BNode(n);
        root.left=null;
            root.right=null;
        return;
    }
    
     
    
    if(n <ro.value){
        if(ro.left==null){
            ro.left=new BNode(n);
            return;
        }else{
        add(n,ro.left);
        }
        
    }else if(n>ro.value)
    {
        if(ro.right==null){
            ro.right=new BNode(n);
         return;
        }else{
        add(n,ro.right);
        }
    }
    return;
    
}

}

