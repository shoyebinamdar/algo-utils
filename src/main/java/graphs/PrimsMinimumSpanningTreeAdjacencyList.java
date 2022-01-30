package graphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class PrimsMinimumSpanningTreeAdjacencyList {
    class GraphNode {
        int dest;
        int weight;

        GraphNode(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<GraphNode>[] adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int v = 0; v < vertices; v++)
                adjacencyList[v] = new LinkedList<>();
        }
    }

    class PQNode {
        int vertex;
        int weight;
    }

    class PQComparator implements Comparator<PQNode> {
        @Override
        public int compare(PQNode node1, PQNode node2) {
            return node1.weight - node2.weight;
        }
    }

    void addEdge(Graph graph, int src, int dest, int weight) {
        GraphNode srcNode = new GraphNode(src, weight);
        GraphNode destNode = new GraphNode(dest, weight);
        graph.adjacencyList[src].addLast(destNode);
        graph.adjacencyList[dest].addLast(srcNode);
    }

    void primsMst(Graph graph) {
        Boolean[] visited = new Boolean[graph.vertices];
        PQNode[] pqNodes = new PQNode[graph.vertices];

        int[] parent = new int[graph.vertices];

        for (int v = 0; v < graph.vertices; v++)
            pqNodes[v] = new PQNode();

        for (int v = 0; v < graph.vertices; v++) {
            visited[v] = false;

            pqNodes[v].weight = Integer.MAX_VALUE;
            pqNodes[v].vertex = v;

            parent[v] = -1;
        }

        visited[0] = true;

        pqNodes[0].weight = 0;

        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
        TreeSet<PQNode> queue = new TreeSet<>(new PQComparator());

        for (int v = 0; v < graph.vertices; v++)
            queue.add(pqNodes[v]);

        // Loops until the queue is not empty
        while (!queue.isEmpty()) {
            PQNode node = queue.pollFirst();

            visited[node.vertex] = true;

            for (GraphNode iterator : graph.adjacencyList[node.vertex]) {
                if (visited[iterator.dest] == false) {
                    // If the key value of the adjacent vertex is
                    // more than the extracted key
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex
                    if (pqNodes[iterator.dest].weight > iterator.weight) {
                        queue.remove(pqNodes[iterator.dest]);
                        pqNodes[iterator.dest].weight = iterator.weight;
                        queue.add(pqNodes[iterator.dest]);
                        parent[iterator.dest] = node.vertex;
                    }
                }
            }
        }

        // Prints the vertex pair of mst
        for (int v = 1; v < graph.vertices; v++)
            System.out.println(parent[v] + " - " + v);
    }

    public static void main(String[] args) {
        int v = 9;

        Graph graph = new Graph(v);

        PrimsMinimumSpanningTreeAdjacencyList e = new PrimsMinimumSpanningTreeAdjacencyList();

        e.addEdge(graph, 0, 1, 4);
        e.addEdge(graph, 0, 7, 8);
        e.addEdge(graph, 1, 2, 8);
        e.addEdge(graph, 1, 7, 11);
        e.addEdge(graph, 2, 3, 7);
        e.addEdge(graph, 2, 8, 2);
        e.addEdge(graph, 2, 5, 4);
        e.addEdge(graph, 3, 4, 9);
        e.addEdge(graph, 3, 5, 14);
        e.addEdge(graph, 4, 5, 10);
        e.addEdge(graph, 5, 6, 2);
        e.addEdge(graph, 6, 7, 1);
        e.addEdge(graph, 6, 8, 6);
        e.addEdge(graph, 7, 8, 7);

        // Method invoked
        e.primsMst(graph);
    }
}