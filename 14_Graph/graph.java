import java.util.ArrayList;

public class graph {
    public static class Edge{
        int v;
        int w;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    } 

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static int findEdge(int u, int v){
        for(int i=0; i < graph[u].size(); i++){
            Edge e = graph[u].get(i);
            if(e.v == v)
                return i;
        }
        return -1;
    }

    public static void removeEdge(int u, int v){
        int idx1 = findEdge(u, v);
        if(idx1 == -1)
            return;
        int idx2 = findEdge(v, u);
        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVertex(int u){
        int n = graph[u].size();
        while(n != 0){
            Edge e = graph[u].get(n-1);
            removeEdge(u, e.v);
            n--;
        }
    }

    public static void display(){
        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i + " -> ");
            for(Edge e : graph[i])
                sb.append("[" + e.v + "," + e.w + "] ");
            System.out.println(sb);
        }
    }

    public static boolean hasPath(int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;
        boolean res = false;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                res = res || hasPath(e.v, dest, vis);
        }
        return res;
    }

    public static void printAllPaths(int src, int dest, boolean[] vis, String ans){
        if(src == dest){
            System.out.println(ans + dest);
            return;
        }
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                printAllPaths(e.v, dest, vis, ans + src);
        }
        vis[src] = false;
    }
    public static void main(String[] args){
        for(int i=0; i<N; i++)
            graph[i] = new ArrayList<>();
        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);

        boolean[] vis = new boolean[N];
        // System.out.println(hasPath(0,6,vis));
        //display();
        //removeEdge(3, 4);
        // removeVertex(2);
        // display();
        printAllPaths(0, 6, vis, "");
    }
}
