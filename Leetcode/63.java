class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length - 1;
        int c = obstacleGrid[0].length - 1;
        
        int[][] dp = new int[r+1][c+1];
        
        for(int i=r; i>=0; i--){           
            for(int j=c; j>=0; j--){      
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == r && j == c){
                    dp[i][j] = 1;
                    continue;
                }
                int hori = 0;
                int vert = 0;
                if(i != r)
                    vert = dp[i+1][j];
                if(j != c)
                    hori = dp[i][j+1];
                dp[i][j] = hori + vert;
            }
        }
        return dp[0][0];
    }
}