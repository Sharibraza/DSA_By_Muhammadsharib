package Graphs;

import java.util.*;

public class DetectCycles {

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

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // 2 - vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 0, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 3, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 3, 1));   
    }

    //O(V+E)
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph,vis,i,-1)) {
                    return true;
                    //Cycle exist in one of the parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int parent){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //case 3 : 
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            //case 1 : 
            else if (vis[e.dest] && e.dest != parent) {
                return true; // always exists
            }
            //case 2 : do nothing --> continue
        }

        return false;
    }

    public static void main(String[] args) {
    /*
            0 --- 3
          / |     | 
         1  |     4  
          \ |      
            2     
    */

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.print(detectCycle(graph));
    }
}
