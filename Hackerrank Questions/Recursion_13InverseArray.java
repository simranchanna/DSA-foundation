import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void inverseArr(int arr[], int i){
        if(i == arr.length){
            return;
        }
        int val = arr[i];
        inverseArr(arr,i+1);
        arr[val] = i;
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
        inverseArr(arr,0);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n"+arr[idx]);
    }
}