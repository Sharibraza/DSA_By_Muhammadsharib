package Graphs;

import java.util.ArrayList;

public class DfsTraversal {
     static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.wt = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        
        for (int i = 0; i < graph.length; i++) {   // null -> initializing empty arrList
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add( new Edge(0, 1, 1));
        graph[0].add( new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add( new Edge(1, 0, 1));
        graph[1].add( new Edge(1, 3, 1));

        // 2 - vertex
        graph[2].add( new Edge(2, 0, 1));
        graph[2].add( new Edge(2, 4, 1));

        // 3 - vertex
        graph[3].add( new Edge(3, 1, 1));
        graph[3].add( new Edge(3, 4, 1));
        graph[3].add( new Edge(3, 5, 1));

        // 4 - vertex
        graph[4].add( new Edge(4, 2, 1));
        graph[4].add( new Edge(4, 3, 1));
        graph[4].add( new Edge(4, 5, 1)); 
        
        // 5 - vertex
        graph[5].add( new Edge(5, 3, 1));
        graph[5].add( new Edge(5, 4, 1));
        graph[5].add( new Edge(5, 6, 1)); 

        // 6 - vertex
        graph[6].add( new Edge(6, 5, 1));
    }

    public static void dfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];  // check which vertex is already visited
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {       //If a vertex hasn't been visited, it triggers dfsUtil. This guarantees that even isolated parts of a disconnected graph are traversed.
                dfsUtil(graph, i, visited);   
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean visited[]){  // O(V+E)
       
        //visit
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
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
        System.out.print("DFS : " + "");
        dfsUtil(graph, 0, new boolean[V]);
    }
}


// Here is a breakdown of how the code works:

// 1. Graph Representation (Edge class)
// Instead of a simple integer array, the graph is built using an array of ArrayLists, where each list stores Edge objects.

// The Edge class defined at DfsTraversal.java:6 stores the source vertex (src), destination vertex (dest), and the weight (wt) of the edge.
// 2. Building the Graph (createGraph method)
// The createGraph method at DfsTraversal.java:17 initializes the graph.

// It iterates through the array and creates an empty ArrayList for each vertex.
// It then manually adds edges to form the graph shape shown in the main method's comments. For example, vertex 0 has edges connecting it to 1 and 2. Because it's an undirected graph, the connections exist in both directions (e.g., 0 connects to 1, and 1 connects to 0).
// 3. The Core Recursion (dfsUtil method)
// The dfsUtil method at DfsTraversal.java:61 contains the actual recursive DFS logic:

// Visit Node: It prints the current node (curr) and immediately marks it as true in the visited array so it is never processed again.
// Find Neighbors: It loops through all the edges connected to the curr vertex.
// Go Deep: If a connected neighbor (e.dest) has not been visited, the function recursively calls itself for that neighbor. This creates the "depth-first" behavior where the algorithm plunges as deep as possible down one path before backtracking.
// 4. Handling Disconnected Graphs (dfs method)
// The dfs method at DfsTraversal.java:52 is a helper that wraps dfsUtil. Not all graphs are fully connected; some have separate, isolated components.

// This method creates the visited array and loops through every vertex.
// If a vertex hasn't been visited, it triggers dfsUtil. This guarantees that even isolated parts of a disconnected graph are traversed.
// (Note: This specific wrapper method isn't utilized in the main execution, but it's a standard best practice).
// 5. Execution (main method)
// The standard execution happens in the main block:

// It sets the number of vertices (V = 7).
// It creates the array of ArrayLists and builds the graph structure.
// It kicks off the traversal starting from vertex 0 by directly calling dfsUtil(graph, 0, new boolean[V]).
