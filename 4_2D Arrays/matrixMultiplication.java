import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        //Matrix 1
        int m = scn.nextInt();
        int n = scn.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        //Matrix 2
        int p = scn.nextInt();
        int q = scn.nextInt();
        int b[][] = new int[p][q];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                b[i][j] = scn.nextInt();
            }
        }
        //Output
        if (n != p) {
            System.out.print("Invalid input");
        } else {
            int ab[][] = matrixMult(a, b);
            for (int i = 0; i < ab.length; i++) {
                for (int j = 0; j < ab[i].length; j++) {
                    System.out.print(ab[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static int[][] matrixMult(int[][] a, int[][] b) {
        int ab[][] = new int[a.length][b[0].length];
        for (int i = 0; i < ab.length; i++) {
            for (int j = 0; j < ab[i].length; j++) {
                int sum = 0;
                for (int s = 0; s < a[i].length; s++) {
                        sum += a[i][s] * b[s][j];
                }
                ab[i][j] = sum;
            }
        }
        return ab;
    }

}