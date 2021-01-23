import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        System.out.println(getMazePaths(0, 0, n - 1, m - 1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        //base case
        if (sr == dr && sc == dc) {
            ArrayList < String > result = new ArrayList < String > ();
            result.add("");
            return result;
        }
        ArrayList < String > result = new ArrayList < String > ();
        if (sc < dc) {
            //move horizontal
            ArrayList < String > hmoves = getMazePaths(sr, sc + 1, dr, dc);
            for (String s: hmoves) {
                result.add("h" + s);
            }
        }
        if (sr < dr) {
            //move vertical
            ArrayList < String > vmoves = getMazePaths(sr + 1, sc, dr, dc);
            for (String s: vmoves) {
                result.add("v" + s);
            }
        }
        return result;
    }

}