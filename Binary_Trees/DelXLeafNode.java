package Binary_Trees;

import Binary_Trees.BTree.Node;
import Binary_Trees.BTree.BinaryTree;

public class DelXLeafNode {

    public static Node delXLeaf(Node root, int x, Node parent) {

        if (root == null) {
            return null;
        }

       root.left =  delXLeaf(root.left, x, root);
       root.right = delXLeaf(root.right, x, root);

       if ( root.data == x && (root.left == null && root.right == null)) {
            return null;
       }

       return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);

        int x = 3;

        BinaryTree.inOrder(root);
        delXLeaf(root, x, root);
        System.out.println();
        BinaryTree.inOrder(root);

        
        // 1. Compile : javac BTree.java DelXLeafNode.java
        // 2. Run : java DelXLeafNode.java
    }
}
