/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author gautamverma
 */
class GraphStructure {
private Map<String, LinkedHashSet<String>> map = new HashMap();

public void addEdge(String node1, String node2) {
    LinkedHashSet<String> adjacent = map.get(node1);
    if(adjacent==null) {
        adjacent = new LinkedHashSet();
        map.put(node1, adjacent);
    }
    adjacent.add(node2);
}

public void addTwoWayVertex(String node1, String node2) {
    addEdge(node1, node2);
    addEdge(node2, node1);
}

public boolean isConnected(String node1, String node2) {
    Set adjacent = map.get(node1);
    if(adjacent==null) {
        return false;
    }
    return adjacent.contains(node2);
}

public LinkedList<String> adjacentNodes(String last) {
    LinkedHashSet<String> adjacent = map.get(last);
    if(adjacent==null) {
        return new LinkedList();
    }
    return new LinkedList<String>(adjacent);
}
}

public class BFSImplementation{

public static int count;
public static Hashtable hash; 
private static final String START = "B";
private static final String END = "E";

public BFSImplementation() {
     hash=new Hashtable();
     count=0;
}
public static void main(String[] args) {  

    GraphStructure graph = new GraphStructure();

    graph.addEdge("A", "B");

    graph.addEdge("A", "C");

    graph.addEdge("B", "A");

    graph.addEdge("B", "D");

    graph.addEdge("B", "E"); // this is the only one-way connection

    graph.addEdge("B", "F");

    graph.addEdge("C", "A");

    graph.addEdge("C", "E");

    graph.addEdge("C", "F");

    graph.addEdge("D", "B");

    graph.addEdge("E", "C");

    graph.addEdge("E", "F");

    graph.addEdge("F", "B");

    graph.addEdge("F", "C");

    graph.addEdge("F", "E");

    LinkedList<String> visited = new LinkedList();
    visited.add(START);
    new BFSImplementation().breadthFirst(graph, visited);
   }      
   public static  void breadthFirst(GraphStructure graph, LinkedList<String> visited) {
    LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());

    for (String node : nodes) {
        if (visited.contains(node)) {
            continue;
        }
        if (node.equals(END)) {
            count++;
            visited.add(node);
            printPath(count,visited);
            visited.removeLast();
            break;
        }
    }
    // in breadth-first, recursion needs to come after visiting adjacent nodes
    for (String node : nodes) {
        if (visited.contains(node) || node.equals(END)) {
            continue;
        }
        visited.addLast(node);
        breadthFirst(graph, visited);
        visited.removeLast();
    }
    }
    public static  void printPath(int count,LinkedList<String> visited) {       
    String temp="";
    for (String node : visited) {
        temp=temp+node+",";            
       // System.out.print(node);
       // System.out.print(" ");
    }
    System.out.println();
    System.out.println("Available Path  "+count+": : : :"+ temp);     
    hash.put(count,temp);
    //System.out.println("exp = " + hash.toString());       
    }
    } 