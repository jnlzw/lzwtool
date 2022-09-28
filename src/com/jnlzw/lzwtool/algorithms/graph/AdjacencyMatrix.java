package com.jnlzw.lzwtool.algorithms.graph;

import javafx.util.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix implements Graph {

    private int size;
    private int[][] map;

    public AdjacencyMatrix(int n) {
        if (n == 0) {
            n = 100;
        }
        this.map = new int[n][n];
        this.size = n;
    }

    @Override
    public void addRoute(int from, int to, int val) {
        map[from][to] = map[from][to] + val;
    }

    @Override
    public int getRouteVal(int from, int to) {
        return map[from][to];
    }

    @Override
    public List<Triple<Integer, Integer, Integer>> getAllRoute(int from) {
        List<Triple<Integer, Integer, Integer>> allRoute = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (map[from][i] != 0) {
                Triple<Integer, Integer, Integer> route =  Triple.of(from, i, map[from][i]);
                allRoute.add(route);
            }
        }
        return allRoute;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%3d ", map[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Graph graph = new AdjacencyMatrix(10);
        graph.addRoute(1, 2, 10);
        graph.print();
    }

}
