class Solution {
    public static int lps(String s, int i, int j, int[][] dp){
        if(i >= j)
            return dp[i][j] = (i == j) ? 1 : 0;
        if(dp[i][j] != 0)
            return dp[i][j];        
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);
        if(ch1 == ch2){
            dp[i][j] = 2 + lps(s, i+1, j-1, dp);
        } else{
            dp[i][j] = Math.max(lps(s, i, j-1, dp), lps(s, i+1, j, dp)); 
        }
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return lps(s, 0, n-1, dp);
    }
}