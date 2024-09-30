package list;
    // List.java
public class List {
    private Node first;

    private static class Node {
        Node next;
        int data;

        Node( int newData ) {
            next = null;
            data = newData;
        }
    }

    public List() {
        first = null;
    }

    public void clear( ) {
        first = clear( first );
    }

    private Node clear( Node node ) {
        if ( node != null )
            node.next = clear( node.next );
        return null;
    }

    public void insert( int data ) {
        first = insert( data, first );
    }

    private Node insert( int data, Node node ) {
        if ( node == null )
            return new Node( data );
        node.next = insert( data, node.next );
        return node;
    }

    public void insertAt(int val, int pos) {
        first = insertAt(val, pos, first);
    }

    public Node insertAt(int data, int pos, Node node) {
        if ( pos == 0) {
            Node newNode = new Node( data );
            newNode.next = node;
            return newNode;
        }
        if (node == null) {
            throw new IllegalArgumentException("invalid position");
        }
        node.next = insertAt(data, pos - 1, node.next);
        return node;
    }

    public void insertSorted(int val) {
       first = insertSorted(val, first);
    }

    private Node insertSorted(int data, Node node) {
        if ( node == null || data <= node.data ) {
            Node newNode = new Node( data );
            newNode.next = node;
            return newNode;
        }

        node.next = insertSorted(data, node.next);
        return node;
    }

    public boolean exist(int data) {
        return exist(data, first);
    }

    private boolean exist(int data, Node node) {
        if (node == null) return false;
        if (data == node.data) return true;
        return exist(data, node.next);
    }

    public boolean delete(int val) {
        first = delete(val, first);
        return first != null;
    }

    private Node delete(int data, Node node) {
        if (node == null) return null;
        if (node.data == data) {
            return node.next;
        }
        node.next = delete(data, node.next);
        return node;
    }

    public int min() {
        int res = min(first);
        if (res == Integer.MAX_VALUE) throw new IllegalArgumentException("empty list");
        return res;
    }

    private int min(Node node) {
        if (node == null) return Integer.MAX_VALUE;
        return Math.min(min(node.next), node.data);
    }

    public void fill(int end) {
        first = fill(end, first);
    }

    private Node fill(int end, Node node) {
        if (end == 0) return null;
        node = new Node(1);
        node.next = fill(end - 1, node.next);
        return node;
    }

    public boolean kill(int val) {
        first = kill(val, first);
        return first != null;
    }

    private Node kill(int val, Node node) {
        if (node == null) return null;
        if (node.data == val) return kill(val, node.next);
        node.next = kill(val, node.next);
        return node;
    }

    public int total(int val) {
        return total(val, first);
    }

    private int total(int val, Node node) {
        if (node == null) return 0;
        if (node.data == val) {
            return 1 + total(val, node.next);
        }
        return total(val, node.next);
    }

    public void print( )  {
        print( first );
        System.out.println( "\n" );
    }

    private void print( Node node ) {
        if ( node == null ) return;
        System.out.print( node.data + " " );
        print( node.next );
    }

    public void walk() {
        walk(first);
    }

    private void walk(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        walk(node.next);
    }
}
