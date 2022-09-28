package com.jnlzw.lzwtool.algorithms.graph;

import javafx.util.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.*;

public class AdjacencyList implements Graph {

    private static class Node {
        private int to;
        private int val;
        private Node next;
    }

    private static class Head {
        private Node headNode;
        private HashSet<Integer> flagSet = new HashSet<>();
    }

    private ArrayList<Head> map;
    private int size;


    public AdjacencyList(int n) {
        if (n == 0) {
            n = 100;
        }
        ArrayList<Head> emptyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            emptyList.add(new Head());
        }
        this.map = emptyList;
        this.size = n;
    }

    @Override
    public void addRoute(int from, int to, int val) {
        Head head = map.get(from);
        Node headNode = head.headNode;
        HashSet<Integer> flagSet = head.flagSet;
        if (!flagSet.contains(to)) {
            Node next = new Node();
            next.val = val;
            next.to = to;
            next.next = headNode;
            head.headNode = next;
            flagSet.add(to);
        } else {
            while (null != headNode) {
                if (headNode.to == to) {
                    headNode.val = headNode.val + val;
                    return;
                }
                headNode = headNode.next;
            }
        }
    }

    @Override
    public int getRouteVal(int from, int to) {
        Node node = map.get(from).headNode;
        while (node != null) {
            if (node.to == to) {
                return node.val;
            }
            node = node.next;
        }
        return 0;
    }

    @Override
    public List<Triple<Integer, Integer, Integer>> getAllRoute(int from) {
        List<Triple<Integer, Integer, Integer>> allRoute = new ArrayList<>();
        Head head = map.get(from);
        Node headNode = head.headNode;
        while (headNode != null) {
            Triple<Integer, Integer, Integer> route = Triple.of(from, headNode.to, headNode.val);
            allRoute.add(route);
            headNode = headNode.next;
        }
        return allRoute;
    }

    @Override
    public void print() {
        for (int i = 0; i < map.size(); i++) {
            Node root = map.get(i).headNode;
            Node next = null;
            System.out.print(i);
            do {
                System.out.print("->");
                if (null != root) {
                    int node = root.to;
                    int val = root.val;
                    System.out.printf("(%s,%s)", node, val);
                    next = root.next;
                }
                root = next;
            } while (null != next);
            System.out.print("\n");
        }
    }


    public static void main(String[] args) {
        Graph graph = new AdjacencyList(10);
        graph.addRoute(1, 2, 10);
        graph.print();
    }
}
