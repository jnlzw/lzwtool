package com.jnlzw.lzwtool;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lzw on 2019/10/18.
 */
public class RC4 {
    private static final int[] s=new int[256];
    private static final int[] t=new int[256];
    private static char[] key;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入明文:");
        String clearText = input.nextLine();
        String Cipher=encode(clearText);
        System.out.println("密文: "+Cipher);
        System.out.println("解密："+decode(Cipher));
    }
    //加密

    public static String encode(String clearText){
        for(int i=0;i<256;i++){
            s[i]=i;
        }
        Random r=new Random();
        for(int i=0;i<32;i++){t[i]=r.nextInt();}
        for(int i=32;i<256;i++){t[i]=t[i%32];}
        int j = 0;
        for (int i = 0 ; i < 256 ; i++){
            j = (j + s[i] + s[i]) % 256;
            s[i]+=s[j];s[j]=s[i]-s[j];s[i]=s[i]-s[j];
        }
        StringBuilder Cipher=new StringBuilder();
        key = new char[clearText.length()];//保存密匙流
        int i = 0;j = 0;
        for (int k = 0; k < clearText.length(); ++k) {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;
            s[i]+=s[j];s[j]=s[i]-s[j];s[i]=s[i]-s[j];
            key[k] = (char) (s[(s[i] + s[j]) % 256]);
        }
        for (i = 0; i < clearText.length(); ++i) {
            Cipher.append((char) (clearText.charAt(i) ^ key[i]));
        }
        return Cipher.toString();
    }

    public static String decode(String Cipher){
        char[] clearText=Cipher.toCharArray();
        for(int i=0;i<clearText.length;i++){
            clearText[i]=(char)(clearText[i]^key[i]);
        }
        return new String(clearText);
    }

}
