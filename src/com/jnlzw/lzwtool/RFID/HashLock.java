package com.jnlzw.lzwtool.RFID;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by lzw on 2020/5/31
 */
public class HashLock {
    teg teg=new teg();
    server server=new server();

    //标签对象
    class teg{
        private String metaID,ID,k;
        public teg(){
            this.ID="1001";
            this.k="1111";
            this.metaID=""+this.k.hashCode();
        }
        public  String getMetalID(){return this.metaID;}
        public String checkK(String k){
            if ((""+k.hashCode()).equals(this.metaID))return this.ID;
            else return "密匙错误";
        }
    }

    //后台服务器对象
    class server{
        private HashMap<String,String> map=new HashMap<>();
        public server(){
            //map.put("1508416","1111");//后台存放hash值和k
            map.put("1539200","2222");
        }
        public String selectK(String metalID){
            return map.getOrDefault(metalID, "查询失败");
        }
    }
    public static void main(String[] args) {
        long startTime=System.nanoTime();   //获取开始时间
        HashLock hashLock=new HashLock();
        System.out.println("标签 --> 读写器 --> 后台 metaID ");
        String metaID=hashLock.teg.getMetalID();
        System.out.println("metalID = " + metaID);
        System.out.println("后台 --> 读写器 --> 标签 k ");
        String k=hashLock.server.selectK(metaID);
        System.out.println("k = " + k);
        System.out.println("标签 --> 读写器 ID");
        String ID=hashLock.teg.checkK(k);
        System.out.println("ID = " + ID);
        long endTime=System.nanoTime();   //获取开始时间
        System.out.println("程序运行时间： "+(endTime-startTime)*1.0/1000000+"ms");
        System.out.println("--------------------");
        System.out.println("攻击者可以获得 metaID=" + metaID + "和ID=" + ID);

    }
}
