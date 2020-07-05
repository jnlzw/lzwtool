package com.jnlzw.lzwtool.demo;

import java.util.LinkedHashMap;

/**
 * Created by lzw on 2020/5/18
 */
public class Test {
    //测试
    public static void main(String[] args) throws Exception {
        Long time = System.currentTimeMillis();
        LargeExcelFileReadUtil<Integer> example = new LargeExcelFileReadUtil<>();
        example.processOneSheet("C:\\Code\\lzw-tool\\src\\com\\jnlzw\\lzwtool\\demo\\poi.xlsx");
        Long endtime = System.currentTimeMillis();
        AvlTree<Integer> avlTree=example.getAvlTree();
        LinkedHashMap<String,String> map=example.getRowContents();
        System.out.println(map.size());
        System.out.println("解析数据耗时" + (endtime - time) + "毫秒");

        time = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) avlTree.contains(111, 222);
        endtime = System.currentTimeMillis();
        System.out.println("查询耗时" + (endtime - time) + "毫秒");

        time = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) avlTree.contains(111);
        endtime = System.currentTimeMillis();
        System.out.println("查询耗时" + (endtime - time) + "毫秒");

        System.out.println("map.size() = " + map.size());
        //avlTree.printTree();
        System.out.println("avlTree.printHeight() = " + avlTree.printHeight());
    }
}
