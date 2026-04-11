package Graphs;

import java.util.ArrayList;

public class HasPath {

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

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 - vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 - vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 - vertex
        graph[6].add(new Edge(6, 5, 1));
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {  // O(V+E) - bcz here we are using dfs so Tc is same as it.

        if (src == dest) {
            return true;
        }

        //visit
        visited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            //e,dest == neighbour
            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {

     /*
           1 --- 3
          /      | \
         0       |  5 --- 6
          \      | /
           2 --- 4

     */

        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];  // arr of arrList
        createGraph(graph);
        int src = 0;
        int dest = 5;
        System.out.print("Does path exists from " + src + " to " + dest + " :- ");
        System.out.println(hasPath(graph, src, dest, new boolean[V]));
    }
}
