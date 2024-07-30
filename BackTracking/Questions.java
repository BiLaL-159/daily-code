package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Questions {
    public static void main(String[] args) {
        System.out.println(findTheWinner(40,7));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> localans= new ArrayList<>();
        solve(nums, ans, localans,0);
        return ans;
    }

    public static void solve(int[] nums, List<List<Integer>> ans, List<Integer> localans, int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(localans));
            return;
        }
        int val= nums[index];
        solve(nums, ans,localans, index+1);
        localans.add(val);
        solve(nums, ans, localans, index+1);
        localans.removeLast();
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        solveWithDuplicates(nums,ans, list,0);
        return ans;
    }

    public static void solveWithDuplicates(int[] nums,List<List<Integer>> ans, List<Integer> list, int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        int value= nums[index];


        list.add(value);
        solveWithDuplicates(nums, ans, list, index+1);
        list.remove(list.size()-1);
        if(index<nums.length-1 && nums[index]==nums[index+1]){
            while(index<nums.length-1 && nums[index]==nums[index+1]){
                index++;
            }
        }
        solveWithDuplicates(nums, ans, list, index+1);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        solveCombinationSum(candidates, target, ans, list);
        return ans;
    }

    public static void solveCombinationSum(int[] arr, int target, List<List<Integer>> ans, List<Integer> list){
            if(target==0){
                ans.add(new ArrayList<>(list));
                return;
            }
            if(target<0){
                return;
            }
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
            solveCombinationSum(arr,target-arr[i], ans, list);
            list.remove(list.size()-1);

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> localans= new ArrayList<>();
        solvePermute(nums,ans,localans,0);
        return ans;
    }
    public void solvePermute(int[] arr, List<List<Integer>> ans, List<Integer> localans, int index){
        if(index==arr.length){
            ans.add(new ArrayList<>(localans));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(localans.contains(arr[i])){
                continue;
            }
            localans.add(arr[i]);
            solvePermute(arr, ans, localans, index+1);
            localans.remove(localans.size()-1);
        }

    }

    public static boolean exist(char[][] board, String word) {
        boolean[] exist={false};
        solveExist(board, word, 0,0);
        return exist[0];
    }
    public static boolean solveExist(char[][] board, String word, int i, int j){
        if(word.length()==0){
           return true;
        }

            if (board[i][j] == '0' || board[i][j]!=word.charAt(0) || i < 0 || i >= board.length || j <= 0 || j >= board[0].length) {
                return false;
            }
                char temp = board[i][j];
                board[i][j] = '0';
                boolean exists=solveExist(board, word.substring(1), i-1, j) ||
                            solveExist(board, word.substring(1), i+1, j)||
                            solveExist(board, word.substring(1), i, j-1)||
                            solveExist(board, word.substring(1), i, j+1);

                return  exists;
    }
    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> list= new ArrayList<>();
       for(int i=0; i<n; i++){
           list.add(i+1);
       }
       return solveFindTheWinner(n, k, list,0);
    }
    public static int solveFindTheWinner(int n,int k, ArrayList<Integer> list, int i){
       if(list.size()==1){
           return list.getFirst();
       }
       i=(i+k-1)%(list.size());
       list.remove(i);
      return solveFindTheWinner(n,k,list,i);
    }

}

