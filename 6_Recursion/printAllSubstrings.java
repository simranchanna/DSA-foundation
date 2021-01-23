import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(gss(str));
    }

    public static ArrayList < String > gss(String str) {
        if (str.length() == 0) {
            ArrayList < String > list = new ArrayList < String > ();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        ArrayList < String > list = gss(str.substring(1));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String s = ch + list.get(i);
            list.add(s);
        }
        return list;
    }

}