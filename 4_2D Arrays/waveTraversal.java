import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        waveTraversal(a);
    }

    public static void waveTraversal(int[][] a) {
        for (int j = 0; j < a[0].length; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i][j]);
                }
            } else {
                for (int i = a.length - 1; i >= 0; i--) {
                    System.out.println(a[i][j]);
                }
            }
        }
    }
}