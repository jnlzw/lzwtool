package com.jnlzw.lzwtool.demo;

/**
 * Created by lzw on 2020/5/16
 */

import java.io.InputStream;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * 数据量比较大(8万条以上)的excel文件解析，将excel文件解析为 行列坐标-值的形式存入map中，此方式速度快，内存耗损小 但只能读取excel文件
 * 提供处理单个sheet方法 processOneSheet(String  filename) 以及处理多个sheet方法 processAllSheets(String  filename)
 * 只需传入文件路径+文件名即可  调用处理方法结束后，只需 接收LargeExcelFileReadUtil.getRowContents()返回值即可获得解析后的数据
 */

public class LargeExcelFileReadUtil<T extends Comparable<? super T>> {

    private LinkedHashMap<String, String> rowContents = new LinkedHashMap<String, String>();
    private SheetHandler<T> sheetHandler;

    public AvlTree<T> getAvlTree(){return sheetHandler.getAvlTree();}

    public LinkedHashMap<String, String> getRowContents() {
        return rowContents;
    }

    public void setRowContents(LinkedHashMap<String, String> rowContents) {
        this.rowContents = rowContents;
    }

    public SheetHandler getSheetHandler() {
        return sheetHandler;
    }

    public void setSheetHandler(SheetHandler sheetHandler) {
        this.sheetHandler = sheetHandler;
    }

    //处理一个sheet
    public void processOneSheet(String filename) throws Exception {
        InputStream sheet = null;
        OPCPackage pkg = null;
        try {
            pkg = OPCPackage.open(filename);
            XSSFReader r = new XSSFReader(pkg);
            SharedStringsTable sst = r.getSharedStringsTable();
            XMLReader parser = fetchSheetParser(sst);
            sheet = r.getSheet("rId1");
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            setRowContents(sheetHandler.getRowContents());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pkg != null) {
                pkg.close();
            }
            if (sheet != null) {
                sheet.close();
            }
        }
    }

    //处理多个sheet
    public void processAllSheets(String filename) throws Exception {
        OPCPackage pkg = null;
        InputStream sheet = null;
        try {
            pkg = OPCPackage.open(filename);
            XSSFReader r = new XSSFReader(pkg);
            SharedStringsTable sst = r.getSharedStringsTable();
            XMLReader parser = fetchSheetParser(sst);
            Iterator<InputStream> sheets = r.getSheetsData();
            while (sheets.hasNext()) {
                System.out.println("Processing new sheet:\n");
                sheet = sheets.next();
                InputSource sheetSource = new InputSource(sheet);
                parser.parse(sheetSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pkg != null) {
                pkg.close();
            }
            if (sheet != null) {
                sheet.close();
            }
        }
    }

    private XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser =
                XMLReaderFactory.createXMLReader(
                        "com.sun.org.apache.xerces.internal.parsers.SAXParser"
                );
        setSheetHandler(new SheetHandler(sst));
        ContentHandler handler = (ContentHandler) sheetHandler;
        parser.setContentHandler(handler);
        return parser;
    }


    //输出行数据
    public List<String> row(int key){
        List<String> list=new LinkedList<>();
        char s='A';
        for (int i=0;i<26;i++) {
            String ans = rowContents.get(""+(char) (s + i)+key);
            if (ans != null) list.add(ans);
            else break;
        }
        return list;
    }
}




