package com.jnlzw.lzwtool;

/**
 * Created by lzw on 2019/9/25.
 */
//    线段树的树节点


//线段树类
public class SegmentTree {

    private class Tree {
        int v;
        int min;
        int max;
        int lazy;
    }

    //修改某个值；修改区间内值
    //给区间内同时增加或减少某个值
    public Tree[] Tree=new Tree[1000];

    /**
     *
     * @param root 根节点标号 为0
     * @param num  建立线段树的参数
     * @param start  num数组的开始下标
     * @param end  num数组的结束下标
     */
    public void build(int root, int num[], int start, int end) {
        if (start == end){
            Tree[root]=new Tree();
            Tree[root].v = num[start];//叶子节点
            Tree[root].max = num[start];//叶子节点
            Tree[root].min = num[start];//叶子节点
            //System.out.println(Tree[root].v);
        }
        else {
            int mid = (start + end) / 2;
            build(root * 2 + 1, num, start, mid);
            build(root * 2 + 2, num, mid + 1, end);
            Tree[root]=new Tree();
            Tree[root].v = Tree[root * 2 + 1].v + Tree[root * 2 + 2].v;
            Tree[root].max = Math.max(Tree[root * 2 + 1].max , Tree[root * 2 + 2].max);
            Tree[root].min = Math.min(Tree[root * 2 + 1].min , Tree[root * 2 + 2].min);
            //System.out.println(Tree[root].max);
        }
    }


    /**
     *
     * @param root 根节点
     * @param astart  当前节点覆盖的区间
     * @param aend
     * @param bstart  要查找的区间
     * @param bend
     * @return  查找区间内的和
     */
    public int searchAll(int root, int astart, int aend, int bstart, int bend) {    //a为当前节点说表示的区间，b为要查找的区间
        if (astart > bend || aend < bstart)return 0;     //区间无交集
        if (astart >= bstart&&aend <= bend)return Tree[root].v;  //当前区间被目标区间包含
        int mid = (astart + aend) / 2;
        return searchAll(root * 2 + 1, astart, mid, bstart, bend) + searchAll(root * 2 + 2, mid + 1, aend, bstart, bend);
    }


    /**
     * @return  区间最大值
     */
    public int searchMax(int root, int astart, int aend, int bstart, int bend) {    //a为当前节点说表示的区间，b为要查找的区间
        if (astart > bend || aend < bstart)return 0;     //区间无交集
        if (astart >= bstart&&aend <= bend)return Tree[root].max;  //当前区间被目标区间包含
        int mid = (astart + aend) / 2;
        return Math.max(searchMax(root * 2 + 1, astart, mid, bstart, bend) , searchMax(root * 2 + 2, mid + 1, aend, bstart, bend));
    }

    /**
     * @return 区间最小值
     */
    public int searchMin(int root, int astart, int aend, int bstart, int bend) {    //a为当前节点说表示的区间，b为要查找的区间
        if (astart > bend || aend < bstart)return 0;     //区间无交集
        if (astart >= bstart&&aend <= bend)return Tree[root].max;  //当前区间被目标区间包含
        int mid = (astart + aend) / 2;
        return Math.min(searchMin(root * 2 + 1, astart, mid, bstart, bend) , searchMin(root * 2 + 2, mid + 1, aend, bstart, bend));
    }
}
