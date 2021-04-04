import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        //{ele, index, index of list}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });      
        for(int i=0; i<lists.size(); i++)
            pq.add(new int[]{lists.get(i).get(0), 0, i});
        while(pq.size() != 0){
            int[] ar = pq.remove();
            rv.add(ar[0]);
            int idx = ar[1];
            int listIdx = ar[2];
            int length = lists.get(listIdx).size();
            if(idx+1 < length){
                ar[1]++;
                ar[0] = lists.get(listIdx).get(idx+1);
                pq.add(ar);
            }
        }    
        return rv;
    }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}