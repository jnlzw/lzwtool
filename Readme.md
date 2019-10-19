# LZW工具箱，用Java封装各种数据结构

## 1 线段树
### （1）构造器
构造的时候需要传入数组作为参数，不支持无参构造。

    public SegmentTree (int num[]){
        N=num.length-1;
        build(0,num,0,N);
    }

### （2）区间查询总和
    /**
     * 
     * @param l 区间左右边界
     * @param r
     * @return 返回区间值之和
     */
    public int sumRange(int l,int r){
        return searchAll(0,0,N,l,r);
    }
    
### （3）区间查询最大值
    /**
     * 
     * @param l 区间左右边界
     * @param r
     * @return 返回区间最大值
     */
    public int maxRange(int l,int r){
        return searchMax(0,0,N,l,r);
    }
### （4）区间查询最小值
    /**
     * 
     * @param l 区间左右边界
     * @param r
     * @return 返回区间最小值
     */
    public int minRange(int l,int r){
        return searchMin(0,0,N,l,r);
    }
### （5）修改单个节点
    /**
     * 
     * @param index 下标
     * @param value  修改值
     */
    public void modifyOneValue(int index,int value){
        updateone(0,0,N-1,index,value);
    }












