import java.io.*;
import java.util.*;

public class Main {
   
   public static int friendDFS(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        int size = 0;
        for (Integer e : graph[src]) {
            if (!vis[e])
                size += friendDFS(graph, e, vis);
        }

        return size + 1;
    }

    public static int perfectFriends(int n, int[][] friends) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        int count = 0;
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] a : friends) {
            graph[a[0]].add(a[1]);
            graph[a[1]].add(a[0]);
        }

        ArrayList<Integer> sizeArray = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                sizeArray.add(friendDFS(graph, i, vis));
        }
        for(int i=0; i<sizeArray.size()-1; i++){
            for(int j=i+1; j<sizeArray.size(); j++){
                count += sizeArray.get(i) * sizeArray.get(j);
            }
        }
        return count; 

    }

   public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);

      int n = scn.nextInt();
      int k = scn.nextInt();
      
      int[][] friends = new int[k][2];
      for(int i=0; i<k; i++){
          for(int j=0; j<2; j++){
              friends[i][j] = scn.nextInt();
          }
      }
      System.out.println(perfectFriends(n, friends));
   }

}