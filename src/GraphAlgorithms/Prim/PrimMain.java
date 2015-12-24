package GraphAlgorithms.Prim;

import java.util.Arrays;

/**
 * Created by Anuradha Sanjeewa on 24/12/2015.
 */
public class PrimMain {
    public static void main(String[] args) {
        Graph g = new Graph(new long[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        });
        int index = 0;
        int[] prim = g.runPrim();
        for (Integer i : prim) {
            if (index != 0)
                System.out.println("Edge " + prim[index] + " " + index);
            index++;
        }
    }
}

class Graph {
    long[][] graph;

    public Graph(long[][] g) {
        graph = g;
    }

    public int[] runPrim() {
        //keep the parents and whether visited
        int[] parent = new int[graph.length];
        //to keep the cost of minimum incident edge on a vertex
        long[] minTree = new long[graph.length];
        Boolean[] visited = new Boolean[graph.length];
        //all nodes areun visited initially
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
            minTree[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        //set entrant cost to zero
        minTree[0] = 0;
        parent[0] = -1;
        //let the algorithm be executed for each node
        for (int i = 0; i < graph.length; i++) {
            //for each neighbour update the cost
            //get the unvisited vertex with min incident
            int minIndex = -1;
            long min = Integer.MAX_VALUE;
            for (int j = 0; j < graph.length; j++) {
                if (minTree[j] < min && visited[j] == false) {
                    min = minTree[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            for (int j = 0; j < graph.length; j++) {
                //for nodes having finite distances (Infinity is assumed to hold the value of 32bit max value)
                if (graph[minIndex][j] < Integer.MAX_VALUE && graph[minIndex][j] > 0) {
                    //if there is a smaller incident update the parent and minTree value
                    if (graph[minIndex][j] < minTree[j]) {
                        //update the new parent
                        parent[j] = minIndex;
                        //update incident edge value
                        minTree[j] = graph[minIndex][j];
                    }
                }

            }


        }
        return parent;
    }
}