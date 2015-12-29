package GraphAlgorithms.CyclesInAGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Anuradha Sanjeewa on 29/12/2015.
 */
public class CycleMain {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 4);
        g.addEdge(0, 3);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(4, 2);
        System.out.println(g.isCyclic(0));
    }
}


class Graph {
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

    public boolean isCyclic(int vertex) {
        Stack<Node> stack = new Stack<>();
        HashMap<Integer, Node> visited = new HashMap<>();
        Node u;
        stack.push(nodes.get(vertex));
        while (stack.size() > 0) {
            u = stack.pop();
            if (!visited.containsKey(u.getId())) {
                visited.put(u.getId(), u);
                u.getNeighbours().forEach(stack::push);
            } else {
                return true;
            }
        }
        return false;
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