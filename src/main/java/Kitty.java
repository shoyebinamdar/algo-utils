import java.util.*;

class Graph {
  private int v;
  private LinkedList<Integer> adjacencyList[];
  //private int distances[][];
  Map<Pair, Integer> distances;
  //int path[][];
  boolean flag = false;


  Graph (int n) {
    this.v = n;
    adjacencyList = new LinkedList[n + 1];
    //distances = new int[v + 1][v + 1];
    distances = new HashMap<>();
    //path = new int[3][100000];

    for (int i = 1; i <= n; i++) {
      adjacencyList[i] = new LinkedList();
    }
  }

  void addEdge(int u, int v) {
    adjacencyList[u].add(v);
    adjacencyList[v].add(u);
  }

  // storing the path from root to node
  void dfs(int cur, int prev, int pathNumber, int ptr, int node, int[][] path)
  {
    for (int i = 0; i< adjacencyList[cur].size(); i++)
    {
      if (adjacencyList[cur].get(i) != prev && !flag)
      {
        // pushing current node into the path
        path[pathNumber][ptr] = adjacencyList[cur].get(i);
        if (adjacencyList[cur].get(i) == node)
        {
          // node found
          flag = true;

          // terminating the path
          path[pathNumber][ptr+1] = -1;
          return;
        }
        dfs(adjacencyList[cur].get(i), cur, pathNumber, ptr+1,
            node, path);
      }
    }
  }

  // This Function compares the path from root to 'a' & root
// to 'b' and returns LCA of a and b. Time Complexity : O(n)
  int lca(int a, int b)
  {
    // trivial case
    if (a == b)
      return a;

    int path[][] = new int[3][100000];
    // setting root to be first element in path
    path[1][0] = path[2][0] = 1;

    // calculating path from root to a
    //boolean flag = false;
    dfs(1, 0, 1, 1, a, path);

    // calculating path from root to b
    flag = false;
    dfs(1, 0, 2, 1, b, path);

    // runs till path 1 & path 2 mathches
    int i = 0;
    while (path[1][i] == path[2][i])
      i++;

    // returns the last matching node in the paths
    return path[1][i-1];
  }

  void print() {
    for (int i = 1; i <= v; i++) {
      for (int j = 0; j < adjacencyList[i].size(); j++) {
        System.out.println( i + " " + adjacencyList[i].get(j));
      }
    }
  }

  /*public int dist(int src, int dest) {
    return distances[src][dest];
  }*/

  public int dist(Pair pair) {
    if (distances.containsKey(pair))
      return distances.get(pair);

    return distances.get(new Pair(1, pair.first)) + distances.get(new Pair(1, pair.second)) - 2 * distances.get(new Pair(1, lca(pair.first, pair.second)));
    //return distances.containsKey(pair) ? distances.get(pair) : dist(pair.first, pair.second);
  }

  public void calculateDistanceFromRoot() {
    for (int i = 2; i <= v; i++)
      dist(1, i);
  }
  // bfs utility for distance computation
  public int dist(int src, int dest) {
    boolean[] visited = new boolean[v + 1];
    List<Integer> distances = new ArrayList<>();

    for (int i = 0; i <= v; i++) {
      visited[i] = false;
    }

    for (int i = 0; i <= v; i++) {
      distances.add(0);
    }

    Queue<Integer> queue = new LinkedList<>();

    queue.add(src);
    distances.set(src, 0);
    visited[src] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();

      for (int i = 0; i < adjacencyList[node].size(); i++) {
        if (!visited[adjacencyList[node].get(i)]) {
          queue.add(adjacencyList[node].get(i));
          visited[adjacencyList[node].get(i)] = true;
          distances.set(adjacencyList[node].get(i), distances.get(node) + 1);
        }
      }
    }

    //System.out.println(distances.toString());
    for (int i = 1; i <= v; i++)
      this.distances.put(new Pair(src, i), distances.get(i));

    return distances.get(dest);
  }


}

class Pair {
  Integer first;
  Integer second;

  public Pair(Integer first, Integer second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public String toString() {
    return this.first + " " + this.second;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pair pair = (Pair) o;
    return first.equals(pair.first) &&
        second.equals(pair.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }
}

public class Kitty {

  private static final long MOD_FACTOR = 1000000007;

  private static List<Pair> getPairs(List<Integer> nodes) {
    List<Pair> pairs = new ArrayList<>();

    for (int i = 0; i < nodes.size(); i++) {
      for (int j = i + 1; j < nodes.size(); j++) {
        pairs.add(new Pair(nodes.get(i), nodes.get(j)));
      }
    }
    return pairs;
  }

  private static long calculateExpression(Graph graph, List<Pair> pairs) {
    if (pairs.isEmpty())
      return 0;

    long sum = 0;
    for (Pair pair: pairs) {
      //sum += pair.first * pair.second * graph.dist(pair.first, pair.second);
      sum += pair.first * pair.second * graph.dist(pair);
    }

    return sum % MOD_FACTOR;
  }

  static void printSolution(Graph graph, List<List<Integer>> nodeSets) {
    for (List<Integer> nodes : nodeSets) {
      List<Pair> pairs = getPairs(nodes);
      //pairs.forEach(System.out::println);
      System.out.println(calculateExpression(graph, pairs));
    }
  }

  static void printSolution1(Graph graph, List<Integer> nodes) {
      List<Pair> pairs = getPairs(nodes);
      //pairs.forEach(System.out::println);
      System.out.println(calculateExpression(graph, pairs));
  }

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    int numberOfNodes, numberOfSets;
    Scanner scanner = new Scanner(System.in);

    String[] firstLine = scanner.nextLine().split(" ");
    numberOfNodes = Integer.parseInt(firstLine[0]);
    numberOfSets = Integer.parseInt(firstLine[1]);

    Graph graph = new Graph(numberOfNodes);

    for (int i = 0; i < numberOfNodes - 1; i++) {
      String[] edge = scanner.nextLine().split(" ");
      graph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
    }

    //graph.print();
    //graph.allDistances();
    graph.calculateDistanceFromRoot();

    List<List<Integer>> nodesSets = new ArrayList<>();
    for (int i = 0; i < numberOfSets; i++) {
      int setSize = Integer.parseInt(scanner.nextLine());
      List<Integer> set = new ArrayList<>();
      String[] nodes = scanner.nextLine().split(" ");
      for (int j = 0; j < nodes.length; j++) {
        set.add(Integer.parseInt(nodes[j]));
      }
      printSolution1(graph, set);
      //nodesSets.add(set);
    }

    //nodesSets.stream().forEach(n -> n.stream().forEach(System.out::println));

    //printSolution(graph, nodesSets);
  }
}

