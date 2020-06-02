package com.jnlzw.lzwtool.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  排序二叉树
 *  t.insert();插入数据
 *   t.printHeight();输出二叉树高度
 *   t.printTree();输出二叉树
 *   t.contains();查询 支持准确查询和范围查询 输出List<int> key-行号列表
 *   t.isEmpty();判断是否为空
 *  
 */
public class AvlTree<T extends Comparable<? super T>> {

    private class AvlNode<T> {//avl树节点

        T element;      // 节点中的数据
        List<Integer> key;       //数据行号
        AvlNode<T> left;         // 左儿子
        AvlNode<T> right;        // 右儿子
        int height;       // 节点的高度

        AvlNode(T theElement) {
            this(theElement, null, null);
        }

        AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }

        AvlNode(T theElement, int theKey, AvlNode<T> lt, AvlNode<T> rt) {
            element = theElement;
            key = new ArrayList<>();
            key.add(theKey);
            left = lt;
            right = rt;
            height = 0;
        }
    }

    private AvlNode<T> root;//avl树根

    public AvlTree() {
        root = null;
    }


    //准确查询 返回行号
    public List<Integer> contains(T x) {
        return contains(x, root);
    }

    private List<Integer> contains(T x, AvlNode t) {
        while (t != null) {
            int compareResult = x.compareTo((T) t.element);
            if (compareResult < 0)
                t = t.left;
            else if (compareResult > 0)
                t = t.right;
            else
                return t.key;    // Match
        }
        return null;   // No match
    }


    //范围查询
    public List<Integer> contains(T l, T r) {
        List<Integer> ansList = new ArrayList<>();
        contains(l, r, ansList, root);
        return ansList;
    }

    private void contains(T l, T r, List<Integer> list, AvlNode t) {
        if (t == null) return;
        if (l.compareTo((T) t.element) <= 0 && r.compareTo((T) t.element) >= 0) {
            list.addAll(t.key);
            contains(l, r, list, t.left);
            contains(l, r, list, t.right);
        } else if (l.compareTo((T) t.element) > 0) {
            contains(l, r, list, t.right);
        } else {
            contains(l, r, list, t.left);
        }
    }


    public boolean isEmpty() {
        return root == null;
    }


    //排序输出avl树
    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }


    //在avl树中插入数据，重复数据复略
    // x是排序元素 key是行号
    public void insert(T x, int key) {
        root = insert(x, key, root);
    }

    private AvlNode<T> insert(T x, int key, AvlNode<T> t) {
        if (t == null)
            return new AvlNode<T>(x, key, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = insert(x, key, t.left);//将x插入左子树中
            if (height(t.left) - height(t.right) == 2)//打破平衡
                if (x.compareTo(t.left.element) < 0)//LL型（左左型）
                    t = rotateWithLeftChild(t);
                else   //LR型（左右型）
                    t = doubleWithLeftChild(t);
        } else if (compareResult > 0) {
            t.right = insert(x, key, t.right);//将x插入右子树中
            if (height(t.right) - height(t.left) == 2)//打破平衡
                if (x.compareTo(t.right.element) > 0)//RR型（右右型）
                    t = rotateWithRightChild(t);
                else                           //RL型
                    t = doubleWithRightChild(t);
        } else {
            t.key.add(key);
            // 重复数据，什么也不做
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;//更新高度
        return t;
    }


    //中序遍历avl树
    private void printTree(AvlNode<T> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }


    //求高度
    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    public int printHeight(){
        return height(root);
    }


    //带左子树旋转,适用于LL型
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    //带右子树旋转，适用于RR型
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    //双旋转，适用于LR型
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    //双旋转,适用于RL型
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }


    public static void main(String[] args) {

    }
}
