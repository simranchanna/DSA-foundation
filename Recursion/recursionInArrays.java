import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        displayArr(a,0);

        displayArrReverse(a,0);

        int x = scn.nextInt();
        System.out.println(firstIndex(a, 0, x));
        
        System.out.println(lastIndex(a, a.length-1, x));

        System.out.println(maxOfArray(a,0));
    }

    public static void displayArr(int[] a, int i) {
        if (i < a.length) {
            System.out.println(a[i]);
            displayArr(a, i + 1);
        }
    }
    public static void displayArrReverse(int[] a, int i) {
        if(i<a.length){
            displayArrReverse(a,i+1);
            System.out.println(a[i]);
        }
    }
    public static int firstIndex(int[] a, int i, int x) {
        if (i == a.length)
            return -1;
        else if (a[i] == x)
            return i;
        else
            return firstIndex(a, i + 1, x);
    }
    public static int lastIndex(int[] a, int i, int x) {
        if (i < 0)
            return -1;
        else if (a[i] == x)
            return i;
        else
            return lastIndex(a, i - 1, x);
    }
    public static int maxOfArray(int[] a, int i) {
        if (i == a.length - 1)
            return a[i];
        int max = maxOfArray(a, i + 1);
        if (max > a[i])
            return max;
        else
            return a[i];
    }

}