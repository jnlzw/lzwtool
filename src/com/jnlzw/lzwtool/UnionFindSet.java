package com.jnlzw.lzwtool;

/**
 * Created by lzw on 2019/10/20.
 */
// 并查集
public class UnionFindSet {
    private int[] parent;
    private int[] weight;


    public UnionFindSet(int n) {
        this.parent = new int[n + 1];
        this.weight = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            weight[i] = 0;
        }
    }


    /**
     * 查找根节点
     *
     * @param a
     * @return
     */
    public int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]); //路径压缩
    }


    /**
     * 合并两个节点
     *
     * @param a
     * @param b
     * @return 成功返回true，若两个根节点本来就在一棵树下返回false
     */
    public boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        if (weight[a] < weight[b]) parent[a] = b;
        if (weight[a] > weight[b]) parent[b] = a;
        parent[a] = b;
        weight[b] += 1;
        return true;
    }
}
