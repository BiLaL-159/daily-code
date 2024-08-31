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




}
