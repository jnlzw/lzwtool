package com.jnlzw.lzwtool;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONObjectIter;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by lzw on 2020/5/1
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        next = "{\"a\":\"1\",\"B\":2,\"C\":{\"D\":\"3\"}}";

        JSONObject jsonObject = new JSONObject(next);
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();

    }
}
