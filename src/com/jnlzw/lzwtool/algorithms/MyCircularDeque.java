package com.jnlzw.lzwtool.algorithms;

class MyCircularDeque {
    int[] nums;
    int s = 0;
    int e = 1;
    int SIZE = 0;
    int MAXSIZE;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.nums = new int[k];
        this.MAXSIZE = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (SIZE + 1 > MAXSIZE) return false;
        nums[s] = value;
        s = (s - 1 + MAXSIZE) % MAXSIZE;
        SIZE += 1;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (SIZE + 1 > MAXSIZE) return false;
        nums[e] = value;
        e = (e + 1 + MAXSIZE) % MAXSIZE;
        SIZE += 1;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (SIZE <= 0) return false;
        s = (s + 1 + MAXSIZE) % MAXSIZE;
        SIZE -= 1;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (SIZE <= 0) return false;
        e = (e - 1 + MAXSIZE) % MAXSIZE;
        SIZE -= 1;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (SIZE<=0)return -1;
        return nums[(s + 1 + MAXSIZE) % MAXSIZE];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (SIZE<=0)return -1;
        return nums[(e - 1 + MAXSIZE) % MAXSIZE];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return SIZE == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return SIZE == MAXSIZE;
    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(10);
        boolean param_1 = obj.insertFront(1);
        boolean param_2 = obj.insertLast(1);
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();

    }
}
