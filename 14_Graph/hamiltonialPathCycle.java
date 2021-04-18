import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int v;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.v = nbr;
         this.wt = wt;
      }
   }
   
   public static ArrayList<Edge>[] graph = null;
   public static int N;
   
   public static int findEdge(int u, int v) {
        for (int i = 0; i < graph[u].size(); i++) {
            Edge e = graph[u].get(i);
            if (e.v == v)
                return i;
        }

        return -1;
    }
   
   public static void hamintonian_dfs(int src, int osrc, boolean[] vis, int NoOfEdges, String psf) {
        if (NoOfEdges == N - 1) {
            System.out.print(psf + src);
            int idx = findEdge(src, osrc);
            if (idx == -1)
                System.out.print(".");
            else 
                System.out.print("*");

            System.out.println();
            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                hamintonian_dfs(e.v, osrc, vis, NoOfEdges + 1, psf + src);
        }

        vis[src] = false;
    }

    public static void hamiltonialPath() {
        boolean[] vis = new boolean[N];
        hamintonian_dfs(0, 0, vis, 0, "");
    }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }
      N = vtces;

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());

      hamiltonialPath();
   }


}