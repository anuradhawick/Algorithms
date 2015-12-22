package GraphAlgorithms.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anuradha Sanjeewa on 22/12/2015.
 */
public class Graph {
    private HashMap<Integer, Node> nodes;
    private int count;

    public Graph(int vCount) {
        nodes = new HashMap<>();
        count = vCount;
        for (int i = 0; i < vCount; i++) {
            nodes.put(i, new Node(i));
        }
    }

    public int getCount() {
        return count;
    }

    public void addEdge(int id, int end) {
        nodes.get(id).addNeighbour(nodes.get(end));
    }

    public void runBFS(int vertex) {
        Node n = nodes.get(vertex);
        Queue<Node> to_visit = new LinkedList<>();
        HashMap<Integer, Node> visited = new HashMap<>();
        to_visit.add(n);
        while (to_visit.size() > 0) {
            // Add all neighbours to the
            n = to_visit.remove();
            System.out.println("Discovering node: " + n.getId());
            for (Node v : n.getNeighbours()) {
                // Ignore nodes that are discovered or having a looped back edged
                if (visited.containsKey(v.getId()) || v.getId() == n.getId()) {
                    continue;
                }
                to_visit.add(v);
            }
            visited.put(n.getId(), n);
        }
    }
}

class Node {
    private int id;
    private ArrayList<Node> neighbours;

    public Node(int id) {
        neighbours = new ArrayList<>();
        this.id = id;
    }

    public void addNeighbour(Node n) {
        this.neighbours.add(n);
    }

    public ArrayList<Node> getNeighbours() {
        return this.neighbours;
    }

    public int getId() {
        return id;
    }
}