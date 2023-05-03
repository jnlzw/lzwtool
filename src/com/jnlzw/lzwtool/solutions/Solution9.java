package com.jnlzw.lzwtool.solutions;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class Pair {
    int key;
    int value;
    Pair next;

    public Pair(int key, int value){
        this.key=key;
        this.value=value;
    }
}


public class Solution9 {
    static Comparator<Pair> cmp = (e1, e2) -> e1.key-e2.key;

    public static void main(String[] args) {
        PriorityQueue<Pair> priorityQueue=new PriorityQueue<>(cmp);
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int[] n=new int[T];

        for (int i=0;i<T;i++){
            n[i]=sc.nextInt();
        }
        for (int i=0;i<T;i++){
            Pair temp=null;
            for (int j=0;j<n[i];j++){
                String next = sc.next();
                Pair pair=new Pair(Integer.parseInt(next.split(":")[0]),Integer.parseInt(next.split(":")[1]));
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
        Pair temp=priorityQueue.poll();
        if (temp.next!=null)priorityQueue.add(temp.next);
        while (!priorityQueue.isEmpty()){
            Pair temp2=priorityQueue.poll();
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
