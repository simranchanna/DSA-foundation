public class mazepath {
    public static int getMazePaths_memo(int i, int j, int r, int c, int[][] dp){
        if(i > r || j > c)
            return 0;
        if(i == r && j == c){
            return dp[i][j] = 1;
        }
        if(dp[i][j] != 0)
            return dp[i][j];

        int hori = getMazePaths_memo(i, j+1, r, c, dp);
        int diag = getMazePaths_memo(i+1, j+1, r, c, dp);
        int vert = getMazePaths_memo(i+1, j, r, c, dp);
        dp[i][j] = hori + diag + vert;
        return dp[i][j];
    }
    public static int getMazePaths_tab(int[][] dp, int r, int c){
        for(int i=r; i>=0; i--){
            for(int j=c; j>=0; j--){
                if(i == r || j == c){
                    dp[i][j] = 1;
                    continue;
                }
                int hori = dp[i][j+1];
                int diag = dp[i+1][j+1];
                int vert = dp[i+1][j];
                dp[i][j] = hori + diag + vert;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        int n = 3, m = 3;
        int[][] dp = new int[n][m];
        System.out.println(getMazePaths_tab(dp, n-1, m-1));
    }
}
