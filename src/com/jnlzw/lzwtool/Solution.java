package com.jnlzw.lzwtool;

import com.sun.javafx.image.impl.IntArgb;

import java.util.*;

/**
 * Created by lzw on 2020/4/18.
 */

class Solution {
    public String reformat(String s) {
        StringBuilder ans= new StringBuilder();
        Queue<Character> num=new ArrayDeque<>();
        Queue<Character>str=new ArrayDeque<>();
        for (int i=0,j=s.length();i<j;i++){
            Character t=s.charAt(i);
            if (t<='z'&&t>='a')str.add(t);
            else num.add(t);
        }
        if (Math.abs(num.size()-str.size())>1)return "";
        if (num.size()>str.size()){
            while (!num.isEmpty()||!str.isEmpty()){
                if (!num.isEmpty()) ans.append(num.poll());
                if (!str.isEmpty()) ans.append(str.poll());
            }
        }else {
            while (!num.isEmpty()||!str.isEmpty()){
                if (!str.isEmpty()) ans.append(str.poll());
                if (!num.isEmpty()) ans.append(num.poll());
            }
        }
        return ans.toString();
    }
}
