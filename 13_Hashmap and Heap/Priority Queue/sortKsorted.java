import java.io.*;
import java.util.*;

public class Main {

    public static void sortKsorted(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for(int ele : arr){
            pq.add(ele);
            if(pq.size() > k)
                arr[idx++] = pq.remove();
        }
        while(pq.size() != 0)
            arr[idx++] = pq.remove();
        for(int ele : arr){
            System.out.println(ele);
        }    
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      sortKsorted(arr, k);
   }

}