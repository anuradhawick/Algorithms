package GraphAlgorithms.BFS;

/**
 * Created by Anuradha Sanjeewa on 22/12/2015.
 */
public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.runBFS(2);
    }
}
