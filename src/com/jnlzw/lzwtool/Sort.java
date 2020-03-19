package com.jnlzw.lzwtool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Sort {

    public <T> void insertionSort(T[] num, Comparator<? super T> c) {
        int key;
        for (int i = 1; i < num.length; i++) {
            key = i;
            while (key > 0) {
                if (c.compare(num[key], num[key - 1]) < 0) {
                    T t = num[key];
                    num[key] = num[key - 1];
                    num[key - 1] = t;
                    key--;
                } else break;
            }
        }
    }


    //归并排序
    public <T> void mergeSort(T[] num, Comparator<? super T> c) {
        perMergeSort(num, 0, num.length - 1, c);
    }

    private <T> void perMergeSort(T[] num, int s, int e, Comparator<? super T> c) {
        if (s == e) return;
        int m = (s + e) / 2;
        perMergeSort(num, s, m, c);
        perMergeSort(num, m + 1, e, c);
        T[] tempNum = (T[]) new Object[num.length];
        int i = s, j = m + 1, index = 0;
        while (i <= m && j <= e) {
            tempNum[index++] = c.compare(num[i] ,num[j])<0 ? num[i++] : num[j++];
        }
        while (i <= m) tempNum[index++] = num[i++];
        while (j <= e) tempNum[index++] = num[j++];
        System.arraycopy(tempNum, 0, num, s, index);//复制数组
    }


    //堆排序
    public <T> void heapSort(T[] num,Comparator<? super T> c) {
        int N = num.length;
        int tempN = N;
        buildMaxHeap(num,c);
        for (int i = N - 1; i > 0; i--) {
            T t = num[i];
            num[i] = num[0];
            num[0] = t;
            N = N - 1;//注意！ 每次将最后一位置为最大位后 maxHeapify时不再考虑
            maxHeapify(num, 0,c);
        }
        N = tempN;
    }

    private <T> void maxHeapify(T[] num, int index,Comparator<? super T> c) {
        int N = num.length;
        int largest = index;
        if (index * 2 + 1 < N && c.compare(num[largest] , num[index * 2 + 1])>0) {
            largest = index * 2 + 1;
        }
        if (index * 2 + 2 < N && c.compare(num[largest] , num[index * 2 + 1])>0) {
            largest = index * 2 + 2;
        }
        if (largest != index) {
            T t = num[index];
            num[index] = num[largest];
            num[largest] = t;
            maxHeapify(num, largest,c);
        }
    }

    private <T> void buildMaxHeap(T[] num,Comparator<? super T> c) {
        for (int i = num.length / 2; i >= 0; i--) {
            maxHeapify(num, i,c);
        }
    }


    //快速排序
    public <T> void quickSort(T[] num,Comparator<? super T> c) {
        perQuickSort(num, 0, num.length - 1,c);
    }

    private <T> void perQuickSort(T[] num, int p, int r,Comparator<? super T> c) {
        if (p < r) {
            int q = partition(num, p, r,c);
            perQuickSort(num, p, q - 1,c);
            perQuickSort(num, q + 1, r,c);
        }
    }

    private <T> int partition(T[] num, int p, int r,Comparator<? super T> c) {
        T key = num[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (c.compare(num[j] , key)<0) {
                T t = num[j];
                num[j] = num[i];
                num[i] = t;
                i = i + 1;
            }
        }
        num[r] = num[i];
        num[i] = key;
        return i;
    }


    //计数排序
    //计数排序的count数组长度为10000，num数组内的数字最大值为9999，可以更改。
    public void countSort(Integer[] num) {
        int N = num.length;
        int[] count = new int[10000];
        for (int i = 0; i < 100; i++) count[i] = 0;
        for (int value : num) count[value]++;
        for (int i = 98; i >= 0; i--) count[i] += count[i + 1];
        Integer[] tempNum = new Integer[N];
        for (int value : num) {
            tempNum[count[value] - 1] = value;
            count[value]--;
        }
        System.arraycopy(tempNum, 0, num, 0, N);
        Sort sort=new Sort();
        reversalArray(num);
    }


    //翻转数组
    public <T> void reversalArray(T[] num) {
        int l = 0, r = num.length - 1;
        while (l < r) {
            T t=num[l];
            num[l]=num[r];
            num[r]=t;
            l++;
            r--;
        }
    }

}



