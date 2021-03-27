import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = nger(a);
    display(nge);
 }
 
 //STARTING OF THE ANSWER
 public static int[] nger(int[] arr){  //next greater element to right
    int n = arr.length;
    LinkedList<Integer> st = new LinkedList<>();
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    for(int i=0; i<n; i++){
        while(st.size() != 0 && arr[st.getFirst()] < arr[i]){
            ans[st.getFirst()] = arr[i];
            st.removeFirst();
        }
        st.addFirst(i);
    }
    return ans;
 }
 public static int[] ngel(int[] arr){   //next greater element to left
    int n = arr.length;
    LinkedList<Integer> st = new LinkedList<>();
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    for(int i=n-1; i>=0; i--){
        while(st.size() != 0 && arr[st.getFirst()] < arr[i]){
            ans[st.getFirst()] = arr[i];
            st.removeFirst();
        }
        st.addFirst(i);
    }
    return ans;
 }
 public static int[] nser(int[] arr){   //next smaller element to right
    int n = arr.length;
    LinkedList<Integer> st = new LinkedList<>();
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    for(int i=0; i<n; i++){
        while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
            ans[st.getFirst()] = arr[i];
            st.removeFirst();
        }
        st.addFirst(i);
    }
    return ans;
 }
 public static int[] nsel(int[] arr){   //next smaller element to right
    int n = arr.length;
    LinkedList<Integer> st = new LinkedList<>();
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    for(int i=n-1; i>=0; i--){
        while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
            ans[st.getFirst()] = arr[i];
            st.removeFirst();
        }
        st.addFirst(i);
    }
    return ans;
 }
 //ENDING OF THE ANSWER

}