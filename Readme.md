# LZW工具箱，用Java封装各种数据结构

## 一 线段树
### 1构造器
构造的时候需要传入数组作为参数，不支持无参构造。

    public SegmentTree (int num[]){
        N=num.length-1;
        build(0,num,0,N);
    }

### 2区间查询总和
    /**
     * 
     * @param l 区间左右边界
     * @param r
     * @return 返回区间值之和
     */
    public int sumRange(int l,int r){
        return searchAll(0,0,N,l,r);
    }
    
### 3区间查询最大值
    /**
     * 
     * @param l 区间左右边界
     * @param r
     * @return 返回区间最大值
     */
    public int maxRange(int l,int r){
        return searchMax(0,0,N,l,r);
    }
### 4区间查询最小值
    /**
     * 
     * @param l 区间左右边界
     * @param r
     * @return 返回区间最小值
     */
    public int minRange(int l,int r){
        return searchMin(0,0,N,l,r);
    }
### 5修改单个节点
    /**
     * 
     * @param index 下标
     * @param value  修改值
     */
    public void modifyOneValue(int index,int value){
        updateone(0,0,N-1,index,value);
    }

## 二 并查集
### 1构造器
    public UnionFindSet(int n){
参数为并查集最大支持的节点数。
### 2查询根节点
    /**
     * 查找根节点
     * @param a
     * @return
     */
    public int find(int a){
采用路径压缩可以降低大量重复查找的时间。
### 3合并节点
    /**
     * 合并两个节点
     * @param a
     * @param b
     * @return 成功返回true，若两个根节点本来就在一棵树下返回false
     */
    public boolean union(int a,int b){
合并时首先查看两棵树的规模，规模小的合并到规模大的树上，保证查询操作不会退化为O(n)。











