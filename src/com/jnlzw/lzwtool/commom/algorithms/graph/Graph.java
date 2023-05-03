package com.jnlzw.lzwtool.commom.algorithms.graph;

import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public interface Graph {

    /**
     * 添加边
     *
     * @param from 起始节点
     * @param to   目标节点
     * @param cap  容量
     */
    void addRoute(int from, int to, int cap);

    void addRoute(int from, int to, int cap, int cost);


    /**
     * 获取某条边容量
     *
     * @param from 起始节点
     * @param to   目标节点
     * @return 边值
     */
    int getRouteCap(int from, int to);


    /**
     * 查询节点所有边
     *
     * @param from 起始节点
     * @return 边
     */
    List<Triple<Integer, Integer, Integer>> getAllRoute(int from);


    /**
     * 打印图
     */
    void print();

}
