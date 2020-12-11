import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(getKPC(str));
    }

    static String keypad[] = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static ArrayList < String > getKPC(String str) {
        if (str.length() == 0) {
            //base case
            ArrayList < String > result = new ArrayList < String > ();
            result.add("");
            return result;
        }
        char ch = str.charAt(0);
        ArrayList < String > list = getKPC(str.substring(1));
        int idx = ch - '0'; //char --->digit
        String words = keypad[idx];
        ArrayList < String > result = new ArrayList < String > ();
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            for (String s: list) {
                result.add(c + s);
            }
        }
        return result;
    }

}