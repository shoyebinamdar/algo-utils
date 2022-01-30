package graphs;

public class DijkstrasShortestPath {
    int vertices;
    int[][] graph;

    public DijkstrasShortestPath(int vertices, int[][] graph) {
        this.vertices = vertices;
        this.graph = graph;
    }

    public void dijkstra() {
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[0] = 0;

        for (int n = 0; n < vertices - 1; n++) {
            int u = vertexWithMinimumDistance(distance, visited);

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    distance[u] != Integer.MAX_VALUE && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        printSolution(distance);
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int v = 0; v < vertices; v++)
            System.out.println(v + " \t\t " + dist[v]);
    }


    private int vertexWithMinimumDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && distance[v] < min) {
                min = distance[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int vertices = 9;
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        DijkstrasShortestPath path = new DijkstrasShortestPath(vertices, graph);
        path.dijkstra();
    }
}
