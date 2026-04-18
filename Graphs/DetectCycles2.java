package Graphs;

import java.util.ArrayList;

public class DetectCycles2 {
    
    static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.wt = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {   // null -> initializing empty arrList
            graph[i] = new ArrayList<>();
        }

        //graph1 - True cycle

        graph[0].add(new Edge(0, 0, 1));
        graph[1].add(new Edge(1, 1, 1));
        graph[2].add(new Edge(2, 2, 1));
        graph[3].add(new Edge(3, 3, 1));

        //graph2 - false cycle

        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 3, 1));
        // graph[2].add(new Edge(2, 3, 1));

    }

    public static boolean isCycle(ArrayList<Edge> graph[]){     // O(V+E)
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]){ // cycle
               return true; 
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {

        int V = 5; // g1
        // int V = 4; // g2

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.print(isCycle(graph));
    }
}
