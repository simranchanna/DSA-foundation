import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printKPC(str, "");
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

    public static void printKPC(String qsf, String asf) {
        if (qsf.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = qsf.charAt(0);
        int digit = ch - '0';
        String word = keypad[digit];
        for (int i = 0; i < word.length(); i++) {
            char kpc = word.charAt(i);
            printKPC(qsf.substring(1), asf + kpc);
        }
    }

}