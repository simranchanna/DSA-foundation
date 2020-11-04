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
        rotateBy90(a);
        display(a);
    }

    public static void rotateBy90(int[][] a) {
        //transpose of matrix
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a[i].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        //swapping columns of matrix
        int x = 0, y = a[0].length - 1;
        while (x < y) {
            for (int i = 0; i < a.length; i++) {
                int temp = a[i][x];
                a[i][x] = a[i][y];
                a[i][y] = temp;
            }
            x++;
            y--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}