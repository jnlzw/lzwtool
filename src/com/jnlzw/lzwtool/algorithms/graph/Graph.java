package com.jnlzw.lzwtool.algorithms.graph;

import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public interface Graph {

    /**
     * 添加边
     *
     * @param from 起始节点
     * @param to   目标节点
     * @param val  边值
     */
    void addRoute(int from, int to, int val);


    /**
     * 获取边值
     *
     * @param from 起始节点
     * @param to   目标节点
     * @return 边值
     */
    int getRouteVal(int from, int to);


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
