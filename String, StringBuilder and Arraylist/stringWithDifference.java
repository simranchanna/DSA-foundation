import java.io.*;
import java.util.*;

public class Main {

    public static String solution(String str) {

        StringBuilder sb = new StringBuilder(str);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < sb.length() - 1; i++) {
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(i + 1);
            int diff = ch2 - ch1;
            res.append(ch1);
            res.append(diff);
        }
        res.append(sb.charAt(sb.length() - 1));
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}