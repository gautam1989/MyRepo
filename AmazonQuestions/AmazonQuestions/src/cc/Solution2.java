package cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
  
    public static void main(String[] args) {
        int i = bstDistance(new int[] {5,6,3,1,2,4,6,7,8,10,9}, 10, 2, 9);
        System.out.println(i);
    }

	public static int bstDistance(int[] values, int n, int node1, int node2) {
        Node root = null;
        Map<Node, Node> allNodes = new HashMap<>();

        for (int i: values) {
            if (root == null) {
                root = new Node(i);
                allNodes.put(root, root);
            }
            root.addNode(i, allNodes);
        }
        Map<Node, List<Node>> cache = new HashMap<>();

        Node fromN = new Node(node1);
        Node toN = new Node(node2);

        if (! allNodes.containsKey(fromN) || ! allNodes.containsKey(toN)) {
            return -1;
        }
        fromN = allNodes.get(fromN);
        toN = allNodes.get(toN);

        List<Node> path = traverse(fromN, toN, cache);
        return path.size() - 1;
    }

    private static List<Node> traverse(Node fromN, Node toN, Map<Node, List<Node>> cache) {

        if(cache.containsKey(fromN)) {
            return cache.get(fromN);
        }
        if (fromN == null || fromN.visited) {
            return new ArrayList<>();
        }
        if (fromN.equals(toN)) {
            List<Node> target = new ArrayList<>();
            target.add(toN);
            return target;
        }
        fromN.visited = true;

        List<Node> parentWay = new ArrayList<>();
        List<Node> lchildWay = new ArrayList<>();
        List<Node> rchildWay = new ArrayList<>();

        parentWay.addAll(traverse(fromN.parent, toN, cache));
        lchildWay.addAll(traverse(fromN.lchild, toN, cache));
        rchildWay.addAll(traverse(fromN.rchild, toN, cache));

        List<Node> shortest = getShortestList(getShortestList(parentWay, lchildWay), rchildWay);

        cache.put(fromN, shortest);
        if (! shortest.isEmpty()) {
            shortest.add(fromN);
        }
        fromN.visited = false;
        return shortest;
    }

    private static List<Node> getShortestList(List<Node> l1, List<Node> l2 ) {
        List<Node> shortest = null;
        if (l1 != null & l2 != null) {
            if (l1.isEmpty()) {
                shortest = l2;
            } else if (l2.isEmpty()) {
                shortest = l1;
            } else {
                shortest = l1.size() < l2.size() ? l1 : l2;
            }
        } else if (l1 == null) {
            shortest = l2;
        } else if (l2 == null) {
            shortest = l1;
        }
        return shortest;
    }

    private static class Node {
        Node parent;
        Node lchild;
        Node rchild;

        final int value;
        public boolean visited;

        private Node(int value) {
            this.value = value;
        }

        public void addNode(int i, Map<Node, Node> allNodes) {
            if (i > value) {
                if (null == rchild) {
                    rchild = new Node(i);
                    rchild.parent = this;
                    allNodes.put(rchild, rchild);
                } else {
                    rchild.addNode(i, allNodes);
                }
            }
            if (i < value) {
                if (null == lchild) {
                    lchild = new Node(i);
                    lchild.parent = this;
                    allNodes.put(lchild, lchild);
                } else {
                    lchild.addNode(i, allNodes);
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            return ((Node) obj).value == value;
        }

        @Override
        public int hashCode() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}