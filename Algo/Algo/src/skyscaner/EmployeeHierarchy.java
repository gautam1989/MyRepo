/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyscaner;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author gautamverma
 */
public class EmployeeHierarchy {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
              List<String>lines=new ArrayList<>();
              Scanner s=new Scanner(System.in);
              while(!s.nextLine().equals("")){
                  lines.add(s.nextLine());
              }
            
		Map<String, Set<String>> tree = new HashMap<>();
		Set<String> employees = new HashSet<>();
		Set<String> roots = new HashSet<>();
		
		for(int i=1;i<lines.size();i++){
			String arr[] = lines.get(i).split(" ");
			if(!tree.containsKey(arr[0])){
				tree.put(arr[0], new HashSet<>());
			}
			tree.get(arr[0]).add(arr[1]);
			if(!employees.contains(arr[1])) {
				employees.add(arr[1]);
			}
			if(!employees.contains(arr[0])){
				roots.add(arr[0]);
			} else {
				roots.remove(arr[0]);
			}
		}
		
		//thus roots contain root elements .. now you can use BFS (using queue to) to print employees at each level.
		printBFS(tree, roots);
		
	}

	public static void printBFS(Map<String, Set<String>> graph, Set<String> roots){
		Queue<String> queue = new LinkedList<>(roots);
		Set<String> visitedNodes = new HashSet<>();
		printBFS(graph, queue, visitedNodes);
	}
	
	private static void printBFS(Map<String, Set<String>> graph, Queue<String> queue,
			Set<String> visitedNodes){
		int size = queue.size();
		if(size==0)
			return;
		for(int i=0; i<size; i++){
			String name = queue.poll();
			if(!visitedNodes.contains(name)){
				System.out.print(name+" ");
				if(graph.get(name)!=null)
					queue.addAll(graph.get(name));
				visitedNodes.add(name);
			}
		}
		System.out.println("");
		printBFS(graph, queue, visitedNodes);
	}	
}