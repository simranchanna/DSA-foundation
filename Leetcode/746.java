class Solution {
    public int mincost_memo(int[] cost, int n, int[] dp){
        if(n <= 1){
            dp[0] = cost[0];
            return dp[n] = cost[n]; 
        }
        if(dp[n] != 0)
            return dp[n];
        dp[n] = cost[n] + Math.min(mincost_memo(cost, n-1, dp), mincost_memo(cost, n-2, dp));
        return dp[n];
    }
    public int mincost_tab(int[] cost, int N, int[] dp){
        for(int n=0; n<=N; n++){
            if(n <= 1){
                dp[n] = cost[n];
                continue;
            }
            dp[n] = cost[n] + Math.min(dp[n-1], dp[n-2]);
        }
        return Math.min(dp[N], dp[N-1]);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        // mincost_memo(cost, n-1, dp);
        // return Math.min(dp[n-2], dp[n-1]);
        return mincost_tab(cost, n-1, dp);
    }
}