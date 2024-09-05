package DP;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
       // System.out.println(fibo(45));
        System.out.println(fiboMemo(105));
        System.out.println(fiboDP(100));
    }
    public static int fibo(int n){
        if(n<=1){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }

    static int[] t;
    public static int fiboMemo(int n){
        t=new int[n+1];
       for(int i=0; i<n+1; i++){
           t[i]=-1;
       }
        return solvefiboMemo(n);
    }

    public static int solvefiboMemo(int n){
        if(t[n]!=-1){
            return t[n];
        }
        if(n<=1){
            return t[n]=n;
        }
        return t[n]=solvefiboMemo(n-1)+solvefiboMemo(n-2);
    }

    static int[] dp;
    public static int fiboDP(int n){
        dp= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<n+1; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }




}
