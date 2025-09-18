import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph03 {
    public static void main(String[] args) {
        ArrayList<edge> graph[] = new ArrayList[6];
        createGraph(graph);
        SourceToDestAllPath(graph, 0, 5, "");
    }
    public static class edge {
        @SuppressWarnings("unused")
        int si, dest, wt;
        public edge(int s, int d, int w) {
            this.si = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // add node in a graph-->>
   static void createGraph(ArrayList<edge>[] graph) {
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
    
    //bfs technique-->
    public static void topologicalsortBFS(ArrayList<edge> graph[]) {
        int indeg[] = new int[graph.length];
        calculate_Indegre(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    // calculate indegree-->
    public static void calculate_Indegre(ArrayList<edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void SourceToDestAllPath(ArrayList<edge>graph[],int src,int dest,String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            edge e=graph[src].get(i);
            SourceToDestAllPath(graph,e.dest,dest,path+src);
        }
    }


}
