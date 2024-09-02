package DP;

public class LCS {
    public static void main(String[] args) {

    }
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0){
            return 0;
        }

        if(text1.charAt(text1.length()-1)==text2.charAt(text2.length()-1)){
            return 1+ longestCommonSubsequence(text1.substring(0,text1.length()-1), text2.substring(0,text2.length()-1));
        }
        else{
            return Math.max(longestCommonSubsequence(text1, text2.substring(0,text2.length()-1)), longestCommonSubsequence(text1.substring(0,text1.length()-1),text2));
        }
    }

        int[][] dp;
        public int longestCommonSubsequenceMemoized(String text1, String text2){
            dp= new int[text1.length()+1][text2.length()+1];
            for(int i=0; i<text1.length()+1; i++){
                for(int j=0; j<text2.length()+1;j++){
                    dp[i][j]=-1;
                }
            }
            return solveLCSMemo(text1,text2, text1.length(),text2.length());

        }
        public int solveLCSMemo(String text1, String text2, int n, int m){
            if(n==0 || m==0){
                return 0;
            }

            if(dp[n][m]!=-1){
                return dp[n][m];
            }
            if(text1.charAt(n-1)==text2.charAt(m-1)){
                return dp[n][m]= 1+ solveLCSMemo(text1,text2,n-1,m-1);
            }
            else{
                return dp[n][m]= Math.max(solveLCSMemo(text1,text2,n-1,m), solveLCSMemo(text1,text2,n,m-1));
            }
        }

        int[][] t;
        public int longestCommonSubsequenceDP(String text1, String text2){
            t= new int[text1.length()+1][text2.length()+1];
            for(int i=0; i<text1.length()+1;i++){
                for(int j=0; j<text2.length()+1; j++){
                    if(i==0 || j==0){
                        t[i][j]=0;
                    }
                }
            }

            for(int i=1; i<text1.length()+1;i++){
                for(int j=1; j<text2.length()+1;j++){
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        t[i][j]=1+t[i-1][j-1];
                    }
                    else{
                        t[i][j]= Math.max(t[i-1][j],t[i][j-1]);
                    }
                }
            }
            return t[text1.length()][text2.length()];

        }



}
