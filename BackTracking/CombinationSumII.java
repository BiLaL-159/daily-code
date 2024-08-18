package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        Arrays.sort(candidates);
        solvecombinationSum2(candidates,target,0,list);
        return ans;
    }

    public void solvecombinationSum2(int[] arr, int target, int i, List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(arr[i]>target){
            return;
        }

        for(int j=i; j<arr.length; j++){
            if(j>i && arr[j]==arr[j-1]){
                continue;
            }
            list.add(arr[j]);
            solvecombinationSum2(arr,target-arr[j],i+1,list);
            list.remove(list.size()-1);
        }
    }

}
