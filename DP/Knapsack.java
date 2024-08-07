package DP;

public class Knapsack {
   static int[][] t;
    static int[][] dp;
    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        int W = 7;
        int n = 4;

        int maxProfit = solveKnapsackTopDown(weight, value, W, n);
        System.out.println("Maximum profit is: " + maxProfit);
    }
    public int knapsack(int[] weight, int[] value, int W){
        int n= weight.length;
        t= new int[W][n];
        for(int i=0; i<t.length; i++){
            for(int j=0; j<t[0].length; j++){
                t[i][j]=-1;
            }
        }
        return solveKnapsack(weight, value, W,n);
    }

    public int solveKnapsack(int[] weight, int[] value, int W, int n){
        if(weight.length==0 || W==0){
            return 0;
        }
        if(t[W][n]!=-1){
            return t[W][n];
        }
        if(weight[n]<=W){
            return t[W][n]= Math.max(value[n]+solveKnapsack(weight,value,W-weight[n],n-1),
                    solveKnapsack(weight,value, W, n-1));
        }
        else{
            return t[W][n]= solveKnapsack(weight,value,W,n-1);
        }
    }


    public static int solveKnapsackTopDown(int[] weight, int[] value, int W, int n){
        t= new int[n+1][W+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(weight[i-1]<=j){
                    t[i][j]= Math.max(value[i-1] + t[i-1][j-weight[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j]= t[i-1][j];
                }
            }
        }
        return t[n][W];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        t= new int[n+1][target+1];
        return solvefindTargetSumWays(nums, target, n);
    }
    public int solvefindTargetSumWays(int[] nums, int target, int n){
        int i=0;
        int j = 0;
        for(i=0; i<=n+1; i++){
            for(j=0; j<=target+1; j++){
                if(i==0){
                    t[i][j]=0;
                }
                t[i][j]=t[i-1][j-nums[i]] + t[i-1][j+nums[i]];
            }
        }
        return t[i+1][j+1];
    }

    public static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;
        dp = new int[n + 1][sum + 1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                dp[i][j]=-1;
            }
        }
        return subsetSumMemo(arr, n, sum);
    }

    public static boolean subsetSumMemo(int[] arr, int n, int sum) {
        if (sum == 0 && n == 0) {
            return true;
        }
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (dp[n][sum] != -1) {
            if (dp[n][sum] == 1) {
                return true;
            } else return false;
        }
        if (arr[n-1] <= sum) {
            if (subsetSumMemo(arr, n - 1, sum - arr[n-1]) || subsetSumMemo(arr, n - 1, sum)) {
                dp[n][sum] = 1;
            } else {
                dp[n][sum] = 0;
            }
            return dp[n][sum] == 1;
        } else {
            if (subsetSumMemo(arr, n - 1, sum)) {
                dp[n][sum] = 1;
            } else {
                dp[n][sum] = 0;
            }
            return dp[n][sum] == 1;
        }
    }
    static boolean[][] k;
    public static boolean subsetSumTopDown(int[] arr, int sum, int n) {
        k = new boolean[n + 1][sum + 1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    k[i][j]=false;
                }
                if(j==0){
                    k[i][j]=true;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    k[i][j] = k[i - 1][j - arr[i - 1]] || k[i - 1][j];
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }
        return k[n][sum];
    }
}
