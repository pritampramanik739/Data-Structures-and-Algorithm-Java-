import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph02 {
    public static void main(String[] args) {
        ArrayList<edge> graph[] = new ArrayList[7];
        createGraph(graph);
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
    static void createGraph(ArrayList<edge> graph[]) {
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


    public static boolean cycledetection(ArrayList<edge> graph[]) {
        boolean vist[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vist[i]) {
                if (cycledetectionutil(graph, vist, i, -1)) {
                    return true; // cycle present
                }
            }
        }
        return false;
    }
    public static boolean cycledetectionutil(ArrayList<edge> graph[], boolean vist[], int curr, int par) {
        vist[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vist[e.ei]) {
                if (cycledetectionutil(graph, vist, e.ei, curr)) {
                    return true;
                }
            }
            // case 1
            else if (vist[e.ei] && e.ei != par) {
                return true;
            }
        }
        return false;
    }

    public static boolean bipartite(ArrayList<edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        edge e = graph[curr].get(j);
                        if (col[e.ei] == -1) {
                            int nextcol = col[curr] == 0 ? 1 : 0;
                            col[e.ei] = nextcol;
                            q.add(e.ei);
                        } else if (col[e.ei] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean iscycleDirected(ArrayList<edge> graph[]) {
        boolean vistf[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vistf[i]) {
                if (iscycleutil(graph, i, vistf, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean iscycleutil(ArrayList<edge> graph[], int curr, boolean vistf[], boolean stack[]) {
        vistf[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (stack[e.ei]) {
                return true;
            }
            if (!vistf[e.ei] && iscycleutil(graph, e.ei, vistf, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topologicalsort(ArrayList<edge> graph[]) {
        boolean visty[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visty[i]) {
                topologicalsortutil(graph, i, visty, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalsortutil(ArrayList<edge> graph[], int curr, boolean visty[], Stack<Integer> s) {
        visty[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!visty[e.ei]) {
                topologicalsortutil(graph, e.ei, visty, s);
            }
        }
        s.push(curr);
    }
    

}
