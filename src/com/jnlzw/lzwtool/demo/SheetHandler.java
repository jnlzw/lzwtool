package com.jnlzw.lzwtool.demo;

/**
 * Created by lzw on 2020/5/16
 */
/**
 SheetHandler  类中处理从excle获取的数据，官方文档中 SheetHandler以内部类形式，为保证更新代码减少内部类class文件忘记打包，改为一般java类
 */
import java.util.LinkedHashMap;

import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public  class SheetHandler<T extends Comparable<? super T>>  extends DefaultHandler {

    private SharedStringsTable sst;
    private String lastContents;
    private boolean nextIsString;
    private String  cellPosition;
    private  LinkedHashMap<String, String>rowContents=new LinkedHashMap<String, String>(); //存放数据 这里暂时没用
    private AvlTree<T> avlTree = new AvlTree<>(); //维护二叉树

    //返回二叉树
    public AvlTree<T> getAvlTree(){return avlTree;}

    public LinkedHashMap<String, String> getRowContents() {
        return rowContents;
    }
    public void setRowContents(LinkedHashMap<String, String> rowContents) {
        this.rowContents = rowContents;
    }

    public SheetHandler(SharedStringsTable sst) {
        this.sst = sst;
    }

    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {
        if(name.equals("c")) {
            //   System.out.print(attributes.getValue("r") + " - ");
            cellPosition=attributes.getValue("r");
            String cellType = attributes.getValue("t");
            if(cellType != null && cellType.equals("s")) {
                nextIsString = true;
            } else {
                nextIsString = false;
            }
        }
        // 清楚缓存内容
        lastContents = "";
    }

    public void endElement(String uri, String localName, String name)
            throws SAXException {
        if(nextIsString) {
            int idx = Integer.parseInt(lastContents);
            lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
            nextIsString = false;
        }

        if(name.equals("v")) {
            //数据读取结束后，将单元格坐标,内容存入map中
            if(!(cellPosition.length() == 2) || !"1".equals(cellPosition.substring(1))){//不保存第一行数据
                //rowContents.put(cellPosition, lastContents);
                rowContents.put(cellPosition,lastContents);
                //选择用哪一列作为索引
                if (cellPosition.startsWith("E"))avlTree.insert( (T)new Integer(lastContents),
                        Integer.parseInt(cellPosition.substring(1)));
            }
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        lastContents += new String(ch, start, length);
    }
}
