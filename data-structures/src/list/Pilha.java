package list;


// Pilha.java
public class Pilha {
    private static class Node {
        int data;
        Node next;

        Node( int newData ) {
            data = newData;
            next = null;
        }
    }

    private Node top;

    public Pilha() {
        top = null;
    }

    public void push( int data ) {
        Node p = new Node( data );
        p.next = top;
        top = p;
    }

    public int pop() {
        int tmp = top.data;
        top = top.next;
        return tmp;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void swap() {
        int oldTop = top.data;
        top = top.next;
        int oldoldTop = top.data;
        push(oldTop);
        push(oldoldTop);
    }

    public boolean exist(int val) {
        return exist(top, val);
    }

    private boolean exist(Node node, int val) {
        if (node == null) return false;
        if (node.data == val) return true;
        return exist(node.next, val);
    }

    public boolean exist2(int val) {
        if (isEmpty()) return false;
        int data = pop();
        if (data == val) return true;
        boolean res = exist(val);
        push(data);
        return res;
    }


    public void print( )  {
        System.out.println( "**********" );
        Node p = top;
        while ( p!= null ) {
            System.out.println( p.data );
            p = p.next;
        }
        System.out.println( "**********" );
    }

}