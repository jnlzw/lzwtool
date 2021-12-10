package com.jnlzw.lzwtool.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lzw on 2020/5/30
 */
public class LZW {
    public List<Integer> encode(String data) {
        List<Integer> result = new ArrayList<Integer>();
        int maxNum = 256; //记录字典最大值
        HashMap<String, Integer> dic = new HashMap<String, Integer>();
        // 初始化字段 将字符0-255都加入字典中。
        for (int i = 0; i < 256; i++) dic.put((char) i + "", i);
        String P = ""; String C = "";
        for (char c : data.toCharArray()) {
            C = P + c;
            if (dic.containsKey(C)) P  = C;
             else {
                dic.put(C, maxNum++);
                result.add(dic.get(P ));
                P = "" + c;
            }
        }
        if (!P.equals("")) result.add(dic.get(P));
        return result;
    }

    public String decode(List<Integer> array) {
        StringBuilder result = new StringBuilder();
        int maxNum = 256; //记录字典最大值
        HashMap<Integer, String> dic = new HashMap<Integer, String>();
        for (int i = 0; i < 256; i++) dic.put(i, (char) i + "");
        String P = "";String C = "";
        for (int code : array) {
            if (dic.containsKey(code)) C = dic.get(code);
            else if (code == maxNum) C= C + C.charAt(0);
            else System.out.println("输入错误！");
            if (!P.equals("")) dic.put(maxNum++, P + C.charAt(0));
            result.append(C);
            P = C;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LZW lzw = new LZW();
        String str="*&()ABUHOJLKACCACCACCACCACACCaccbe";
        System.out.println("字符串："+str);
        System.out.println("编码结果");
        System.out.println(lzw.encode(str));
        System.out.println("解码结果");
        System.out.println(lzw.decode(lzw.encode(str)));
    }
}
