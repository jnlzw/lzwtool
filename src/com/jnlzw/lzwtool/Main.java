package com.jnlzw.lzwtool;

/**
 * Created by lzw on 2019/9/25.
 */
public class Main {
    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree();
        int[] nums={1,2,3,4,5,6};
        segmentTree.build(0,nums,0,5);
        System.out.println(segmentTree.searchMin(0,0,5,0,5));
   }
}
