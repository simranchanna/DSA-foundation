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

    public static ArrayList<Edge>[] graph = new ArrayList[7];

    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static void display(){
        for(int i=0; i<7; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i + " -> ");
            for(Edge e : graph[i])
                sb.append("[" + e.v + "," + e.w + "] ");
            System.out.println(sb);
        }
    }

    public static void main(String[] args){
        for(int i=0; i<7; i++)
            graph[i] = new ArrayList<>();
        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);

        display();
    }
}
