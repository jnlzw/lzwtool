package com.jnlzw.lzwtool.Solutions;

import java.util.Scanner;

public class Solution8 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] num=new int[n];
        for (int i=0;i<n;i++)num[i]=scanner.nextInt();
        int ans1 = function(n, num);
        int l=0,r=n-1;
        while (l<r){
            num[l]=num[l]+num[r];
            num[r]=num[l]-num[r];
            num[l]=num[l]-num[r];
            l++;
            r--;
        }
        int ans2=function(n,num);
        System.out.println(n-Math.max(ans1,ans2));
    }

    private static int function(int n,int[] num){
        int[] dp=new int[n];
        int ans=1;
        dp[0]=1;
        for (int i=1;i<n;i++){
            int temp=0;
            for (int j=0;j<i;j++) {
                if (num[j] <= num[i]) temp = Math.max(temp, dp[j]);
            }
            dp[i]=temp+1;
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
