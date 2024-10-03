package tree;

public class BinaryTree {
    private Node root;

    private static class Node {
        Node left;
        Node right;
        int data;

        Node( int newData ) {
            left = right = null;
            data = newData;
        }
    }

    public BinaryTree() {
        root = null;
    }

    public void insert( int data ) {
        root = insert( root, data );
    }

    private Node insert( Node root, int data ) {
        if (root == null) return new Node(data);
        if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    public void print( ) {
        print( root );
    }

    private void print( Node n ) {
        if (n == null) {
            return;
        }
        print(n.left);
        System.out.print(n.data + " ");
        print(n.right);
    }

    public int find( int val ) {
        return find( root, val );
    }

    private int find( Node n, int val ) {
        // ?????????????????????????
        return -1;
    }

}