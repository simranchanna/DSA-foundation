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
        int s = scn.nextInt();
        int r = scn.nextInt();
        shellRotate(a, s, r);
        display(a);
    }
    public static void shellRotate(int[][] a, int s, int r) {
        //create 1d array
        int rmin = s - 1;
        int rmax = a.length - s;
        int cmin = s - 1;
        int cmax = a[0].length - s;
        int n = 2 * (cmax - cmin + 1);
        n = n + 2 * (rmax - rmin - 1);
        int[] shell = new int[n];
        //insert shell elements
        int count = 0;
        for (int i = rmin; i <= rmax; i++) {
            shell[count] = a[i][cmin];
            count++;
        }
        for (int i = cmin + 1; i <= cmax; i++) {
            shell[count] = a[rmax][i];
            count++;
        }
        for (int i = rmax - 1; i >= rmin; i--) {
            shell[count] = a[i][cmax];
            count++;
        }
        for (int i = cmax - 1; i > cmin; i--) {
            shell[count] = a[rmin][i];
            count++;
        }
        //rotate
        rotate(shell, r);
        //replace shell
        count = 0;
        for (int i = rmin; i <= rmax; i++) {
            a[i][cmin] = shell[count];
            count++;
        }
        for (int i = cmin + 1; i <= cmax; i++) {
            a[rmax][i] = shell[count];
            count++;
        }
        for (int i = rmax - 1; i >= rmin; i--) {
            a[i][cmax] = shell[count];
            count++;
        }
        for (int i = cmax - 1; i > cmin; i--) {
            a[rmin][i] = shell[count];
            count++;
        }
    }
    public static void reverse(int[] a, int low, int high) {
        while (low < high) {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }
    }
    public static void rotate(int[] shell, int k) {
        int n = shell.length;
        k = k % n;
        if (k < 0)
            k = k + n;
        reverse(shell, n - k, n - 1);
        reverse(shell, 0, n - k - 1);
        reverse(shell, 0, n - 1);
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