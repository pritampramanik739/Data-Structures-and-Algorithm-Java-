import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph04_ShortestPath {
    public static void main(String[] args) {
        ArrayList<edge> graph[] = new ArrayList[6];
        creategraph(graph);
        djkistra(graph, 0);
        ArrayList<edge> edges = new ArrayList<>();
        CreateGraphMethod2(edges);
        bellmanford(edges, 0, 5);
    }
    public static class edge {
        @SuppressWarnings("unused")
        int src,dest,wt;
        public edge(int s, int d,int wt) {
            this.src = s;
            this.dest = d;
            this.wt=wt;
        }
    }

    static void creategraph(ArrayList<edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0, 1, 2));
        graph[0].add(new edge(0, 2, 4));
        graph[1].add(new edge(1, 2, 1)); 
        graph[1].add(new edge(1, 3, 7)); 
        graph[2].add(new edge(2, 4, 3));        
        graph[3].add(new edge(3, 5, 1));
        graph[4].add(new edge(4, 5, 5));
        graph[4].add(new edge(4, 3, 2));
    }

    static class pair implements Comparable<pair>{
        int n;
        int path;
        public pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(pair p2){
            return this.path-p2.path;
        }
    }

    public static void djkistra(ArrayList<edge>graph[],int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE; // initialize all distance with infinity
            }
        }
        boolean visst[]=new boolean[graph.length];
        PriorityQueue<pair>pq=new PriorityQueue<>();
        pq.add(new pair(src, 0));
        while(!pq.isEmpty()){
            pair curr=pq.remove();
            if(!visst[curr.n]){
                visst[curr.n]=true;
                for(int i=0;i<graph[curr.n].size();i++){
                    edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }

    public static void bellmanford(ArrayList<edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        // algorithm-->> O(V)
        for (int i = 0; i < V - 1; i++) {
            // edges--O(E)
            for (ArrayList<edge> graph1 : graph) {
                for (int k = 0; k < graph1.size(); k++) {
                    edge e = graph1.get(k);
                    // u,v,wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // relaxation-->>
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }


    static void CreateGraphMethod2(ArrayList<edge> graph) {
        graph.add(new edge(0, 1, 2));
        graph.add(new edge(0, 2, 4));
        graph.add(new edge(1, 2, -4));
        graph.add(new edge(2, 3, 2));
        graph.add(new edge(3, 4, 4));
        graph.add(new edge(4, 1, -1));
    }

    public static void bellmanford(ArrayList<edge> graph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < V - 1; i++) {
            // edges--0(E)
            for (int j = 0; j < graph.size(); j++) {
                edge e = graph.get(j);
                // u,v,wt
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                // relaxation-->>
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }

            }
        }
         for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }



}
