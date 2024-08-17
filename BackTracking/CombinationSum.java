package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr={1,4,5,10,15,7,8,2};
        int[] value={2,3,1,5,4,1,2,3};
        int target=15;
        ArrayList<Integer> list= new ArrayList<>();
        int[] maxprofit={0};
        int profit=0;
        allPossibilities(arr,value,target,0,list,0,0);
        allPossibilities2(arr,value,target,0,list,profit,maxprofit);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<Integer> set= new HashSet<>();
        List<Integer> list= new ArrayList<>();
        return helper(candidates,target, 0, set, list);
    }
    public List<List<Integer>> helper(int[] arr, int target, int i, HashSet<Integer> occured, List<Integer> list){

        if(i==arr.length || target==0){
            List<List<Integer>> locallist= new ArrayList<>();
            locallist.add(new ArrayList<>(list));
            return locallist;
        }
        List<List<Integer>> ans= new ArrayList<>();
        if(arr[i]<=target && !occured.contains(arr[i])){
            ans.addAll(helper(arr,target,i+1,occured,list));
            occured.add(arr[i]);
            list.add(arr[i]);
            ans.addAll(helper(arr,target-arr[i],i+1,occured,list));
            occured.remove(occured.size()-1);
            list.remove(list.size()-1);
        }
        else{
            ans.addAll(helper(arr,target,i+1,occured,list));
        }
        return ans;
    }

    public static void allPossibilities(int[] arr, int[] value, int target, int i, ArrayList<Integer> list,int profit, int maxProfit){
        if(target==0){
            if(profit>maxProfit){
                maxProfit=profit;
                System.out.println(list +" & Profit: "+ profit);
            }
            return;
        }
        if(target<0 || i==arr.length){
            return;
        }
            list.add(arr[i]);
            allPossibilities(arr,value,target-arr[i], i+1, list,profit+value[i],maxProfit);
            list.remove(list.size()-1);
            allPossibilities(arr,value,target,i+1,list,profit,maxProfit);

    }
    public static void allPossibilities2(int[] arr, int[] value, int target, int i, ArrayList<Integer> list, int profit, int[] maxProfit){
        if (target == 0) {
            if (profit > maxProfit[0]) {
                maxProfit[0] = profit;
                System.out.println(list + " & Max Profit: " + profit);
            }
            return;
        }
        if (i == arr.length) {
            return;
        }

       if(arr[i]<=target){
           list.add(arr[i]);
           allPossibilities2(arr, value, target - arr[i], i + 1, list, profit + value[i], maxProfit);
           list.remove(list.size() - 1);
           allPossibilities2(arr, value, target, i + 1, list, profit, maxProfit);
       }
      else{
           allPossibilities2(arr, value, target, i + 1, list, profit, maxProfit);
       }
    }

    static List<List<Integer>> ans;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        combSumSolver(candidates,0, target, list);
        return ans;
    }

    public static void combSumSolver(int[] arr, int index,int target, List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));

        }
        if(index==arr.length){
            return;
        }

        if(arr[index]<=target){
            //not take it
            combSumSolver(arr,index+1,target,list);
            //take it
            list.add(arr[index]);
            combSumSolver(arr,index,target-arr[index],list);
            list.remove(list.size()-1);
        }
        else{
            combSumSolver(arr,index+1,target,list);
        }

    }




}
