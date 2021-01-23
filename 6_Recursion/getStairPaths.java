import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList < String > getStairPaths(int n) {
        //base case
        if (n == 0) {
            ArrayList < String > list = new ArrayList < String > ();
            list.add("");
            return list;
        }
        ArrayList < String > list = new ArrayList < String > ();
        //1 step
        if (n >= 1) {
            ArrayList < String > step1 = getStairPaths(n - 1);
            for (String s: step1) {
                list.add(1 + s);
            }
        }
        //2 step
        if (n >= 2) {
            ArrayList < String > step2 = getStairPaths(n - 2);
            for (String s: step2) {
                list.add(2 + s);
            }
        }
        //3 step
        if (n >= 3) {
            ArrayList < String > step3 = getStairPaths(n - 3);
            for (String s: step3) {
                list.add(3 + s);
            }
        }
        return list;
    }

}