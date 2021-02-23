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
        int x = scn.nextInt();
        firstAndLast(arr, x);
    }
    public static void firstAndLast(int[] arr, int x) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x){
                if(first == -1)
                    first = i;
                last = i;
            }
        }
        System.out.println(first);
        System.out.println(last);
    }
}