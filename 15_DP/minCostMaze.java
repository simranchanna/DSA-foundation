import java.io.*;
import java.util.*;

public class Main {

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
                    dp[i][j] = cost[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);               
            }
        }    
        return dp[0][0];   
    }
    public static int minPathSum(int[][] cost) {
        int r = cost.length;
        int c = cost[0].length;
        int[][] dp = new int[r][c];
        return mincost_dp(r-1, c-1, dp, cost);
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] cost = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cost[i][j] = scn.nextInt();
            }
        }
        System.out.println( minPathSum(cost));
    }

}