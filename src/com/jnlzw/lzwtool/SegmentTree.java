package com.jnlzw.lzwtool;

/**
 * Created by lzw on 2019/9/25.
 */


//线段树类
public class SegmentTree {

    private class Tree {
        int v;
        int min;
        int max;
        int lazy;
    }

    private int N;
    //修改某个值；修改区间内值
    //给区间内同时增加或减少某个值
    private Tree[] Tree = new Tree[1000];


    public SegmentTree(int num[]) {
        N = num.length - 1;
        build(0, num, 0, N);
    }

    /**
     * @param root  根节点标号 为0
     * @param num   建立线段树的参数
     * @param start num数组的开始下标
     * @param end   num数组的结束下标
     */
    private void build(int root, int num[], int start, int end) {
        if (start == end) {
            Tree[root] = new Tree();
            Tree[root].v = num[start];//叶子节点
            Tree[root].max = num[start];//叶子节点
            Tree[root].min = num[start];//叶子节点
            //System.out.println(Tree[root].v);
        } else {
            int mid = (start + end) / 2;
            build(root * 2 + 1, num, start, mid);
            build(root * 2 + 2, num, mid + 1, end);
            Tree[root] = new Tree();
            Tree[root].v = Tree[root * 2 + 1].v + Tree[root * 2 + 2].v;
            Tree[root].max = Math.max(Tree[root * 2 + 1].max, Tree[root * 2 + 2].max);
            Tree[root].min = Math.min(Tree[root * 2 + 1].min, Tree[root * 2 + 2].min);
            //System.out.println(Tree[root].max);
        }
    }


    /**
     * @param l 区间左右边界
     * @param r
     * @return 返回区间值之和
     */
    public int sumRange(int l, int r) {
        return searchAll(0, 0, N, l, r);
    }

    private int searchAll(int root, int astart, int aend, int bstart, int bend) {    //a为当前节点说表示的区间，b为要查找的区间
        if (astart > bend || aend < bstart) return 0;     //区间无交集
        if (astart >= bstart && aend <= bend) return Tree[root].v;  //当前区间被目标区间包含
        int mid = (astart + aend) / 2;
        return searchAll(root * 2 + 1, astart, mid, bstart, bend) + searchAll(root * 2 + 2, mid + 1, aend, bstart, bend);
    }


    /**
     * @param l 区间左右边界
     * @param r
     * @return 返回区间最大值
     */
    public int maxRange(int l, int r) {
        return searchMax(0, 0, N, l, r);
    }

    private int searchMax(int root, int astart, int aend, int bstart, int bend) {    //a为当前节点说表示的区间，b为要查找的区间
        if (astart > bend || aend < bstart) return 0;     //区间无交集
        if (astart >= bstart && aend <= bend) return Tree[root].max;  //当前区间被目标区间包含
        int mid = (astart + aend) / 2;
        return Math.max(searchMax(root * 2 + 1, astart, mid, bstart, bend), searchMax(root * 2 + 2, mid + 1, aend, bstart, bend));
    }

    /**
     * @param l 区间左右边界
     * @param r
     * @return 返回区间最小值
     */
    public int minRange(int l, int r) {
        return searchMin(0, 0, N, l, r);
    }

    private int searchMin(int root, int astart, int aend, int bstart, int bend) {    //a为当前节点说表示的区间，b为要查找的区间
        if (astart > bend || aend < bstart) return 0;     //区间无交集
        if (astart >= bstart && aend <= bend) return Tree[root].min;  //当前区间被目标区间包含
        int mid = (astart + aend) / 2;
        return Math.min(searchMin(root * 2 + 1, astart, mid, bstart, bend), searchMin(root * 2 + 2, mid + 1, aend, bstart, bend));
    }


    /**
     * @param index 下标
     * @param value 修改值
     */
    public void modifyOneValue(int index, int value) {
        updateone(0, 0, N - 1, index, value);
    }

    private void updateone(int root, int start, int end, int index, int value) {
        if (start == end) {
            if (start == index) {
                Tree[root].v = value;
                Tree[root].max = value;
                Tree[root].min = value;
            }
            return;
        }//找到对应的节点
        int mid = (start + end) / 2;
        if (index <= mid) updateone(root * 2 + 1, start, mid, index, value);
        else updateone(root * 2 + 2, mid + 1, end, index, value);
        Tree[root].v = Tree[root * 2 + 1].v + Tree[root * 2 + 2].v;//回溯更新
        Tree[root].max = Math.max(Tree[root * 2 + 1].max, Tree[root * 2 + 2].max);
        Tree[root].min = Math.min(Tree[root * 2 + 1].min, Tree[root * 2 + 2].min);
    }


}
