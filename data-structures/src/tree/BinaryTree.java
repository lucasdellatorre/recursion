package tree;

import java.util.LinkedList;
import java.util.Queue;

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

    public void printTraversal() {
        printTraversal(root);
    }

    private void printTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.data + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public int find( int val ) {
        return find( root, val );
    }

    private int find( Node n, int val ) {
        if (n == null) return -1;
        if (n.data == val) return val;
        if (val > n.data) {
            return find(n.right, val);
        } else {
            return find(n.left, val);
        }
    }

    public boolean exist(int val) {
        return exist(val, root);
    }

    public boolean exist(int val, Node node) {
        if (root == null) return false;
        if (root.data == val) return true;
        return exist(val, node.left) || exist(val, node.right);
    }

    public int altura() {
        return altura(root);
    }

    private int altura(Node node) {
        if (node == null) return 0;
        return Math.max(altura(node.right), altura(node.left)) + 1;
    }

    public int numnodos() {
        return numnodos(root);
    }

    private int numnodos(Node node) {
        if (node == null) return 0;
        return numnodos(node.right) + numnodos(node.left) + 1;
    }


    public boolean isValidBST() {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(Node node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) return false;
        return isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }
}