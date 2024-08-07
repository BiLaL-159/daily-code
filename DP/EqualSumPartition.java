package DP;

public class EqualSumPartition {
    public static void main(String[] args) {
      int[] nums=  {1,5,11,5};

    }
   static  int[][] m;
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum=sum+nums[i];
        }
        return solvecanPartition(nums, sum);
    }

    public static boolean solvecanPartition(int[] nums, int sum){
        if(sum%2!=0){
            return false;
        }
//        return isSubset(nums, sum/2, nums.length);

         m= new int[nums.length+1][sum/2+1];
         for(int i=0; i<nums.length+1; i++){
            for(int j=0; j<sum/2+1; j++){
                 m[i][j]=-1;
            }
         }
        return isSubsetMemo(nums, sum/2, nums.length);
    }


    public static boolean isSubsetMemo(int[] nums, int sum, int n){
        if(n==0 && sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(sum==0){
            return true;
        }

        if (m[n][sum] != -1) {
            if (m[n][sum] == 1) {
                return true;
            } else return false;
        }
        if (nums[n-1] <= sum) {
            if (isSubsetMemo(nums, n - 1, sum - nums[n-1]) || isSubsetMemo(nums, n - 1, sum)) {
                m[n][sum] = 1;
            } else {
                m[n][sum] = 0;
            }
            return m[n][sum] == 1;
        } else {
            if (isSubsetMemo(nums, n - 1, sum)) {
                m[n][sum] = 1;
            } else {
                m[n][sum] = 0;
            }
            return m[n][sum] == 1;
        }

    }
    static boolean[][] k;
    public static boolean isSubset(int[] arr, int sum, int n) {
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

    static int[][] z;
    public static int BUKnapsack(int[] weight, int[] value, int n, int W){
        z= new int[n+1][W+1];
       for(int i=0; i<n+1; i++){
           for(int j=0; j<W+1; j++){
               if(i==0 || j==0){
                   z[i][j]=0;
               }
           }
       }

       for(int i=1; i<n+1; i++){
           for(int j=1; j<W+1; j++){
               if(weight[i-1]<=j){
                   z[i][j]= Math.max(value[i-1]+ z[i-1][j- weight[i-1]], z[i-1][j]);
               }
               else{
                   z[i][j]= z[i-1][j];
               }
           }
       }
       return z[n][W];
    }
}
