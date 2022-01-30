package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasShortestPathAdjacencyList {
    int vertices;
    ArrayList<ArrayList<Node>> graph;

    public DijkstrasShortestPathAdjacencyList(int vertices, ArrayList<ArrayList<Node>> graph) {
        this.vertices = vertices;
        this.graph = graph;
    }

    static class Node {
        int vertex, weight;

        Node(int v, int w) {
            vertex = v;
            weight = w;
        }
        int getVertex() { return vertex; }
        int getWeight() { return weight; }
    }

    public int[] dijkstra(int source) {
        int[] distance = new int[vertices];

        for (int i = 0; i < vertices; i++)
            distance[i] = Integer.MAX_VALUE;

        distance[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));

        pq.add(new Node(source, 0));

        while (pq.size() > 0) {
            Node current = pq.poll();

            for (Node n : graph.get(current.getVertex())) {
                if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
                    distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
                    pq.add(new Node(n.getVertex(), distance[n.getVertex()]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int v = 9;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new Node(1, 4));
        graph.get(0).add(new Node(7, 8));
        graph.get(1).add(new Node(2, 8));
        graph.get(1).add(new Node(7, 11));
        graph.get(1).add(new Node(0, 7));
        graph.get(2).add(new Node(1, 8));
        graph.get(2).add(new Node(3, 7));
        graph.get(2).add(new Node(8, 2));
        graph.get(2).add(new Node(5, 4));
        graph.get(3).add(new Node(2, 7));
        graph.get(3).add(new Node(4, 9));
        graph.get(3).add(new Node(5, 14));
        graph.get(4).add(new Node(3, 9));
        graph.get(4).add(new Node(5, 10));
        graph.get(5).add(new Node(4, 10));
        graph.get(5).add(new Node(6, 2));
        graph.get(6).add(new Node(5, 2));
        graph.get(6).add(new Node(7, 1));
        graph.get(6).add(new Node(8, 6));
        graph.get(7).add(new Node(0, 8));
        graph.get(7).add(new Node(1, 11));
        graph.get(7).add(new Node(6, 1));
        graph.get(7).add(new Node(8, 7));
        graph.get(8).add(new Node(2, 2));
        graph.get(8).add(new Node(6, 6));
        graph.get(8).add(new Node(7, 1));

        DijkstrasShortestPathAdjacencyList path = new DijkstrasShortestPathAdjacencyList(v, graph);

        int[] distance = path.dijkstra(0);

        System.out.println("Vertex  " + "  Distance from Source");
        for (int i = 0; i < v; i++) {
            System.out.println(i + "             " + distance[i]);
        }
    }
}
