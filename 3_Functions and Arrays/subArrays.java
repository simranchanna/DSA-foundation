import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        subArrays(arr, n);
    }
    public static void subArrays(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(a[k] + "\t");
                }
                System.out.println();
            }
        }
    }
}