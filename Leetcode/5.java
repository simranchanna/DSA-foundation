import java.sql.Array;
import java.util.Arrays;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxI = 0, maxJ = 0, maxLength = 0;
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){
                if(gap == 0) 
                    dp[i][j] = 1;
                else if(gap == 1 && s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2;
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] != 0)
                    dp[i][j] = dp[i+1][j-1] + 2;
                if(dp[i][j] > maxLength){
                    maxI = i;
                    maxJ = j;
                    maxLength = dp[i][j];
                }        
            }
        }
        return s.substring(maxI, maxJ+1);  
    }
}