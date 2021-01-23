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
        int sum[] = sumArr(a1, a2);
        if (sum[0] != 0)
            System.out.println(sum[0]);
        for (int i = 1; i < sum.length; i++) {
            System.out.println(sum[i]);
        }
    }
    public static int[] sumArr(int[] a1, int[] a2) {
        int n1 = a1.length, n2 = a2.length;
        int n3 = Math.max(n1, n2);
        int sum[] = new int[n3 + 1];
        int i = n1 - 1, j = n2 - 1, k = n3;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int v1 = i >= 0 ? a1[i] : 0;
            int v2 = j >= 0 ? a2[j] : 0;
            int add = v1 + v2 + carry;
            if (add > 9) {
                carry = add / 10;
                add = add % 10;
            } else
                carry = 0;
            sum[k] = add;
            i--;
            j--;
            k--;
        }
        sum[0] = carry;
        return sum;
    }

}