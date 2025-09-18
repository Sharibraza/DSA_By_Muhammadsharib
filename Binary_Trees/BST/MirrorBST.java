package Binary_Trees.BST;

import Binary_Trees.BST.Bst.*;

public class MirrorBST {

    public static void preOrder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node mirror(Node root) {

        if (root == null) {
            return null;
        }

        Node leftSub = mirror(root.left);
        Node rightSub = mirror(root.right);

        root.left = rightSub;
        root.right = leftSub;

        return root;
    }

    public static void main(String[] args) {

        int val[] = {8,5,10,3,6,11};
        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Bst.buildBST(root, val[i]);
        }

        System.out.println("Original view: ");
        preOrder(root);

        System.out.println("\nMirror view : ");
        mirror(root);
        preOrder(root);

        // 1. Compile : javac Bst.java MirrorBST.java
        // 2. Run : java MirrorBST.java
    }
}
