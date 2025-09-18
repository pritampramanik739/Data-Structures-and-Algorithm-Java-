import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph06 {
    public static void main(String[] args) {
        int n = 4;
        int flight[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3; 
        System.out.println(chepestvalue(n,flight,src,dest,1));
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        System.out.println(connectcities(cities));
    }
    

    public static class edge {
        @SuppressWarnings("unused")
        int src;
        int dest;
        int wt;

        public edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // cheapest flight--->
    public static void creategraph(int flight[][], ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight1 : flight) {
            int src = flight1[0];
            int dest = flight1[1];
            int wt = flight1[2];
            edge e = new edge(src, dest, wt);
            graph[src].add(e);
        }
    }
    
    static class Info {
        int v;
        int cost;
        int stop;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }
    
    public static int chepestvalue(int n, int flight[][], int src, int dest, int k) {
        ArrayList<edge> graph[] = new ArrayList[n];
        creategraph(flight, graph);
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stop > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                edge e = graph[curr.v].get(i);
                int v = e.dest;
                int wt = e.wt;
                if(curr.cost+wt<dist[v] && curr.stop<=k){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v,dist[v],curr.stop+1));
                }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }

    // connecting cities-->
    static class Information implements Comparable<Information>{
        int dest;
        int cost;
        public Information(int d,int c){
            this.dest=d;
            this.cost=c;
        }
        @Override
        public int compareTo(Information e2){
            return this.cost-e2.cost;
        }
    }
    public static int connectcities(int cities[][]){
        PriorityQueue<Information>pq=new PriorityQueue<>();
        boolean vis[]=new boolean[cities.length];
        pq.add(new Information(0,0));
        int finalcost=0;
        while(!pq.isEmpty()){
            Information e=pq.remove();
            if(!vis[e.dest]){
                vis[e.dest]=true;
                finalcost+=e.cost;
                for(int i=0;i<cities[e.dest].length;i++){
                    if(cities[e.dest][i]!=0){
                        pq.add(new Information(i,cities[e.dest][i]));
                    }
                }
            }
        }
        return finalcost;
    }


    //FloodFill Algorithm-->>>
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        int orgcol = image[sr][sc];   // ✅ store original color once
        if (orgcol != color) {        // avoid unnecessary recursion
            helper(image, sr, sc, color, vis, orgcol);
        }
        return image;
    }
    
    public static void helper(int image[][], int sr, int sc, int color, boolean vis[][], int orgcol) {
        // base case
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || 
            vis[sr][sc] || image[sr][sc] != orgcol) {
            return;
        }
        
        vis[sr][sc] = true;       // ✅ mark visited
        image[sr][sc] = color;    // fill the cell
        
        // left
        helper(image, sr, sc - 1, color, vis, orgcol);
        // right
        helper(image, sr, sc + 1, color, vis, orgcol);
        // up
        helper(image, sr - 1, sc, color, vis, orgcol);
        // down
        helper(image, sr + 1, sc, color, vis, orgcol);
    }



}
