import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int u;
      int v;
      int w;

      Edge(int src, int nbr, int wt) {
         this.u = src;
         this.v = nbr;
         this.w = wt;
      }
   }

   static class Pair implements Comparable<Pair> {
      int wsf;
      String psf;

      Pair(int wsf, String psf){
         this.wsf = wsf;
         this.psf = psf;
      }

      public int compareTo(Pair o){
         return this.wsf - o.wsf;
      }
   }

   public static int vtces;
   public static ArrayList<Edge>[] graph;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      vtces = Integer.parseInt(br.readLine());
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

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      int criteria = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
      multisolver(graph, src, dest, visited, criteria, k, src + "", 0);
      
      System.out.println("Smallest Path = " + spath + "@" + spathwt);
      System.out.println("Largest Path = " + lpath + "@" + lpathwt);
      System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
      System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
   }



   static String spath = "";
   static Integer spathwt = Integer.MAX_VALUE;
   static String lpath = "";
   static Integer lpathwt = Integer.MIN_VALUE;
   static String cpath = "";
   static Integer cpathwt = Integer.MAX_VALUE;
   static String fpath = "";
   static Integer fpathwt = Integer.MIN_VALUE;
   static PriorityQueue<Pair> pq = new PriorityQueue<>();
   public static void multisolver(int src, int dest, boolean[] vis, int criteria, int k, String psf, int wsf) {
       if(src == dest){
           System.out.println(psf + dest + "@" + wsf);
           return;
       }
       vis[src] = true;
       for(Edge e : graph[src]){
           if(!vis[e.v])
            multisolver(e.v, dest, vis, criteria, k, psf + src, wsf + e.w);
       }
       vis[src] = false;  
   }
}