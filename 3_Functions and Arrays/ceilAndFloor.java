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
        ceilAndFloor(arr, x);
    }
    public static void ceilAndFloor(int[] arr, int x) {
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x){
                ceil = x;
                floor = x;
            }
            else if(arr[i] < x){
                if(floor < arr[i])
                    floor = arr[i];
            }
            else if(arr[i] > x){
                if(ceil > arr[i])
                    ceil = arr[i];
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
}