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
        spiralDisplay(a);
    }
    public static void spiralDisplay(int[][] a) {
        int rmin = 0;
        int rmax = a.length - 1;
        int cmin = 0;
        int cmax = a[0].length-1;
        int d = 0;
        while (rmin <= rmax && cmin <= cmax) {
            //down
            if (d == 0) {
                for (int i = rmin; i <= rmax; i++) {
                    System.out.println(a[i][cmin]);
                }
                cmin++;
            }
            //right
            else if (d == 1) {
                for (int i = cmin; i <= cmax; i++) {
                    System.out.println(a[rmax][i]);
                }
                rmax--;
            }
            //up
            else if (d == 2) {
                for (int i = rmax; i >= rmin; i--) {
                    System.out.println(a[i][cmax]);
                }
                cmax--;
            }
            //left
            else {
                for (int i = cmax; i >= cmin; i--) {
                    System.out.println(a[rmin][i]);
                }
                rmin++;
            }
            d++;
            d = d % 4;
        }
    }
}