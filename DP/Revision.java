package DP;

import java.util.ArrayList;
import java.util.List;

public class Revision {
    public static void main(String[] args) {
        int W=4;
        int[] wt={4,5,1};
        int[] val={1,2,3};

    }

    static int[][] dp;

    public static int MaxProfit(int[] wt, int[]val, int W){
        dp= new int[wt.length][W+1];
        for(int i=-1; i<wt.length-1; i++){
            for(int j=0; j<W+1; j++){
                if(i==-1) {
                    dp[i][j]=0;
                }
                if(j==0){
                    dp[i][j]=0;
                }
            }
        }
       return solveMaxProfit(wt, val, W, wt.length-1);
    }
    public static int solveMaxProfit(int[] wt, int[] val, int W, int i){

        if (i < 0 || W == 0) {
            return 0;
        }

        for(int x=0; x<i; x++){
            for(int y=0; y<W+1; y++){
                if (wt[i] > W) {
                    dp[i][W]=dp[i-1][W];
                }
                int includeItem= val[i]+ dp[i-1][W-wt[i]];
                int excludeItem= dp[i-1][W];
                dp[i][W]=Math.max(includeItem, excludeItem);
            }
        }

       return dp[i][W];
    }

    public static int solveCorrectly(int[] wt, int[] val, int W){
       int n=wt.length;
       for(int i=1; i<n+1; i++){
           for(int j=1; j<W+1; j++){
               if(wt[i-1]<=W){
                   dp[i][j]=Math.max(val[i-1]+ dp[i-1][j-wt[i-1]],dp[i-1][j]);
               }
               else{
                   dp[i][j]=dp[i-1][j];
               }
           }
       }

       return dp[n][W];
    }
}

