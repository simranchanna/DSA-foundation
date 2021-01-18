import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int sumOfDigitsString(String s, int i){
        if(i==s.length()){
            return 0;
        }
        char ch = s.charAt(i);
        int digit = Character.getNumericValue(ch);
        return (digit + sumOfDigitsString(s,i+1));
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(sumOfDigitsString(s,0));
    }
}