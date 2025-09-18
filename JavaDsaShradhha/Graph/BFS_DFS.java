
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS {

    public static void main(String[] args) {
        ArrayList<edge> graph[] = new ArrayList[7];
        ctraeteGraph(graph);
        System.out.println(haspath(graph, 0, 7, new boolean[7]));
    }

    public static class edge {

        @SuppressWarnings("unused")
        int si, ei, wt;

        public edge(int s, int d, int w) {
            this.si = s;
            this.ei = d;
            this.wt = w;
        }

    }

    // add node in a graph-->>
    static void ctraeteGraph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));

        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 3, 1));

        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 4, 1));

        graph[3].add(new edge(3, 1, 1));
        graph[3].add(new edge(3, 4, 1));
        graph[3].add(new edge(0, 5, 1));

        graph[4].add(new edge(4, 2, 1));
        graph[4].add(new edge(4, 5, 1));
        graph[4].add(new edge(4, 3, 1));

        graph[5].add(new edge(5, 3, 1));
        graph[5].add(new edge(5, 4, 1));
        graph[5].add(new edge(5, 6, 1));

        graph[6].add(new edge(6, 5, 1));
    }

    // Bfs-->levelwise[queue] tc=O(v+e) sc=O(v) 
    public static void BFS(ArrayList<edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean vist[] = new boolean[graph.length];
        q.add(0); // stsrt node is 0 we can start from any node.
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vist[curr]) {
                System.out.print(curr + " ");
                vist[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e = graph[curr].get(i);
                    q.add(e.ei);
                }
            }
        }
    }

    //dfs--> stack
    public static void DFS(ArrayList<edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.ei]) {
                DFS(graph, e.ei, vis);
            }
        }
    }

    public static boolean haspath(ArrayList<edge> graph[], int src, int dest, boolean vist[]) {
        if (src == dest) {
            return true;
        }
        vist[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            edge e = graph[src].get(i);
            if (!vist[e.ei] && haspath(graph, e.ei, dest, vist)) {
                return true;
            }
        }
        return false;
    }

    public static void bfs(ArrayList<edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsutil(graph, vis);
            }
        }
    }

    public static void bfsutil(ArrayList<edge>[] graph, boolean vis[]) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e = graph[curr].get(i);
                    q.add(e.ei);
                }
            }
        }
    }

    public static void dfs(ArrayList<edge>[] graph) {
        boolean vist[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vist[i]) {
                dfsutil(graph, i, vist);
            }
        }
    }

    public static void dfsutil(ArrayList<edge>[] graph, int curr, boolean vist[]) {
        if (vist[curr]) {
            return;   // already visited

                }vist[curr] = true;        // mark visited first
        System.out.print(curr + " ");

        for (edge e : graph[curr]) {
            if (!vist[e.ei]) {
                dfsutil(graph, e.ei, vist);
            }
        }
    }

}
