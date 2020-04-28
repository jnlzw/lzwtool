package com.jnlzw.lzwtool.Algorithms;

/**
 * Created by lzw on 2019/10/28.
 */
public class KMP {
    /**
     * @param S 文本串
     * @param P 模式串
     * @return 返回第一个匹配的下标的位置，匹配失败返回-1
     */
    public int KMPcompaer(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, j = 0;
        while (i<s_arr.length && j<t_arr.length){
            if(j == -1 || s_arr[i]==t_arr[j]){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if(j == t_arr.length)
            return i-j;
        else
            return -1;
    }

    private int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k=next[j-1];
            while (k!=-1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                }
                else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }



    public static void main(String[] args) {
        KMP kmp=new KMP();
        //模式串长度为1的时候报错
        System.out.println(kmp.KMPcompaer("aaaaaddddd", "cc"));
    }
}
