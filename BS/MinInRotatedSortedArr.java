package BS;

public class MinInRotatedSortedArr {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;

        while(l<r){
            int mid= l+(r-l)/2;
            if(isTrue(mid,nums)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean isTrue(int index, int[] arr){
        return index < arr.length && arr[index] < arr[index + 1];
    }

}
