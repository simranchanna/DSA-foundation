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
        int x = scn.nextInt();
        search(a, x);
    }
    public static void search(int[][] a, int x) {
        int n = a.length;
        if (x < a[0][0] || x > a[n - 1][n - 1]) {
            System.out.print("Not Found");
            return;
        }
        int r = 0, c = n - 1;
        while (r < n && c >= 0) {
            if (x == a[r][c]) {
                System.out.println(r);
                System.out.println(c);
                return;
            } else if (x < a[r][c])
                c--;
            else if (x > a[r][c])
                r++;
        }
        System.out.print("Not Found");
    }
}