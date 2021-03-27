import java.io.*;
import java.util.*;

public class Main{

    public static int[] nser(int[] arr){   //next smaller index to right
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<n; i++){
            while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
                ans[st.getFirst()] = i;
                st.removeFirst();
            }
            st.addFirst(i);
        }
        return ans;
     }
     public static int[] nsel(int[] arr){   //next smaller index to left
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=n-1; i>=0; i--){
            while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
                ans[st.getFirst()] = i;
                st.removeFirst();
            }
            st.addFirst(i);
        }
        return ans;
     }

    public static int largestArea(int[] a){
        int[] nser = nser(a);
        int[] nsel = nsel(a);
        int area = 0;
        for(int i=0; i<a.length; i++){
            if(nsel[i] == -1 && nser[i] == -1)
                area = Math.max(area, a.length * a[i]);
            else    
                area = Math.max(area, (nser[i] - nsel[i] -1) * a[i]);
        }
        return area;
    }
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    System.out.println(largestArea(a));
 }
}