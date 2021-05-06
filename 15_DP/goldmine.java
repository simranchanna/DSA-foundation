import java.io.*;
import java.util.*;

public class Main {

    public static int goldmine_memo(int r, int c, int n, int m, int[][] dp, int[][] cost, int[][] dir){
        if(c == m)
            return dp[r][c] = cost[r][c];
        if(dp[r][c] != -1)
            return dp[r][c];    
        int maxgold = 0;    
        for(int i=0; i<dir.length; i++){
            int x = r + dir[i][0];
            int y = c + dir[i][1];

            if(x>=0 && x<=n && y>=0 && y<=m){
                maxgold = Math.max(maxgold, goldmine_memo(x, y, n, m, dp, cost, dir)); 
            }
        } 
        dp[r][c] = cost[r][c] + maxgold;
        return dp[r][c];
    }
    public static int goldmine(int[][] cost){
        int n = cost.length;
        int m = cost[0].length;
        int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
        int[][] dp = new int[n][m];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        int maxgold = 0;    
        for(int i=0; i<n; i++){
            maxgold = Math.max(maxgold, goldmine_memo(i, 0, n-1, m-1, dp, cost, dir));
        }    
        return maxgold;
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
        System.out.println(goldmine(cost));
    }

}