import java.util.*;

public class fibonacci {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a = 0, b = 1, c;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1)
                System.out.println(i);
            else {
                c = a + b;
                System.out.println(c);
                a = b;
                b = c;
            }
        }
    }
}