package com.jnlzw.lzwtool.Solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class pair  {
    int key;
    int value;
    pair next;

    public pair(int key,int value){
        this.key=key;
        this.value=value;
    }
}


public class Solution9 {
    static Comparator<pair> cmp = (e1, e2) -> e1.key-e2.key;

    public static void main(String[] args) {
        PriorityQueue<pair> priorityQueue=new PriorityQueue<>(cmp);
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int[] n=new int[T];

        for (int i=0;i<T;i++){
            n[i]=sc.nextInt();
        }
        for (int i=0;i<T;i++){
            pair temp=null;
            for (int j=0;j<n[i];j++){
                String next = sc.next();
                pair pair=new pair(Integer.parseInt(next.split(":")[0]),Integer.parseInt(next.split(":")[1]));
                if (j==0){
                    temp=pair;
                    priorityQueue.add(pair);
                }else {
                    temp.next=pair;
                    temp=pair;
                }
            }
        }
        if (priorityQueue.isEmpty()) return;
        pair temp=priorityQueue.poll();
        if (temp.next!=null)priorityQueue.add(temp.next);
        while (!priorityQueue.isEmpty()){
            pair temp2=priorityQueue.poll();
            //System.out.printf("%d:%d ",temp2.key,temp2.value);
            if (temp.key==temp2.key){
                temp.value=temp.value+temp2.value;
            }else {
                System.out.printf("%d:%d ",temp.key,temp.value);
                temp=temp2;
            }
            if (temp2.next!= null)priorityQueue.add(temp2.next);
        }
        System.out.printf("%d:%d ",temp.key,temp.value);
    }
}
