import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long toNum(String s,int i,long pow){
        if(i<0){
            return 0;
        }
        char ch = s.charAt(i);
        long digit = Character.getNumericValue(ch);
        long res = (digit*pow) + toNum(s,i-1,pow*10);
        return res;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int div = scn.nextInt();
        long res = toNum(s,s.length()-1,1);
        System.out.println(res/div);
    }
}