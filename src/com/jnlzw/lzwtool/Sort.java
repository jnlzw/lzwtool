package com.jnlzw.lzwtool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Sort {

    //插入排序
    public void insertionSort(int[] num) {
        int key;
        for (int i = 1; i < num.length; i++) {
            key = i;
            while (key > 0) {
                if (num[key] < num[key - 1]) {
                    num[key] += num[key - 1];
                    num[key - 1] = num[key] - num[key - 1];
                    num[key] = num[key] - num[key - 1];
                    key--;
                } else break;
            }
        }
    }


    //归并排序
    public void mergeSort(int[] num) {
        perMergeSort(num, 0, num.length - 1);
    }

    private void perMergeSort(int[] num, int s, int e) {
        if (s == e) return;
        int m = (s + e) / 2;
        perMergeSort(num, s, m);
        perMergeSort(num, m + 1, e);
        int[] tempNum = new int[num.length];
        int i = s, j = m + 1, index = 0;
        while (i <= m && j <= e) {
            tempNum[index++] = num[i] < num[j] ? num[i++] : num[j++];
        }
        while (i <= m) tempNum[index++] = num[i++];
        while (j <= e) tempNum[index++] = num[j++];
        System.arraycopy(tempNum, 0, num, s, index);//复制数组
    }


    //堆排序
    public void heapSort(int[] num) {
        int N = num.length;
        int tempN = N;
        buildMaxHeap(num);
        for (int i = N - 1; i > 0; i--) {
            int c = num[i];
            num[i] = num[0];
            num[0] = c;
            N = N - 1;//注意！ 每次将最后一位置为最大位后 maxHeapify时不再考虑
            maxHeapify(num, 0);
        }
        N = tempN;
    }

    private void maxHeapify(int[] num, int index) {
        int N = num.length;
        int largest = index;
        if (index * 2 + 1 < N && num[largest] > num[index * 2 + 1]) {
            largest = index * 2 + 1;
        }
        if (index * 2 + 2 < N && num[largest] > num[index * 2 + 2]) {
            largest = index * 2 + 2;
        }
        if (largest != index) {
            int c = num[index];
            num[index] = num[largest];
            num[largest] = c;
            maxHeapify(num, largest);
        }
    }

    private void buildMaxHeap(int[] num) {
        for (int i = num.length / 2; i >= 0; i--) {
            maxHeapify(num, i);
        }
    }


    //快速排序
    public void quickSort(int[] num) {
        perQuickSort(num, 0, num.length - 1);
    }

    private void perQuickSort(int[] num, int p, int r) {
        if (p < r) {
            int q = partition(num, p, r);
            perQuickSort(num, p, q - 1);
            perQuickSort(num, q + 1, r);
        }
    }

    private int partition(int[] num, int p, int r) {
        int key = num[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (num[j] < key) {
                int c = num[j];
                num[j] = num[i];
                num[i] = c;
                i = i + 1;
            }
        }
        num[r] = num[i];
        num[i] = key;
        return i;
    }

    //计数排序
    //计数排序的count数组长度为10000，num数组内的数字最大值为9999，可以更改。
    public void countSort(int[] num) {
        int N = num.length;
        int[] count = new int[10000];
        for (int i = 0; i < 100; i++) count[i] = 0;
        for (int value : num) count[value]++;
        for (int i = 98; i >= 0; i--) count[i] += count[i + 1];
        int[] tempNum = new int[N];
        for (int value : num) {
            tempNum[count[value] - 1] = value;
            count[value]--;
        }
        System.arraycopy(tempNum, 0, num, 0, N);
        reversalArray(num);
    }


    //翻转数组
    public void reversalArray(int[] num) {
        int l = 0, r = num.length - 1;
        while (l < r) {
            num[l] += num[r];
            num[r] = num[l] - num[r];
            num[l] = num[l] - num[r];
            l++;
            r--;
        }
    }


    //全部默认从小到大排序
    public static void main(String[] args) {
        int[] num = {3, 4, 1, 4, 5, 7, 8, 23, 0};
        Sort sort = new Sort();
        sort.insertionSort(num);
        sort.reversalArray(num);
        for (int e : num) System.out.println(e);

    }
}



