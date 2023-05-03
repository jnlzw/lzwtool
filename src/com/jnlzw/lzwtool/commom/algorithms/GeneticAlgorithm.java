package com.jnlzw.lzwtool.commom.algorithms;

import java.lang.Math;
import java.util.Random;

/**
 * Created by lzw on 2020/7/5
 * 基因遗传算法
 */


public class GeneticAlgorithm {
     /*
    确立决策变量以及约束条件
    f(x)=x*sin(10*PI*x)+2  [-1,2]
    确定编码方式  22位2进制
    解码函数 decoding()
    适应度函数  函数没有负值 直接使用f返回值作为适应度函数
    选择函数—比例选择函数 selection()
    杂交函数—recombination()
    变异函数—mutation()
     */

    //参数确定
    private static double Pr = 0.50;//杂交概率
    private static double Pm = 0.02;//变异概率
    private static int N = 50;//群体大小
    private static int Ger = 100;//终止代数
    private static long[] gene = new long[N];

    private static double decoding(long coding) {
        return -1.0 + 3.0 * ((coding * 1.0) / (Math.pow(2.0, 22.0) - 1));
    }

    //函数
    private static double function(double x) {
        return x * Math.sin(10 * Math.PI * x) + 2;
    }

    private static void selection() { //选择函数
        double[] selectTemp = new double[N];
        long[] newgene = new long[N];
        for (int i = 0; i < N; i++) selectTemp[i] = function(decoding(gene[i]));
        double maxNum = selectTemp[0];
        for (int i = 1; i < N; i++) {
            selectTemp[i] += selectTemp[i - 1];
            maxNum = Math.max(maxNum, selectTemp[i]);
        }
        //for(int i=0;i<N;i++){System.out.println(selectTemp[i]);}
        for (int i = 0; i < N; i++) {
            Random r = new Random();
            double returnR = r.nextDouble() * maxNum;
            int index;
            for (index = 0; index < N; index++) if (selectTemp[index] > returnR) break;
            newgene[i] = gene[index];
            //System.out.println(decoding(newgene[i]));
        }
        gene = newgene;
    }

    private static void recombination() {  //杂交函数  中间重组
        /*
        StringBuilder[] str=new StringBuilder[N];
        for(int i=0;i<N;i++){
            str[i]=new  StringBuilder(Long.toBinaryString(gene[i]));
            System.out.println(str[i]);
        }
        */
        long[] tempgene = new long[N];
        for (int i = 0; i < N; i++) {
            Random r = new Random();
            if (r.nextDouble() < Pr / 2) {
                int tempIndex = r.nextInt(N);
                tempgene[i] = (long) Math.floor(Math.min(gene[i], gene[tempIndex]) + r.nextDouble() * Math.abs(gene[i] - gene[tempIndex]) * 0.2);
                tempgene[tempIndex] = (long) Math.floor(Math.max(gene[i], gene[tempIndex]) - r.nextDouble() * Math.abs(gene[i] - gene[tempIndex]) * 0.2);
            } else tempgene[i] = gene[i];
        }
        gene = tempgene;
    }

    private static void mutation() { //变异函数 随机加减一个小步长
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            if (r.nextDouble() < Pm) {
                long step = (long) Math.floor(r.nextDouble() * Math.pow(2, 22) * 0.05);
                if (r.nextInt(2) == 1) {
                    gene[i] += step;
                    gene[i] = Math.min(2, gene[i]);
                } else {
                    gene[i] -= step;
                    gene[i] = Math.max(-1, gene[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        double max = -1;
        for (int n = 0; n < 100; n++) {
            //初始化gene数组
            for (int i = 0; i < N; i++) {
                Random r = new Random();
                gene[i] = (long) Math.floor(r.nextDouble() * Math.pow(2.0, 22.0));
                //System.out.println(decoding(gene[i]));
            }

            double sum = 0;
            double maxGene = -10;

            for (int k = 0; k < Ger; k++) {
                selection();
                recombination();
                mutation();

                for (int m = 0; m < N; m++) {
                    sum += function(decoding(gene[m]));
                    maxGene = Math.max(maxGene, function(decoding(gene[m])));
                }
                // System.out.printf("平均值%f  最大值%f\n", sum / N, maxGene);
            }

            max = Math.max(max, maxGene);
        }

        System.out.println("max = " + max);


    }
}

