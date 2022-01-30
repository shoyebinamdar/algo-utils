package graphs;

public class PrimsMinimumSpanningTree {
    private int vertices;
    int[][] graph;

    public PrimsMinimumSpanningTree(int vertices, int[][] graph) {
        this.vertices = vertices;
        this.graph = graph;
    }

    public void primMST() {
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        int[] parent = new int[vertices]; // for printing mst only

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        distance[0] = 0;
        parent[0] = -1;

        for (int n = 0; n < vertices - 1; n++) {
            int u = vertexWithMinimumDistance(distance, visited);

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && graph[u][v] < distance[v]) {
                    distance[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST(parent);
    }

    private void printMST(int[] parent) {
        System.out.println("Edge \t Weight");

        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t\t" + graph[i][parent[i]]);
        }
    }

    private int vertexWithMinimumDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args)
    {
        int graph[][] = new int[][] {
                                      { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 }
                                    };
        PrimsMinimumSpanningTree primsMinimumSpanningTree = new PrimsMinimumSpanningTree(5, graph);

        primsMinimumSpanningTree.primMST();
    }

}
