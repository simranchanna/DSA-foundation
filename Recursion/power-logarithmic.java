import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.print(power(x, n));
    }

    public static int power(int x, int n) {
        if (n == 0)
            return 1;
        int nBy2 = power(x, n / 2);
        int ans = nBy2 * nBy2;
        if (n % 2 == 0)
            return ans;
        else
            return ans * x;
    }

}