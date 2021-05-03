class Solution {
    public static int mincost(int i, int j, int r, int c, int[][] dp, int[][] cost){
        if(i == r && j == c)
            return dp[i][j] = cost[i][j];
        if(dp[i][j] != 0)
            return dp[i][j];
        int hori = Integer.MAX_VALUE;
        int vert = Integer.MAX_VALUE;
        if(i < r)
            vert = mincost(i+1, j, r, c, dp, cost);
        if(j < c)
            hori = mincost(i, j+1, r, c, dp, cost);
        dp[i][j] = cost[i][j] + Math.min(hori, vert);
        return dp[i][j];        
    }
    public static int mincost_dp(int r, int c, int[][] dp, int[][] cost){
        for(int i=r; i>=0; i--){
            for(int j=c; j>=0; j--){
                if(i == r && j == c){
                    dp[i][j] = cost[i][j];
                    continue;
                }
                if(i == r)
                    dp[i][j] = cost[i][j] + dp[i][j+1];
                else if(j == c)
                    dp[i][j] = cost[i][j] + dp[i+1][j];
                else 
                    dp[i][j] = cost[i][j] + dp[i+1][j] + dp[i][j+1];               
            }
        }    
        return dp[0][0];   
    }
    public int minPathSum(int[][] cost) {
        int r = cost.length;
        int c = cost[0].length;
        int[][] dp = new int[r][c];
        return mincost_dp(r-1, c-1, dp, cost);
    }
}