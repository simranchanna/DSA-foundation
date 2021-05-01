public class fibonacci {
    public static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    // public static void print2D(int[][] arr){
    //     for(int[] ele : arr){
    //         print(ele);
    //     }
    // }

    public static int fibo_memo(int n, int[] dp){  //memoization
        if(n <= 1){
            dp[n] = n;
            return n;
        }
        if(dp[n] != -1)
            return dp[n];
        dp[n] = fibo_memo(n-1, dp) + fibo_memo(n-2, dp);
        return dp[n];   
    }    

    public static int fibo_tab(int N, int[] dp){  //tabulation
        for(int n = 0; n <= N; n++){
            if(n <= 1){
                dp[n] = n;
                continue;
            }
            dp[n] = dp[n-1] + dp[n-2];
        }
        return dp[N];  
    }

    public static int fibo_opti(int n) {  //optimization
        int a = 0, b = 1;
        for (int i = 0; i <= n; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args){
        int n = 5;
        int[] dp = new int[n + 1];
        // for(int i=0; i<=n; i++){
        //     dp[i] = -1;
        // }    
        // fibo_memo(n, dp);    
        print(dp);
        // for(int i=0; i<=n; i++){
        //     dp[i] = -1;
        // }    
        // fibo_tab(n, dp);    
        // print(dp);
        // fibo_opti(n);
    }
}
