import java.util.Arrays;

class Solution {
    public static int lcs(String s1, String s2, int i, int j, int[][] dp){  //memoization
        if(i == 0 || j == 0)
            return dp[i][j] = 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = 1 + lcs(s1, s2, i-1, j-1, dp);
        return dp[i][j] = Math.max(lcs(s1, s2, i-1, j, dp), lcs(s1, s2, i, j-1, dp));    
    }
    public int longestCommonSubsequence(String text1, String text2) {  //tabulation
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        // for(int[] arr : dp)
        //    Arrays.fill(arr, -1);
        for(int i=0; i<n1+1; i++){
            for(int j=0; j<n2+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);    
            }
        }
        return dp[n1][n2];
        //return lcs(text1, text2, n1, n2, dp);
    }
}