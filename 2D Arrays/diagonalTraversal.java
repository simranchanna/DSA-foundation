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
        diagonalTraversal(a, n);
    }
    public static void diagonalTraversal(int[][] a, int n) {
        for (int row = 0; row < n; row++) {
            for (int i = 0, j = i + row; j < n; i++, j++) {
                System.out, println(a[i][j]);
            }
        }
    }
}