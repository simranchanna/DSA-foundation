import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        saddlePoint(a, n);
    }
    public static int minRow(int[][] a, int i) {
        int min = Integer.MAX_VALUE;
        for (int n = 0; n < a.length; n++) {
            if (a[i][n] < min)
                min = n;
        }
        return min;
    }
    public static int maxCol(int[][] a, int j) {
        int max = Integer.MIN_VALUE;
        for (int n = 0; n < a.length; n++) {
            if (a[n][j] > max)
                max = a[n][j];
        }
        return max;
    }
    public static void saddlePoint(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            int j = minRow(a, i);
            int k = maxCol(a, j);
            if (a[i][j] == k) {
                System.out.print(k);
                return;
            }
        }
        System.out.println("Invalid input");
    }
}