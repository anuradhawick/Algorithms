package GraphAlgorithms.Kruskal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Anuradha Sanjeewa on 29/12/2015.
 */
public class kruMain {
}


class SpanningTree {

}

class Edge {
    private int src;
    private int des;
    private int cost;

    public Edge(int s, int d, int c) {
        this.src = s;
        this.des = d;
        this.cost = s;
    }

    public int getSrc() {
        return src;
    }

    public int getDes() {
        return des;
    }

    public int getCost() {
        return cost;
    }
}

class MST {
    private HashMap<Integer, Node> nodes;
    private int count;

    public MST(int vCount) {
        nodes = new HashMap<>();
        count = vCount;
        for (int i = 0; i < vCount; i++) {
            nodes.put(i, new Node(i));
        }
    }

    public int getCount() {
        return count;
    }

    public void addEdge(int id, int end,int cost) {
        nodes.get(id).addNeighbour(nodes.get(end),cost);
        nodes.get(end).addNeighbour(nodes.get(id),cost);
    }

//    public boolean isCyclic(int vertex) {
//        Stack<Node> stack = new Stack<>();
//        HashMap<Integer, Node> visited = new HashMap<>();
//        Node u;
//        stack.push(nodes.get(vertex));
//        while (stack.size() > 0) {
//            u = stack.pop();
//            if (!visited.containsKey(u.getId())) {
//                visited.put(u.getId(), u);
//                u.getNeighbours().forEach(stack::push);
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }

    public void addEdge(Edge e) {

    }

    public void removeEdge(Edge e) {

    }
}

class Node {
    private int id;
    private ArrayList<Node> neighbours;
    private HashMap<Node, Integer> edges;

    public Node(int id) {
        neighbours = new ArrayList<>();
        edges = new HashMap<>();
        this.id = id;
    }

    public void addNeighbour(Node n, int d) {
        this.neighbours.add(n);
        this.edges.put(n, d);
    }

    public void removeNeighbour(Node n) {
        edges.remove(n);
        neighbours.remove(n);
    }

    public ArrayList<Node> getNeighbours() {
        return this.neighbours;
    }

    public int getId() {
        return id;
    }
}
