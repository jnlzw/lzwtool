package com.jnlzw.lzwtool;
import java.util.Scanner;

/**
 * Created by lzw on 2019/10/18.
 * 加密函数: Y=（AX+B）%26
 * 解密函数: X=（A的逆元）*（Y-B）%26
 */

public class AffineCipher {

    //mod n
    private static final int n = 26;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入密钥k1 k2:");
        int k1 = input.nextInt();
        int k2 = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.println("输入明文:");
        String express = input2.nextLine();
        String ciphertext;
        ciphertext = encode(k1, k2, express);
        System.out.println("密文:" + ciphertext);
        String decrypttext = decode(k1, k2, ciphertext);
        System.out.println("解密:" + decrypttext);

    }

    //加密
    public static String encode(int k1, int k2, String express){
        express = express.toUpperCase();
        char[] expressChar = express.toCharArray();
        int[] cipherChar = new int[express.length()];
        for (int i=0;i<express.length();i++){
            cipherChar[i] = ((expressChar[i] - 65) * k1 + k2) % n;
        }
        StringBuilder Cipher = new StringBuilder();
        for(int j=0;j<cipherChar.length;j++){
            Cipher = Cipher.append((char)(cipherChar[j] + 65));
        }
        return Cipher.toString();
    }

    // 解密
    public static String decode(int k1, int k2, String ciphertext){
        //穷举求出k3
        // (k3 * k1) mod 26 = 1
        int k3 ;
        for (int i = 2;;i++){
            if((i*k1) % n == 1){
                k3 = i;
                break;
            }
        }
        //求出明文
        //  M= k3(c- k2) mod n
        StringBuffer clearText = new StringBuffer();
        for (int j=0;j<ciphertext.length();j++){
            int c = ((k3 * (ciphertext.charAt(j) - 65 - k2))) % 26;
            if (c < 0){
                c = c + 26;
            }
            clearText.append((char)( c + 65));
        }
        return clearText.toString();
    }

}
