import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void dfs(int src, boolean[] vis) {
    vis[src] = true;
    for (Edge e : graph[src])
        if (!vis[e.nbr])
            dfs(e.nbr, vis);
     }

    public static boolean isConnected(int N) {
        boolean[] vis = new boolean[N];
        int components = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                components++;
                dfs(i, vis);
            }
        }
        return components == 1;
    }

    public static ArrayList<Edge>[] graph = null; 

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      System.out.println(isConnected(vtces));


   }
}