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
        Node res = delete(val, first);
        if (res == null) return false;
        first = res;
        return true;
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
