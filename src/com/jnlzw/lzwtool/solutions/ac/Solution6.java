package com.jnlzw.lzwtool.solutions.ac;

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
