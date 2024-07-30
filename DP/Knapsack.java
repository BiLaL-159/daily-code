package DP;

public class Knapsack {
    int[][] t;
    public static void main(String[] args) {

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
}
