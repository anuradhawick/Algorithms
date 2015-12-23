package GraphAlgorithms.Dijkstra;

/**
 * Created by Anuradha Sanjeewa on 23/12/2015.
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Graph {
    private HashMap<Integer, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void addEdge(int idU, int idV, int distance) {
        // we are implementing a un directed graph, thus edges are two way
        if (!nodes.containsKey(idU)) {
            nodes.put(idU, new Node(idU));
        }
        if (!nodes.containsKey(idV)) {
            nodes.put(idV, new Node(idV));
        }
        // adding the edge
        nodes.get(idU).addNeighbour(nodes.get(idV), distance);
        nodes.get(idV).addNeighbour(nodes.get(idU), distance);
    }

    public void runDijstra(int vertex) {
        HashSet<Node> S = new HashSet<>();
        // Initializing the node to 0
        Node n = nodes.get(vertex);
        n.setDistance(0);
        S.add(n);
        while (S.size() > 0) {
            // get the node with the minimum distance
            n = getTheMinDistanceNode(S);
            S.remove(n);
            for (Map.Entry<Node, Integer> i : n.getNeighbours().entrySet()) {
                if (n.getDistance() + n.getCost(i.getKey()) < i.getKey().getDistance()) {
                    i.getKey().setDistance(n.getDistance() + n.getCost(i.getKey()));
                    S.add(i.getKey());
                }
            }
        }
        System.out.println("Here");
        // printing the result
        for (Map.Entry<Integer, Node> i : nodes.entrySet()) {
            System.out.println("Distance to :" + i.getKey() + " = " + nodes.get(i.getKey()).getDistance());
        }
    }

    // Return the object having the minimum distnce
    public Node getTheMinDistanceNode(HashSet<Node> S) {
        Node min = null;
        long dist = Integer.MAX_VALUE;
        for (Node i : S) {
            if (dist > i.getDistance()) {
                dist = i.getDistance();
                min = i;
            }
        }
        return min;
    }
}

class Node {
    private int id;
    private long distance;
    HashMap<Node, Integer> neighbours;

    public Node(int id) {
        neighbours = new HashMap<>();
        this.id = id;
        // All nodes are initiated to infinity (32 bit max value)
        this.setDistance(Integer.MAX_VALUE);
    }

    public void addNeighbour(Node n, int distance) {
        this.neighbours.put(n, distance);
    }

    public HashMap<Node, Integer> getNeighbours() {
        return this.neighbours;
    }

    public int getId() {
        return id;
    }

    public int getCost(Node n) {
        return neighbours.get(n);
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}