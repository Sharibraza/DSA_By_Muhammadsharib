package Graphs;

import java.util.*;

public class TarjansAgloBridge {

    static class Edge {

        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {  
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int desc[], int low[], boolean vis[], int time) {

        vis[curr] = true;
        desc[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == par) {             // case 1 : 
                continue;
            } else if (!vis[neigh]) {       // case 2 :
                
                dfs(graph, neigh, curr, desc, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (desc[curr] < low[neigh]) {
                    System.out.println("Bridge : " + curr + " ---- " + neigh);
                }
            } else {                        // case 3 :
                low[curr] = Math.min(low[curr], desc[neigh]);
            }
        }
    }

    public static void tarjansBridge(ArrayList<Edge> graph[], int V) {
        int desc[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, desc, low, vis, time);
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];   
        createGraph(graph);
        tarjansBridge(graph, V);
    }
}
