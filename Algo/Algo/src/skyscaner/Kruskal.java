/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyscaner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author gautamverma
 */

class Edge implements Comparator<Edge>{
    char vertex1;
        char vertex2;
        float weight;

    public Edge(char vertex1, char vertex2, float weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    @Override
    public int compare(Edge o1, Edge o2) {
        if(o1.weight<o2.weight){
            return 1;  
        }else if(o1.weight >o2.weight){
            return -1;
        }else{
            return 0;
        }
    }

    public Edge() {
    }
        
    
            
}

class Graph{
    ArrayList<Character> vertices;
    ArrayList<Edge> edges;
}
public class Kruskal {
    
    
    HashMap<Character,Character>PARENT=new HashMap<>();
    HashMap<Character,Integer>RANK=new HashMap<>();
    
    public static void main(String args[]){
        char t[]={'a','b','c','d','e','f'};
        Graph g=new Graph();
        g.vertices=new ArrayList<Character>();
        g.vertices.add('a');
        g.vertices.add('b');
       g.vertices.add('c');
       g.vertices.add('d');
       g.vertices.add('e');
       g.vertices.add('f');
        g.edges=new ArrayList<Edge>();
        g.edges.add(new Edge('a', 'b', 4));
        g.edges.add(new Edge('a', 'f', 2));
        g.edges.add(new Edge('f', 'b', 5));
        g.edges.add(new Edge('c', 'b', 6));
        g.edges.add(new Edge('c', 'f', 1));
        g.edges.add(new Edge('f', 'e', 4));
        g.edges.add(new Edge('d', 'e', 2));
        g.edges.add(new Edge('d', 'c', 3));
        Kruskal k=new Kruskal(g);
    }
    
    Character Find(Character vertex){
        if(PARENT.get(vertex)==vertex)
            return PARENT.get(vertex);
        return Find(PARENT.get(vertex));   
    }
    
    
    void Union(Character root1,Character root2){
        if(RANK.get(root1) > RANK.get(root2))
            PARENT.put(root2, root1);
        else if(RANK.get(root1) < RANK.get(root2))
            PARENT.put(root1, root2);
        else{
            PARENT.put(root1, root2);
            RANK.put(root2, RANK.get(root2)+1);
        }
    }
    
    
    void MakeSet(Character vertex){
        PARENT.put(vertex, vertex);
        RANK.put(vertex, 0);
    }
    

    public Kruskal(Graph g) {
        
        List<Edge>A=new ArrayList<>();
        for(Character c:g.vertices){
            MakeSet(c);
        }
        Collections.sort(g.edges, new Edge());
        for(Edge e:g.edges){
            Character ro1=Find(e.vertex1);
            Character ro2=Find(e.vertex2);
            if(ro1!=ro2){
                A.add(e);
                Union(ro1, ro2);
            }
        }
        Collections.sort(A,new Edge());
        float c=0f;
        for(Edge f:A){
            System.out.println(f.vertex1 +" "+f.vertex2+" "+f.weight);
            c=c+f.weight;
        }
        System.out.println(c);
    }
    
    
            
           
}
