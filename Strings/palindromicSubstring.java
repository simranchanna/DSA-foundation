import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPalindrome(String str) {
        int low = 0;
        int high = str.length() - 1;
        while (low < high) {
            char c1 = str.charAt(low);
            char c2 = str.charAt(high);
            if (c1 != c2){
                return false;
            }    
            low++;
            high--;
        }
        return true;
    }
    public static void solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String ss = str.substring(i, j);
                if (isPalindrome(ss)) {
                    System.out.println(ss);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}