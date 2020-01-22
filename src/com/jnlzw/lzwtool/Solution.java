package com.jnlzw.lzwtool;

import java.lang.reflect.Array;
import java.util.*;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by lzw on 2019/12/1.
 */
class Solution {

    private static int judge(String a,String b){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))count++;
        }
        if(count==1)return 1;
        else return 0;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String>list= Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<String>wordList=new ArrayList<>(list);
        int[][] mapp=new int[100][100];
        wordList.add(beginWord);
        if (!wordList.contains(endWord)){
            System.out.println("endWord不在字典中");
            return;
        }
        //构造mapp数组
        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                mapp[i][j]=mapp[j][i]=judge(wordList.get(i),wordList.get(j));
            }
        }
        int s=wordList.size()-1,e=wordList.indexOf(endWord);//设置起点和终点
        int minSize=1000;
        List<List<Integer>> Q = new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        temp.add(s);Q.add(temp);//加入起点
        //开始广搜
        while (!Q.isEmpty()){
            temp=Q.remove(0);
            if(temp.get(temp.size()-1)==e&&temp.size()<=minSize){
                //到达终点 且路径最短
                minSize=temp.size();
                for(int i=0;i<minSize;i++)System.out.printf("%s ",wordList.get(temp.get(i)));
                System.out.println();
            }
            int now=temp.get(temp.size()-1);
            for(int i=0;i<mapp.length;i++){
                if(mapp[now][i]==1&&!temp.contains(i)){
                    List<Integer>tTemp=new ArrayList<>(temp);
                    tTemp.add(i);
                    Q.add(tTemp);
                }
            }
        }
    }
}
