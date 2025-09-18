import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Graph05_MST {
    public static void main(String[] args) {
        ArrayList<edge>[] graph = new ArrayList[4];
        creategraph(graph);
        Prims(graph);
        ArrayList<node> g=new ArrayList<>();
        creategraph(g);
        Krushkal(g,4);
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
        graph[0].add(new edge(0, 1, 10));
        graph[0].add(new edge(0, 2, 15));
        graph[0].add(new edge(0, 3, 30));
        graph[1].add(new edge(1, 0, 10)); 
        graph[1].add(new edge(1, 3, 40)); 
        graph[2].add(new edge(2, 0, 15));        
        graph[2].add(new edge(2, 3, 50));
        graph[3].add(new edge(3, 1, 40));
        graph[3].add(new edge(3, 2, 50));
    }
    // prims algorithm-->>>
    static  class pair implements Comparable<pair>{
        int v;
        int cost;
        public pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(pair p2){
            return this.cost-p2.cost;
        }
    }

    public static void Prims(ArrayList<edge>graph[]){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pair>pq=new PriorityQueue<>();
        pq.add(new pair(0, 0));
        int finalcost=0;
        while(!pq.isEmpty()){
            pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalcost+=curr.cost;
                for(int i=0;i<graph[curr.v].size();i++){
                    edge e=graph[curr.v].get(i);
                    pq.add(new pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("finalcost is : "+ finalcost);
    }

    //disjoint set-->
    static int b=4;
    static int  par[]=new int[4];
    static int rank[]=new int[4];

    public static void init(){
        for(int i=0;i<b;i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);  //path compression-->>
    }

    public static void union(int a,int b){
        int parA=find(a);
        int paraB=find(b);
        if(rank[parA]==rank[paraB]){
            par[paraB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[paraB]){
            par[parA]=paraB;
        }else{
            par[paraB]=parA;
        }
    }


    //kruskal algorithm-->>
    
    public static class node implements Comparable<node>{
        int src;
        int dest;
        int wt;
        node(int z,int x,int c){
            this.src=z;
            this.dest=x;
            this.wt=c;
        }
        @Override
        public int compareTo(node n2){
            return this.wt-n2.wt;
        }
    }

    static void creategraph(ArrayList<node>g){
        g.add(new node(0, 1, 10));
        g.add(new node(0, 2, 15));
        g.add(new node(0, 3, 30));
        g.add(new node(1, 3, 40));
        g.add(new node(2, 3, 50));
    }
    // here use of disjoint set..__..
    public static void Krushkal(ArrayList<node>g,int v){
        init();
        Collections.sort(g);
        int mstcost=0;
        int count=0;
        for(int i=0;count<v-1;i++){
            node e=g.get(i);
            int parA=find(e.src);
            int paraB=find(e.dest);
            if(parA!=paraB){
                union(e.src, e.dest);
                mstcost+=e.wt;
                count++;
            }
        }
        System.out.println(" "+ mstcost);
    }




}