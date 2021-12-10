package com.jnlzw.lzwtool.solutions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Solution6 {
    public boolean backspaceCompare(String S, String T) {
        S = function(S);
        T = function(T);
        return S.equals(T);
    }

    private String function(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ('#' == c && stringBuilder.length() > 0) stringBuilder.deleteCharAt(stringBuilder.length()-1);
            if ('#' != c) stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
