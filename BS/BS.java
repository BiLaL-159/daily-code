package BS;

public class BS {
    public static void main(String[] args) {

    }
    public int mySqrt(int x) {
        int[] arr= new int[x];
        for(int i=1; i<x; i++){
            arr[i]=i;
        }
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid= left+(right-left)/2;
            if(Math.pow(arr[mid],2)==x){
                return arr[mid];
            }
            else if(Math.pow(arr[mid],2)>x){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}
