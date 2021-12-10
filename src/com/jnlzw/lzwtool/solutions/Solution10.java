package com.jnlzw.lzwtool.solutions;
import java.util.Deque;
import java.util.LinkedList;

/**
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */

class Solution10 {

    public String stringX(String str, int n) {
        StringBuilder strBuilder = new StringBuilder();
        while (n-- > 0) strBuilder.append(str);
        str = strBuilder.toString();
        return str;
    }

    public String decodeString(String s) {
        System.out.println("s.length() = " + s.length());
        StringBuilder ans = new StringBuilder();
        Deque<String> str = new LinkedList<>();
        for (int i = 0, j = s.length(); i < j; i++) {
            if (s.charAt(i)!=']')str.addLast(""+s.charAt(i));
            else { //遇到]
                System.out.println("i = " + i);
                //先回收字符串
                StringBuilder tempStr= new StringBuilder();
                while (!str.peekLast().equals("[")) tempStr.insert(0,str.pollLast());
                str.pollLast();
                //再回收数字
                System.out.println(str.peekLast());
                StringBuilder tempNum= new StringBuilder();
                while (str.size()>0&&str.peekLast().compareTo("9")<=0&&str.peekLast().compareTo("0")>=0)tempNum.insert(0,str.pollLast());
                str.addLast(stringX(tempStr.toString(),Integer.parseInt(tempNum.toString())));
            }
        }
        while (str.size()>0) ans.append(str.pollFirst());
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution10 solution10 =new Solution10();
        System.out.println(solution10.decodeString("3[a]2[b4[F]c]"
        ));
    }
}