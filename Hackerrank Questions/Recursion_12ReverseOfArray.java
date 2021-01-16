import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void reverseArr(int arr[], int s, int e){
        if(s>=e){
            return;
        }
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        reverseArr(arr,s+1,e-1);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int idx = scn.nextInt();
        reverseArr(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n"+arr[idx]);
    }
}