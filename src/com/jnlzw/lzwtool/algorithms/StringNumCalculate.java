package com.jnlzw.lzwtool.algorithms;



/**
 * 字符串形式正整数数字计算
 */
public class StringNumCalculate {
    public static void main(String[] args) {
        System.out.println(multiply("525",
                "625"));
    }


    public static int compare(String a, String b) {
        a = removeZero(a);
        b = removeZero(b);
        if (a.length() != b.length()) return a.length() > b.length() ? 1 : -1;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) return 1;
            if (a.charAt(i) < b.charAt(i)) return -1;
        }
        return 0;
    }

    public static int compare(StringBuilder a, StringBuilder b) {
        return compare(a.toString(), b.toString());
    }


    public static String multiply(String a, String b) {
        String ans = "0";
        StringBuilder num1 = new StringBuilder(a);
        StringBuilder num2 = new StringBuilder(b);
        num1 = num1.reverse();
        num2 = num2.reverse();
        for (int i = 0; i < num2.length(); i++) {
            String tempAns = mul(num1.toString(), String.valueOf(num2.charAt(i)));
            int j = i;
            while (j-- > 0) tempAns = tempAns.concat("0");
            ans = add(ans, tempAns);
        }
        return ans;
    }


    private static String mul(String a, String b) {
        a = removeZero(a);
        b = removeZero(b);
        if (b.length() > 1) throw new RuntimeException("数字2必须是个位数");
        StringBuilder ans = new StringBuilder();
        StringBuilder num1 = new StringBuilder(a);
        num1 = num1.reverse();
        int i = 0, j = num1.length();
        int m = 0;
        for (; i < j; i++) {
            int t = Integer.parseInt(String.valueOf(num1.charAt(i))) * Integer.parseInt(b) + m;
            m = t / 10;
            ans.append(t % 10);
        }
        if (m != 0) ans.append(m);
        return removeZero(ans.reverse());
    }


    public static String add(String a, String b) {
        StringBuilder ans = new StringBuilder();
        StringBuilder num1 = new StringBuilder(removeZero(a));
        StringBuilder num2 = new StringBuilder(removeZero(b));
        num1 = num1.reverse();
        num2 = num2.reverse();
        int i = 0, j = Math.min(num1.length(), num2.length());
        int m = 0;
        for (; i < j; i++) {
            int t = Integer.parseInt(String.valueOf(num1.charAt(i))) + Integer.parseInt(String.valueOf(num2.charAt(i))) + m;
            m = t / 10;
            ans.append(t % 10);
        }
        for (; i < num1.length(); i++) {
            int t = Integer.parseInt(String.valueOf(num1.charAt(i))) + m;
            m = t / 10;
            ans.append(t % 10);
        }
        for (; i < num2.length(); i++) {
            int t = Integer.parseInt(String.valueOf(num2.charAt(i))) + m;
            m = t / 10;
            ans.append(t % 10);
        }
        if (m != 0) ans.append(m);
        return removeZero(ans.reverse());
    }

    // abs(a-b)
    public static String subtract(String a, String b) {
        StringBuilder num1 = new StringBuilder(removeZero(a));
        StringBuilder num2 = new StringBuilder(removeZero(b));
        if (compare(num1, num2) == 0) return "0";
        if (compare(num1, num2) < 0) {
            StringBuilder c = num1;
            num1 = num2;
            num2 = c;
        }
        num1 = num1.reverse();
        num2 = num2.reverse();
        int m = 0;
        int i = 0;
        for (; i < num2.length(); i++) {
            char num1char = num1.charAt(i);
            char num2char = num2.charAt(i);
            int t = num1char - num2char - m;
            if (t >= 0) {
                num1.replace(i, i + 1, String.valueOf(t));
                m = 0;
            } else {
                t = t + 10;
                num1.replace(i, i + 1, String.valueOf(t));
                m = 1;
            }
        }
        for (; i < num1.length(); i++) {
            if (m == 0) break;
            int t = num1.charAt(i) - '0' - m;
            if (t >= 0) {
                num1.replace(i, i + 1, String.valueOf(t));
                break;
            } else {
                t = t + 10;
                num1.replace(i, i + 1, String.valueOf(t));
                m = 1;
            }
        }
        return removeZero(num1.reverse());
    }

    // a/b    a<b*10
    public static String divide(String a, String b) {
        if (compare(a, multiply(b, "10")) >= 0) throw new RuntimeException();
        for (int i = 1; i <= 10; i++) {
            if (compare(a, multiply(b, "" + i)) < 0) return "" + (i - 1);
        }
        return "-1";
    }

    //去除字符串首的0
    private static String removeZero(String a) {
        StringBuilder num = new StringBuilder(a);
        while (num.length() > 1 && num.charAt(0) == '0') num.deleteCharAt(0);
        return num.toString();
    }

    private static String removeZero(StringBuilder a) {
        while (a.length() > 1 && a.charAt(0) == '0') a.deleteCharAt(0);
        return a.toString();
    }
}
