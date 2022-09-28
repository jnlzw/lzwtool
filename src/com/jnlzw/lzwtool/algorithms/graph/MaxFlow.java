package com.jnlzw.lzwtool.algorithms.graph;

import javafx.util.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class MaxFlow {

    public static int calc(Graph graph, int from, int to) {

        ArrayList<Triple<Integer, Integer, Integer>> path = new ArrayList<>();
        int maxFlow = 0;

        do {
            path.clear();

            // 搜索路径
            int maxVal = DFS(graph, from, to, path, new HashSet<>(), 1 << 30);
//            System.out.println("maxVal = " + maxVal);
//            System.out.println("path = " + path);

            maxFlow += maxVal;

            // 重置图
            for (Triple<Integer, Integer, Integer> route : path) {
                Integer left = route.getLeft();
                Integer right = route.getMiddle();
                graph.addRoute(left, right, -1 * maxVal);
                graph.addRoute(right, left, maxVal);
            }
        } while (!CollectionUtils.isEmpty(path));

        System.out.println("maxFlow = " + maxFlow);

        return maxFlow;
    }

    // 带路径的深度优先搜索
    private static int DFS(Graph graph, int now, int to, List<Triple<Integer, Integer, Integer>> path, Set<Integer> flag, int maxVal) {
        if (now == to) {
            return maxVal;
        }

        // 查询所有可行路径
        List<Triple<Integer, Integer, Integer>> allRoute = graph.getAllRoute(now);

        for (Triple<Integer, Integer, Integer> route : allRoute) {
            // 节点已经走过，直接跳过
            if (flag.contains(route.getMiddle())) {
                continue;
            }
            flag.add(route.getMiddle());
            path.add(route);
            // 递归调用
            int val = DFS(graph, route.getMiddle(), to, path, flag, Math.min(maxVal, route.getRight()));
            if (val != 0) {
                return val;
            }
            path.remove(route);
            flag.remove(route.getMiddle());
        }

        return 0;
    }

    private int BFS(Graph graph, int now, int to) {


        return 0;
    }


    // 测试方法
    public static void main(String[] args) {
        Graph graph = new AdjacencyList(10);
        graph.addRoute(1, 2, 10);
        graph.addRoute(2, 3, 10);
        graph.addRoute(2, 4, 5);
        graph.addRoute(4, 5, 10);
        graph.addRoute(3, 5, 2);
        MaxFlow.calc(graph, 1, 5);
    }


}
