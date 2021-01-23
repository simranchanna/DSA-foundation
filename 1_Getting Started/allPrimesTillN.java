import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        for (int n = low; n <= high; n++) {
            boolean flag = true;
            for (int j = 2; j * j <= n; j++) {
                if (n % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println(n);
        }
    }
}