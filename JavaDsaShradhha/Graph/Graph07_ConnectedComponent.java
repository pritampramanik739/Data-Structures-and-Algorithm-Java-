import java.util.ArrayList;
import java.util.Stack;

public class Graph07_ConnectedComponent {
    public static void main(String[] args) {
        ArrayList<edge> g[] = new ArrayList[5];
        creategraph(g);
        kosaraju(g, 5);
        createBridgeGraph(g);
        tarjanBridge(g, 5);
        getarticulationPoints(g, 5);

    }
    public static class edge {
        int src;
        int dest;

        edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // kosaraju algorithm for connected graph-->>
    public static void creategraph(ArrayList<edge> g[]) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        g[0].add(new edge(0, 2));
        g[0].add(new edge(0, 3));
        g[1].add(new edge(1, 0));
        g[2].add(new edge(2, 1));
        g[3].add(new edge(3, 4));
    }

    public static void kosaraju(ArrayList<edge> graph[], int v) {
        // Stack create step 1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topsort(graph, i, vis, s);
            }
        }
        // step 2
        ArrayList<edge> transpose[] = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false; // reinitialize vis array to reuse it in step 3 without creating new one
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                edge e = graph[i].get(j);
                transpose[e.dest].add(new edge(e.dest, e.src)); // reverse the node-->
            }

        }
        // step 3
        while (!s.isEmpty()) {
            int cu = s.pop();
            if (!vis[cu]) {
                System.out.print("scc-->");
                dfS(transpose, cu, vis);
                System.out.println();
            }
        }
    }

    public static void topsort(ArrayList<edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topsort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfS(ArrayList<edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfS(graph, e.dest, vis);
            }
        } 
    }


    // tarjan algorithm for bridge in graph-->
    // Bridge in graph-->
    public static void createBridgeGraph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));

        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 1));

        graph[3].add(new edge(3, 0));
        graph[3].add(new edge(3, 4));
        //graph[3].add(new edge(3, 5));

        graph[4].add(new edge(4, 3));
       // graph[4].add(new edge(4, 5));
 
       //  graph[5].add(new edge(5, 3));
       // graph[5].add(new edge(5, 4));   
    }

    public static void tarjanBridge(ArrayList<edge>graph[],int v){
        int dt[]=new int[v];
        int low[]=new int[v];
        int time=0;
        boolean vissst[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vissst[i]){
                DFS(graph, i, -1, dt, low, vissst, time);
            }
        }
    }

    public static void DFS(ArrayList<edge>graph[],int curr,int par,int dt[],int low[],boolean vis[],int time){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            int neigh=e.dest;
            if(neigh==par){
                // do nothing, skip parent
            }else if(!vis[neigh]){
                DFS(graph, neigh, curr, dt, low, vis, time);
                low[curr]=Math.min(low[curr], low[neigh]);
                if(dt[curr]<low[neigh]){
                    System.out.println("bridge "+curr+"---"+neigh);
                }
            }else{
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }
    }


    // Articulation point in graph-->>
    public static void getarticulationPoints(ArrayList<edge>graph[],int v){
        int dt[]=new int[v];
        int low[]=new int[v];
        int time=0;
        boolean vis[]=new boolean[v];
        boolean ap[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                ArticulationDfs(graph, i, -1, dt, low, time, vis, ap);
            }
        }
        for(int i=0;i<v;i++){
            if(ap[i]){
                System.out.println("ap : "+ i);
            }
        }
    }

     public static void ArticulationDfs(ArrayList<edge>graph[],int curr,int par,int dt[],int low[],int time,boolean vis[],boolean ap[]){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int children =0;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            int neigh=e.dest;
            if(neigh==par){
                //do nothing, skip parent
            }else if(vis[neigh]){
                low[curr]=Math.min(low[curr], dt[neigh]);
            }else{
                ArticulationDfs(graph,neigh,curr,dt,low,time,vis,ap);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(par!=-1 && dt[curr]<=low[neigh]){ //case 2  and 3 for articulation point
                    ap[curr]=true;
                }
                children++;
            }
        }
        if(par==-1 && children>1){ // case 1 for articulation point
            ap[curr]=true;
        }

    }

    
}
