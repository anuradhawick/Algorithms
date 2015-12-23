package GraphAlgorithms.DFS;

/**
 * Created by Anuradha Sanjeewa on 23/12/2015.
 */

import java.util.*;

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

    public void runDFS(int vertex) {
        Stack<Node> stack = new Stack<>();
        HashMap<Integer, Node> visited = new HashMap<>();
        Node u;
        stack.push(nodes.get(vertex));
        while (stack.size() > 0) {
            u = stack.pop();
            if (!visited.containsKey(u.getId())) {
                visited.put(u.getId(), u);
                System.out.println("Discovering node: " + u.getId());
                u.getNeighbours().forEach(stack::push);
            }
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