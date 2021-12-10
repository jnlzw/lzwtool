package com.jnlzw.lzwtool.dataStructures;

/**
 * Created by lzw on 2020/4/29
 */

public class BloomFilter {
    private byte[] flag;
    private int size;
    private int perSize; //预计大小
    private double fpp;  //失误率
    private int hushNum;

    public BloomFilter(int perSize,double fpp){
        this.perSize=perSize;
        this.fpp=fpp;
        this.size=-1*(int)Math.round((perSize*Math.log10(fpp))/Math.pow(Math.log10(2),2));
        System.out.println("size = " + size);
        this.flag=new byte[this.size];
        this.hushNum=(int)Math.round(0.7*size/perSize);
        System.out.println("hushNum = " + hushNum);
    }

    private int[] getIndex(String str){
        int[] reIndex=new int[hushNum];
        for (int i=0;i<hushNum;i++){
            reIndex[i]=((""+i+str).hashCode())%size;
        }
        return reIndex;
    }

    public void put(String str){
        int[] indexs=getIndex(str);
        for (int index:indexs){
            flag[index]=1;
        }
    }



    public static void main(String[] args) {
        BloomFilter bloomFilter=new BloomFilter(10000,0.1);
        bloomFilter.put("aaa");

    }
}
