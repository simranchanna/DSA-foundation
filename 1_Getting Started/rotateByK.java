import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int ans = n;
        int c = 0;
        while (n > 0) {
            c++;
            n /= 10;
        }
        k = k % c;
        if (k < 0) {
            k = c + k;
        }
        int div = 1;
        for (int i = 0; i < k; i++) {
            div *= 10;
        }
        int rem = ans % div;
        ans /= div;
        for (int i = 0; i < c - k; i++) {
            rem *= 10;
        }
        ans += rem;
        System.out.println(ans);
    }
}