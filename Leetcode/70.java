class Solution {
    public int climb_memo(int n, int[] dp){ //memoization
        if(n <= 2){
            dp[n] = n;
            return n;
        }
        if(dp[n] != 0)
            return dp[n];
        dp[n] = climb_memo(n-1, dp) + climb_memo(n-2, dp);
        return dp[n];
    }
    public int climb_tab(int N, int[] dp){  //tabulation
        for(int n = 0; n <= N; n++){
            if(n <= 2){
                dp[n] = n;
                continue;
            }
            dp[n] = dp[n-1] + dp[n-2];
        }    
        return dp[N];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climb_tab(n, dp);
    }
}