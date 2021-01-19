import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isPalindrome(String s, int i, int j){
        if(i>=j)
            return true;
        char c1 = s.charAt(i);
        char c2 = s.charAt(j);
        if(c1==c2 || c1-c2==32 || c2-c1==32)
            return isPalindrome(s,i+1,j-1);
        else 
            return false;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(isPalindrome(s,0,s.length()-1));
    }
}