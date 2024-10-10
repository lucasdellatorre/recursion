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

    public int pai(int val) {
        Node res = pai(root, val);
        return res == null ? -1 : res.data;
    }

    private Node pai(Node node, int val) {
        if (node == null) return null;
        if (node.left != null && node.left.data == val) return node;
        if (node.right != null && node.right.data == val) return node;

        Node left = pai(node.left, val);
        if (left != null) return left;
        return pai(node.right, val);
    }

    public int soma() {
        return soma(root);
    }

    private int soma(Node node) {
        if (node == null) return 0;
        return soma(node.left) + soma(node.right) + node.data;
    }

    public int conta(int val)  {
        return conta(val, root);
    }

    private int conta(int val, Node node) {
        if (node == null) return 0;
        if (node.data == val) return conta(val, node.left) + conta(val, node.right) + 1;
        return conta(val, node.left) + conta(val, node.right);
    }

    public int numpares() {
        return numpares(root);
    }

    private int numpares(Node node) {
        if (node == null) return 0;
        if (node.data % 2 == 0) return numpares(node.left) + numpares(node.right) + 1;
        return numpares(node.left) + numpares(node.right);
    }

    public int filhosdir() {
        return filhosdir(root);
    }

    private int filhosdir(Node node) {
        if (node == null) return 0;
        if (node.right != null) return filhosdir(node.left) + filhosdir(node.right) + 1;
        return filhosdir(node.left);
    }

    public boolean isValidBST() {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(Node node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) return false;
        return isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }

    public void emordem() {
        emordem(root);
    }

    private void emordem(Node node) {
        if (node == null) return;
        emordem(node.left);
        System.out.println(node.data);
        emordem(node.right);
    }

    public void emordemreversa() {
        emordemreversa(root);
    }

    private void emordemreversa(Node node) {
        if (node == null) return;
        emordemreversa(node.right);
        System.out.println(node.data);
        emordemreversa(node.left);
    }

    public void inverte() {
        root = inverte(root);
    }

    private Node inverte(Node node) {
        if (node == null) return null;
        Node left = inverte(node.left);
        Node right = inverte(node.right);

        node.left = right;
        node.right = left;
        return node;
    }
}