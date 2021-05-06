import java.io.*;
import java.util.*;

public class Main {

    public static int friendsPairing(int n){    //brute force
        if(n == 0 || n == 1){
            return 1;
        }
        int ans = 0;
        ans += friendsPairing(n-1);
        ans += friendsPairing(n-2) * (n-1);
        return ans;
    }

    public static int friendsPairing_memo(int n, int[] dp){     //memoization
        if(n == 0 || n == 1){
            dp[n] = 1;
            return 1;
        }
        if(dp[n] != 0)
            return dp[n];
        int ans = 0;
        ans += friendsPairing(n-1);
        ans += friendsPairing(n-2) * (n-1);
        return dp[n] = ans;
    }

    public static int friendsPairing_dp(int N, int[] dp){     //tabulation
        for(int n=0; n<=N; n++){
            if(n == 0 || n == 1){
                dp[n] = 1;
                continue;
            }
            int ans = 0;
            ans = ans + dp[n-1] + (dp[n-2] * (n-1));
            dp[n] = ans;
        }
        return dp[N];
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        System.out.println(friendsPairing_dp(n, dp));
    }

}