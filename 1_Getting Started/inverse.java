import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = 1;
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            int pow = 1;
            for (int i = 0; i < rem - 1; i++) {
                pow *= 10;
            }
            ans += c * pow;
            c++;
            n /= 10;
        }
        System.out.println(ans);
    }
}