# LZW 工具箱

一个以 **Java** 实现的算法与数据结构练习仓库，包含常见算法、数据结构、图论与若干示例代码。

## 环境要求

- JDK 1.8
- Maven 3.x

## 项目结构

- `src/com/jnlzw/lzwtool/commom/algorithms`
  - `ArithmeticCoding`：算术编码
  - `LZW`：LZW 压缩算法
  - `GeneticAlgorithm`：遗传算法（用于复杂方程最值搜索）
  - `KMP`：字符串快速匹配
  - `Pow`：快速幂（可配合大数类型使用）
  - `Sort`：排序算法工具类（泛型实现）
- `src/com/jnlzw/lzwtool/commom/algorithms/graph`
  - 图相关算法与结构（如最短路、最大流等）
- `src/com/jnlzw/lzwtool/commom/datastructures`
  - `BloomFilter`：布隆过滤器
  - `BPlusTree`：B+ 树
  - `BTree`：B 树
  - `Heap`：堆（大顶堆/小顶堆）
  - `SegmentTree`：线段树
  - `UnionFindSet`：并查集
- `src/com/jnlzw/lzwtool/solutions`
  - 部分 LeetCode 题解
- `src/com/jnlzw/lzwtool/other`
  - 并发、IO、NIO/BIO、Excel 读取等示例

## 待完善方向

- 最短路
- 最小生成树
- 关键路径
- 最大流
- 最小割

## 说明

本仓库偏向学习与实验用途，部分代码可能仍在持续迭代中。
