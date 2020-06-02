package com.jnlzw.lzwtool.RFID;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lzw on 2020/5/31
 */
public class RandomHashLock {
    teg teg=new teg();
    server server=new server();

    class teg{
        String ID;
        public String getHashValue() {
            this.ID="1001";
            String rand = "" + new Random().nextInt(10000);
            return rand + "_" + (rand + ID).hashCode();
        }
    }

    class server{
        List<String> IDList=new ArrayList<>();
        public server(){
            //IDList.add("1001");//后台存放ID列表
            IDList.add("1002");
            IDList.add("1003");
        }
        public String selectID(String r,String hashCode){
            for (String id:IDList)if (hashCode.equals(""+(r+id).hashCode()))return id;
            return "查询失败";
        }
    }

    public static void main(String[] args) {
        long startTime=System.nanoTime();   //获取开始时间
        RandomHashLock randomHashLock=new RandomHashLock();
        System.out.println("标签 --> 读写器 --> 后台 (r_hashCode)");
        String resp=randomHashLock.teg.getHashValue();
        System.out.println("resp = " + resp);
        String r=resp.split("_")[0];
        String hashCode=resp.split("_")[1];
        System.out.println("后台 --> 读写器 ID");
        String ID=randomHashLock.server.selectID(r,hashCode);
        System.out.println("ID = " + ID);
        long endTime=System.nanoTime();   //获取开始时间
        System.out.println("程序运行时间： "+(endTime-startTime)*1.0/1000000+"ms");
        System.out.println("---------------------------");
        System.out.println("攻击者可以获得r=" + r + "和c=" + hashCode);
    }
}
