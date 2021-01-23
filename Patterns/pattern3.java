import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 0; j--) {
                if (j - i > 0)
                    System.out.print("	");
                else
                    System.out.print("*	");
            }
            System.out.println();
        }
    }
}