AvlTree：排序二叉树类

LargeExcelFileReadUtil，SheetHandler：操作Excel

## 解决过程：
将excel文件解析为 行列坐标-值的形式存入map中，同时维护一个排序二叉树结构，可以看做是数据表的“索引”。
在原本的排序二叉树上做了一些改进，支持使用不唯一的列作为索引来构建二叉树，例如用姓名构建索引，
要查询某个姓名对应的行时，一次查询即可返回所有的行号，十万行数据中查询比较次数不会超过20次。
初次之外还采用递归的方式实现了范围查询。

存在缺点：在使用前需要有一个解析的过程（十万条数据大约5s左右）。如果Excel表中添加了一行数据只需要在二叉树中也插入对应的节点即可，
但是如果Excel表中删除了某行数据则需要重新解析。可以实现联合索引但是过程比较复杂，实际上一个索引值已经能过滤掉绝大多数的数据
，实现联合索引的意义不大。

## 使用过程：
```
//实例化LargeExcelFileReadUtil类，泛型类型为排序二叉树“索引”类型。
LargeExcelFileReadUtil<Integer> example = new LargeExcelFileReadUtil<>();
//解析excel文件
example.processOneSheet("C:\\Code\\lzw-tool\\src\\com\\jnlzw\\lzwtool\\demo\\poi.xlsx");
//获取构建好的排序二叉树
AvlTree<Integer> avlTree=example.getAvlTree();
//根据条件查询，返回值为List（索引是不唯一的会返回符合条件的行号的List）
avlTree.contains(111);
```

具体构建索引的逻辑在SheetHandler的endElement方法中编写。

## LargeExcelFileReadUtil提供方法：
```
    public AvlTree<T> getAvlTree(){

    public LinkedHashMap<String, String> getRowContents() {
    //解析单个Sheet
    public void processOneSheet(String filename) throws Exception {
    //解析所有Sheet
    public void processAllSheets(String filename) throws Exception {
    //输出对应行号的数据
    public List<String> row(int key){
```

## 排序二叉树提供方法：
```
/**
 *  排序二叉树
 *  t.insert();插入数据
 *   t.printHeight();输出二叉树高度
 *   t.printTree();输出二叉树
 *   t.contains();查询 支持准确查询和范围查询 输出List<Integer> key-行号列表
 *   t.isEmpty();判断是否为空
 */
```


## 最终结果：
解析十万条数据大约需要5秒左右，一万次范围查询耗时100毫秒左右（耗时和范围的大小有很大关系），
一万次准确查询耗时10毫秒以下。
