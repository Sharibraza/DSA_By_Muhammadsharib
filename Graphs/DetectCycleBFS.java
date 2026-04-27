package Graphs;

import java.util.*;

public class DetectCycleBFS {

    public static void addEdge(ArrayList<Integer> adj[], int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public static boolean isCyclicDisconnected(ArrayList<Integer> adj[], int V) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        for (int i = 0; i < V; i++) {
            if (!vis[i] && isCyclicConnected(adj, i, V, vis)) {
                    return true;    
            }
        }
        return false;
    }

    public static boolean isCyclicConnected(ArrayList<Integer> adj[], int s, int V, boolean vis[]) {
        int parents[] = new int[V];
        Arrays.fill(parents,-1);

        Queue<Integer> q = new LinkedList<>();
        vis[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }  
                else if ( parents[u] != v ) {
                    return true;
                }  
            }
        }
        return false;
    }

    

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Integer> adj[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {   
            adj[i] = new ArrayList<>();
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);

        if (isCyclicDisconnected(adj, V)) {
            System.out.print("Cycle : Yes ");
        } else {
            System.out.print("Cycle : NO ");
        }
    }
}
