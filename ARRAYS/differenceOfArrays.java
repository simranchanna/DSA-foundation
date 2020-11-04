import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int a1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int a2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }
        int result[] = subtract(a1, a2);
        int counter = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                if (counter != 0)
                    System.out.println(result[i]);
            } else {
                counter = 1;
                System.out.println(result[i]);
            }
        }
    }
    public static int[] subtract(int[] a1, int[] a2) {
        int n1 = a1.length, n2 = a2.length;
        int result[] = new int[n2];
        int i = n1 - 1, j = n2 - 1;
        int borrow = 0;
        while (j >= 0) {
            int v1 = i >= 0 ? a1[i] : 0;
            int v2 = a2[j];
            int dif = v2 - v1 - borrow;
            if (dif < 0) {
                borrow = 1;
                dif = dif + 10;
            } else
                borrow = 0;
            result[j] = dif;
            i--;
            j--;
        }
        return result;
    }

}