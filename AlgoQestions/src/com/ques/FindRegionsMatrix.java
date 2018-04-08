package com.ques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

class Node{
	boolean visited;
	String val;
	Node parent;
	int x;
	int y;
}

public class FindRegionsMatrix {

	Queue<Node> queue = new LinkedList<Node>();
	Map<Node,Set<Node>> keyMap =new HashMap<Node,Set<Node>>();
	private static int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1},  {0,1}, {1,1},  {1,0},  {1,-1},  {0, -1}};

	public Node[][] createNodeMatrix(String matrix[][]){
		Node[][] matrixN=new Node[matrix.length][matrix.length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				Node n=new Node();
				n.visited=false;
				n.parent=n;
				n.x=i;
				n.y=j;
				n.val=matrix[i][j];
				matrixN[i][j]=n;
			}
		}
		return matrixN;

	}


	public void print(Node[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				System.out.print(matrix[i][j].val);
			}
			System.out.println();
		}
	}

	public void findregions(Node[][] matrixN){
		queue.add(matrixN[0][0]);
		while(!queue.isEmpty()){
			Node n = queue.poll();
			n.visited=true; 
			getSurroundings(matrixN, n.x, n.y, n);
		}
		for (Entry<Node, Set<Node>> entry : keyMap.entrySet()) {
			System.out.println("Item : (" + entry.getKey().x+","+entry.getKey().x+")");
			for(Node s:entry.getValue()){
				System.out.print("("+s.x+","+s.y+")");
			}
		}
		
	}

	public void getSurroundings(Node[][] matrix, int x, int y,Node n){
		for (int[] direction : directions) {
			int cx = x + direction[0];
			int cy = y + direction[1];
			if(cy >=0 && cy < matrix.length){
				
				if(cx >= 0 && cx < matrix[cy].length && matrix[cy][cx].visited==false){
					queue.add(matrix[cx][cy]);
					}
				
				if(cx >= 0 && cx < matrix[cy].length && n.val.equals("T"))
				{
					
					if(matrix[cx][cy].val.equals("T") && matrix[cx][cy].parent==matrix[cx][cy]){
						matrix[cx][cy].parent=n.parent;
						if(keyMap.containsKey(n.parent)){
							keyMap.get(n.parent).add(matrix[cx][cy]);
						}else{
							Set<Node> s = new HashSet<Node>();
							s.add(matrix[cx][cy]);
							keyMap.put(n.parent, s);
						}
					}else if(matrix[cx][cy].val.equals("T") && matrix[cx][cy].parent!=matrix[cx][cy]){
						n.parent = matrix[cx][cy].parent;
						if(keyMap.containsKey(n.parent)){
							keyMap.get(n.parent).add(matrix[cx][cy]);
						}else{
							Set<Node> s = new HashSet<Node>();
							s.add(matrix[cx][cy]);
							keyMap.put(n.parent, s);
						}
					}
				}
			}}

	}

	public static void main(String[] args) {
		
		String matrix[][]=new String[][]{{"F","F","F","F"},{"F","T","T","T"},{"F","F","F","T"},{"F","T","T","F"}};
		FindRegionsMatrix frm = new FindRegionsMatrix();
		Node[][] matrixN = frm.createNodeMatrix(matrix);
		frm.findregions(matrixN);
		//frm.print(matrixN);
		System.out.println("S");

	}
}
