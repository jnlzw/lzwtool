package com.jnlzw.lzwtool;

import java.util.Scanner;

/**
 * Created by lzw on 2020/5/1
 */
public class Test {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            int i = input.nextInt();
            int result = function(i);
            System.out.println(result);
        }
    }

    public static int function(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        for (int j = 0; j < 10; j++) {
            function2(i);
        }

        return i * i;
    }

    public static int function2(int i) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        function3(i);

        return -1;
    }

    public static int function3(int i) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return -1;
    }
}
