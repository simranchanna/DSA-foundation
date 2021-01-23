import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
    public static void solution(ArrayList < Integer > al) {
        int i = 0;
        while (i < al.size()) {
            int x = al.get(i);
            if (isPrime(x))
                al.remove(i);
            else
                i++;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList < Integer > al = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }

}