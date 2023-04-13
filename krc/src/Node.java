import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T abbreviation;
    private T expansion;
    public List<T> children;
    private Node<T> parent;
    private Node<T> child;
    private Node<T> tail;
    private int nodeId;

    Node() {
        children = new ArrayList<T>();
        this.abbreviation = null;
        this.expansion = null;
        this.parent = null;
        this.child = null;
        this.tail = null;
        this.nodeId = -1;
    }
    Node(T abbreviation, T expansion) {
        this.abbreviation = abbreviation;
        this.expansion = expansion;
        this.parent = null;
        this.child = null;
        this.tail = null;
        this.nodeId = -1;
    }

    public T getAbbreviation() {
        return abbreviation;
    }

    public T getExpansion() {
        return expansion;
    }

    public void setAbbreviation(T abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setExpansion(T expansion) {
        this.expansion = expansion;
    }

    public Node<T> getParent() {
        return parent;
    }

    public Node<T> getChild() {
        return child;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void setChild(Node<T> child) {
        this.child = child;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public Node<T> getTail() {
        return tail;
    }
    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public int getNodeId() {
        return nodeId;
    }
}


