import list.List;
import list.Pilha;
import recursion.Recursion;
import tree.BinaryTree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();

        btree.insert(5);
        btree.insert(7);
        btree.insert(8);
        btree.insert(4);
        btree.insert(6);

        btree.print();

    }
}