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
        exitPoint(a);
    }
    public static void exitPoint(int[][] a) {
        //d=0 East
        //d=1 South
        //d=2 West
        //d=3 North
        int d = 0;
        int i = 0, j = 0;
        while (i >= 0 && i < a.length && j >= 0 && j < a[0].length) {
            d += a[i][j];
            d = d % 4;
            if (d == 0)
                j++;
            else if (d == 1)
                i++;
            else if (d == 2)
                j--;
            else
                i--;
        }
        if (i < 0)
            i++;
        else if (j < 0)
            j++;
        else if (i == a.length)
            i--;
        else
            j--;
        System.out.print(i + "\n" + j);
    }
}