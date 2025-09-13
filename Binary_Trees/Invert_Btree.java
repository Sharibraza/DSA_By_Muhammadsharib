package Binary_Trees;

import Binary_Trees.BTree.Node;
import Binary_Trees.BTree.BinaryTree;

public class Invert_Btree {

    public static void invertTree(Node root) {

        if (root == null) {
            return;
        }

        invertTree(root.left);
        invertTree(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BinaryTree.levelOrder(root);
        invertTree(root);
        System.out.println();
        BinaryTree.levelOrder(root);
    }
}

