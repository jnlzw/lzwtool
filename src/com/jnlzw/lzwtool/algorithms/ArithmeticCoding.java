package com.jnlzw.lzwtool.Algorithms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticCoding {
    private List<String> symbol;
    private List<Double> p;
    private List<Double> range;
    public ArithmeticCoding(List<String> symbol, List<Double> p){
        this.symbol=symbol;
        this.p=p;
        List<Double> temp=new ArrayList<>();
        Double f=0.;
        temp.add(0.);
        for (Double aDouble : p) {
            f = f + aDouble;
            temp.add(f);
        }
        this.range=temp;
    }
    public void encode(List<String> str){
        str.forEach(System.out::print);
        double l=0,r=1;
        for (String tempStr : str) {
            int index = symbol.indexOf(tempStr);
            // 更新左右范围值 注意要同步更新
            double tempL = l;
            double tempR = r;
            tempL = (r - l) * range.get(index) + l;
            tempR = (r - l) * range.get(index + 1) + l;
            l = tempL;
            r = tempR;
        }
        System.out.println("编码范围是" + String.format("%.6f", l) + "到" + String.format("%.6f", r));
        System.out.println("其中间值"+String.format("%.6f", (l + r) / 2));
    }
    // 假设解码知道消息长度
    public void decode(Double code,int len){
        System.out.println(""+code+"解码结果: ");
        while(len-->0){
            int index=0;
            // 查找code范围属于哪个符号
            while(code>range.get(index))index++;
            System.out.print(symbol.get(index - 1));
            // 更新code值用于下一次循环解码
            code=(code-range.get(index-1))/(range.get(index)-range.get(index-1));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArithmeticCoding arithmeticcoding=new ArithmeticCoding(Arrays.asList("A","B","C","D"),Arrays.asList(0.1,0.2,0.3,0.4));
        arithmeticcoding.encode(Arrays.asList("A","B","D","C","D"));
        arithmeticcoding.decode(0.02632,5);
    }
}
