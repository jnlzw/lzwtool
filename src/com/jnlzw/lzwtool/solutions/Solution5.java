package com.jnlzw.lzwtool.solutions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution5 {
    public String compressString(String S) {
        if (Objects.isNull(S))return null;
        List<Character> characterList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        char flag = '*';
        int len = 0;
        for (int i = 0; i < S.length(); i++) {
            if (flag != S.charAt(i)) {
                characterList.add(S.charAt(i));
                integerList.add(len);
                flag = S.charAt(i);
                len = 1;
            } else {
                len += 1;
            }
        }
        integerList.add(len);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < characterList.size(); i++) {
            ans.append(characterList.get(i));
            ans.append(integerList.get(i+1));
        }
        System.out.println("S.length() = " + S.length());
        System.out.println("ans.toString().length() = " + ans.toString().length());
        if (ans.toString().length()>=S.length())return S;
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.compressString("abababaab"));
    }
}
