package com.jnlzw.lzwtool.commom.algorithms;

import java.math.BigInteger;

/**
 * Created by lzw on 2020/4/27.
 * 快速幂
 */

public class Pow {
    public long pow(int a, int b) {
        long ans = 1;
        long temp = a;
        while (b != 0) {
            if ((b & 1) == 1) ans *= temp;
            b = b >> 1;
            temp *= temp;
        }
        return ans;
    }

    public long pow(int a, int b,int mod) {
        long ans = 1;
        long temp = a;
        while (b != 0) {
            if ((b & 1) == 1) ans = (ans*temp)%mod;
            b = b >> 1;
            temp = (temp*temp)%mod;
        }
        return ans;
    }

    public BigInteger bigIntegerPow(int a, int b) {
        BigInteger ans = new BigInteger("" + 1);
        BigInteger temp = new BigInteger("" + a);
        while (b != 0) {
            System.out.println("temp = " + temp);
            if ((b & 1) == 1)
                ans = ans.multiply(temp);
            b = b >> 1;
            temp = temp.pow(2);
        }
        return ans;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.pow(1, 1000000000));
    }
    

    

}
