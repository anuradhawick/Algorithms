package SimpleDataStructures.LinkedList;

import java.util.Iterator;

/**
 * Created by Anuradha Sanjeewa on 30/12/2015.
 */
public class LinkedList<T> implements Iterator<T>, Iterable<T> {
    Node head;
    Node tail;
    // related to iterator
    Node iterNode;
    boolean start = false;

    public LinkedList() {
        head = null;
        tail = null;
        iterNode = null;
    }

    public void add(T value) {
        if (tail == null) {
            Node<T> n = new Node<>();
            n.setValue(value);
            this.head = n;
            this.tail = n;
        } else {
            Node<T> n = new Node<>();
            n.setValue(value);
            tail.setNext(n);
            this.tail = n;
        }
    }

    public void remove(T value) {
        Node n = head;
        if (n == null) {
            return;
        }
        while (n != null) {
            if (n.getValue() == value) {
                Node val = n;
                if (n.getPrev() != null) {
                    n.getPrev().setNext(n.getNext());
                }
                if (n.getNext() != null) {
                    n.getNext().setPrev(n.getPrev());
                } else {
                    // Only one element in the list
                    head = null;
                    tail = null;
                }
                return;
            } else {
                n = n.getNext();
            }

        }

    }

    public void push(T value) {
        if (head == null) {
            Node<T> n = new Node<>();
            n.setValue(value);
            this.head = n;
            this.tail = n;
        } else {
            Node<T> n = new Node<>();
            n.setValue(value);
            n.setNext(head);
            this.head.setPrev(n);
            this.head = n;
        }
    }

    public T pop() {
        if (head == null) {
            return null;

        } else if (head == tail) {
            // Only one element in the list
            T val = (T) head.getValue();
            head = null;
            tail = null;
            return val;
        } else {
            T val = (T) head.getValue();
            head = head.getNext();
            head.setPrev(null);
            return val;
        }
    }

    // Implementing the Iterator
    @Override
    public boolean hasNext() {
        if (!start) {
            iterNode = head;
            start = true;
        }
        if (iterNode == null) {
            start = false;
            return false;
        } else {
            return true;
        }

    }

    @Override
    public T next() {
        if (iterNode == null) {
            iterNode = head;
            T ret = (T) iterNode.getValue();
            iterNode = iterNode.getNext();
            return ret;
        } else {
            T ret = (T) iterNode.getValue();
            iterNode = iterNode.getNext();
            return ret;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }
}

class Node<T> {
    private T value;
    private Node next;
    private Node prev;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}