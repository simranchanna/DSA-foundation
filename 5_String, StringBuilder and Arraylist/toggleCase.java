import java.io.*;
import java.util.*;

public class Main {

    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder(str);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char temp = (char)('A' + (ch - 'a'));
                res.append(temp);
            } else {
                char temp = (char)('a' + (ch - 'A'));
                res.append(temp);
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}