class Solution {
    public int editDistance(String s1, String s2, int i, int j, int[][] dp) {  //memoization
        if(i == 0 || j == 0)
            return dp[i][j] = (i==0 ? j : i);
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = editDistance(s1, s2, i-1, j-1, dp);
        int insert = editDistance(s1, s2, i, j-1, dp);
        int replace = editDistance(s1, s2, i-1, j-1, dp);
        int delete = editDistance(s1, s2, i-1, j, dp);
        return dp[i][j] = Math.min(Math.min(insert,replace), delete) + 1;        
    }
    public int minDistance(String word1, String word2) {  //tabulation
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = (i==0 ? j : i);
                    continue;
                }
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int insert = dp[i][j-1]; //editDistance(s1, s2, i, j-1, dp);
                    int replace = dp[i-1][j-1]; // editDistance(s1, s2, i-1, j-1, dp);
                    int delete = dp[i-1][j]; //editDistance(s1, s2, i-1, j, dp);
                    dp[i][j] = Math.min(Math.min(insert,replace), delete) + 1;
                }    
            }
        }
        return dp[n][m];
        //for(int[] arr : dp)     Arrays.fill(arr, -1);
        //return editDistance(word1, word2, n, m, dp);
    }
}