/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visa;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.tree.TreeNode;

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
    static int rheight=0;
    public static void main(String[] args) throws IOException {
        
        
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BNode Ten=new BNode(10);
        BNode One=new BNode(1);BNode Two=new BNode(2);
        BNode Three=new BNode(3);BNode Four=new BNode(4);BNode fifteen=new BNode(15);
        BNode eleven=new BNode(11);
        BNode sixteen=new BNode(16);BNode fourteen=new BNode(14);
        BNode five=new BNode(5);
        add(Ten);
        add(One);
        add(Three);add(Four);add(Two);
        add(fifteen);add(eleven);add(sixteen);add(fourteen);add(five);
        display(root);
        
        System.out.println("SORT: ");
      //  Hsort(root);
      //  mySort(root);
        
        
        System.out.println(heightOfBinaryTree(root.left));
        System.out.println(maxHeight(root.left));
        //System.out.println(maxDepthIterative(root,0));
        maxDepthIterative(root,0);
        System.out.println(height(root.left));
        System.out.println(height(root.right));
        System.out.println("SOORTF FAST");
        sortFast(root);
        System.out.println("");
        System.out.println("FOUND: "+find(root, 110));
     }
    
    
    //1 way to height
   public static   int maxHeight(BNode p) {
  if (p==null) return 0;
  int left_height = maxHeight(p.left);
  int right_height = maxHeight(p.right);
  return (left_height > right_height) ? left_height + 1 : right_height + 1;
}
    
   
   public static int find(BNode root,int N){
       
       if(root==null)
           return 0;
       else if(root.value==N)
           return N;
       find(root.left,N);
       find(root.right,N);
       return 0;
       
   }
   
   public static void sortFast(BNode root){
       if(root==null){
           return;
       }else{
           sortFast(root.left);
           System.out.print(root.value+" ");
           sortFast(root.right);
       }
              
   }
   
    //2 way to height
    public static int heightOfBinaryTree(BNode node)
{
    if (node == null)
    {
        return 0;
    }
    else
    {
        return 1 +
        Math.max(heightOfBinaryTree(node.left),
            heightOfBinaryTree(node.right));
    }
}
    
    //3 max depth
    public static void maxDepthIterative(BNode root,int height) {
     
        if(root==null){
            return ;
        }else
        {
            maxDepthIterative(root.left, height);
         
            maxDepthIterative(root.right, height);
            System.out.print(root.value+" ");
            
        }
        
        
}
    
    //4 height
    public static int height(BNode node) {
    int height = 0;
    if (node != null) {
        // Breadth-first traversal, keeping track of the number of levels
        Queue<BNode> thisLevel = new LinkedList<BNode>(),
                        nextLevel = new LinkedList<BNode>();

        thisLevel.add(node);
        while (null != (node = thisLevel.poll())) {
            if (node.left  != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);

            if (thisLevel.isEmpty()) {
                height++;

                Queue<BNode> swapTemp = thisLevel;
                thisLevel = nextLevel;
                // We could create a new nextLevel queue, but reusing the
                // newly emptied thisLevel queue is more efficient.
                nextLevel = swapTemp;
            }
        }
    }
    return height;
}
    
    static int findHeightright(BNode root){
        rheight=rheight+1;
        if(root.left==null && root.right==null){
            return rheight;
        }else if(root.left !=null && root.right !=null){
            rheight-=1;
            findHeightright(root.left);
            findHeightright(root.right);
        }
        return rheight;
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
