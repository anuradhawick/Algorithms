package GraphAlgorithms.FloydWarshall;

/**
 * Created by Anuradha Sanjeewa on 24/12/2015.
 */
public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 3, 10);
        g.addEdge(0, 1, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 1);

        long[][] result = g.runFloyd();
        // printing the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (result[i][j] == Integer.MAX_VALUE) {
                    System.out.format("%5s", "INF");
                } else {
                    System.out.format("%5d", result[i][j]);
                }
            }
            System.out.println("");
        }
    }
}

class Graph {
    long[][] graph;

    public Graph(int size) {
        graph = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void addEdge(int u, int v, int d) {
        graph[u][v] = d;
    }

    public long[][] runFloyd() {
        long[][] dist = new long[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // running floyd warhall algorithms
        // consider a pivot node k
        for (int k = 0; k < graph.length; k++) {
            // consider any 2 nodes of the graph
            // starting node
            for (int i = 0; i < graph.length; i++) {
                // target node
                for (int j = 0; j < graph.length; j++) {
                    // get the min distance
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }
}