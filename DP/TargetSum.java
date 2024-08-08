package DP;

public class TargetSum {
    public static void main(String[] args) {

    }
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int element: nums){
            sum+=element;
        }
        dp= new int[n+1][2*sum+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<2*sum+1; j++){
                dp[i][j]=-1;
            }
        }
        return solvefindTargetSumWays(nums, target, n, 0, sum);
    }

    public int solvefindTargetSumWays(int[] nums, int target, int n, int curr_sum, int offset){
        if(n==0 && curr_sum==target){
            return 1;
        }
        if(n==0){
            return 0;
        }

        if (dp[n][curr_sum + offset] != -1) {
            return dp[n][curr_sum + offset];
        }
        dp[n][curr_sum + offset] = solvefindTargetSumWays(nums, target, n - 1, curr_sum + nums[n - 1], offset)
                + solvefindTargetSumWays(nums, target, n - 1, curr_sum - nums[n - 1], offset);
        return dp[n][curr_sum + offset];
    }

}
