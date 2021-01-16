import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isPalindrome(int arr[], int start,int end){
        if(start>=end){
            return true;
        }
        if(arr[start] == arr[end]){
            return isPalindrome(arr,start+1,end-1);
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(isPalindrome(arr,0,n-1));
    }
}