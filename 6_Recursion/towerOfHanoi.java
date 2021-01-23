import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int A = scn.nextInt();
        int B = scn.nextInt();
        int C = scn.nextInt();
        toh(n, A, B, C);
    }

    public static void toh(int n, int src, int dest, int aux) {
        //base case
        if (n == 0) {
            return;
        }
        //move n-1 disks from src to aux
        toh(n - 1, src, aux, dest);
        //my level work
        System.out.println(n + "[" + src + " -> " + dest + "]");
        //move n-1 disks from aux to dest
        toh(n - 1, aux, dest, src);
    }

}