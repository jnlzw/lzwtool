package com.jnlzw.lzwtool;

/**
 * Created by lzw on 2019/9/25.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        SegmentTree segmentTree = new SegmentTree(nums);
        System.out.println(segmentTree.maxRange(0,5));
        segmentTree.modifyOneValue(0,100);
        System.out.println(segmentTree.maxRange(0,5));

        UnionFindSet unionFindSet=new UnionFindSet(100);
        unionFindSet.union(1,2);
        System.out.println(unionFindSet.find(1)+" "+unionFindSet.find(2));

    }
}
