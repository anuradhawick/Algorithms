package GraphAlgorithms.Dijkstra;

import java.util.HashSet;

/**
 * Created by Anuradha Sanjeewa on 23/12/2015.
 */
public class main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1,2,1);
        g.addEdge(2,4,2);
        g.addEdge(3,4,6);
        g.addEdge(3,2,2);
        g.addEdge(1,3,5);

        g.runDijstra(1);
    }
}
